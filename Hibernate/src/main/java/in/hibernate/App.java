package in.hibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main( String[] args ) throws IOException
	{
		System.out.println( "Jai shree Ganesh" );
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		//		System.out.println(factory);
		//		System.out.println(factory.isClosed());

		// creating a student

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Student roll number.....");
		int id = Integer.parseInt(br.readLine());
		System.out.println("Enter student name.....");
		String name  = br.readLine();
		System.out.println("Enter student city name.....");
		String city  = br.readLine();

		Student st = new Student(id,name,city);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();// starting the transaction

		session.save(st);
		tx.commit();
		session.close();




	}	
}
