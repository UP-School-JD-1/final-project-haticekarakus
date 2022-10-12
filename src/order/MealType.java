package order;

public enum MealType {
	Food(3), Drink(2);

	public final int maxCount;

	private MealType(int count) {
		this.maxCount = count;
	}
}
