package main;

import dal.CSVHelper;
import dal.DataSourceHelper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import model.Car;
import model.Driver;


public class Main {
    private static final String DRIVERS_PATH = "F:\\Documents\\Projektonž\\MVC-and-Java\\Java\\PPPK-Java\\src\\main\\drivers.csv";
    private static final String DRIVERS_INSERT = "INSERT INTO Vozac VALUES (?, ?, ?, ?)";
    
    private static final String CARS_PATH = "F:\\Documents\\Projektonž\\MVC-and-Java\\Java\\PPPK-Java\\src\\main\\cars.csv";
    private static final String CARS_INSERT = "INSERT INTO Vozilo VALUES (?, ?, ?, ?)";
    
    public static void main(String[] args) throws IOException {
        List<Driver> drivers = CSVHelper.getDrivers(DRIVERS_PATH);
        List<Car> cars = CSVHelper.getCars(CARS_PATH);
        
        importDrivers(drivers);
        importCars(cars);
    }

    private static void importDrivers(List<Driver> drivers) {
        DataSource dataSource = DataSourceHelper.createDataSource();

        final int batchSize = 100;

        try (Connection conn = dataSource.getConnection()) {

            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(DRIVERS_INSERT)) {

                // Insert sample records
                int counter = 1;
                for (int i = 0; i < drivers.size(); i++) {
                    Driver d = drivers.get(i);

                    stmt.setString(1, d.getFirstName());
                    stmt.setString(2, d.getLastName());
                    stmt.setString(3, d.getPhoneNumber());
                    stmt.setString(4, d.getDriversLicenceNumber());

                    //Add statement to batch
                    stmt.addBatch();

                    //Execute batch of 1000 records
                    if (i % batchSize == 0) {
                        long t1 = System.currentTimeMillis();
                        stmt.executeBatch();
                        long t2 = System.currentTimeMillis();
                        conn.commit();
                        long t3 = System.currentTimeMillis();
                        System.out.println("Batch " + (counter++) + " executed successfully: t.executeBatch=" + (t2 - t1) + ", t.commit)=" + (t3 - t2) + " - " + new Date());
                    }
                }
                //execute final batch
                stmt.executeBatch();
                conn.commit();
                System.out.println("Final batch executed successfully");
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    System.out.println("Transaction is being rolled back.");
                    conn.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void importCars(List<Car> cars) {
        DataSource dataSource = DataSourceHelper.createDataSource();

        final int batchSize = 100;

        try (Connection conn = dataSource.getConnection()) {

            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(CARS_INSERT)) {

                // Insert sample records
                int counter = 1;
                for (int i = 0; i < cars.size(); i++) {
                    Car c = cars.get(i);

                    stmt.setString(1, c.getType());
                    stmt.setString(2, c.getBrand());
                    stmt.setString(3, c.getInitialKm().toString());
                    stmt.setString(4, c.getYearOfProduction().toString());


                    //Add statement to batch
                    stmt.addBatch();

                    //Execute batch of 1000 records
                    if (i % batchSize == 0) {
                        long t1 = System.currentTimeMillis();
                        stmt.executeBatch();
                        long t2 = System.currentTimeMillis();
                        conn.commit();
                        long t3 = System.currentTimeMillis();
                        System.out.println("Batch " + (counter++) + " executed successfully: t.executeBatch=" + (t2 - t1) + ", t.commit)=" + (t3 - t2) + " - " + new Date());
                    }
                }
                //execute final batch
                stmt.executeBatch();
                conn.commit();
                System.out.println("Final batch executed successfully");
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    System.out.println("Transaction is being rolled back.");
                    conn.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
