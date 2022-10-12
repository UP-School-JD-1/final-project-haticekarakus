package waiter;

import java.util.ArrayList;
/**
 * Garson sayýsý waiter count ile ayarlanýr.
 * get free waiter ile is meþguliyeti false olan garson çekilir.
 *
 */
public class WaiterList {
	public static WaiterList instance = null;
	private ArrayList<Waiter> waiters;
	
	private int WaiterCount = 5;
	
	public WaiterList() {
		if(instance != null)
			return;
		instance = this;
		
		waiters = new ArrayList<>();
		for(int i = 0; i < WaiterCount; i++)
			waiters.add(new Waiter());
		
	}
	public Waiter getFreeWaiter() {
		for(Waiter wait: waiters)
			if(!wait.isBusy())
				return wait;
		return null;
	}
}
