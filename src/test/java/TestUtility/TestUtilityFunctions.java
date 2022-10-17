package TestUtility;

import java.util.HashMap;
import java.util.Map;

public class TestUtilityFunctions {

    public static Map<String,String> fetchDataIMDB(String data){
        Map<String,String> map = new HashMap<>();

        String[] arr = data.split(" ");
        String month = arr[0];
        String day = arr[1].replace(",", "").trim();
        String year = arr[2].trim();
        map.put("month", month);
        map.put("day", day);
        map.put("year", year);

        return map;
    }

    public static Map<String,String> fetchDataWikiPedia(String data){
        Map<String,String> map = new HashMap<>();

        String[] arr = data.split(" ");
        String day = arr[0].trim();
        String month = arr[1].trim();
        String year = arr[2].trim();
        map.put("month", month);
        map.put("day", day);
        map.put("year", year);

        return map;
    }
}
