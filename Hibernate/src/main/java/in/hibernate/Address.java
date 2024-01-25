package in.hibernate;

import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name="student_address")
public class Address {
	@Id		// primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// auto increment
	private int address_id;

	@Column(length = 50)
	private String city;

	@Column(length = 100 , name= "STREET")
	private String street;

	@Temporal(TemporalType.DATE)
	private Date dateAdded;

	private boolean isOpen;

	// ye new line add ki hai
	@Lob
	@Column(name = "photo", columnDefinition="BLOB")
	private byte[] image;
	@Transient
	private double x;
	public Address(int address_id, String city, String street, Date dateAdded, boolean isOpen, byte[] image, double x) {
		super();
		this.address_id = address_id;
		this.city = city;
		this.street = street;
		this.dateAdded = dateAdded;
		this.isOpen = isOpen;
		this.image = image;
		this.x = x;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", city=" + city + ", street=" + street + ", dateAdded="
				+ dateAdded + ", isOpen=" + isOpen + ", image=" + Arrays.toString(image) + ", x=" + x + "]";
	}


}
