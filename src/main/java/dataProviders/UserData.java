package dataProviders;

import org.testng.annotations.DataProvider;

public class UserData {

    @DataProvider(name = "user credentials")
    public Object[][] dpMethod() {
        return new Object [][] {{"Diya05", "deepa55"}};
    }
}
