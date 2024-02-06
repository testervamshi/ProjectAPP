package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement txt_firstname;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement txt_lastname;
	
	@FindBy(xpath="//input[@id='email_address']")
	WebElement text_email;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txt_pwd;
	
	@FindBy(xpath="//input[@name='password_confirmation']")
	WebElement txt_Cnfpwd;
	
	@FindBy(xpath="//button//span[text()='Create an Account']")
	WebElement btn_Register;
	
	public void setFirstname(String uname) {
		txt_firstname.sendKeys(uname);
	}
	
	public void setLastname(String lname) {
		txt_lastname.sendKeys(lname);
	}
	
	public void setEmail(String mailid) {
		text_email.sendKeys(mailid);
	}
	
	public void setPassword(String password) {
		txt_pwd.sendKeys(password);
	}
	
	public void setCnfPassword(String password) {
		txt_Cnfpwd.sendKeys(password);
	}
	
	public void clickRegister() {
		btn_Register.click();
	}
}
