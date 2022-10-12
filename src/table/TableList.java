package table;

import java.util.ArrayList;

import waiter.WaiterWorks;
import customer.Customer;
import customer.WaitingCustomer;

/**
 * masa say�s� table count de�i�keni ile ayarlanabilir. Constructor 
 * i�erisinde bu say�ya g�re bir masa listesi olu�turulur. isTableEmpty metodu
 * ile masan�n bo� olup olmad���n�n kontrol� ger�ekle�trilir. setTableEmpty
 * metodu masa,m��teri ve boolean bir de�er alarak e�er true g�nderilmi�se
 * bekleyen listesinden bir m��teri al�p masaya oturtur. masan�n is empty de�eri
 * false'a �ekilip create waiter prep work �a��r�l�r.
 */

public class TableList {
	public static TableList instance = null;
	private ArrayList<Table> tables;

	private int TableCount = 8;

	public TableList() {
		if (instance != null)
			return;
		instance = this;

		tables = new ArrayList<>();
		for (int i = 0; i < TableCount; i++)
			tables.add(new Table());
	}

	public Table isTableEmpty() {
		for (Table table : tables)
			if (table.isEmpty())
				return table;
		return null;
	}

	public void setTableEmpty(Table table, Customer cust, boolean isEmpty) {
		if (isEmpty) {
			if (WaitingCustomer.instance.getCustomers().size() != 0) {
				table.setCustomer(WaitingCustomer.instance.getCustomers().get(0));
				WaitingCustomer.instance.getCustomers().remove(0);
				table.getCustomer().setTable(table);
				table.setEmpty(false);

				WaiterWorks.instance.createWaiterPrepWork(table.getCustomer());
			} else {
				table.setCustomer(null);
				table.setEmpty(true);
			}
		} else {
			table.setCustomer(cust);
			table.getCustomer().setTable(table);
			table.setEmpty(false);

			WaiterWorks.instance.createWaiterPrepWork(table.getCustomer());
		}

//		for(Table tab: tables)
//			System.out.print( tab.ID + "-" + tab.isEmpty + ", ");
	}

}
