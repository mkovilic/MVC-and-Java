package dal;

import model.Driver;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Car;


public class CSVHelper {
    public static List<Driver> getDrivers(String path) throws FileNotFoundException, IOException {
        List<Driver> drivers = new ArrayList<>();        
        String line = "";
        String splitter = ",";
        
        try(BufferedReader br = new BufferedReader(new FileReader(path))){            
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] driver = line.split(splitter);                
                Driver d = new Driver(driver[0], driver[1], driver[2], driver[3]);
                drivers.add(d);
            }
        }
        return drivers;
    }
    
    public static List<Car> getCars(String path) throws FileNotFoundException, IOException{
        
        List<Car> cars = new ArrayList<>();
        
        String line = "";
        String splitter = ",";
        
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] car = line.split(splitter);                
                Car c = new Car(car[0], car[1],Integer.valueOf(car[2]), Integer.valueOf(car[3]));
                cars.add(c);
            }
        }
        return cars;
    }
}
