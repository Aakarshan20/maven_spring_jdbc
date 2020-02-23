package com.it.jdbc;

/*
* 程序的耦合
* 耦合:
*    程序間的依賴
*   方法間的依賴
* 解耦:
*   降低程序間的一爛
* 開發中:
*   編譯期不依賴 運行時不依賴
* 解決:
*   使用反射Class.forName來創建對象 避免使用new
*   缺點:
*       com.mysql.jdbc.Driver寫死 此處不OK
* 解決2:
*   透過讀取配置類，來獲取要創建的對象類名  
* */

import java.sql.*;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //1.註冊驅動
        //DriverManager.registerDriver( new com.mysql.jdbc.Driver());
        //解耦
        Class.forName("com.mysql.jdbc.Driver");

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
