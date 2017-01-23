package assignment;

public class OrderData {
	
	private String pizzaType;
	private long epochTime;
	
	public String getPizzaType() {
		return pizzaType;
	}
	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}
	public long getEpochTime() {
		return epochTime;
	}
	public void setEpochTime(long epochTime) {
		this.epochTime = epochTime;
	}
	
	@Override
	public String toString() {
		return pizzaType  + " " + epochTime;
	}
}
