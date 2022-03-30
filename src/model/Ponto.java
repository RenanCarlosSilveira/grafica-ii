/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author renan
 */
public class Ponto {

    private int posx;
    private int posy;
    private String nome;

    public Ponto(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
    }

    public Ponto() {
    }

    public Ponto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String setNome() {
        return nome;
    } 
    //VOID PARA CHAMAR NA JANELA DE PONTO
    public void setNome(String descricao) {
        this.nome = descricao;
    }

    public int getX() {
        return posx;
    }

    public void setX(int posx) {
        this.posx = posx;
    }

    public int getY() {
        return posy;
    }

    public void setY(int posy) {
        this.posy = posy;
    }

}
