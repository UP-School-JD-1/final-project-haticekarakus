package order;

import java.util.ArrayList;

/**
 * Her bir öðün için gerekli deðiþkenler tanýmlandý. get all meal metodu ile
 * meal listesi döndürüldü. get all with meal type ile istediðimiz türden
 * yemekleri listeliyoruz.
 */
public class Meal {
	private String name;
	private MealType type;

	private int prepTime;
	private int cookTime;
	private int serveTime;

	public Meal(String name, MealType type, int prepTime, int cookTime, int serveTime) {
		this.name = name;
		this.type = type;
		this.prepTime = prepTime;
		this.cookTime = cookTime;
		this.serveTime = serveTime;

		if (mealsList == null)
			mealsList = new ArrayList<>();

		Meal.mealsList.add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MealType getType() {
		return type;
	}

	public void setType(MealType type) {
		this.type = type;
	}

	public int getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}

	public int getCookTime() {
		return cookTime;
	}

	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}

	public int getServeTime() {
		return serveTime;
	}

	public void setServeTime(int serveTime) {
		this.serveTime = serveTime;
	}

	public String toString() {
		return getName() + " " + getType() + " " + String.valueOf(getPrepTime()) + " " + String.valueOf(getCookTime())
				+ " " + String.valueOf(getServeTime());
	}

	private static ArrayList<Meal> mealsList = null;

	public static ArrayList<Meal> getAllMeal() {
		if (mealsList == null)
			mealsList = new ArrayList<>();

		return mealsList;
	}

	public static ArrayList<Meal> getAllMealWithType(MealType type) {
		ArrayList<Meal> tmpList = new ArrayList<>();

		if (mealsList == null)
			mealsList = new ArrayList<>();

		for (Meal meal : mealsList)
			if (meal.getType() == type)
				tmpList.add(meal);

		return tmpList;
	}

}
