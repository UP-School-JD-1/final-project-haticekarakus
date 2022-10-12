package order;

import java.util.ArrayList;
import java.util.Random;

/**
 * Constructor içerisinde belirlediðimiz max count'a göre random bir
 * þekilde sipariþ listesi oluþturuluyor.
 * 
 *
 */
public class Order {
	private ArrayList<Meal> meals;
	private ArrayList<Meal> mealHaveBeenDone;

	public Order() {
		meals = new ArrayList<>();
		mealHaveBeenDone = new ArrayList<>();

		Random rand = new Random();

		for (MealType type : MealType.values()) {

			int count = rand.nextInt(type.maxCount);
			for (int i = 0; i < count; i++) {
				ArrayList<Meal> avalibleMeals = Meal.getAllMealWithType(type);
				meals.add(avalibleMeals.get(rand.nextInt(avalibleMeals.size())));
			}
		}

		if (meals.size() == 0) {
			ArrayList<Meal> avalibleMeals = Meal.getAllMealWithType(MealType.Food);

			meals.add(avalibleMeals.get(rand.nextInt(avalibleMeals.size())));
		}

	}

	public ArrayList<Meal> getMeals() {
		return meals;
	}

	public void setMeals(ArrayList<Meal> meals) {
		this.meals = meals;
	}

	public ArrayList<Meal> getMealHaveBeenDone() {
		return mealHaveBeenDone;
	}

	public void setMealHaveBeenDone(ArrayList<Meal> mealHaveBeenDone) {
		this.mealHaveBeenDone = mealHaveBeenDone;
	}

	public String toString() {
		String str = "";

		for (Meal me : meals) {
			str += me.toString() + ", ";
		}

		return str;
	}
}
