package org.jsp.JpaCrud;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeletePersonById {
public static void main(String[] args) {
EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
System.out.println("Enter you Id to delete the details!!");
 Scanner sc=new Scanner(System.in);
 int id=sc.nextInt();
 Student s=manager.find(Student.class, id);
 if(s!=null) {
  manager.remove(s);
  EntityTransaction t=manager.getTransaction();
  t.begin();
  t.commit();
  System.out.println("Records is deleted Successfully!!");
	}
	else {
		System.out.println("You have entered an Invalid Id");
	}
}
	
}