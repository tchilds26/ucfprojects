package enterprise1;

public class Book {
	public int code;
	public String name;
	public double price;
	
	
	public Book(int code, String name, double price) {
		this.name = name;
		this.price = price;
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
	this.price=price;
	
	
}
	
	
	
	 @Override
	    public String toString() {
	        return "Book [code=" + code + " name=" + name + " price=" + price + "]";
	    }

}