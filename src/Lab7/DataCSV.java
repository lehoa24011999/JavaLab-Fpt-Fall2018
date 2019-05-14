package Lab7;

public class DataCSV {

	
	private String code;
	private String name;
	private String email;
	private String phone;
	private String address;
	
	public DataCSV() {
		super();
	}
	public DataCSV(String code, String name, String email, String phone, String address) {
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
		return this.name+"\t" + this.address;
	}
}
