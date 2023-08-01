package application;

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
		listSeller.sort((sell1, sell2) -> sell1.getName().toUpperCase().compareTo(sell2.getName().toUpperCase()));
		
		for (Seller sel : listSeller) {
			System.out.println(sel);
		}
		
		System.out.println();
	}

}
