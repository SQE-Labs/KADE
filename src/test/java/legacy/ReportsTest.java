package legacy;

import org.automation.base.BaseTest;
import org.automation.pages.DashBoardPage;
import org.automation.pages.LoginPage;
import org.automation.pages.ReportsPage;
import org.automation.utilities.Assertions;
import org.automation.utilities.PropertiesUtil;
import org.testng.annotations.Test;

public class ReportsTest extends BaseTest {
	LoginPage login=new LoginPage();
	DashBoardPage dashboard=new DashBoardPage();
	ReportsPage reports =new ReportsPage();
	
	@Test(enabled = true, description="verifyReportButton")
    public void tc01_verifyReportButton(){
		login.performSignIn(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));
		dashboard.clickOnReports();
	 	Assertions.assertEquals(reports.getPageTitle(), "Reports");		//Verify page title
	}
	
	
}
