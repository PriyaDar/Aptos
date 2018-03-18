import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
/**
 * This  page object contains the main elements on customer registration page
 */
public class CustomerRegistrationPageObject {
	WebDriver driver;
	@FindBy(how=How.ID,using="firstName")WebElement firstName;
	@FindBy(how=How.ID,using="surname")WebElement surName;
	@FindBy(how=How.XPATH,using="//*[@id='form-registerEmail' and @class='form-group' ]/div[@class='form-group__input']/input[@id='email']")WebElement email;
	@FindBy(how=How.ID,using="telephone")WebElement telephone;
	@FindBy(how=How.ID,using="newPassword")WebElement newPassword;
	@FindBy(how=How.ID,using="confirmPassword")WebElement confirmPassword;
	@FindBy(how=How.XPATH,using="//div[@class='form-group__btn']/button[@class='form-button form-block btn btn--success btn--scale button']/span[contains(text(),'Create Account')]")WebElement createButton;
	@FindBy(how=How.XPATH,using="//li/form[@class='ng-pristine ng-valid']/button[@class='form-button form-block account-logout-link button']") WebElement signout;

	public void customerRegister( String uFirstName,
			String uSurname, String uEmail, String uTelephone,
			String uNewPassword, String uConfirmPassword) 
	{

		this.firstName.sendKeys(uFirstName);
		this.surName.sendKeys(uSurname);
		this.email.sendKeys(uEmail);
		this.telephone.sendKeys(uTelephone);
		this.newPassword.sendKeys(uNewPassword);
		this.confirmPassword.sendKeys(uConfirmPassword);
	}

	/**register button method*/
	public void clickonRegisterButton() {

		createButton.click();	
	}
	/**
	 * Sign out button mehtod
	 */
	public void signoutbutton() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		signout.click();
	}
}


































