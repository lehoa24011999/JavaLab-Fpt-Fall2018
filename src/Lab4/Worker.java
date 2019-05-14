package Lab4;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Worker implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int age;
	private int salary;
	private String workLocation;
	//adding
	private String state;
	private String dateChange;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Calendar cal = Calendar.getInstance();
//	System.out.println(dateFormat.format(cal.getTime()));
	public Worker() {
		super();
	}
	public Worker(String id, String name, int age, int salary, String workLocation) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.workLocation = workLocation;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getDateChange() {
		return dateChange;
	}
	public void setDateChange(String dateChange) {
		this.dateChange = dateChange;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + "\t" + this.name + "\t"+this.age+"\t"+ this.salary+"\t";
	}
	public void print() {
		System.out.println("===================Display information salary==================");
		System.out.println(this.id + "\t" + this.name + "\t"+this.age+"\t"+ 
				this.salary+"\t"+ this.state + "\t"+ this.dateChange);
		System.out.println("================================================================");
	}


}
