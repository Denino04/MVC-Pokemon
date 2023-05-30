/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Database.Connector;
import Controller.PokemonController;
import Model.PokemonModel;
import View.PokemonView;

public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    PokemonView view = new PokemonView();
    PokemonModel model = new PokemonModel();
    PokemonController con = new PokemonController(view, model);
    }
    
}
