package cimponents;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DatePicker {
	
	private static WebDriver driver;
    private By datepickerbox =  By.id("datepicker");
    private By period = By.cssSelector(".datepicker-days table th[class='datepicker-switch']");
	private By prevArrow = By.cssSelector(".datepicker-days thead th[class='prev']");
	private By nextArrow = By.cssSelector(".datepicker-days thead th[class='next']"); 
	private String day_FORMAT = "//td[text()='%d' and @class='day']";
	private String day_FORMAT_Today = "//td[text()='%d' and @class='today day']";
	
	
	public DatePicker(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LocalDate chooseDate(LocalDate date)
	{
		open();
		chooseMonth(date);
		chooseDay(date.getDayOfMonth());
		return getSelectedDate();
	}
	
	public void chooseDay(int dayOfMonth) {
	
		try {
			By locator  = By.xpath(String.format(day_FORMAT, dayOfMonth));
			driver.findElement(locator).click();
		}
		catch (Exception e)
		{
			By locator  = By.xpath(String.format(day_FORMAT_Today, dayOfMonth));
			driver.findElement(locator).click();
		}
		
		
		
		
	}

	public void chooseMonth(LocalDate date) {
		
		//get current month
		var currentPeriod = getCurrentPeriod();
				
		//compare current with destination
		long monthsAway = ChronoUnit.MONTHS.between(currentPeriod, date);
		System.out.println(monthsAway);
		
		//which are to use?
		By arrow = monthsAway < 0 ? prevArrow : nextArrow ;
		
		//click arrow
		for(int i =0 ; i < Math.abs(monthsAway); i++)
		{
			driver.findElement(arrow).click();
		}
		
		System.out.println(arrow);
	
			
	}
	
	public LocalDate getSelectedDate()
	{
	
		var fields = driver.findElement(datepickerbox).getAttribute("value").split("/");
		
		return LocalDate.of(Integer.parseInt(fields[2]), Integer.parseInt(fields[0]), Integer.parseInt(fields[1]));
	}

	private LocalDate getCurrentPeriod() {
		var currentPeriod = driver.findElement(period).getText().split(" ");
		
		
		return  LocalDate.of(Integer.parseInt(currentPeriod[1]), Month.valueOf(currentPeriod[0].toUpperCase()), 20);
	}

	public void open()
	{
		driver.findElement(datepickerbox).click();
	}
}
