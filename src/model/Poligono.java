/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author renan
 */
public class Poligono extends JPanel {

    //DERIVO DOS PONTOS
    private ArrayList<Ponto> pontos = new ArrayList<Ponto>();
    private String nome;

    public ArrayList<Ponto> getPontosPoligono() {
        return pontos;
    }
    
    public void setPontosPoligono(ArrayList<Ponto> linhas) {
        this.pontos = linhas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}





