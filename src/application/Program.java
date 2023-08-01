package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("*** TEST 1: Seller findById ***");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println();
		
		System.out.println("*** TEST 2: Seller findByDepartment ***");
		Department dep = new Department(2, null);
		List <Seller> listSeller = sellerDao.findByDepartment(dep);
		//listSeller.sort((sell1, sell2) -> sell2.getName().toUpperCase().compareTo(sell1.getName().toUpperCase()));
		for (Seller sel : listSeller) {
			System.out.println(sel);
		}
		
		System.out.println();
		
		System.out.println("*** TEST 3: Seller findAll ***");
		List <Seller> listSeller2 = sellerDao.findAll();
		for (Seller sel : listSeller2) {
			System.out.println(sel);
		}

		System.out.println();
		
		/*
		System.out.println("*** TEST 4: Seller insert ***");
		Seller newSeller = new Seller(null, "Greg", "greg@gamil.com", new Date(), 4000.00, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
		*/

		System.out.println();
		
		System.out.println("*** TEST 5: Seller update ***");
		seller = sellerDao.findById(1);
		System.out.println(seller.getName());
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update complete! New name = " + seller.getName());
		
	}

}
