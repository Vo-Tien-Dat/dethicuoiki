/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testdethicuoiki;

/**
 *
 * @author __Vo_Dat__
 */
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author __Vo_Dat__
 */
public class ketnoi {
    private static Connection connect;
    
    public ketnoi(){
        connectDataBase();
    }
    
    public static boolean addTaikhoan(taikhoan tk){
        String sql = "INSERT INTO DangKyTaiKhoan(EMAIL,PASSWORD,NAME,NUMBER) VALUES(?,?,?,?)";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1,tk.getEmail());
            ps.setString(2,tk.getPassword());
            ps.setString(3,tk.getName());
            ps.setString(4,tk.getNumber());
            return ps.executeUpdate() > 0;
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }
    
    public static void connectDataBase() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=LOGIN";
        String username = "sa";
        String password = "12345678";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(url,username,password);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("ket hoi thanh cong");
        }
    }
}
