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

public class Linha extends JPanel {

    private Ponto pos1;
    private Ponto pos2;
    private String nome;

    public Linha() {
    }

    //INICIALIZADOR DE PONTOS SOLO
    public Linha(Ponto pos1, Ponto pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    //INICIALIZADOR FAZ LINHA
    public Linha(int p1, int p2, int p3, int p4) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /*public Linha updateLinha(Linha linharecebe, int escalax, int escalay, String nome) {
        Ponto p1 = new Ponto(linharecebe.getP1().getX()+escalax, linharecebe.getP1().getY()+escalay);
        Ponto p2 = new Ponto(linharecebe.getP2().getX()+escalax, linharecebe.getP2().getY()+escalay);;
        Linha linhaupdate = new Linha(p1, p2);
        linhaupdate.setNome(nome);
        System.out.println(linhaupdate.getNome());
        //DesenhaObjetos.desenhaObjetos((Graphics2D) painelPintura.getGraphics());
        //**************************************************
        /*System.out.println("ANTES " + DesenhaObjetos.calculaXReal(linhaupdate.pos1.getX()) + " " + escalax);
        System.out.println(DesenhaObjetos.calculaYReal(linhaupdate.pos1.getY()) + " " + escalay);
        System.out.println(DesenhaObjetos.calculaXReal(linhaupdate.pos2.getX()) + " " + escalax);
        System.out.println(DesenhaObjetos.calculaYReal(linhaupdate.pos2.getY()) + " " + escalay);*/
        
        //************************************************************
        /*linhaupdate.pos1.setX(pos1.getX() + escalax);
        linhaupdate.pos1.setY(pos1.getY() + escalay);
        linhaupdate.pos2.setX(pos2.getX() + escalax);
        linhaupdate.pos2.setY(pos2.getY() + escalay);*/
        //DesenhaObjetos.linhas.add(linhaupdate);
        //************************************************************
        /*System.out.println("DEPOIS " + DesenhaObjetos.calculaXReal(linhaupdate.pos1.getX()) + " " + escalax);
        System.out.println(DesenhaObjetos.calculaYReal(linhaupdate.pos1.getY()) + " " + escalay);
        System.out.println(DesenhaObjetos.calculaXReal(linhaupdate.pos2.getX()) + " " + escalax);
        System.out.println(DesenhaObjetos.calculaYReal(linhaupdate.pos2.getY()) + " " + escalay);
        /*linha.pos1.setY(pos1.getY() + escalay);
         linha.pos2.setX(pos1.getX() + escalax);
         linha.pos2.setY(pos1.getY() + escalay);*/
        /*System.out.println("Linha teste Update: X " + (int) DesenhaObjetos.calculaXReal(linhaupdate.getP1().getX()) + " Y " + (int) DesenhaObjetos.calculaYReal(linhaupdate.getP1().getY()));
        System.out.println("Linha teste Update: X " + (int) DesenhaObjetos.calculaXReal(linhaupdate.getP2().getX()) + " Y " + (int) DesenhaObjetos.calculaYReal(linhaupdate.getP2().getY()));
        return linhaupdate;
    }*/

}
