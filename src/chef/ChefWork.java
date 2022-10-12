package chef;

import order.Meal;
import customer.Customer;
/**
 * Chef work events inteface'i ile çalýþmayý baþlatma ve bitirme metotlarýný kullanýr.
 * start work metodu ile þefe iþ atanýr ve start metodu baþlatýlýr.
 * Daha sonra thread baþlatýlýr þef iþ süresi boyunca uyutulur ve iþi bittiðinde done'a çekilir. 
 */

public class ChefWork extends Thread {
	private int workTime;
	private Chef worker;
	private Meal meal;
	private Customer customer;

	public ChefWorkEvents events;

	public ChefWork(int time, Meal meal, Customer cust) {
		this.workTime = time;
		this.meal = meal;
		this.customer = cust;
	}

	public int getWorkTime() {
		return workTime;
	}

	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}

	public Chef getWorker() {
		return worker;
	}

	public void setWorker(Chef worker) {
		this.worker = worker;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void startWork(Chef work) {
		worker = work;
		worker.setBusy(true);

		if (events != null)
			events.start();

		this.start();
	}

	private int SecToMs = 1000;

	public void run() {
		try {
			Thread.sleep(workTime * SecToMs);

			if (events != null)
				events.done();

		} catch (InterruptedException e) {
			System.err.println("One of the waiter work Thread Interrupted");
			e.printStackTrace();
		}
	}

	public interface ChefWorkEvents {
		public ChefWork Work = null;

		public void start();

		public void done();
	}


}