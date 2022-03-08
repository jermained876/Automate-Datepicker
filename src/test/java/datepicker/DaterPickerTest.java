package datepicker;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.testng.annotations.Test;

import base.BaseTests;
import cimponents.DatePicker;

public class DaterPickerTest extends BaseTests {
	
	
	public void pastDate()
	{
		//December 20 1989
		
		var dateToSelect = LocalDate.of(1986, Month.DECEMBER, 20);
		var selectedDate = new DatePicker(driver).chooseDate(dateToSelect);
		//Verify Date
		assertEquals(dateToSelect, selectedDate);
		
	//	assertEquals(dateToSelect, )
	}
	
	 void futureDate()
	{
		//August 3 2025

		var dateToSelect = LocalDate.of(2025, Month.AUGUST, 3);
		var selectedDate = new DatePicker(driver).chooseDate(dateToSelect);
		//Verify Date
		assertEquals(dateToSelect, selectedDate);
	}
	
	@Test
	public void currentDate()
	{
		
		//August 3 2025

				var dateToSelect = LocalDate.of(2001, Month.MARCH, 2);
				var selectedDate = new DatePicker(driver).chooseDate(dateToSelect);
				//Verify Date
				assertEquals(dateToSelect, selectedDate);
		
	}

}
