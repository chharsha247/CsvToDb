package com.harsha.CsvToDb.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Inventory {
	@Id
	@GeneratedValue
	private int sno;
	private String code;
	private String name;
	private String batch;
	public int stock;
	public int deal;
	public int free;
	public double mrp;
	public double rate;
	public Date exp;
	private String company;
	private String supplier;
	
	
	public Inventory() {}


	public Inventory(int sno, String code, String name, String batch, int stock, int deal, int free, double mrp,
			double rate, Date exp, String company, String supplier) {
		super();
		this.sno = sno;
		this.code = code;
		this.name = name;
		this.batch = batch;
		this.stock = stock;
		this.deal = deal;
		this.free = free;
		this.mrp = mrp;
		this.rate = rate;
		this.exp = exp;
		this.company = company;
		this.supplier = supplier;
	}


	public int getSno() {
		return sno;
	}


	public void setSno(int sno) {
		this.sno = sno;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBatch() {
		return batch;
	}


	public void setBatch(String batch) {
		this.batch = batch;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getDeal() {
		return deal;
	}


	public void setDeal(int deal) {
		this.deal = deal;
	}


	public int getFree() {
		return free;
	}


	public void setFree(int free) {
		this.free = free;
	}


	public double getMrp() {
		return mrp;
	}


	public void setMrp(double mrp) {
		this.mrp = mrp;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	public Date getExp() {
		return exp;
	}


	public void setExp(Date exp) {
		this.exp = exp;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getSupplier() {
		return supplier;
	}


	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}


	@Override
	public String toString() {
		return "Inventory [sno=" + sno + ", code=" + code + ", name=" + name + ", batch=" + batch + ", stock=" + stock
				+ ", deal=" + deal + ", free=" + free + ", mrp=" + mrp + ", rate=" + rate + ", exp=" + exp
				+ ", company=" + company + ", supplier=" + supplier + "]";
	}
	
	
	
}
