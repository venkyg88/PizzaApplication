package testing;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import assignment.PizzaApplication;
import assignment.OrderData;
import java.util.List;
import java.util.ArrayList;

public class PizzaApplicationTest {
	
	private List<OrderData> orderList = new ArrayList<>();
	private void setUp() {
		//We will create a OrderData list from a few values and use for testing
		
		OrderData order = new OrderData();
		orderList.add(order);
	}

	@Test
	public void test() throws Exception {
		final File file = new File("/Users/venkat/Documents/workspace/PizzaApplication/src/test_file.txt");
		
		List<OrderData> value = new ArrayList<>();
		value = PizzaApplication.readLinesAndSort(file);
		
		boolean flag = value.equals(orderList);
		
	}
	
	
	@Test
	public void testOutputDate() {
		String desired = "Mon, Sep 19, '16 2:24 PM";
		String expected = PizzaApplication.convertToReadableDate(1474295087);
		assertEquals(desired, expected);
	}
	
	@Test
	public void testForDate(){
		String desired = "Mon, Sep 09, '16 09:04 PM";
		String expected = PizzaApplication.convertToReadableDate(56);
		assertFalse(desired.equals(expected));
	}
	
	@Test
	public void testForOutputList() {		
		assertEquals(0, PizzaApplication.getOutputList(orderList).size());
	}

}
