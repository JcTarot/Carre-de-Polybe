/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carredepolybe;

/**
 *
 * @author Jean-Christophe Tarot formation_ep
 */
public class CarreDePolybeBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // CONSTANTES
        final int N=5;
        // VARIABLES
        //int i, j;
        //char lettre;
        String mot;
        
        
        // INITIALISATION DU TABLEAU CarreDePolybeBase
       char[][] T = new char[][] {
            {'A','B','C','D','E'},
            {'F','G','H','I','J'},
            {'K','L','M','N','O'},
            {'P','Q','R','S','T'},
            {'U','V','X','Y','Z'}
         };    
         // AFFICHAGE TABLEAU CarreDePolybeBase
        for (int i = 0; i < N; i++) {
            System.out.println();
            for (int j = 0; j < N; j++) {
                System.out.print(T[i][j] + "\t");
            }
        }
        System.out.println();
        // INITIALISATION TABLEAU c : mot codé avec carré de Polybe
        mot="DEW";
        /*
        int c [] = new int [ mot.length()*2];
        
        int cd = 0;
        int k = 0;
        while ( k < mot.length() ) { 
            lettre = mot.charAt(k);
            // TEST V ou W
            if ( lettre == 'W') lettre = 'V';
            // PARCOURT du carré de Polybe
            for (i = 0; i < 5; i++) {
                for (j = 0; j < 5; j++) {
                    // INITIALISATION c à la valeur du carré de polybe
                    if (lettre == T[i][j]) {

                    c[cd] = i;
                    
                    c[cd+1] = j;
                        
                    }                    
                }
            }
            k++;
            cd = cd + 2;
        }*/
        // TEST 
        int cc [] = Code_Polybe(mot);
        // AFFICHAGE TABLEAU c : mot codé avec carré de Polybe 
        System.err.println("");
        for (int l = 0; l < mot.length()*2; l++) {
            System.err.print(cc[l]+" ");
        }
    }
 
    public static int[] Code_Polybe(String mot) {
        // INITIALISATION DU TABLEAU CarreDePolybeBase
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
        int cd = 0;
        int k = 0;
        while ( k < mot.length() ) { 
            lettre = mot.charAt(k);
            // TEST V ou W
            if ( lettre == 'W') lettre = 'V';
            // PARCOURT du carré de Polybe
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    // INITIALISATION c à la valeur du carré de polybe
                    if (lettre == Tc[i][j]) {
                    c[cd] = i;
                    c[cd+1] = j;
                    }                    
                }
            }
            k++;
            cd = cd + 2;
        } 
        return c;
    }
                
/*public static void AfficheTableau(char[][] tab) {
// AfficheTableau(T);
        for (int i = 0; i < 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(tab[i][j]);
            }
        }
    }*/
}
