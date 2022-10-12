package customer;

import order.Meal;

import order.Order;
import table.Table;
import table.TableList;

/**
 * Her yeni müþteri nesnesi için id'yi otomatik arttýrýr. 
 * Finish order ile masanýn doluluðu set edilir. 
 * Add cooked meal ile sipariþ kontrolü sonrasý masadan ayrýlma gerçekleþir.
 *
 */
public class Customer {
	private int id;
	private Order order;
	private Table table;

	private static int lastId = 0;

	public Customer() {
		this.id = lastId++;
		order = new Order();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public void finishOrder() {
		TableList.instance.setTableEmpty(table, this, true);
	}

	public String toString() {
		return String.valueOf(id) + " " + order + " " + (table != null ? table.toString() : "null");
	}

	public void addCookedMeal(Meal meal) {
		order.getMealHaveBeenDone().add(meal);

		if (order.getMeals().size() == order.getMealHaveBeenDone().size()) {
			TableList.instance.setTableEmpty(table, null, true);
			System.out.println(getId() + 1 + ". customer left the restaurant.");

		}

	}

}
