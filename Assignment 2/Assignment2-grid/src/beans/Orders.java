package beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Orders {
	ArrayList<Order> orders = new ArrayList<Order>();
	
	public Orders() {
		orders.add(new Order("00001", "Product 1", (float)1.00, 1));
		orders.add(new Order("00002", "Product 2", (float)1.50, 1));
		orders.add(new Order("00003", "Product 3", (float)3.00, 1));
		orders.add(new Order("00004", "Product 4", (float)1.75, 1));
		orders.add(new Order("00005", "Product 5", (float)50.00, 1));
		orders.add(new Order("00006", "Product 6", (float)14.00, 1));
		orders.add(new Order("00007", "Product 7", (float)11.00, 1));
		
	}

	
	
	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	

}
