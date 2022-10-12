package chef;

import java.util.ArrayList;

import waiter.WaiterWork;
import waiter.WaiterWorks;

/**
 * Þefin yapacaðý iþler bir listede tutulur. add work metodu ile boþ olan
 * þeflere görev atanýr. Eðer þefler doluysa görev listeye atýlýr. create chef
 * work metodu ile waiterdan sipariþ alýnýp iþe baþlanýr ve bittiðinde þef boþa
 * çýkartýlýr. Hazýrlanan sipariþ garsonun sipariþlerine eklenir.
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
