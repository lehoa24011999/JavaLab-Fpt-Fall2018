package Lab6;

public class FormatData {
	
	private String phone;
	private String email;
	private String date;
	
	public FormatData() {
		super();
	}
	public FormatData(String phone, String email, String date) {
		super();
		this.phone = phone;
		this.email = email;
		this.date = date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

}
