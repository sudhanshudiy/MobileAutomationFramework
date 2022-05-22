package dataProviders;

import org.testng.annotations.DataProvider;
import util.CommonUtils;

public class UserData {



    @DataProvider(name = "valid creds")
    public Object[][] validCredentials() {
        return new Object [][] {{"Diya05", "deepa55"}};
    }

    @DataProvider(name = "In valid user credentials")
    public Object[][] inValidCredentials() {
        return new Object [][] {{"Diya00", "deepa00"}};
    }

    @DataProvider(name = "userNames")
    public Object[][] userNames() {
        return new Object [][] {{"nick"}};
    }

    @DataProvider(name = "singUpDetails")
    public Object[][] signUpDetails() {
        CommonUtils commonUtils = new CommonUtils();
        String name = "".concat("free").concat(String.valueOf(commonUtils.getCurrentTimeStampInMili()));
        return new Object [][] {{name, "May 22, 2022", name, "123456", "xyz@gmail.com"}};
    }
}
