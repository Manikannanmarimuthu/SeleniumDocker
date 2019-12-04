package com.mercury.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mercury.pages.FindFlightPage;
import com.mercury.pages.FlightConfirmationPage;
import com.mercury.pages.FlightDetailsPage;
import com.mercury.pages.RegisterDetailsPage;
import com.mercury.pages.RegistrationConfirmationPage;
import com.qa.test.BaseTest;

public class BookFlightTest extends BaseTest {

	private String noOfPassengers;
	private String expectedPrice;

	@BeforeMethod
	@Parameters({ "noOfPassengers", "expectedPrice" })
	public void setupParameters(String noOfPassengers, String expectedPrice) {
		this.noOfPassengers = noOfPassengers;
		this.expectedPrice = expectedPrice;
	}

	@Test
	public void registerPageDetailsPage() {
		RegisterDetailsPage registerPageDetails = new RegisterDetailsPage(driver);
		registerPageDetails.launchRegisterPage();
		registerPageDetails.enterContactInfo("Manikannan", "Marimuthu", "8754546460", "manikannan@mvitech.com");
		registerPageDetails.enterMailingInfo("Chrompet", "Radha Nagar", "Chennai", "TN", "621701", "INDIA");
		registerPageDetails.enterUserInfo("manikannanmarimuthu", "mani123", "mani123");
		registerPageDetails.clickSubmit();
	}

	@Test(dependsOnMethods = "registerPageDetailsPage")
	public void registrationCondfirmationPage() {
		RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
		registrationConfirmationPage.goToFlightDetailsPage();
	}

	@Test(dependsOnMethods = "registrationCondfirmationPage")
	public void flightDetailsPage() {
		FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
		flightDetailsPage.selectPassengers(noOfPassengers);
		flightDetailsPage.goToFindFlightsPage();
	}

	@Test(dependsOnMethods = "flightDetailsPage")
	public void findFlightPage() {
		FindFlightPage findFlightPage = new FindFlightPage(driver);
		findFlightPage.submitFindFlightPage();
		findFlightPage.goToFlightConfirmationPage();
	}

	@Test(dependsOnMethods = "findFlightPage")
	public void fligtConfirmationPage() {
		FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
		Assert.assertEquals(flightConfirmationPage.getPrice(), expectedPrice);
	}

}
