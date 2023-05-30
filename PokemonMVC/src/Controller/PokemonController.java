/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import Main.Pokemon;
import Model.PokemonModel;
import View.PokemonView;

public class PokemonController {
    private ArrayList<Pokemon> list;
    private String ID;
    private String Nama;
    private String Handalan;
    private String Posisi;
    
    public PokemonController (PokemonView View, PokemonModel Model){
        if(Model.isContainPokemon()){
            list = Model.getPokemon();
            String [][] data = convertData(list);
            View.tabel.setModel((new JTable(data, View.namaKolom)).getModel());
        }else{
            JOptionPane.showMessageDialog(null, "Player Belum Terdaftar");
        }
        
        View.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String ID = View.getID();
               String Nama = View.getNama();
               String Handalan = View.getHandalan();
               String Posisi = View.getPosisi();
               Pokemon Pokemon = new Pokemon(ID, Nama, Handalan, Posisi);
               Model.insertpokemon(Pokemon);
               list = Model.getPokemon();
               System.out.println(list.get(0).getID());
               String [][] data = convertData(list);
               View.tabel.setModel((new JTable(data, View.namaKolom)).getModel());
               View.tfID.setText("");
                View.tfNama.setText("");
                View.tfHandalan.setText("");
                View.tfPosisi.setText("");
            }
        }); 
        
        View.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.out.println("btnUpdate");
               ID = View.getID();
               Nama = View.getNama();
               Handalan = View.getHandalan();
               Posisi = View.getPosisi();
               Pokemon Pokemon = new Pokemon(ID, Nama, Handalan, Posisi);
               Model.updatePokemon(Pokemon);
               list = Model.getPokemon();
               String [][] data = convertData(list);
               View.tabel.setModel((new JTable(data, View.namaKolom)).getModel());
               View.tfID.setText("");
                View.tfNama.setText("");
                View.tfHandalan.setText("");
                View.tfPosisi.setText("");
            }
        });
        
        View.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = View.getID();
                Model.deletepokemon(ID);
                list = Model.getPokemon();
                String[][] data = convertData(list);
                View.tabel.setModel((new JTable(data, View.namaKolom)).getModel());
                View.tfID.setText("");
                View.tfNama.setText("");
                View.tfHandalan.setText("");
                View.tfPosisi.setText("");
            }
        });
        
        View.tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                int baris = View.tabel.getSelectedRow();
                int kolom = View.tabel.getSelectedColumn();
                ID = View.tabel.getValueAt(baris, 0).toString(); 
                Nama = View.tabel.getValueAt(baris, 1).toString();
                Handalan = View.tabel.getValueAt(baris, 2).toString();
                Posisi = View.tabel.getValueAt(baris, 3).toString();                
                View.tfID.setText(ID);
                View.tfNama.setText(Nama);
                View.tfHandalan.setText(Handalan);
                View.tfPosisi.setText(Posisi);
            }
            
        });
        
        View.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.tfID.setText("");
                View.tfNama.setText("");
                View.tfHandalan.setText("");
                View.tfPosisi.setText("");
            }
        }); 
        
    }
        private String[][] convertData(ArrayList<Pokemon> list) {    
        String[][] data = new String[list.size()][4];
        
        for(int i=0; i<list.size();i++)
        {
            data[i][0] = list.get(i).getID();
            data[i][1] = list.get(i).getNama();
            data[i][2] = list.get(i).getHandalan();
            data[i][3] = list.get(i).getPosisi();         
        }
        return data;
    }
}
