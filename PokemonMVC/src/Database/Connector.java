/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import com.sun.source.tree.CatchTree;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS ROG
 */
public class Connector{
    public Connection koneksi;
    public Statement statement;
    private final String url = "jdbc:mysql://localhost/pokemon";
    private final String username = "root";
    private final String pass = "";
    public Connector() {
        try {
            // Class.forName("com.mysql.jdbc.cj.driver");
            koneksi = (Connection)DriverManager.getConnection(url, username, pass);
            statement = (Statement)koneksi.createStatement();
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
            JOptionPane.showMessageDialog(null, "Koneksi Gagal!");
            System.exit(0);
        }
    }
}

