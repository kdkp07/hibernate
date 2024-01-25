package in.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	@SuppressWarnings("deprecation")
	public static void main( String[] args ) throws IOException
	{
		System.out.println( "Jai shree Ganesh" );
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		//		System.out.println(factory);
		//		System.out.println(factory.isClosed());

		// creating a student

		//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//		System.out.println("Enter Student roll number.....");
		//		int id = Integer.parseInt(br.readLine());
		//		System.out.println("Enter student name.....");
		//		String name  = br.readLine();
		//		System.out.println("Enter student city name.....");
		//		String city  = br.readLine();
		//
		//		Student st = new Student(id,name,city);

		// creating object of Address class
		Address add = new Address();
		add.setAddress_id(23455);
		add.setCity("Bangalore");
		add.setStreet("545,Whitefield");
		add.setDateAdded(new Date());
		add.setX(34.22);
		add.setOpen(true);

		// reading an image
		FileInputStream file = new FileInputStream("src/main/java/sample2x2.png"); 
		byte[] data = new byte[file.available()];
		file.read(data);
		add.setImage(data);

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();// starting the transaction
		//		session.save(st);
		session.save(add);
		tx.commit();


		session.close();

		System.out.println("Done....");


	}	
}
