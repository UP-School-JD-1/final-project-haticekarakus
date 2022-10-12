package waiter;

import customer.Customer;

import order.Meal;

/**
 * start work ile waiterýn busy deðiþkeni true yapýlýr.
 * Start metodu çaðrýlýr. 
 * Daha sonra thread baþlatýlarak garson çalýþma süresi kadar uyutulur ve iþ done'a çekilir.
 */
public class WaiterWork extends Thread {
	private int workTime;
	private Waiter worker;
	private Meal meal;
	private Customer customer;

	public WaiterWorkEvents events;

	public WaiterWork(int time, Meal meal, Customer cust) {
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

	public Waiter getWorker() {
		return worker;
	}

	public void setWorker(Waiter worker) {
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

	public void startWork(Waiter work) {
		worker = work;
		worker.setBusy(true);

		if (events != null)
			events.start();

		this.start();
	}

	private int secToMilisecond = 1000;

	public void run() {
		try {
			Thread.sleep(workTime * secToMilisecond);

			if (events != null)
				events.done();
		} catch (InterruptedException e) {
			System.err.println("One of the waiter work Thread Interrupted");
			e.printStackTrace();
		}
	}

	public interface WaiterWorkEvents {
		public WaiterWork Work = null;

		public void start();

		public void done();
	}
}
