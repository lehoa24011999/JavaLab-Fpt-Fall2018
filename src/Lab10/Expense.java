package Lab10;

import java.util.Date;

public class Expense {
	private int id;
	private Date date;
	private double number;
	private String content;
	public Expense(int id, Date date, double number, String content) {
		super();
		this.id = id;
		this.date = date;
		this.number = number;
		this.content = content;
	}
	public Expense() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getNumber() {
		return number;
	}
	public void setNumber(double number) {
		this.number = number;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "|"+this.id+"\t"+this.date+"\t\t\t"+this.number+"\t\t\t"+this.content+"";
		
	}

}
