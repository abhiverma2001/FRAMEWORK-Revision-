package org.jsp.JpaCrud;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FetchPersonById {
  public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter your id to dispaly the details!");
	int id=sc.nextInt();
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	Student s=manager.find(Student.class, id);
	if(s!=null) {
		System.out.println("Id:"+s.getId());
		System.out.println("Name:"+s.getName());
		System.out.println("Course:"+s.getCourse());
		System.out.println("Phone:"+s.getPhone());
		System.out.println("Email:"+s.getEmail());
		System.out.println("Password"+s.getPassword());
	}else {
		System.out.println("You have enterd an Invalid Id");
	}
}
}
