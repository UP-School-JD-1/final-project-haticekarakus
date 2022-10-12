package table;

import java.util.ArrayList;

import waiter.WaiterWorks;
import customer.Customer;
import customer.WaitingCustomer;

/**
 * masa sayýsý table count deðiþkeni ile ayarlanabilir. Constructor 
 * içerisinde bu sayýya göre bir masa listesi oluþturulur. isTableEmpty metodu
 * ile masanýn boþ olup olmadýðýnýn kontrolü gerçekleþtrilir. setTableEmpty
 * metodu masa,müþteri ve boolean bir deðer alarak eðer true gönderilmiþse
 * bekleyen listesinden bir müþteri alýp masaya oturtur. masanýn is empty deðeri
 * false'a çekilip create waiter prep work çaðýrýlýr.
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
