/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author ASUS ROG
 */
public class Pokemon {
    private String ID;
    private String Nama;
    private String Handalan;
    private String Posisi;
    
    public Pokemon(String ID, String Nama, String Handalan, String Posisi)
    {
        this.ID = ID;
        this.Nama = Nama;
        this.Handalan = Handalan;
        this.Posisi = Posisi;
    }
    
    public String getID(){
        return ID;
    }
    
    public void setID(String ID){
        this.ID = ID;
    }
    
    public String getNama(){
        return Nama;
    }
    
    public void setNama(String Nama){
        this.Nama = Nama;
    }
    
    public String getHandalan(){
        return Handalan;
    }
    
    public void setHandalan(String Handalan){
        this.Handalan = Handalan;
    }
    
    public String getPosisi(){
        return Posisi;
    }
    
    public void setPosisi(String Posisi){
        this.Posisi = Posisi;
    }
}
