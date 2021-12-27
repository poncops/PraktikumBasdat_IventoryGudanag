/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneychanger;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class MoneyChanger {
    private int jumlah, perolehan, kembalian, s, e, r;
    //private User usr;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //adm = new Admin();
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int pil;
        Auth.dataAdmin(); //Inisialisasi Admin dan user
        do{
            Menu.menuUtama(); //Tampilan Menu Utama
            pil = scan.nextInt();
            switch(pil){
                case 1:
                    Menu.logonAdmin(); //Login Admin
                    break;
                case 2:
                    Menu.logonUser(); //Login User
                    break;
                case 3:
                    //
                  break;
                case 4:
                    //
                  break;
                case 5:
                    //
                }
    }while(pil != 6);
      
    }
    
}
