package chef;

import java.util.ArrayList;
/**
 * Þef sayýsý burada belirtilir. ChefList nesnesi oluþtuðunda bu sayý kadar listeye þef eklenir.
 * Get free chef metodu ile boþta olan bir þef döndürülür.
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
