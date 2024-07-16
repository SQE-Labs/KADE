package test;

import org.automation.base.BaseTest;
import org.testng.annotations.Test;

public class myTest extends BaseTest {


    @Test
    public void a(){
        System.out.println(BaseTest.getDriver().toString());
    }
    @Test
    public void b(){
        System.out.println(BaseTest.getDriver().toString());
    }
    @Test
    public void c(){
        System.out.println(BaseTest.getDriver().toString());
    }
    @Test
    public void d(){
        System.out.println(BaseTest.getDriver().toString());
    }

}
