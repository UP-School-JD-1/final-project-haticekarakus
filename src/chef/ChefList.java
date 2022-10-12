package chef;

import java.util.ArrayList;
/**
 * �ef say�s� burada belirtilir. ChefList nesnesi olu�tu�unda bu say� kadar listeye �ef eklenir.
 * Get free chef metodu ile bo�ta olan bir �ef d�nd�r�l�r.
 */

public class ChefList {
	public static ChefList instance = null;

	private ArrayList<Chef> chefs;

	private int ChefCount = 3;

	public ChefList() {
		if (instance != null)
			return;

		instance = this;

		chefs = new ArrayList<>();
		for (int i = 0; i < ChefCount; i++)
			chefs.add(new Chef());
	}

	public ArrayList<Chef> getChefs() {
		return chefs;
	}

	public void setChefs(ArrayList<Chef> chefs) {
		this.chefs = chefs;
	}

	public Chef getFreeChef() {
		for (Chef chef : chefs)
			if (!chef.isBusy)
				return chef;
		return null;
	}
}
