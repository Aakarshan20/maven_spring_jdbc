package com.it.jdbc;

/*
* 程序的耦合
* */

import java.sql.*;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //1.註冊驅動
        DriverManager.registerDriver( new com.mysql.jdbc.Driver());
        //2.獲取連接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy", "root", "1234");
        //3.取得操作DB的預處裡對象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //4.執行sql 得到結果集
        ResultSet rs = pstm.executeQuery();
        //5.遍歷結果集
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.釋放資源
        rs.close();
        pstm.close();
        conn.close();
    }
}
