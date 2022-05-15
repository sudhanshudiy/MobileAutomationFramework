package dataProviders;

import org.testng.annotations.DataProvider;

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
}
