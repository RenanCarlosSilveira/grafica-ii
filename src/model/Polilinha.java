/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author renan
 */
public class Polilinha {
    
    //DERIVO DOS PONTOS PARA FAZER POLILINHA
    private ArrayList<Ponto> pontos = new ArrayList<Ponto>();
    private String nome;

    public ArrayList<Ponto> getPontosPolilinha() {
        return pontos;
    }

    public void setPontosPolilinha(ArrayList<Ponto> linhasPolilinha) {
        this.pontos = linhasPolilinha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


