package chef;

import java.util.ArrayList;

import waiter.WaiterWork;
import waiter.WaiterWorks;

/**
 * �efin yapaca�� i�ler bir listede tutulur. add work metodu ile bo� olan
 * �eflere g�rev atan�r. E�er �efler doluysa g�rev listeye at�l�r. create chef
 * work metodu ile waiterdan sipari� al�n�p i�e ba�lan�r ve bitti�inde �ef bo�a
 * ��kart�l�r. Haz�rlanan sipari� garsonun sipari�lerine eklenir.
 */
public class ChefWorks {
	public static ChefWorks instance;
	private ArrayList<ChefWork> works;

	public ChefWorks() {
		if (instance != null)
			return;
		instance = this;

		works = new ArrayList<>();
	}

	public ArrayList<ChefWork> getWorks() {
		return works;
	}

	public void setWorks(ArrayList<ChefWork> works) {
		this.works = works;
	}

	public void addWorks(ChefWork work) {
		Chef chef = ChefList.instance.getFreeChef();

		if (chef != null)
			work.startWork(chef);
		else
			works.add(work);
	}

	public ChefWork GetWork() {
		if (works.size() == 0)
			return null;
		ChefWork tmpWork = works.get(0);
		works.remove(0);
		return tmpWork;
	}

	public void createChefWork(WaiterWork waiterWork) {
		ChefWork work = new ChefWork(waiterWork.getMeal().getCookTime(), waiterWork.getMeal(),
				waiterWork.getCustomer());

		work.events = new ChefWork.ChefWorkEvents() {
			public ChefWork Work = work;

			@Override
			public void start() {
			}

			@Override
			public void done() {
				System.out.println("Cook Has Been Done For " + (Work.getCustomer().getId() + 1) + ". customer.");
				Work.getWorker().setBusy(false);

				WaiterWorks.instance.createWaiterServeWork(Work);
			}
		};

		ChefWorks.instance.addWorks(work);

	}
}
