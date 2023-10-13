package org.jsp.JpaCrud;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateStudent {
public static void main(String[] args) {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction  transaction=manager.getTransaction();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter your Id to update the record");
	int id=sc.nextInt();
	System.out.println("Enter your name,cousre,phone,email and password");
	String name=sc.next();
	String course=sc.next();
	long phone=sc.nextLong();
	String email=sc.next();
	String password=sc.next();
	Student st=new Student();
	st.setId(id);
	st.setName(name);
	st.setCourse(course);
	st.setPhone(phone);
	st.setEmail(email);
	st.setPassword(password);
	manager.merge(st);
	transaction.begin();
	transaction.commit();
	System.out.println("Your details Updated Successfully!!");
}
}
