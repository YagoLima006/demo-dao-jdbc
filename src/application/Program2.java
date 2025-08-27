package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DepartmentDao;
import model.dao.impl.DaoFactory;
import model.entities.Department;

public class Program2
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Teste 1: findById ===");
		Department dep = departmentDao.findById(6);
		System.out.println(dep);
		System.out.println("Completed");
		
		System.out.println("=== Teste 2: findAll ===");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list)
		{
			System.out.println(obj);
		}
		
		System.out.println("=== Teste 3: Insert ===");
		Department newDep = new Department(13, "Sports");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id: " + newDep.getId()+ " New name: " + newDep.getName());
		
		System.out.println("=== Teste 4: Update ===");
		dep = departmentDao.findById(12);
		dep.setName("E-sports");
		dep.setId(14);
		departmentDao.update(dep);
		System.out.println("Update completed!");
		
		System.out.println("=== Teste 5: Delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed! ");
		sc.close();
		
	}

}
