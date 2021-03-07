package beans;

public class Order {
	String orderNo = "";
	String productName = "";
	float price = 0;
	int qty = 0;
	public Order(String orderNo, String productName, float price, int qty) {
		this.orderNo = orderNo;
		this.productName = productName;
		this.price = price;
		this.qty = qty;
	}
	
	
	
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
	
}
