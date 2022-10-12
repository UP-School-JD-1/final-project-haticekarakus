package restaurant;

import chef.ChefList;
import chef.ChefWorks;
import customer.WaitingCustomer;
import order.Meal;

import order.MealType;
import table.TableList;
import waiter.WaiterList;
import waiter.WaiterWorks;

public class RestaurantSimulation {
	public static void main(String[] args) {
		System.out.println("Start");

		PrepareMenu();

		new WaitingCustomer();

		new TableList();

		new WaiterList();
		new WaiterWorks();

		new ChefList();
		new ChefWorks();

	}

	private static void PrepareMenu() {
		new Meal("Pizza", MealType.Food, 1, 2, 1);
		new Meal("Hamburger", MealType.Food, 1, 3, 2);
		new Meal("Spagetti", MealType.Food, 1, 1, 3);
		new Meal("Cola", MealType.Drink, 1, 1, 1);
		new Meal("Tea", MealType.Drink, 1, 1, 1);
		new Meal("Fries", MealType.Food, 1, 2, 1);
		new Meal("Coffe", MealType.Drink, 1, 1, 1);
		new Meal("CheeseCake", MealType.Food, 1, 3, 2);
		new Meal("Lemonade", MealType.Food, 1, 1, 1);
	}
}
