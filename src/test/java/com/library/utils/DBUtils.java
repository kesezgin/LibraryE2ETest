package com.library.utils;

import io.cucumber.java.it.Ma;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static ResultSetMetaData rsmd;

    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(ConfigurationReader.getProperty("qa1.library.url"),
                    ConfigurationReader.getProperty("qa1.library.username"),
                    ConfigurationReader.getProperty("qa1.library.password"));
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void executeQuery(String query){
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void destroyConnection(){

        try {
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Map<String,Object>> getQueryResultMap(String query){

        executeQuery(query);
        List<Map<String,Object>> rowList = new ArrayList<>();

        try {
            rsmd = resultSet.getMetaData();

            while (resultSet.next()){

                Map<String,Object> columnNameValue = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    columnNameValue.put(rsmd.getColumnName(i),resultSet.getObject(i));
                }

                rowList.add(columnNameValue);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowList;
    }

    public static Map<String,Object> getFirstRowMap(String query){
        return getQueryResultMap(query).get(0);
    }

    public static int getIDofBook(String query, String column){
        return Integer.parseInt(getFirstRowMap(query).get(column).toString());
    }

}
