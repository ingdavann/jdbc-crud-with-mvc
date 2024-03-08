package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class LoadRepository {
    public static final Properties properties = new Properties();
    public static void loadProperties(){
        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader("application.properties"))
        ){
            properties.load(bufferedReader);
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }

}
