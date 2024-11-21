package com.proyectoinsituto;

import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

     public static DataSource getMySQLDataSource() {
        Properties props = new Properties();
        FileInputStream fis = null;
        MysqlDataSource mysqlDS = null;
        try {
            fis = new FileInputStream("proyectoinstituto\\src\\main\\java\\com\\proyectoinsituto\\auxiliarFiles\\db.properties");
            props.load(fis);
            mysqlDS = new MysqlDataSource();
            mysqlDS.setUrl(props.getProperty("URL"));
            mysqlDS.setUser(props.getProperty("USUARIO"));
            mysqlDS.setPassword(props.getProperty("PASSWORD"));
        } catch (Exception e) {
            e.getMessage();
        }
        return mysqlDS;
    }
}