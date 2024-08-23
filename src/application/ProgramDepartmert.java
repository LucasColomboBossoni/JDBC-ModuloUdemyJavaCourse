package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDepartmert {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = new DaoFactory().createDepartmentDao();
		
		System.out.println("=== Teste 1: department findById ===");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== Teste 2: department findAll ===");
		List<Department> list = new ArrayList<Department>();		
		list = departmentDao.findAll();
		for (Department x : list) {
			System.out.println(x);
		}
		
		System.out.println("\n=== Teste 3: department insert ===");
		Department insert = new Department(null, "Music");
		departmentDao.insert(insert);
		System.out.println("Inserted! New id = " + insert.getId());
		
		System.out.println("\n=== Teste 4: department update ===");
		department = departmentDao.findById(1);
		department.setName("Food");
		departmentDao.update(department);
		System.out.println("Updated! " + department.getName());
		
		System.out.println("\n=== Teste 5: department delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted completed!");
		
		sc.close();
	}
}
