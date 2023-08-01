package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departDao = DaoFactory.createDepartmentDao();
		
		System.out.println("*** TEST 1: Department findById ***");
		Department dep = departDao.findById(3);
		System.out.println(dep);

		System.out.println();
		
		

		System.out.println("*** TEST 2: Department findAll ***");
		List<Department> listDep = departDao.findAll();
		for (Department dep1 : listDep) {
			System.out.println(dep1);
		}

		System.out.println();

		
		System.out.println("*** TEST 3: Department insert ***"); 
		Department newDep = new Department(null, "Foods");
		departDao.insert(newDep);
		System.out.println("Inserted! New Id = " + newDep.getId());

		
		System.out.println();

		System.out.println("*** TEST 4: Department update ***");
		Department department = departDao.findById(1);
		System.out.println(department.getName());
		department.setName("Teste");
		departDao.update(department);
		System.out.println("Update complete! New name = " + department.getName());

		System.out.println();
		

		System.out.println("*** TEST 5: Department delete ***");
		System.out.print("Enter id of department for delete test: ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		departDao.deleteById(id);
		System.out.println("Delete complete!");
		sc.close();


	}

}
