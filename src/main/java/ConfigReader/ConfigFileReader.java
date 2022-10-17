package ConfigReader;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

    private static Properties properties;

    private  final String propertyFilePath = "src/main/resources/config.properties";

    public ConfigFileReader() {
        BufferedReader bufferedReader;
        FileReader fileReader;

        try {
            fileReader = new FileReader(propertyFilePath);
            bufferedReader = new BufferedReader(fileReader);
            properties = new Properties();
            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties file not found at " + propertyFilePath);
        }
    }

    public String getUrl(String applicationUrl){
        String url = properties.getProperty(applicationUrl);
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the config.properties file.");
    }

    public String getBrowser(){
        String browser = properties.getProperty("browser");
        if(browser != null) return browser;
        else throw new RuntimeException("browser not specified in the config.properties file.");
    }

    public String getTimeOutDuration(){
        String timeOutDuration = properties.getProperty("timeout");
        if(timeOutDuration != null) return timeOutDuration;
        else throw new RuntimeException("timeOutDuration not specified in the config.properties file.");
    }

    public String getEnvironmentValue(){
        String timeOutDuration = properties.getProperty("env");
        if(timeOutDuration != null) return timeOutDuration;
        else throw new RuntimeException("Environment not specified in the config.properties file.");
    }

}
