package testingAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class search {
	
	@FindBy(xpath = "//*[@id=\"jenkins\"]")
	private WebElement softwareText3;
	
	public WebElement createPage() {
		return softwareText3;
	}
	
	@FindBy(xpath = "//*[@id=\"person-testy\"]/td[2]/a")
	private WebElement softwareText;
	
	public WebElement findTesty() {
		return softwareText;
	}
	
	@FindBy(xpath = "//*[@id=\"people\"]/tbody/tr[2]/td[2]/a")
	private WebElement softwareText2;
	
	public WebElement findPeople() {
		return softwareText2;
	}

}
