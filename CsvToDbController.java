package com.harsha.CsvToDb.controller;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.harsha.CsvToDb.Dao.InventoryDao;
import com.harsha.CsvToDb.Model.Inventory;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;


@RestController
public class CsvToDbController {
	
	@Autowired
	InventoryDao inventoryDao;
	@PostMapping("/")
	public String getDetails(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
		/*
		 * Scanner sc = new Scanner(new
		 * File("C:\\Users\\harshavardhan.c\\Downloads\\CsvFile.csv"));
		 * sc.useDelimiter(","); //sets the delimiter pattern while (sc.hasNext())
		 * //returns a boolean value { System.out.print(sc.next()); //find and returns
		 * the next complete token from this scanner } sc.close(); //closes the scanner
		 */
		CSVReader reader = null;  
		List<Inventory> inventoryList=null;
		try  
		{  
			//parsing a CSV file into CSVReader class constructor  
			reader = new CSVReaderBuilder(new InputStreamReader(file.getInputStream())).withSkipLines(1).build();  
			String [] nextLine=new String[10];  
			//reads one line at a time  
			while ((nextLine = reader.readNext()) != null)  
			{  
				//for(String token:nextLine) System.out.println(token);
				
				Inventory inventory=new Inventory();
				if(nextLine[0]!=null) inventory.setCode(nextLine[0]); else inventory.setCode(null);
				if(nextLine[1]!=null) inventory.setName(nextLine[1]); else inventory.setName(null);
				if(nextLine[2]!=null) inventory.setBatch(nextLine[2]); else inventory.setBatch(null);
				if(nextLine[3]!=null) inventory.setStock(Integer.parseInt(nextLine[3])); else inventory.setStock(0);
				if(nextLine[4]!=null) inventory.setDeal(Integer.parseInt(nextLine[4])); else inventory.setDeal(0);
				if(nextLine[5]!=null) inventory.setFree(Integer.parseInt(nextLine[5])); else inventory.setFree(0);
				if(nextLine[6]!=null) inventory.setMrp(Double.parseDouble(nextLine[6])); else inventory.setMrp(0.0);
				if(nextLine[7]!=null) inventory.setRate(Double.parseDouble(nextLine[7])); else inventory.setRate(0.0);
				Date date1=null;
				if(nextLine[8]!=null && !nextLine[8].equals("/  /")) {
					date1 = new SimpleDateFormat("dd/MM/yyyy").parse(nextLine[8]);
				}
			    inventory.setExp(date1);
			    if(nextLine[9]!=null) inventory.setCompany(nextLine[9]);  else inventory.setCompany(null);
			    if(nextLine[10]!=null) inventory.setSupplier(nextLine[10]);  else inventory.setSupplier(null);
				
			    inventoryDao.save(inventory);
			}
			
		}  
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}  
		
		
		return "Data uploaded in db successfully!!!!!!!!";
	}
	@GetMapping(value = "/getProducts")
	public List<Inventory> getProductsOnSupplier(){
		return inventoryDao.findBySupplierAndStock("MED MANOR ORGANICS PVT LT     HYDERABAD","GIFT ITEM");
		//return inventoryDao.findAll(firstPageWithTwoElements);
	}
}
