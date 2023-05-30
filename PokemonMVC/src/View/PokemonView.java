/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class PokemonView extends JFrame implements ActionListener{
    JLabel lID = new JLabel("ID");
    JLabel lNama = new JLabel("Nama");
    JLabel lHandalan = new JLabel("Handalan");
    JLabel lPosisi = new JLabel("Posisi");

    public JTextField tfID = new JTextField();
    public JTextField tfNama = new JTextField();
    public JTextField tfHandalan = new JTextField();
    public JTextField tfPosisi = new JTextField();

    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"ID", "Nama", "Handalan", "Posisi"};

    public PokemonView() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        setTitle("Data Champion");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(650,400);

        add(scrollPane);
        scrollPane.setBounds(150, 20, 480, 300);

        add(lID);
        lID.setBounds(10, 20, 90, 20);
        add(tfID);
        tfID.setBounds(10, 40, 120, 20);

        add(lNama);
        lNama.setBounds(10, 60, 90, 20);
        add(tfNama);
        tfNama.setBounds(10, 80, 120, 20);

        add(lHandalan);
        lHandalan.setBounds(10, 100, 90, 20);
        add(tfHandalan);
        tfHandalan.setBounds(10, 120, 120, 20);

        add(lPosisi);
        lPosisi.setBounds(10, 140, 90, 20);
        add(tfPosisi);
        tfPosisi.setBounds(10, 160, 120, 20);
       
        add(btnTambah);
        btnTambah.setBounds(10, 230, 120, 20);

        add(btnUpdate);
        btnUpdate.setBounds(10, 260, 120, 20);

        add(btnDelete);
        btnDelete.setBounds(10, 290, 120, 20);

        add(btnReset);
        btnReset.setBounds(10, 320, 120, 20);
        btnReset.addActionListener(this);
    }

    @Override
     public void actionPerformed(ActionEvent e) {
     if(e.getSource() == btnReset){
            tfID.setText("");
            tfNama.setText("");
            tfHandalan.setText("");
            tfPosisi.setText("");
        }
     }
     
    public String getID(){
        return tfID.getText();
    }
    public String getNama(){
        return tfNama.getText();
    }
    public String getHandalan(){
        return tfHandalan.getText();
    }
    public String getPosisi(){
        return tfPosisi.getText();
    }
}
