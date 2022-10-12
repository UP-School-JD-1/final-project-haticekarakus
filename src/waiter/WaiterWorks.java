package waiter;

import java.util.ArrayList;

import chef.ChefWork;
import chef.ChefWorks;
import customer.Customer;
import order.Meal;

/**
 * add work metodu ile bo�ta olan bir garsona start work atan�r. Bo�ta garson
 * yoksa works listesine g�rev eklenir. get work ile listeden bir g�rev al�n�r.
 * create waiter prep work ile oturan bir m��terinin sipari�i al�n�r ve �efe
 * atan�r. serve metodu ile �efin haz�rlad��� sipari�ler m��terilere servis
 * edilir.
 */
public class WaiterWorks {
	public static WaiterWorks instance;
	private ArrayList<WaiterWork> works;

	public WaiterWorks() {
		if (instance != null)
			return;
		instance = this;

		works = new ArrayList<>();
	}

	public ArrayList<WaiterWork> getWorks() {
		return works;
	}

	public void setWorks(ArrayList<WaiterWork> works) {
		this.works = works;
	}

	public void addWorks(WaiterWork work) {
		Waiter wait = WaiterList.instance.getFreeWaiter();

		if (wait != null)
			work.startWork(wait);

		else
			works.add(work);

	}

	public WaiterWork getWork() {
		if (works.size() == 0)
			return null;
		WaiterWork tmpWork = works.get(0);
		works.remove(0);
		return tmpWork;
	}

	public void createWaiterPrepWork(Customer cust) {
		for (Meal meal : cust.getOrder().getMeals()) {
			WaiterWork work = new WaiterWork(meal.getPrepTime(), meal, cust);

			work.events = new WaiterWork.WaiterWorkEvents() {
				public WaiterWork Work = work;

				@Override
				public void start() {
				}

				@Override
				public void done() {
					System.out.println("Order has been taken for " + (Work.getCustomer().getId() + 1) + ". customer");
					Work.getWorker().setBusy(false);

					ChefWorks.instance.createChefWork(Work);
				}
			};

			WaiterWorks.instance.addWorks(work);
		}
	}

	public void createWaiterServeWork(ChefWork chefWork) {
		WaiterWork work = new WaiterWork(chefWork.getMeal().getServeTime(), chefWork.getMeal(), chefWork.getCustomer());

		work.events = new WaiterWork.WaiterWorkEvents() {
			public WaiterWork Work = work;

			@Override
			public void start() {
			}

			@Override
			public void done() {
				System.out.println("Serve Has Been Done For " + (Work.getCustomer().getId() + 1) + ". customer");
				Work.getWorker().setBusy(false);

				Work.getCustomer().addCookedMeal(Work.getMeal());
			}
		};

		WaiterWorks.instance.addWorks(work);

	}

}
