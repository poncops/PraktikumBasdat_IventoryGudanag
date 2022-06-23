/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi_06925;
import java.sql.Connection;
import java.sql.DriverManager;
public class Koneksidb_06925 {
public  static  Connection getconection(){
    Connection conn = null;
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/db_inventorigudang";
    String user = "root";
    String pass = "";
    
    try {
        Class.forName(driver);
        conn=DriverManager.getConnection(url,user,pass);
        System.out.println("Berhasil Koneksi Database");
    } catch (Exception e) {
        System.out.println("Gagal Keneksi Database");
        e.printStackTrace();
    }
    return conn;
  }  
}
