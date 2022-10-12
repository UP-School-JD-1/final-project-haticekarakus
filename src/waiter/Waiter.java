package waiter;
/**
 * set busy metodu ile garson boþsa waiter worksten bir iþ atanýr.
 *
 */
public class Waiter {
	private int id;
	private boolean isBusy;
	private static int lastId = 0;

	public Waiter() {
		id = lastId++;
		isBusy = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isBusy() {
		return isBusy;
	}


	public void setBusy(boolean busy) {
		if (!busy) {
			WaiterWork work = WaiterWorks.instance.getWork();
			if (work != null) {
				work.startWork(this);
			}
		}

		this.isBusy = busy;
	}

}
