package table;

import customer.Customer;

/**
 * id, customer ve is empty de�i�kenlerine sahip bir class. Her table nesnesi
 * olu�tu�unda id'si bir artarak atan�r. �lk olu�tu�unda bo� olma durumu
 * true'dur.
 */

public class Table {
	private int id;

	private static int lastId = 1;

	private Customer customer = null;
	private boolean isEmpty = true;

	public Table() {
		this.id = lastId++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

}
