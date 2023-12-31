package org.jsp.userproduct.controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import org.jsp.userproduct.config.UserProductConfig;
import org.jsp.userproduct.dao.ProductDao;
import org.jsp.userproduct.dao.UserDao;
import org.jsp.userproduct.dto.Product;
import org.jsp.userproduct.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class Test {
	@Autowired
	EntityManager manager;
	static Scanner sc=new Scanner(System.in);
	static UserDao udao;
	static ProductDao pdao;
	static {
		ApplicationContext context=new AnnotationConfigApplicationContext(UserProductConfig.class);
		udao=context.getBean(UserDao.class);
	}
	static {
		ApplicationContext context=new AnnotationConfigApplicationContext(UserProductConfig.class);
		pdao=context.getBean(ProductDao.class);
	}
	public static void main(String[] args) {
		System.out.println("1:Save the User");
		System.out.println("2:Update the User");
		System.out.println("3:Find User by Id");
		System.out.println("4:Find User by Id and Phone");
		System.out.println("5:Delete the User");
		System.out.println("6:Save the Product");
		System.out.println("7:Update the Product");
		System.out.println("8:Find Product by User Id");
		System.out.println("9:Delete the Product");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:{
			
			saveUser();
			break;
		}
		case 2:{
			updateUser();
			break;
		}
		case 3:{
			findUserById();
			break;
			
		}
		case 4:{
			findUserByIdandPhone();
			break;
		}
		case 5:{
			deleteUser();
			break;
		}
		case 6:{
			saveProduct();
			break;
		}
		case 7:{
			updateProduct();
				break;
		}
		case 8:{
			findProductByUserid();
			break;
		}
		case 9:{
			deleteProduct();
			break;
		}
		}
	}

	public static void deleteProduct() {
		System.out.println("Enter User id to delete");
		int uid=sc.nextInt();
		System.out.println("Enter Product id to delete");
		int pid=sc.nextInt();
		pdao.deleteProduct(uid, pid);
		
	}

	public static void findProductByUserid() {
		
		System.out.println("Enter Id to find");
		int id=sc.nextInt();
		List<Product> list=pdao.findProductByUserId(id);
		if(list.size()>0) {
			for(Product p:list) {
				System.out.println(p);
			}
		}
		}
   public static void saveProduct() {
		System.out.println("Enter Id to find");
		int id=sc.nextInt();
		System.out.println("Enter name,productid,price to Save product");
		String name=sc.next();
		String productid=sc.next();
		int price=sc.nextInt();
		Product p=new Product();
		p.setName(name);
		p.setPrice(price);
		p.setProductid(productid);
		p=pdao.saveProduct(p, id);
		System.out.println("Product saved with id:"+p.getId());
		}
	public static void updateProduct() {
		System.out.println("Enter Id to find");
		int id=sc.nextInt();
		User u=udao.findUserById(id);
		if(u!=null) {
		System.out.println("Enter Id,name,productid,price to Update product");
		int pid=sc.nextInt();
		String name=sc.next();
		String productid=sc.next();
		int price=sc.nextInt();
		Product p=new Product();
		p.setId(pid);
		p.setName(name);
		p.setPrice(price);
		p.setProductid(productid);
		p=pdao.updateProduct(p, id);
		System.out.println("Product updated with id:"+p.getId()+"with user id:"+u.getId());
		}
		}
	public static void deleteUser() {
		System.out.println("Enter Id to delete the user");
		int id=sc.nextInt();
		udao.deleteUser(id);
		}
	public static void findUserByIdandPhone() {
		System.out.println("Enter Id and phone to find the user");
		int id=sc.nextInt();
		long phone=sc.nextLong();
		User u=new User();
		u=udao.fetchUserByIdandPhone(id, phone);
		System.out.println(u);
		}
    public static void findUserById() {
		System.out.println("Enter Id to find");
		int id=sc.nextInt();
		User u=new User();
		u=udao.findUserById(id);
		System.out.println(u);
		}
      public static void saveUser() {
		System.out.println("Enter name and phone to Save User");
		String name=sc.next();
		long phone=sc.nextLong();
		User u=new User();
		u.setName(name);
		u.setPhone(phone);
		udao.saveUser(u);
		System.out.println("User saved with id:"+u.getId());
		}
	   public static void updateUser() {
		System.out.println("Enter Id,name and phone to Update User");
		int id=sc.nextInt();
		String name=sc.next();
		long phone=sc.nextLong();
		User u=new User();
		u.setId(id);
		u.setName(name);
		u.setPhone(phone);
		udao.updateUser(u);
		System.out.println("User updated with id:"+u.getId());
		}
}
