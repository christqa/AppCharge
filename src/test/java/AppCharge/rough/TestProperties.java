package rough;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) throws IOException {


        PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");
        System.out.println(System.getProperty("user.dir"));
        BasicConfigurator.configure();
        Properties config = new Properties();
        Properties OR = new Properties();
        FileInputStream fis = new FileInputStream (System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
        config.load(fis);
        FileInputStream fis1 = new FileInputStream (System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
        OR.load(fis1);
        System.out.println(config.getProperty("browser"));
        System.out.println(OR.getProperty("bmlBtn"));





    }
}
