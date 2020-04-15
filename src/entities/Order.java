package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;

	private Client client;

	private List<OrderItem> items = new ArrayList<>();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");

	public Order() {

	}

	public Order(Date moment, OrderStatus status, Client client) {

		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {

		items.add(item);
	}

	public void removeItem(OrderItem item) {

		items.remove(item);
	}
	
	public double total() {
		
		double sum = 0.0;
		
		for(OrderItem item : items) {
			
			sum += item.subTotal();
			
		}
		
		return sum;
		
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: "+sdf.format(moment)+"\n");
		sb.append("Order Status: "+status+"\n");
		sb.append(client+"\n");
		sb.append("Order items:\n");
		for (OrderItem item : items) {
		
		sb.append(item+"\n");
			
		}
		sb.append(total());
		
		
		
		return sb.toString();
		
		
	}
	

}
