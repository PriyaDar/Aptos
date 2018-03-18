import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AptosMain {
/**
 * this is the main method
 * @param args
 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\priya\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver  driver=new ChromeDriver();
		List <Customer>customers = new ArrayList();	//ArrayList<String> fnames=new ArrayList<String>(5);	
		String[] fNames = {"FName","Testuser","TUser","TstUsr","TUserr"};
		String[] sNames = {"SurName","SrName","SName","SSName","SNName"};
		for (int i=0; i <5 ; i++){
			customers.add(customerRegistration(driver, fNames[i],sNames[i]));
		}
		
		for (Customer customer : customers) {
			System.out.println("Name:"+customer.getFirstName());
			System.out.println("Email:"+customer.getEmailId());
			System.out.println("Password:"+ customer.getPassword());
			System.out.println("Marketing Preference"+customer.getPrefText1());
			
		}

	}
	/**
	 * This method logins a customer using customer login page object
	 * @param driver
	 * @return
	 */
	private static Customer customerLogin(WebDriver driver) {

		return null;
	}
	/**
	 * This method registers a customer using customer registration page object
	 * @param driver
	 * @param fName
	 * @param sName
	 * @return customer
	 */
	private static Customer customerRegistration(WebDriver driver, String fName, String sName) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.getthelabel.com/");
		driver.findElement(By.xpath("//li[@class='action-list__item header__account']")).click();
		driver.findElement(By.xpath("//a[@class='primary-link']")).click();

		Long tm = System.currentTimeMillis();
		String password = "Password1!";
		String emaild = "testuser."+tm.longValue()+"@gmail.com";

		Customer cus= new Customer();
		cus.setFirstName(fName);
		cus.setSurName(sName);
		cus.setEmailId(emaild);
		cus.setPassword(password);
		Select select=new Select(driver.findElement(By.id("title")));
		select.selectByIndex(3);
		CustomerRegistrationPageObject register=PageFactory.initElements(driver,CustomerRegistrationPageObject.class);

		register.customerRegister(fName, sName, emaild, "07457457545", "Password1!", "Password1!");
		Select day=new Select(driver.findElement(By.id("day")));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		day.selectByIndex(getRandomDayIndex());
		Select month=new Select(driver.findElement(By.id("month")));
		month.selectByIndex(4);
		Select year=new Select(driver.findElement(By.id("year")));
		year.selectByIndex(8);

		WebElement checkbox1=driver.findElement(By.xpath(".//*[@id='marketing_list']/div[1]/div/label"));
		if (getRandomBoolean())
		{
			String ch1=checkbox1.getText();
			cus.setPrefText1(ch1);
			checkbox1.click();
			cus.setPerf1(false);
		} else {
			cus.setPrefText1(checkbox1.getText());
			cus.setPerf1(true);
		}
		register.clickonRegisterButton();
		driver.getPageSource().contains("My account details");
		register.signoutbutton();
		return cus;
	}
	public static boolean getRandomBoolean() {
		return Math.random() < 0.5;//returns true or false randomly
	}
	public static int getRandomDayIndex() {
		Random randomNum=new Random();
		int  min=0;
		int max=30;
		int result=min+randomNum.nextInt(max);
		return result;
		
		//return Math.random() < 0.5;//returns true or false randomly
	}
}
