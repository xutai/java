package com.company.EssentialJavaClasses.env;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass {
    public static void main(String[] args) {
        try {
//            SettingUpThePropertiesObject.main(args);
            GettingPropertyInformation.main(args);
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}

class SettingUpThePropertiesObject {
    public static void main(String[] args) throws IOException {
        /* Setting Up the Properties Object */

        // create and load default properties
        Properties defaultProps = new Properties();
        FileInputStream in = new FileInputStream("defaultProperties");
        defaultProps.load(in);
        in.close();

        // create application properties with default
        Properties applicationProps = new Properties(defaultProps);

        // now load properties
        // from last invocation
        in = new FileInputStream("appProperties");
        applicationProps.load(in);
        in.close();


        /* Saving Properties */
        FileOutputStream out = new FileOutputStream("appProperties");
        applicationProps.store(out, "---No Comment---");
        out.close();
    }
}

class SavingProperties {
    public static void main(String[] args) throws Exception {

    }
}

class GettingPropertyInformation {
    public static void main(String[] args) throws Exception {
        Properties defaultProps = new Properties();
        System.out.println(defaultProps.size());
        System.out.println(defaultProps.elements());
        System.out.println(defaultProps.keys());
        System.out.println(defaultProps.propertyNames());
    }
}

class SettingProperties {
    public static void main(String[] args) throws Exception {
    }
}