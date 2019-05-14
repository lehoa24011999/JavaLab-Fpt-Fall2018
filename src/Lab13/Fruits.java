package Lab13;

public class Fruits {
//	Fruit Id, Fruit Name, Price, Quantity and Origin.

	private int id;
	private String name;
	private int price;
	private int quantity;
	private String origin;
	public Fruits(int id, String name, int price, int quantity, String origin) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.origin = origin;
	}
	public Fruits() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.id+"\t"+this.name+"\t"+this.price+"$"+"\t"+this.quantity+"\t"+this.origin;
		}
	
}
