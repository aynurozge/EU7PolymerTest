    package com.todomvc.utilities;

    import java.io.FileInputStream;
    import java.util.Properties;

    public class ConfigurationReader {

    private static Properties properties;//decleare a variable
    //static blocks:it initiates every time Icall the classname

    static {

        try {
            //what file to read
            String path = "configuration.properties";
            //read the file into java, finds the file using the String path
            FileInputStream input = new FileInputStream(path);
            //properties-->class that store properties in key value format
            properties = new Properties();//created properties object
            //the values from the file input is loaded/fed in to the properties object
            properties.load(input);//input is representing my con.prop.file

            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static  String get(String keyName) {//create one method
        return properties.getProperty(keyName);}



    }
