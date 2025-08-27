package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.SellerDao;
import model.dao.impl.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

public class Program 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Teste 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("=== Teste 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list)
		{
			System.out.println(obj);
		}
		
		System.out.println("=== Teste 3: seller findAll ===");
		list= sellerDao.findAll();
		for(Seller obj : list)
		{
			System.out.println(obj);
		}
		
		System.out.println("=== Teste 4: seller Insert ===");
		Seller newSeller = new Seller(null, " Greg", "Greg@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id: " + newSeller.getId());
		
		System.out.println("=== Teste 5: seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Marta Wayine" );
		sellerDao.update(seller);
		System.out.println("Update completed! ");
		
		System.out.println("=== Teste 6: seller Delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed! ");
		sc.close();
	}
	
}
