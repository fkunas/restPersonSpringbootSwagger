package dto;

public class Person {
	String id;
	String firstname;
	String lastname;
	String country;
	String street;
	String streetnumber;
	
	public Person(){
		
	}
	
	public Person(String id, String firstname, String lastname, String country, String street, String streetnumber) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.country = country;
		this.street = street;
		this.streetnumber = streetnumber;
	}
	
	public String getId(){
		return id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getCountry() {
		return country;
	}
	public String getStreet() {
		return street;
	}
	public String getStreetnumber() {
		return streetnumber;
	}
	public void setId(String id){
		this.id = id;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setStreetnumber(String streetnumber) {
		this.streetnumber = streetnumber;
	}
}
