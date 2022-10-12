package customer;

import java.util.ArrayList;

import java.util.Random;

import table.Table;
import table.TableList;

/**
 * add customer metodu ile boþ masa çaðýrýp eðer masa varsa müþteri listeden
 * kaldýrýlýp masaya oturtulur daha sonra thread ile belirtilen milisaniyede bir
 * müþteri eklemesi yapýlýr.
 *
 */
public class WaitingCustomer {
	public static WaitingCustomer instance;
	private ArrayList<Customer> customers;

	public Random rand = new Random();

	private int MAXIMUMCUSTOMERTIME = 5;
	private int SECTOMILISEC = 1000;

	public WaitingCustomer() {
		if (instance != null)
			return;
		instance = this;

		this.customers = new ArrayList<>();

		WaitingCustomerController thread = new WaitingCustomerController();

		thread.start();
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public void addCustomer(Customer cust) {
		customers.add(cust);

		Table table = TableList.instance.isTableEmpty();

		if (table != null) {
			TableList.instance.setTableEmpty(table, cust, false);
			customers.remove(cust);
			System.out.println(cust.getId() + 1 + ". customer sit on the " + (table.getId()) + ". table");
		}

	}

	public class WaitingCustomerController extends Thread {
		public void run() {
			while (true) {
				try {
					Thread.sleep((rand.nextInt(MAXIMUMCUSTOMERTIME) + 1) * SECTOMILISEC);

					addCustomer(new Customer());
				} catch (InterruptedException e) {
					System.err.println("Waiting Customer Thread Interrupted");
					e.printStackTrace();
				}
			}
		}

	}

}
