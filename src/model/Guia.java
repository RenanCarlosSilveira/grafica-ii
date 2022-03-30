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
import model.Ponto;
import control.DesenhaObjetos;
import javax.swing.JPanel;

public class Guia extends JPanel {

    private Ponto pos1;
    private Ponto pos2;

    public Guia() {
    }

    //INICIALIZADOR DE PONTOS SOLO
    public Guia(Ponto pos1, Ponto pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    //INICIALIZADOR FAZ LINHA
    public Guia(int p1, int p2, int p3, int p4) {
        this.pos1.setX(p1);
        this.pos1.setY(p2);
        this.pos2.setX(p3);
        this.pos2.setY(p4);
    }

    public Ponto getP1() {
        return pos1;
    }

    public void setP1(Ponto pos1) {
        this.pos1 = pos1;
    }

    public Ponto getP2() {
        return pos2;
    }

    public void setP2(Ponto pos2) {
        this.pos2 = pos2;
    }

}
