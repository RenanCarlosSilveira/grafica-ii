/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Random;

/**
 *
 * @author renan
 */
public class Matriz {

    //Controle para as operações de matriz

    //Chamada para criação de matrizes com valores aleatórios
    public int[][] getMatrizRandom(int linhas, int colunas) {
        Random valores = new Random();
        //matriz base para todas as chamadas
        int matriz[][] = new int[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = valores.nextInt(100);
                System.out.println(matriz);
            }
        }
        return matriz;
    }

    //Chamada para converter tudo em texto e unir para resultado
    public String setMatrizString(int linhas, int colunas, int[][] matriz) {
        //String pra unir as matrizes ao texto
        String Texto = "";  
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                Texto = Texto + Integer.toString(matriz[i][j])+"\t";
            }
            Texto = Texto + "\n";
        }
        return Texto;
    }

}
