package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    public static final String CONN_PROPERTY_FILENAME = "h2database.properties";
    private final String jdbcUrl;
    private final String jdbcUserName;
    private final String jdbcUserPass;

    public H2ConnectionFactory() {
        Properties props = PropertyLoader.loadProperties(CONN_PROPERTY_FILENAME);
        jdbcUrl = props.getProperty("db_url");
        jdbcUserName = props.getProperty("user");
        jdbcUserPass = props.getProperty("password");
    }

    @Override
    public Connection createConnection() {
        Connection conn;
        try{
            conn = DriverManager.getConnection (jdbcUrl, jdbcUserName,jdbcUserPass);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return conn;
    }
}

