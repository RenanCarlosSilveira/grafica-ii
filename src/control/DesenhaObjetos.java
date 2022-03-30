/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Graphics2D;
import static java.awt.SystemColor.window;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Guia;
import model.Linha;
import model.Poligono;
import model.Polilinha;
import model.Ponto;
import view.NMain;

/**
 *
 * @author renan
 */
public class DesenhaObjetos {

    /*WindowPort window = new WindowPort(-300, -300, 300, 300);

     public WindowPort getWindow() {
     return window;
     }

     public void setWindow(WindowPort window) {
     this.window = window;
     }*/
    //REFERENTE AS DIMENSOES DE X NO JPANEL
    public static double xv = 0.00;
    public static double xvmin = 0.00;
    public static double xwmin = -700.00;
    public static double xwmax = 700.00;
    public static double xvmax = 700.00;
    //REFERENTE AS DIMENSOES DE Y NO JPANEL
    public static double yv = 0.00;
    public static double yvmax = 700.00;
    public static double ywmin = -700.00;
    public static double ywmax = 700.00;
    public static double yvmin = 0.00;

    //ARRAY DE CADA LISTA DE OBJETO
    public static ArrayList<Ponto> pontos = new ArrayList<Ponto>();
    public static ArrayList<Linha> linhas = new ArrayList<Linha>();
    public static ArrayList<Guia> guia = new ArrayList<Guia>();
    public static ArrayList<Polilinha> polilinhas = new ArrayList<Polilinha>();
    public static ArrayList<Poligono> poligonos = new ArrayList<Poligono>();

    public ArrayList<Ponto> getPontos() {
        return pontos;
    }

    public void setPontos(ArrayList<Ponto> pontos) {
        this.pontos = pontos;
    }

    public ArrayList<Linha> getPontosLinha() {
        return linhas;
    }

    public void setPontosLinha(ArrayList<Linha> pontosLinha) {
        this.linhas = pontosLinha;
    }

    public ArrayList<Polilinha> getPontosPolilinha() {
        return polilinhas;
    }

    public void setPontosPolilinha(ArrayList<Polilinha> pontosPolilinha) {
        this.polilinhas = pontosPolilinha;
    }

    public ArrayList<Poligono> getPontosPoligono() {
        return poligonos;
    }

    public void setPontosPoligono(ArrayList<Poligono> pontosPoligono) {
        this.poligonos = pontosPoligono;
    }

    public static void desenhaObjetos(Graphics2D painelPintura) {
        //ESTATICOS PARA PREPARAR O VIEWPORT (PAINEL PINTURA) PARA CADA NOVA CHAMADA
        painelPintura.clearRect(0, 0, 700, 700);
        repintaFundo(painelPintura);
        //Instanciar para cada objeto a ser desenhado
        desenhaPonto(painelPintura);
        desenhaLinha(painelPintura);
        desenhaPolilinha(painelPintura);
        desenhaPoligono(painelPintura);
        desenhaGuia(painelPintura);
        //atualizar a cada nova chamada
        updateList();
    }

    public static double calculaXReal(int xw) {
        xv = xvmin + (xw - xwmin) / (xwmax - xwmin) * (xvmax - xvmin);
        return xv;
    }

    public static double calculaYReal(int yw) {
        //xv = xvmin + (((xw - xwmin) / (xwmax - xwmin)) * (xvmax - xvmin));
        yv = yvmax - (yw - ywmin) / (ywmax - ywmin) * (yvmax - yvmin);
        return yv;
    }

    //LEMBRAR DE CHAMAR TODA VEZ QUE ATUALIZAR A LISTA GERAL    
    public static void updateList() {
        DefaultTableModel model = (DefaultTableModel) NMain.objList.getModel();
        model.setRowCount(0);
        for (Ponto p : DesenhaObjetos.pontos) {
            model.addRow(new Object[]{"Ponto", p.getNome()});
        }
        for (Linha l : DesenhaObjetos.linhas) {
            model.addRow(new Object[]{"Linha", l.getNome()});
        }
        for (Polilinha polilinha : DesenhaObjetos.polilinhas) {
            int cont = 1;
            model.addRow(new Object[]{"Polilinha", polilinha.getNome()});
            for (Ponto p : polilinha.getPontosPolilinha()) {
                cont++;
            }
        }
        for (Poligono poligono : DesenhaObjetos.poligonos) {
            int cont2 = 1;
            model.addRow(new Object[]{"Poligono", poligono.getNome()});
            for (Ponto p : poligono.getPontosPoligono()) {
                cont2++;
            }
        }
    }

//------------------------DESENHA OBJETOS COM GRAPHICS2D
    //PONTO
    public static void desenhaPonto(Graphics2D painelPintura) {
        for (Ponto ponto : pontos) {
            painelPintura.drawOval((int) calculaXReal(ponto.getX()), (int) calculaYReal(ponto.getY()), 3, 3);
            int xx = (int) calculaXReal(ponto.getX());
            int yy = (int) calculaYReal(ponto.getY());
            System.out.println("Posição do Ponto: " + xx + " " + yy);
        }
        repintaFundo(painelPintura);
    }

