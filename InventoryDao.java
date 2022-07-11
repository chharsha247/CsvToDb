package com.harsha.CsvToDb.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.harsha.CsvToDb.Model.Inventory;
@Repository
public interface InventoryDao extends JpaRepository<Inventory, Integer> {
	public List<Inventory> findBySupplier(String supplier);
	@Query("from Inventory where stock>0 and supplier = :supplier and name = :name and exp> CURRENT_TIMESTAMP()")
	public List<Inventory> findBySupplierAndStock(@Param("supplier") String supplier,@Param("name") String name);
}
