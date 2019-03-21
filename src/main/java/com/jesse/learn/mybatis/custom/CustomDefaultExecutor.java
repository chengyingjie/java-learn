package com.jesse.learn.mybatis.custom;

import com.jesse.learn.mybatis.demo.KolDO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomDefaultExecutor implements CustomExecutor {

    @Override
    public <T> T query(String statement, String parameter) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        KolDO kolDO = null;
        try {
            conn = getConnection();

            //TODO ParameterHandler
            preparedStatement = (PreparedStatement) conn.prepareStatement(String.format(statement, Integer.parseInt(parameter)));
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();

            //TODO ObjectFactory
            kolDO = new KolDO();

            //TODO ResultSetHandler
            while (rs.next()) {
                kolDO.setId(rs.getLong(1));
                kolDO.setName(rs.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (T)kolDO;
    }

    public Connection getConnection() {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=UTF-8&characterSetResults=UTF-8&useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName(driver); // 加载mysql驱动程序
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
