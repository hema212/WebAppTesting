package gsuitePageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePageObjects {
	public WebDriver driver;

	By Avatar = By.xpath("//span[@class='username-drop-down__span']");
	By AdminText = By.xpath("//ul[@class='MuiList-root MuiList-padding']/a[1]");
	By SignoutText = By.xpath("//span[contains(text(), 'Sign Out')]");
	By UsersText = By.xpath("//i[contains(text(), 'people')]");
	By ManageText = By.xpath("//div[contains(text(), 'Manage')]");
	By InviteText = By.xpath("//div[contains(text(), 'Invite')]");
	By EditInviteModalHeader = By.tagName("h5");
	By DeleteModalHeader = By.tagName("h5");
	By DeptValueInTable = By.xpath("//tbody[@class='MuiTableBody-root']/tr/td[3]");
	By StatusInTable = By.xpath("//tbody[@class='MuiTableBody-root']/tr/td[5]");
	By NumberOfUsersSize = By.xpath("//tbody[@class='MuiTableBody-root']/tr");
	By Row = By.tagName("tr");
	By Column = By.tagName("td");
	By UserOneDept = By.xpath("//tbody[@class='MuiTableBody-root']/tr[1]/td[3]");
	By UserOneStatus = By.xpath("//tbody[@class='MuiTableBody-root']/tr[1]/td[5]");
	By UserTwoDept = By.xpath("//tbody[@class='MuiTableBody-root']/tr[2]/td[3]");
	By UserTwoStatus = By.xpath("//tbody[@class='MuiTableBody-root']/tr[2]/td[5]");

	// Manage page xpaths
	By QuickSettingsText = By.xpath("//div[contains(text(), 'Quick Settings')]");
	By ConnectIdentityText = By.xpath("//div[@class='row']/../../div[3]/div/div[1]");
	By GSuiteIdentityIcon = By.xpath("//div[@class='row']/../../div[3]/div/div[4]/button[3]");
	By GSuiteIcon = By.xpath("//div[@class='row']/../../div[3]/div/div[4]/button[3]");
	By ManagePageEditIcon = By.xpath("//button[@aria-label='Edit'][1]");
	By ManagePageEditModalHeader = By.id("form-dialog-title");
	//By ManagePageDeleteIcon = By.xpath("//button[@aria-label='Edit'][2]");

	// GSuite Connect flow xpath for newly added user
	By SetupGSuiteFirstStepText = By.xpath("//div[@class='row top-buffer-row']/div/div/p[1]");
	By StepCount = By.xpath("//div[@class='row top-buffer-row']/div/div/p[2]");
	By CancelButton = By.xpath("//span[contains(text(), 'Cancel')]");
	By EditCancelButton = By.xpath("//span[contains(text(), 'Cancel')]");
	By ConnectGSuiteButton = By.xpath("//span[contains(text(), 'Connect G Suite')]");
	By GSuiteInputField = By.xpath("//input[@data-qa='signin_domain_input']");
	By GSuiteContinueSubmitButton = By.xpath("//button[@type='submit']");
	By GSuiteEmailInputField = By.xpath("//input[@data-qa='login_email']");
	By GSuitePwdInputField = By.xpath("//input[@data-qa='login_password']");
	By GSuiteSignInButton = By.xpath("//button[@id='signin_btn']");
	By AllowButton = By.xpath("//button[contains(text(), 'Allow')]");
	By AllowButtonSpan = By.xpath("//div[@class='dG5hZc']/div[1]/div/div/button");
	By GSuiteSigninHeaderText = By.xpath("//h1/span");
	By GSuiteSignInWorkspaceText = By.xpath("//div[@role='heading']");
	By GSuiteUserMailId = By.tagName("small");
	By otpField = By.id("totpPin");

	// Cancel button flow xpath
	By CancelModalHeader = By.xpath("//h5");
	By ImSureButton = By.xpath("//span[contains(text(), 'I’m sure')]");
	By NevermindButton = By.xpath("//span[contains(text(), 'Nevermind')]");

	// Disconnect button flow xpath
	By DisconnectGSuiteButton = By.xpath("//span[contains(text(), 'Disconnect G Suite')]");
	By DisconnectGSuiteModalHeader = By.xpath("//h5");
	By YesDisconnectIM = By.xpath("//span[contains(text(), 'Yes, disconnect it')]");
	By NokeepItIM = By.xpath("//span[contains(text(), 'No, keep it')]");

	// Radio button option for select people
	By SelectAllUsers = By.xpath("//input[@value='ALL_USERS']");
	By SelectOrgUnits = By.xpath("//input[@value='ORGUNITS']");
	By SelectGroups = By.xpath("//input[@value='GROUPS']");
	By ManuallyAddUsers = By.xpath("//input[@value='SELECTED_USERS']");
	By ContinueNext = By.xpath("//div[@data-testid='nextButton']");
	By EngineeringOrgUnit = By.xpath("//div[contains(text(), 'Engineering')]/../span/span/input");
	By TotalOrgunitMember = By.xpath("//div[contains(text(), 'Engineering')]/following-sibling::div");
	By ActiveMembersCount = By.xpath("//div[@class='sc-bdnylx iIpJwe']/following-sibling::div[1]");

	// Select people page continue button
	By ContinueWithEveryoneButton = By.xpath("//span[contains(text(), 'Continue with Everyone')]");

	// Configure Invites Button xpath
	By ConfigureInvitesBackButton = By.xpath("//span[contains(text(), 'Back')]");
	By CreateAssemblyAccountsButton = By.xpath("//span[contains(text(), 'Create Assembly Accounts')]");

	// Radio button option xpath for Configure Invites
	By SendInvitationsNowRadio = By.xpath("//div[contains(text(), 'Ready')]/../div[3]/label[1]/span[1]/span/input[1]");
	By SendThemLaterRadio = By.xpath("//div[contains(text(), 'Ready')]/../div[3]/label[2]/span[1]/span/input[1]");
	By AutoApproveRadio = By.xpath("//div[contains(text(), 'Auto')]/../div[3]/label[1]/span[1]/span/input[1]");
	By AdminApproveRadio = By.xpath("//div[contains(text(), 'Auto')]/../div[3]/label[2]/span[1]/span/input[1]");
	By SaveSettingsButton = By.xpath("//span[contains(text(), 'Save Settings')]");
	By CloseButton = By.xpath("//span[contains(text(), 'Close')]");

	// Create Accounts Button xpath
	By viewPeopleInviteButton = By.xpath("//span[contains(text(), 'View')]");

	// Edit connection Button
	By EditConnectionButton = By.xpath("//span[contains(text(), 'Edit Connection')]");

	// Upgarde now feature xpath
	By UpgradeNowFeature = By.xpath("//span[@data-cy='premium-crown-icon']");
	By BusinessPlanRadioButton = By.xpath("//input[@value='business']");
	By TeamPlanRadioButton = By.xpath("//input[@value='team']");
	By UpgradePlanText = By.xpath("//h3/../../div/h3");
	By UpgradePlanNextButton = By.xpath("//span[contains(text(), 'Next')]");
	By SetUpPaymentBackButton = By.xpath("//span[contains(text(), 'Back')]");
	By SetUpPaymentNextButton = By.xpath("//span[contains(text(), 'Next >')]");
	By ApplyButton = By.xpath("//span[contains(text(), 'Apply')]");
	By SetUpAlertMessage = By.xpath("//div[@role='alert']");
	By CardNameInputField = By.xpath("//input[@placeholder='Name as seen on card']");
	By IframeCardNumber = By.xpath("//iframe[@title='Secure card number input frame']");
	By CardNumberInputField = By.xpath("//input[@placeholder='5555 0000 0000 1234']");
	By IframeExpiryDate = By.xpath("//iframe[@title='Secure expiration date input frame']");
	By CardExpiryDateField = By.xpath("//input[@placeholder='Expiration date']");
	By IframeCvcNumber = By.xpath("//iframe[@title='Secure CVC input frame']");
	By CardCvcField = By.xpath("//input[@placeholder='CVC']");
	By PromCodeInputField = By.xpath("//input[@placeholder='Promo code?']");
	By ReviewBillBackButton = By.xpath("//span[contains(text(), 'Back')]");
	By ReviewBillConfirm = By.xpath("//span[contains(text(), 'Confirm')]");
	By successToast = By.xpath("//span[@id='client-snackbar']");
	By ReviewBillingContent = By.xpath("//h3/../div[1]");

	// SSO xpaths
	By SignInWithGSuiteSSOClick = By.xpath("//h5/../div[1]/div/div/div[4]");
	By SignInWithGSuiteButton = By.xpath("//span[contains(text(), 'Sign in with Google')]");
	By DifferentAssemblyAccount = By.xpath("//div[@class='c-menu_select']");
	By GsuiteSsoSignIn = By.xpath("//h5/../div[1]/div/div[2]/button");
	By SelectGsuiteUser = By.xpath("//div[@data-identifier='hemaramakrishna@my.joinassembly.com']");
	By GsuiteAllow = By.xpath("//div[@class='dG5hZc']/div[1]/div[1]/div[1]/button[1]");
	By AcceptGsuiteConsent = By.xpath("//input[@value='Accept']");
	By GsuiteEmail = By.xpath("//input[@id='identifierId']");
	By SubmitEmail = By.xpath("//input[@id='identifierId']");
	By GsuitePwd = By.xpath("//input[@aria-label='Enter your password']");
	By GsuiteNextButton = By.xpath("//div[@class='zQJV3']/div/div[1]/div/div/button");
	By GsuiteSignInHeader = By.xpath("//h1/span");
	By DepartmentLabel = By.tagName("label");
	

	// GSuite connected with other assembly
	By GSuiteAccountMessageMismatchError = By.xpath("//div[@role='alert']");

	// Queued Invites
	By SelectAllCheckBox = By.xpath("//input[@type='checkbox']");
	By EditButton = By.xpath("//div[@class='row row-container__div '][1]/div/button[1]");
	By BulkApprove = By.xpath("//div[@class='row row-container__div '][1]/div/button[2]");
	By DeleteButton = By.xpath("//div[@class='row row-container__div '][1]/div/button[3]");
	By DepartmentDropdown = By.id("department-select");
	By DesignerDept = By.xpath("//li[@data-value='Design & User Experience']");
	By SelectStatus = By.id("status-select");
	By GiverStatus = By.xpath("//li[@data-value='giver']");
	By ReceiverStatus = By.xpath("//li[@data-value='receiver']");
	By ConfirmInvite = By.xpath("//span[contains(text(), 'Confirm')]");
	By InvitesBreadcrum = By.xpath("//span[@class='admin-breadcrumps-secondary__span']");
	By SingleUserSelectToEdit = By.xpath("//th[contains(text(), 'Assembly Alerts')]/../td[1]/span");
	By UserNameFullName = By.id("standard-name");
	By DepartmentDropdownEditEmployee = By.id("standard-select-department");
	By HumanResourceDept = By.xpath("//li[@data-value='Human Resources']");
	By BirthMonthDropDown = By.id("standard-select-birth-month");
	By BirthMonthSelect = By.xpath("//li[@data-value='June']");
	By BirthDayDropDown = By.id("standard-select-birth-day");
	By BirthDayDate = By.xpath("//li[@data-value='16']");
	By HelperBirthMonthError = By.id("standard-select-birth-month-helper-text");
	By HelperNameError = By.id("standard-name-helper-text");
	By BulkApproveModalHeaderText = By.xpath("//div[@data-test='sentinelEnd']/../div[3]/h3");
	By NoDataAvailableText = By.xpath("//div[@class='row row-container__div admin-fixed-width__div']/div");
	By AssemblyUserText = By.xpath("//th[contains(text(), 'Assembly')]");

	By ManagePageDeleteIcon = By.xpath("//div[@class='row row-container__div '][1]/div/div[3]/button[2]");
	By RemovButtonText = By.xpath("//span[contains(text(), 'Remove')]");

	By botObject = By.xpath("//div[@class='intercom-crher1 e2ujk8f3']");
	By botFrame = By.xpath("//iframe[@name='intercom-launcher-frame']");

	public GooglePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement avatarIcon() {
		return this.driver.findElement(Avatar);
	}

	public WebElement QuickSettingsText() {
		return this.driver.findElement(QuickSettingsText);
	}

	public WebElement SignoutText() {
		return this.driver.findElement(SignoutText);
	}

	public WebElement AdminText() {
		return this.driver.findElement(AdminText);
	}

	public WebElement UsersText() {
		return this.driver.findElement(UsersText);
	}

	public WebElement ManageText() {
		return this.driver.findElement(ManageText);
	}

	public WebElement InviteText() {
		return this.driver.findElement(InviteText);
	}

	public List<WebElement> NumberOfUsersSize() {
		return this.driver.findElements(NumberOfUsersSize);
	}

	public List<WebElement> Row() {
		return this.driver.findElements(Row);
	}

	public List<WebElement> Column() {
		return this.driver.findElements(Column);
	}

	public WebElement UserOneDept() {
		return this.driver.findElement(UserOneDept);
	}

	public WebElement UserOneStatus() {
		return this.driver.findElement(UserOneStatus);
	}

	public WebElement UserTwoDept() {
		return this.driver.findElement(UserTwoDept);
	}

	public WebElement UserTwoStatus() {
		return this.driver.findElement(UserTwoStatus);
	}

	public WebElement EditInviteModalHeader() {
		return this.driver.findElement(EditInviteModalHeader);
	}

	public WebElement DeleteModalHeader() {
		return this.driver.findElement(DeleteModalHeader);
	}

	public WebElement DeptValueInTable() {
		return this.driver.findElement(DeptValueInTable);
	}

	public WebElement StatusInTable() {
		return this.driver.findElement(StatusInTable);
	}

	public WebElement ConnectIdentityText() {
		return this.driver.findElement(ConnectIdentityText);
	}

	public WebElement GSuiteIdentityIcon() {
		return this.driver.findElement(GSuiteIdentityIcon);
	}

	public WebElement GSuiteIcon() {
		return this.driver.findElement(GSuiteIcon);
	}
	
	public WebElement ManagePageEditIcon() {
		return this.driver.findElement(ManagePageEditIcon);
	}
	
	public WebElement ManagePageEditModalHeader() {
		return this.driver.findElement(ManagePageEditModalHeader);
	}

	public WebElement SetupStepText() {
		return this.driver.findElement(SetupGSuiteFirstStepText);
	}

	public WebElement StepCount() {
		return this.driver.findElement(StepCount);
	}

	public WebElement CancelButton() {
		return this.driver.findElement(CancelButton);
	}

	public WebElement EditCancelButton() {
		return this.driver.findElement(EditCancelButton);
	}

	public WebElement ConnectGSuiteButton() {
		return this.driver.findElement(ConnectGSuiteButton);
	}

	public WebElement GSuiteInputField() {
		return this.driver.findElement(GSuiteInputField);
	}

	public WebElement GSuiteContinueSubmitButton() {
		return this.driver.findElement(GSuiteContinueSubmitButton);
	}

	public WebElement GSuiteEmailInputField() {
		return this.driver.findElement(GSuiteEmailInputField);
	}

	public WebElement GSuitePwdInputField() {
		return this.driver.findElement(GSuitePwdInputField);
	}

	public WebElement GSuiteSignInButton() {
		return this.driver.findElement(GSuiteSignInButton);
	}

	public WebElement AllowButton() {
		return this.driver.findElement(AllowButton);
	}

	public WebElement AllowButtonSpan() {
		return this.driver.findElement(AllowButtonSpan);
	}

	public WebElement GSuiteSigninHeaderText() {
		return this.driver.findElement(GSuiteSigninHeaderText);
	}

	public WebElement DepartmentLabel() {
		return this.driver.findElement(DepartmentLabel);
	}

	public WebElement GSuiteSignInWorkspaceText() {
		return this.driver.findElement(GSuiteSignInWorkspaceText);
	}

	public WebElement GSuiteUserMailId() {
		return this.driver.findElement(GSuiteUserMailId);
	}

	public WebElement otpField() {
		return this.driver.findElement(otpField);
	}

	public WebElement CancelModalHeader() {
		return this.driver.findElement(CancelModalHeader);
	}

	public WebElement ImSureButton() {
		return this.driver.findElement(ImSureButton);
	}

	public WebElement NevermindButton() {
		return this.driver.findElement(NevermindButton);
	}

	public WebElement DisconnectGSuiteButton() {
		return this.driver.findElement(DisconnectGSuiteButton);
	}

	public WebElement DisconnectGSuiteModalHeader() {
		return this.driver.findElement(DisconnectGSuiteModalHeader);
	}

	public WebElement YesDisconnectIM() {
		return this.driver.findElement(YesDisconnectIM);
	}

	public WebElement NokeepItIM() {
		return this.driver.findElement(NokeepItIM);
	}

	public WebElement SelectAllUsers() {
		return this.driver.findElement(SelectAllUsers);
	}

	public WebElement SelectOrgUnits() {
		return this.driver.findElement(SelectOrgUnits);
	}

	public WebElement SelectGroups() {
		return this.driver.findElement(SelectGroups);
	}

	public WebElement ManuallyAddUsers() {
		return this.driver.findElement(ManuallyAddUsers);
	}

	public WebElement ContinueNext() {
		return this.driver.findElement(ContinueNext);
	}

	public WebElement EngineeringOrgUnit() {
		return this.driver.findElement(EngineeringOrgUnit);
	}

	public WebElement TotalOrgunitMember() {
		return this.driver.findElement(TotalOrgunitMember);
	}
	
	public WebElement ActiveMembersCount() {
		return this.driver.findElement(ActiveMembersCount);
	}

	public WebElement ContinueWithEveryoneButton() {
		return this.driver.findElement(ContinueWithEveryoneButton);
	}

	public WebElement CreateAssemblyAccountsButton() {
		return this.driver.findElement(CreateAssemblyAccountsButton);
	}

	public WebElement ConfigureInvitesBackButton() {
		return this.driver.findElement(ConfigureInvitesBackButton);
	}

	public WebElement SendInvitationsNowRadio() {
		return this.driver.findElement(SendInvitationsNowRadio);
	}

	public WebElement SendThemLaterRadio() {
		return this.driver.findElement(SendThemLaterRadio);
	}

	public WebElement AutoApproveRadio() {
		return this.driver.findElement(AutoApproveRadio);
	}

	public WebElement AdminApproveRadio() {
		return this.driver.findElement(AdminApproveRadio);
	}

	public WebElement SaveSettingsButton() {
		return this.driver.findElement(SaveSettingsButton);
	}

	public WebElement CloseButton() {
		return this.driver.findElement(CloseButton);
	}

	public WebElement viewPeopleInviteButton() {
		return this.driver.findElement(viewPeopleInviteButton);
	}

	public WebElement CardNameInputField() {
		return this.driver.findElement(CardNameInputField);
	}

	public WebElement UpgradeNowFeature() {
		return this.driver.findElement(UpgradeNowFeature);
	}

	public WebElement BusinessPlanRadioButton() {
		return this.driver.findElement(BusinessPlanRadioButton);
	}

	public WebElement TeamPlanRadioButton() {
		return this.driver.findElement(TeamPlanRadioButton);
	}

	public WebElement UpgradePlanText() {
		return this.driver.findElement(UpgradePlanText);
	}

	public WebElement UpgradePlanNextButton() {
		return this.driver.findElement(UpgradePlanNextButton);
	}

	public WebElement SetUpPaymentBackButton() {
		return this.driver.findElement(SetUpPaymentBackButton);
	}

	public WebElement SetUpPaymentNextButton() {
		return this.driver.findElement(SetUpPaymentNextButton);
	}

	public WebElement ApplyButton() {
		return this.driver.findElement(ApplyButton);
	}

	public WebElement SetUpAlertMessage() {
		return this.driver.findElement(SetUpAlertMessage);
	}

	public WebElement IframeCardNumber() {
		return this.driver.findElement(IframeCardNumber);
	}

	public WebElement CardNumberInputField() {
		return this.driver.findElement(CardNumberInputField);
	}

	public WebElement IframeExpiryDate() {
		return this.driver.findElement(IframeExpiryDate);
	}

	public WebElement CardExpiryDateField() {
		return this.driver.findElement(CardExpiryDateField);
	}

	public WebElement IframeCvcNumber() {
		return this.driver.findElement(IframeCvcNumber);
	}

	public WebElement CardCvcField() {
		return this.driver.findElement(CardCvcField);
	}

	public WebElement PromCodeInputField() {
		return this.driver.findElement(PromCodeInputField);
	}

	public WebElement ReviewBillBackButton() {
		return this.driver.findElement(ReviewBillBackButton);
	}

	public WebElement ReviewBillConfirm() {
		return this.driver.findElement(ReviewBillConfirm);
	}

	public WebElement EditConnectionButton() {
		return this.driver.findElement(EditConnectionButton);
	}

	public WebElement SignInWithGSuiteSSOClick() {
		return this.driver.findElement(SignInWithGSuiteSSOClick);
	}
	
	public WebElement SignInWithGSuiteButton() {
		return this.driver.findElement(SignInWithGSuiteButton);
	}

	public WebElement successToast() {
		return this.driver.findElement(successToast);
	}

	public WebElement ReviewBillingContent() {
		return this.driver.findElement(ReviewBillingContent);
	}

	public WebElement DifferentAssemblyAccount() {
		return this.driver.findElement(DifferentAssemblyAccount);
	}

	public WebElement GsuiteSsoSignIn() {
		return this.driver.findElement(GsuiteSsoSignIn);
	}

	public WebElement SelectGsuiteUser() {
		return this.driver.findElement(SelectGsuiteUser);
	}

	public WebElement GsuiteAllow() {
		return this.driver.findElement(GsuiteAllow);
	}

	public WebElement AcceptGsuiteConsent() {
		return this.driver.findElement(AcceptGsuiteConsent);
	}

	public WebElement GsuiteEmail() {
		return this.driver.findElement(GsuiteEmail);
	}

	public WebElement GsuitePwd() {
		return this.driver.findElement(GsuitePwd);
	}

	public WebElement GsuiteNextButton() {
		return this.driver.findElement(GsuiteNextButton);
	}

	public WebElement GsuiteSignInHeader() {
		return this.driver.findElement(GsuiteSignInHeader);
	}

	public WebElement SubmitEmail() {
		return this.driver.findElement(SubmitEmail);
	}

	public WebElement GSuiteAccountMessageMismatchError() {
		return this.driver.findElement(GSuiteAccountMessageMismatchError);
	}

	public WebElement SelectAllCheckBox() {
		return this.driver.findElement(SelectAllCheckBox);
	}

	public WebElement EditButton() {
		return this.driver.findElement(EditButton);
	}

	public WebElement BulkApprove() {
		return this.driver.findElement(BulkApprove);
	}

	public WebElement DeleteButton() {
		return this.driver.findElement(DeleteButton);
	}

	public WebElement DepartmentDropdown() {
		return this.driver.findElement(DepartmentDropdown);
	}

	public WebElement DesignerDept() {
		return this.driver.findElement(DesignerDept);
	}

	public WebElement SelectStatus() {
		return this.driver.findElement(SelectStatus);
	}

	public WebElement GiverStatus() {
		return this.driver.findElement(GiverStatus);
	}

	public WebElement ReceiverStatus() {
		return this.driver.findElement(ReceiverStatus);
	}

	public WebElement ConfirmInvite() {
		return this.driver.findElement(ConfirmInvite);
	}

	public WebElement InvitesBreadcrum() {
		return this.driver.findElement(InvitesBreadcrum);
	}

	public WebElement SingleUserSelectToEdit() {
		return this.driver.findElement(SingleUserSelectToEdit);
	}

	public WebElement UserNameFullName() {
		return this.driver.findElement(UserNameFullName);
	}

	public WebElement DepartmentDropdownEditEmployee() {
		return this.driver.findElement(DepartmentDropdownEditEmployee);
	}

	public WebElement HumanResourceDept() {
		return this.driver.findElement(HumanResourceDept);
	}

	public WebElement BirthMonthDropDown() {
		return this.driver.findElement(BirthMonthDropDown);
	}

	public WebElement BirthMonthSelect() {
		return this.driver.findElement(BirthMonthSelect);
	}

	public WebElement BirthDayDropDown() {
		return this.driver.findElement(BirthDayDropDown);
	}

	public WebElement BirthDayDate() {
		return this.driver.findElement(BirthDayDate);
	}

	public WebElement HelperBirthMonthError() {
		return this.driver.findElement(HelperBirthMonthError);
	}

	public WebElement HelperNameError() {
		return this.driver.findElement(HelperNameError);
	}

	public WebElement BulkApproveModalHeaderText() {
		return this.driver.findElement(BulkApproveModalHeaderText);
	}

	public WebElement NoDataAvailableText() {
		return this.driver.findElement(NoDataAvailableText);
	}

	public List<WebElement> AssemblyUserText() {
		return this.driver.findElements(AssemblyUserText);
	}

	public WebElement ManagePageDeleteIcon() {
		return this.driver.findElement(ManagePageDeleteIcon);
	}

	public WebElement RemovButtonText() {
		return this.driver.findElement(RemovButtonText);
	}

	public WebElement botobject() {
		return this.driver.findElement(botObject);
	}

	public WebElement botFrame() {
		return this.driver.findElement(botFrame);
	}
}
