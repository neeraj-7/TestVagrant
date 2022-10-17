package MovieDataProvider;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
        return new Object[][]
                {
                        {"Pushpa: The Rise - Part 1" }
                      //  {"Vikrant Rona"}
                     //TODO:add movie names here
                };

    }
}
