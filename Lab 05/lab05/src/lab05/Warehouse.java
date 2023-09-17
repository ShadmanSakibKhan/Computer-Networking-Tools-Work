package lab05;

public class Warehouse {
	
	private double capacity;
	private double balance;
	private String name;
	
	public Warehouse(double c, double b, String n) { 
		
		this.capacity = c;
		
		if(b > this.capacity) {
		
			this.balance = b;
		
		}
		
		this.name = n;
		
	}
	
	public void printInfo() {
		
		System.out.println("capacity, balance, name");
		
	}
	
	public double howMuchSpaceLeft() {
		
		return capacity - balance;
		
	}
	
	public void addProduct(double x) {
		
		double temp = balance + x;
	
		if(temp < capacity) {
		
			balance = balance + x;
		
		}
		
	}
	
	public void removeProduct(double x) {
		
		balance = balance - x;
		
	}
			
}