    //LINHA
    public static void desenhaLinha(Graphics2D painelPintura) {
        System.out.println("Posições da Linha");
        for (Linha linha : linhas) {
            //OBS AO PROFESSOR: NÃO ESTAVA DESENHANDO LINHAS NA HORIZONTAL, POIS HAVIA CHAMADO APENAS "CALCULAYREAL" NO AUTO-PREENCHIMENTO (CTRL + SPACE) DO NETBEANS
            painelPintura.drawLine((int) calculaXReal(linha.getP1().getX()), (int) calculaYReal(linha.getP1().getY()), (int) calculaXReal(linha.getP2().getX()), (int) calculaYReal(linha.getP2().getY()));
            System.out.println("Linha: " + linha.getNome() + " " + (int) calculaXReal(linha.getP1().getX()) + " " + (int) calculaYReal(linha.getP1().getY()));
            System.out.println("Linha: " + linha.getNome() + " " + (int) calculaXReal(linha.getP2().getX()) + " " + (int) calculaYReal(linha.getP2().getY()));
        }
        repintaFundo(painelPintura);
    }

    public static void desenhaPolilinha(Graphics2D painelPintura) {
        System.out.println("Posições da Polilinha");
        for (Polilinha polilinha : polilinhas) {
            //CONSULTA VETOR DE PONTOS DA POLILINHA A DESENHAR
            for (int i = 1; i < polilinha.getPontosPolilinha().size(); i++) {
                Ponto p1 = polilinha.getPontosPolilinha().get(i - 1);
                Ponto p2 = polilinha.getPontosPolilinha().get(i);
                //PONTOS X1, Y1 + X2, Y2 DA CLASSE INSTANCIADA PARA DESENHAR COM O GRAPHICS2D
                painelPintura.drawLine((int) calculaXReal(p1.getX()), (int) calculaYReal(p1.getY()), (int) calculaXReal(p2.getX()), (int) calculaYReal(p2.getY()));
                System.out.println("Polilinha: " + polilinha.getNome() + " " + (int) calculaXReal(p1.getX()) + " " + (int) calculaYReal(p1.getY()));
                System.out.println("Polilinha: " + polilinha.getNome() + " " + (int) calculaXReal(p2.getX()) + " " + (int) calculaYReal(p2.getY()));
            }
        }
        repintaFundo(painelPintura);
    }

    //POLIGONOS
    public static void desenhaPoligono(Graphics2D painelPintura) {
        System.out.println("Posições do Poligono");
        for (Poligono poligono : poligonos) {
            for (int i = 1; i < poligono.getPontosPoligono().size(); i++) {
                Ponto p1 = poligono.getPontosPoligono().get(i - 1);
                Ponto p2 = poligono.getPontosPoligono().get(i);
                //OBS AO PROFESSOR: POLIGONOS ESTAVAM SAINDO DE PONTA CABEÇA, POIS HAVIA CHAMADO APENAS "CALCULAXREAL" NO AUTO-PREENCHIMENTO (CTRL + SPACE) DO NETBEANS
                painelPintura.drawLine((int) calculaXReal(p1.getX()), (int) calculaYReal(p1.getY()), (int) calculaXReal(p2.getX()), (int) calculaYReal(p2.getY()));
                System.out.println("Polilinha: " + poligono.getNome() + " " + (int) calculaXReal(p1.getX()) + " " + (int) calculaYReal(p1.getY()));
                System.out.println("Polilinha: " + poligono.getNome() + " " + (int) calculaXReal(p2.getX()) + " " + (int) calculaYReal(p2.getY()));
            }
        }
        repintaFundo(painelPintura);
    }

    //MENU FERRAMENTAS - EXTRA
    public static void desenhaGuia(Graphics2D painelPintura) {
//ADICIONA LINHAS EM X E Y
        //VOLTA A COR DO PAINEL PARA A CORRETA
        System.out.println("Posições da Guia");
        for (Guia linha : guia) {
            //OBS AO PROFESSOR: NÃO ESTAVA DESENHANDO LINHAS NA HORIZONTAL, POIS HAVIA CHAMADO APENAS "CALCULAYREAL" NO AUTO-PREENCHIMENTO (CTRL + SPACE) DO NETBEANS
            painelPintura.drawLine((int) calculaXReal(linha.getP1().getX()), (int) calculaYReal(linha.getP1().getY()), (int) calculaXReal(linha.getP2().getX()), (int) calculaYReal(linha.getP2().getY()));
            System.out.println((int) calculaXReal(linha.getP1().getX()) + " " + (int) calculaYReal(linha.getP1().getY()));
            System.out.println((int) calculaXReal(linha.getP2().getX()) + " " + (int) calculaYReal(linha.getP2().getY()));
        }
        /*repintaFundo(painelPintura);
        for (Guia guia : guia) {
            painelPintura.drawLine((int) calculaXReal((int) xvmax / 2), (int) calculaYReal((int) yvmin), (int) calculaXReal((int) xvmax / 2), (int) calculaYReal((int) yvmax));
            painelPintura.drawLine((int) calculaXReal((int) xvmin), (int) calculaYReal((int) yvmax / 2), (int) calculaXReal((int) xvmax), (int) calculaYReal((int) yvmax / 2));
        }*/
        repintaFundo(painelPintura);

        painelPintura.setBackground(new java.awt.Color(255, 255, 255));

    }

    //CHAMAR PARA APLICAR A COR CORRETA AO FUNDO DEPOIS DAS OPERACOES COM A VIEWPORT
    public static void repintaFundo(Graphics2D painelPintura) {
        //VOLTA A COR DO PAINEL PARA A CORRETA
        painelPintura.setBackground(new java.awt.Color(255, 255, 255));
    }
}
