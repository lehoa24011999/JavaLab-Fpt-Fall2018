package Lab8;

public class Student implements Comparable<Student> {

	
	private String code;
	private String name;
	private String email;
	private String phone;
	private String address;
	
	public Student() {
		super();
	}
	public Student(String code, String name, String email, String phone, String address) {
		super();
		this.code = code;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.code+"\t"+this.name+"\t"+ this.address+"\t"+this.phone+"\t"+this.email ;
	}
	@Override
	public int compareTo(Student o) {
		
		return this.name.compareToIgnoreCase(o.name);
	}
}
