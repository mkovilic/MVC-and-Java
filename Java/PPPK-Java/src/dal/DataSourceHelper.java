package dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javax.sql.DataSource;

public class DataSourceHelper {
    public static DataSource createDataSource() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setServerName("DESKTOP-9PJTSVI\\SQLEXPRESS");
        dataSource.setDatabaseName("PPPK");
        dataSource.setUser("sa");
        dataSource.setPassword("SQL");
        return dataSource;
    }
}