package chef;

/**
 * Her �ef nesnesi olu�tu�unda id'si 1 artar.
 * Set busy metodu �eflere i� atamas� yap�l�r.
 */
public class Chef {
	public int id;
	public boolean isBusy;

	private static int lastID = 0;

	public Chef() {
		this.id = lastID++;
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
			ChefWork work = ChefWorks.instance.GetWork();
			if (work != null) {
				work.startWork(this);
			}
		}

		this.isBusy = busy;
	}

}
