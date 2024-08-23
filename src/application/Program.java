package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = new DaoFactory().createSellerDao();
		
		System.out.println("=== Teste 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Teste 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller x : list) {
			System.out.println(x);
		}
		
		System.out.println("\n=== Teste 3: seller findAll ===");
		list = sellerDao.findAll();
		for (Seller x : list) {
			System.out.println(x);
		}
		
		System.out.println("\n=== Teste 4: seller insert ===");
		Seller insert = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(insert);
		System.out.println("Inserted! New id = " + insert.getId());
		
		System.out.println("\n=== Teste 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Updated! " + seller.getName());
		
	}

}
