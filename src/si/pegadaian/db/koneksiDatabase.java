/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si.pegadaian.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.util.Arrays.equals;
import java.util.Properties;

/**
 *
 * @author user-pc
 */
public class koneksiDatabase {
    private static Connection conn;
    private static Properties propert=new Properties();
    
    public static Connection getKoneksi() throws SQLException{
        if(conn==null){
            try{
                propert.load(new FileInputStream("C:\\Users\\jaya\\Documents\\NetBeansProjects\\si.pegadaian.mvc\\src\\si\\pegadaian\\db\\konfigurasiDatabaseProperties.properties"));
            }catch(IOException ex){
                System.err.println("error mengambil file"+ex);
            }
//            conn=DriverManager.getConnection(propert.getProperty("jdbc.url"), propert.getProperty("jdbc.username"), propert.getProperty("jdbc.password"));
              conn=DriverManager.getConnection("jdbc:mysql://localhost/pegadaian","root","");
        }
        return conn;
    }
    
    public static void main (String[] args) throws SQLException {
        if(getKoneksi().equals(conn)){
            System.out.println("Sukses Terkoneksi");
        }
    }

    public ResultSet getData(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
