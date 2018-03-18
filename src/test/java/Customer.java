
/**
 * This class pojo (plain old java object or value object)to hold each customer information.
 */
public class Customer {
	String firstName;
	String surName;
	String emailId;


	String telephone;
	String password;
	String confirmPassword;
	String prefText1;
	String prefText2;

	boolean perf1;
	boolean perf2;

	public String getPrefText1() {
		return prefText1;
	}
	public void setPrefText1(String prefText1) {
		this.prefText1 = prefText1;
	}
	public String getPrefText2() {
		return prefText2;
	}
	public void setPrefText2(String prefText2) {
		this.prefText2 = prefText2;
	}
	public boolean isPerf1() {
		return perf1;
	}
	public void setPerf1(boolean perf1) {
		this.perf1 = perf1;
	}
	public boolean isPerf2() {
		return perf2;
	}
	public void setPerf2(boolean perf2) {
		this.perf2 = perf2;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
