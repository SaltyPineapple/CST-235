package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

@Stateless
@Local(ordersBusinessInterface.class)
@Alternative
public class AnotherOrdersBusinessService implements ordersBusinessInterface{

	List<Order> orders = new ArrayList<Order>();
	
	public AnotherOrdersBusinessService() {
		orders.add(new Order("0000a", "Product 1", (float)1.00, 1));
		orders.add(new Order("0000b", "Product 2", (float)1.50, 1));
		orders.add(new Order("0000c", "Product 3", (float)3.00, 1));
		orders.add(new Order("0000d", "Product 4", (float)1.75, 1));
		orders.add(new Order("0000e", "Product 5", (float)50.00, 1));
		orders.add(new Order("0000f", "Product 6", (float)14.00, 1));
		orders.add(new Order("0000g", "Product 7", (float)11.00, 1));
	}
	
	@Override
	public void test() {
		System.out.println("TEST from Another orders business service ===================");
		
	}

	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orders;
	}

	public void setOrders(List<Order> orders) {
		// TODO Auto-generated method stub
		this.orders = orders;
	}

}
