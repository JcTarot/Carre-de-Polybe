/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carredepolybe;

import java.util.Scanner;

/**
 *
 * @author Jean-Christophe Tarot formation_ep
 */
public class CarreDePolybe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // CONSTANTES
        final int N=5;
        // VARIABLES
        String motChoisit;
        
        
        // INITIALISATION DU TABLEAU CarreDePolybe
       char[][] T = new char[][] {
            {'A','B','C','D','E'},
            {'F','G','H','I','J'},
            {'K','L','M','N','O'},
            {'P','Q','R','S','T'},
            {'U','V','X','Y','Z'}
         };    
        // AFFICHAGE TABLEAU CarreDePolybe
        AfficheTableau(T);
        System.out.println();
        
        // SAISIE
        System.out.print("Le mot à CODER (en lettre majuscules) : ");
        motChoisit = reader.nextLine();
    //motChoisit ="DEV";
    
        // CRYPTAGE DU MOT CHOISIT
        int[] mot_crypte = Code_Polybe(motChoisit);
        
        // AFFICHAGE TABLEAU c : mot codé avec carré de Polybe 
        System.err.println("");
        for (int l = 0; l < mot_crypte.length; l++) {
            System.out.print(mot_crypte[l]+" ");
        }
        System.out.println();
        
        // DECODAGE DU MOT CRYPTE
        String mot_decrypte = Decode_Polybe(mot_crypte);
        System.out.printf("Le mot decrypte est %s", mot_decrypte);
        System.out.println();
    }
 
    public static int[] Code_Polybe(String mot) {
        // INITIALISATION DU TABLEAU CarreDePolybe
        char[][] Tc = new char[][] {
                                        {'A','B','C','D','E'},
                                        {'F','G','H','I','J'},
                                        {'K','L','M','N','O'},
                                        {'P','Q','R','S','T'},
                                        {'U','V','X','Y','Z'}
                                    }; 
        // INITIALISATION TABLEAU c : mot codé avec carré de Polybe

        int c [] = new int [ mot.length()*2];
        char lettre;
        int pos = 0;
        for (int k=0; k < mot.length(); k++ ) { 
            lettre = mot.charAt(k);
            // TEST V ou W
            if ( lettre == 'W') lettre = 'V';
            // PARCOURT du carré de Polybe
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    // INITIALISATION c à la valeur du carré de polybe
                    if (lettre == Tc[i][j]) {
                        c[pos++] = i;
                        c[pos++] = j;
                    }                    
                }
            }
        } 
        return c;
    }

    
    
    public static String Decode_Polybe(int[] mot_crypte) {
        // INITIALISATION DU TABLEAU CarreDePolybe
        char[][] Td = new char[][] {
                                        {'A','B','C','D','E'},
                                        {'F','G','H','I','J'},
                                        {'K','L','M','N','O'},
                                        {'P','Q','R','S','T'},
                                        {'U','V','X','Y','Z'}
                                    }; 
        
        String mot ="";
        int i=9,j=9;

        for (int k = 0; k < mot_crypte.length-1; k = k+2 ) { 
            i = mot_crypte[k];
            j = mot_crypte[k+1];
            if ( Td[i][j] == 'V') {
                mot += "(V/W)";
            } else {
                mot += Td[i][j];
            }
        } 
        return mot;
    }    
    
    
    
    public static void AfficheTableau(char[][] tab) {
        // Affiche Tableau Dimension 2 ordre 5 
        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(tab[i][j] + " ");
            }
        }
    }
}
