package com.hexa.hibernation.com.hexaware.hibernation1;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
	SessionFactory fac;
	Session ses;
	 Transaction tx;
	 
	 Scanner sc = new Scanner(System.in);
	
	App()
	{
        fac=new Configuration().configure("hiber.cfg.xml").addAnnotatedClass(Book.class).buildSessionFactory();
    	
    	 ses=fac.openSession();
		
	}
	    void insertBook()
	    {
	    	System.out.println("enter book number");
	    	int bn=sc.nextInt();
	    	System.out.println("enter price");
    		double Price =  sc.nextDouble();
    		System.out.println("enter book name");
    		String Bname = sc.next();
	    	 tx=ses.beginTransaction();
	         Book b= new Book();
	         b.setBno(bn);
	         b.setName(Bname);
	         b.setPrice(Price);
	         
	         ses.save(b);
	         tx.commit();
	    }
	    void RemoveByBNo()
	    {
	    	System.out.println("enter book number");
	    	int bn=sc.nextInt();
	    	tx=ses.beginTransaction();
	    	Book b= ses.find(Book.class,bn);
	    	if(b!=null)
	    	{
	    		ses.delete(b);
	    		tx.commit();
	    		
	    	}
	    	else
	    	{
	    		System.out.println("Not Found");
	    	}
	    	
	    }
	    
	    void UpdateRecord()
	    {
	    	System.out.println("enter book number");
	    	int bn=sc.nextInt();
	    	tx=ses.beginTransaction();
	    	Book b= ses.find(Book.class,bn);
	    	if(b!=null)
	    	{	
	    		System.out.println("enter updated price");
	    		double updatePrice =  sc.nextDouble();
	    		b.setPrice(updatePrice);
	    		ses.update(b);
	    		tx.commit();
	    		
	    	}
	    	else
	    	{
	    		System.out.println("Not Found");
	    	}

	    }
	    
	    void SearchByBNo()
	    {
	    	System.out.println("enter book number");
	    	int bn=sc.nextInt();
	    	tx=ses.beginTransaction();
	    	Book b= ses.find(Book.class,bn);
	    	if(b!=null)
	    	{	
	    		System.out.println(b.toString());
	    		tx.commit();
	    		
	    	}
	    	else
	    	{
	    		System.out.println("Not Found");
	    	}
	    	
	    }
	    
	    void showAll()
	    {
	    	
	    	 tx=ses.beginTransaction();
	    	
	    	 Query q=ses.createQuery("from Book ");
	    	 List <Book>books= q.list();
	    	
	    	 for(Book b : books)
	    	 {
	    		 System.out.println(b.toString());
	    		
	    	 }
	    	
	    	
 
	    }
	    
    public static void main( String[] args )
    {
    	App app= new App();
    	app.showAll();

    	
    	System.out.println("Welcome");
    }
}
