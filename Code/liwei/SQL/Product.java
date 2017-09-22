package liwei.SQL;
/**
 * 产品对象
 * */
public class Product {
    private int id;
    private String pname;
    private double price;
    
    public Product(int id, String pname, double price) {
    	   this.id = id;
    	   this.pname = pname;
    	   this.price = price;
    }
    public Product() {
		// TODO Auto-generated constructor stub
	}
    public String toString() {
		return "product [id = " + this.id + ",pname = " + this.pname + ", price = " + this.price + "]";
	}
    public void setId(int id) {
		this.id = id;
	}
    public int getID() {
		return this.id;
	}
    public void setPname(String pname) {
		this.pname = pname;
	}
    public String getPname() {
		return this.pname;
	}
    public void setPrice(double price) {
		this.price = price;
	}
    public double getPrice() {
		return this.price;
	}
    
}
