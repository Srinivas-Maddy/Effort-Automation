package com.effort.pages.routes;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.effort.base.BaseAutomationPage;

public class RoutePlanFilterPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(RoutePlanFilterPage.class.getName());

	@FindBy(id = "filters")
	private WebElement filters_Btn;

	@FindBy(id = "cmpltdStats")
	private WebElement completed_Chk;

	@FindBy(id = "unCmpltdStats")
	private WebElement incompleted_Chk;

	@FindBy(id = "rjctdStats")
	private WebElement rejected_Chk;

	@FindBy(id = "todayRoutePlan")
	private WebElement todayRoutePlan_Chk;

	@FindBy(id = "pastRoutePlan")
	private WebElement pastRoutePlan_Chk;

	@FindBy(id = "upcomingRoutePlan")
	private WebElement upcomingRoutePlan_Chk;

	@FindBy(id = "manual")
	private WebElement manualSpecify_Chk;

	@FindBy(id = "select2-chosen-3")
	private WebElement selectEmployee_Dpr;

	@FindBy(id = "reset")
	private WebElement reset_Btn;

	@FindBy(id = "search")
	private WebElement apply_Btn;

	@FindBy(xpath = "//font[contains(text(),'Incomplete')]")
	private List<WebElement> incomplete_Txt;

	@FindBy(xpath = "//font[contains(text(),'Completed')]")
	private List<WebElement> completed_Txt;

	@FindBy(xpath = "//font[contains(text(),'Rejected')]")
	private List<WebElement> rejected_Txt;

	@FindBy(xpath = "(//tr[@class='odd']//td)[5]")
	private WebElement todayRouteStartTime_Txt;

	@FindBy(xpath = "(//tr[@class='odd']//td)[6]")
	private WebElement employee_Txt;

	@FindBy(id = "formDateTime")
	private WebElement startBetween_Txt;

	@FindBy(xpath = "//div[@class='xdsoft_mounthpicker']//button[@class='xdsoft_prev']")
	private WebElement back_Icon;

	@FindBy(xpath = "//div[contains(@class,'xdsoft_time xdsoft_current')]")
	private List<WebElement> currentTime_Txt;

	@FindBy(id = "toDateTime")
	private WebElement toDate_Txt;

	@FindBy(xpath = "//div[@role='option']")
	private List<WebElement> employeeName_Txt;

	public RoutePlanFilterPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);

	}

	public static String EmployeeName;

	public void clickOnTodaysRoutePlanCheckBox() {
		logger.info("Starting of clickOnTodaysRoutePlanCheckBox Method");

		waitUntilElementVisible(driver, this.todayRoutePlan_Chk);
		this.todayRoutePlan_Chk.click();

		logger.info("Ending of clickOnTodaysRoutePlanCheckBox Method");
	}

	public void clickOnFiltersButton() {
		logger.info("Starting of clickOnFiltersButton Method");

		waitUntilElementVisible(driver, this.filters_Btn);
		this.filters_Btn.click();

		logger.info("Ending of clickOnFiltersButton Method");
	}

	public void clickOnPastRoutePlan() {
		logger.info("Starting of clickOnPastRoutePlan Method");

		waitUntilElementVisible(driver, this.pastRoutePlan_Chk);
		this.pastRoutePlan_Chk.click();

		logger.info("Ending of clickOnPastRoutePlan Method");
	}

	public void clickOnUpcomingRoutePlan() {
		logger.info("Starting of clickOnUpcomingRoutePlan Method");

		waitUntilElementVisible(driver, this.upcomingRoutePlan_Chk);
		this.upcomingRoutePlan_Chk.click();

		logger.info("Ending of clickOnUpcomingRoutePlan Method");
	}

	public void clickOnApplyButton() {
		logger.info("Starting of clickOnApplyButton Method");

		waitUntilElementVisible(driver, this.apply_Btn);
		this.apply_Btn.click();

		logger.info("Ending of clickOnApplyButton Method");
	}

	public void clickOnResetButton() {
		logger.info("Starting of clickOnResetButton Method");

		waitUntilElementVisible(driver, this.reset_Btn);
		this.reset_Btn.click();

		logger.info("Ending of clickOnResetButton Method");
	}

	public void clickOnCompletedCheckBox() {
		logger.info("Starting of clickOnCompletedCheckBox Method");

		waitUntilElementVisible(driver, this.completed_Chk);
		this.completed_Chk.click();

		logger.info("Ending of clickOnCompletedCheckBox Method");
	}

	public void clickOnIncompletedCheckBox() {
		logger.info("Starting of clickOnIncompletedCheckBox Method");

		waitUntilElementVisible(driver, this.incompleted_Chk);
		this.incompleted_Chk.click();

		logger.info("Ending of clickOnIncompletedCheckBox Method");
	}

	public void clickOnRejectedCheckBox() {
		logger.info("Starting of clickOnRejectedCheckBox Method");

		waitUntilElementVisible(driver, this.rejected_Chk);
		this.rejected_Chk.click();

		logger.info("Ending of clickOnRejectedCheckBox Method");
	}

	public void clickOnEmployeeDropDown() {
		logger.info("Starting of clickOnEmployeeDropDown Method");

		scrollIntoView(selectEmployee_Dpr);
		waitUntilElementVisible(driver, this.selectEmployee_Dpr);
		this.selectEmployee_Dpr.click();

		logger.info("Ending of clickOnEmployeeDropDown Method");
	}

	public void setToDate() {
		logger.info("Starting of setToDate Method");

		waitUntilElementVisible(driver, this.toDate_Txt);
		this.toDate_Txt.click();
		hardWait(1);
		try {
			waitUntilElementVisible(driver, this.currentTime_Txt.get(1));
			this.currentTime_Txt.get(1).click();

		} catch (Exception e) {
			mouseHoverAndClick(currentTime_Txt.get(1));
		}
		logger.info("Ending of setToDate Method");
	}

	public void clickOnManualSpecifyCheckBox() {
		logger.info("Starting of clickOnManualSpecifyCheckBox Method");

		scrollIntoView(manualSpecify_Chk);
		waitUntilElementVisible(driver, this.manualSpecify_Chk);
		this.manualSpecify_Chk.click();

		logger.info("Ending of clickOnManualSpecifyCheckBox Method");
	}

	public void setStartBetweenDate() {
		logger.info("Starting of setStartBetweenDate Method");

		waitUntilElementVisible(driver, this.startBetween_Txt);
		this.startBetween_Txt.click();

		for (int i = 1; i < 13; i++) {
			hardWait(1);
			this.back_Icon.click();
		}

		try {
			waitUntilElementVisible(driver, this.currentTime_Txt.get(0));
			this.currentTime_Txt.get(0).click();

		} catch (Exception e) {
			mouseHoverAndClick(currentTime_Txt.get(0));
		}
		logger.info("Ending of setStartBetweenDate Method");
	}


	public void selectEmployee() {
		logger.info("Starting of selectEmployee Method");

		waitUntilElementVisible(driver, this.employeeName_Txt.get(1));
		EmployeeName = employeeName_Txt.get(1).getText();
		this.employeeName_Txt.get(1).click();

		logger.info("Ending of selectEmployee Method");
	}

	public boolean isIncompleteStatusDisplayed() {
		logger.info("Starting of isIncompleteStatusDisplayed Method");

		boolean isIncompleteStatusDisplayed = false;
		try {
			for (int i = 0; i < incomplete_Txt.size(); i++) {
				waitUntilElementVisible(driver, this.incomplete_Txt.get(i));
				if (incomplete_Txt.get(i).isDisplayed()) {
					if (i == incomplete_Txt.size() - 1) {
						isIncompleteStatusDisplayed = true;
					}

				}
			}
		} catch (Exception e) {
			isIncompleteStatusDisplayed = false;
		}

		logger.info("Ending of isIncompleteStatusDisplayed Method");
		return isIncompleteStatusDisplayed;
	}

	public boolean isCompleteStatusDisplayed() {
		logger.info("Starting of isCompleteStatusDisplayed Method");

		boolean isCompleteStatusDisplayed = false;
		try {
			for (int i = 0; i < completed_Txt.size(); i++) {
				waitUntilElementVisible(driver, this.completed_Txt.get(i));
				if (completed_Txt.get(i).isDisplayed()) {
					if (i == completed_Txt.size() - 1) {
						isCompleteStatusDisplayed = true;
					}
				}
			}
		} catch (Exception e) {
			isCompleteStatusDisplayed = false;
		}

		logger.info("Ending of isCompleteStatusDisplayed Method");
		return isCompleteStatusDisplayed;
	}

	public boolean isRejectedStatusDisplayed() {
		logger.info("Starting of isRejectedStatusDisplayed Method");

		boolean isRejectedStatusDisplayed = false;
		try {
			for (int i = 0; i < rejected_Txt.size(); i++) {
				waitUntilElementVisible(driver, this.rejected_Txt.get(i));
				if (rejected_Txt.get(i).isDisplayed()) {
					if (i == rejected_Txt.size() - 1) {
						isRejectedStatusDisplayed = true;
					}
				}
			}
		} catch (Exception e) {
			isRejectedStatusDisplayed = false;
		}

		logger.info("Ending of isRejectedStatusDisplayed Method");
		return isRejectedStatusDisplayed;
	}

	public boolean isTodayRoutePlansDisplayed() {

		boolean isTodayRoutePlansDisplayed = false;
		try {
			waitUntilElementVisible(driver, this.todayRouteStartTime_Txt);
			System.out.println(todayRouteStartTime_Txt.getText());
			System.out.println(super.getCurrentDate());
			if (todayRouteStartTime_Txt.getText().equalsIgnoreCase(super.getCurrentDate())) {

				isTodayRoutePlansDisplayed = true;

			}
		} catch (Exception e) {
			isTodayRoutePlansDisplayed = false;
		}

		logger.info("Ending of isTodayRoutePlansDisplayed Method");
		return isTodayRoutePlansDisplayed;
	}

	public boolean isPastRoutePlansDisplayed() {
		logger.info("Starting of isPastRoutePlansDisplayed Method");

		boolean isPastRoutePlansDisplayed = false;
		try {
			waitUntilElementVisible(driver, this.todayRouteStartTime_Txt);
			System.out.println(todayRouteStartTime_Txt.getText());
			System.out.println(super.getCurrentDate());
			String dateMonth[] = todayRouteStartTime_Txt.getText().split("-");
			int year = Integer.valueOf(dateMonth[0]);
			int month = Integer.valueOf(dateMonth[1]);
			int date = Integer.valueOf(dateMonth[2]);

			String currentDateMonth[] = super.getCurrentDate().split("-");
			int currentYear = Integer.valueOf(currentDateMonth[0]);// currentDateMonth[0];
			int currentMonth = Integer.valueOf(currentDateMonth[1]);
			int currentDate = Integer.valueOf(currentDateMonth[2]);

			if (year == currentYear) {
				if (month == currentMonth) {
					if (date == currentDate) {

						isPastRoutePlansDisplayed = false;

					} else if (date < currentDate) {
						isPastRoutePlansDisplayed = true;
					}

				} else if (month < currentMonth) {
					isPastRoutePlansDisplayed = true;
				}
			} else if (year < currentYear) {
				isPastRoutePlansDisplayed = true;
			}

		} catch (Exception e) {
			isPastRoutePlansDisplayed = false;
		}

		logger.info("Ending of isPastRoutePlansDisplayed Method");
		return isPastRoutePlansDisplayed;
	}

	public boolean isUpcomingRoutePlansDisplayed() {
		logger.info("Starting of isUpcomingRoutePlansDisplayed Method");

		boolean isUpcomingRoutePlansDisplayed = false;
		try {
			waitUntilElementVisible(driver, this.todayRouteStartTime_Txt);
			System.out.println(todayRouteStartTime_Txt.getText());
			System.out.println(super.getCurrentDate());
			String dateMonth[] = todayRouteStartTime_Txt.getText().split("-");
			int year = Integer.valueOf(dateMonth[0]);
			int month = Integer.valueOf(dateMonth[1]);
			int date = Integer.valueOf(dateMonth[2]);

			String currentDateMonth[] = super.getCurrentDate().split("-");
			int currentYear = Integer.valueOf(currentDateMonth[0]);
			int currentMonth = Integer.valueOf(currentDateMonth[1]);
			int currentDate = Integer.valueOf(currentDateMonth[2]);

			if (year == currentYear) {
				if (month == currentMonth) {
					if (date == currentDate) {

						isUpcomingRoutePlansDisplayed = false;

					} else if (date > currentDate) {
						isUpcomingRoutePlansDisplayed = true;
					}

				} else if (month > currentMonth) {
					isUpcomingRoutePlansDisplayed = true;
				}
			} else if (year > currentYear) {
				isUpcomingRoutePlansDisplayed = true;
			}

		} catch (Exception e) {
			isUpcomingRoutePlansDisplayed = false;
		}

		logger.info("Ending of isUpcomingRoutePlansDisplayed Method");
		return isUpcomingRoutePlansDisplayed;
	}

	public boolean isSelectedEmployeeDisplayed() {

		boolean isSelectedEmployeeDisplayed = false;
		try {
			waitUntilElementVisible(driver, this.employee_Txt);
			if (employee_Txt.getText().equalsIgnoreCase(EmployeeName)) {

				isSelectedEmployeeDisplayed = true;

			}
		} catch (Exception e) {
			isSelectedEmployeeDisplayed = true;
		}

		logger.info("Ending of isSelectedEmployeeDisplayed Method");
		return isSelectedEmployeeDisplayed;
	}

}
