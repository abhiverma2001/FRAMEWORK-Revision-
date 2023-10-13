package org.jsp.JpaCrud;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveStudent {
  public static void main(String[] args) {
	Student st=new Student();
	st.setName("Abhishek");
	st.setCourse("B.Tech");
	st.setPhone(6306412);
	st.setEmail("abhi21@gmail.com");
	st.setPassword("abhi12");
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	manager.persist(st);
	EntityTransaction transaction=manager.getTransaction();
	transaction.begin();
	transaction.commit();
	System.out.println("Student saved with Id:"+st.getId());
}
}
