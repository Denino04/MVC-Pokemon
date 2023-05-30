/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.sun.source.tree.CatchTree;
import java.sql.*;
import javax.swing.JOptionPane;
import Database.Connector;
import java.util.ArrayList;
import Main.Pokemon;

public class PokemonModel {
    Connector con = new Connector();
    
    public void insertpokemon (Pokemon Pokemon){
        String query = "insert into champions(Player_ID, Nama, Handalan, Posisi) values (?,?,?,?)";
        PreparedStatement pstm;       
        try {
        con.statement = con.koneksi.createStatement();
        pstm = con.koneksi.prepareStatement(query);
        pstm.setString(1, Pokemon.getID());
        pstm.setString(2, Pokemon.getNama());
        pstm.setString(3, Pokemon.getHandalan());
        pstm.setString(4, Pokemon.getPosisi());
        pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deletepokemon (String ID){
        String query = "delete from champions where Player_ID = ?";
        PreparedStatement pstm;
        
        try{
            pstm = con.koneksi.prepareStatement(query);
            pstm.setString(1, ID);
            pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void updatePokemon (Pokemon Pokemon){
        String query = "Update champions SET Nama=?, Handalan=?, Posisi=? WHERE Player_ID=?";
        PreparedStatement pstm;
        try{
        con.statement = con.koneksi.createStatement();
        pstm = con.koneksi.prepareStatement(query);
        pstm.setString(1, Pokemon.getNama());
        pstm.setString(2, Pokemon.getHandalan());
        pstm.setString(3, Pokemon.getPosisi());
        pstm.setString(4, Pokemon.getID());
        pstm.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Pokemon> getPokemon(){
        System.out.println("getPokemon()");
        String query = "Select * from champions";
        PreparedStatement pstm;
        
        try{
            con.statement = con.koneksi.createStatement();
            pstm = con.koneksi.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            ArrayList<Pokemon> list = new ArrayList<>();
            Pokemon Pokemon;
            while (rs.next()){
                Pokemon = new Pokemon(
                rs.getString("Player_ID"),
                rs.getString("Nama"),
                rs.getString("Handalan"),
                rs.getString("Posisi")
                );
                list.add(Pokemon);
            } return list;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } return null;
    }
    
    public boolean isContainPokemon(){
        System.out.println("isContainPokemon()");
        try{
            String query = "Select count(*) as num from Champions";
            PreparedStatement pstm = con.koneksi.prepareStatement(query);
            con.statement = con.koneksi.createStatement();
            ResultSet rs = pstm.executeQuery(query);
            rs.next();
            if(rs.getInt("num")>0) return true;
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }return false;
    }
}
