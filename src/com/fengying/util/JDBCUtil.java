package com.fengying.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.*;

public class JDBCUtil {
    static ComboPooledDataSource dataSource = null;
    static {
        dataSource = new ComboPooledDataSource();
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
}
