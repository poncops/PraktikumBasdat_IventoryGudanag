/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneychanger;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Menu {
    private static String uname,upass;
    private static int cekLogin=-1, pil;
    
    
    public static void menuUtama(){
        System.out.println("\n========================");
        System.out.println("=====  M  E  N  U  =====");
        System.out.println("========================");
        System.out.println("1. Login Admin (" +  Auth.dataAdmin() + ")");
        System.out.println("2. Login User (" +   Auth.getJumlUser() + ")");
        System.out.println("========================");
        System.out.print("Masukkan pilihan : ");
    }
    
    public static void logonAdmin(){
        Scanner  scan = new Scanner(System.in);
        System.out.println("\n=========================");
        System.out.println("======  L O G I N  ======");
        System.out.println("=========================");
        System.out.print("Admin : ");
        uname = scan.next();
        System.out.print("Password : ");
        upass = scan.next();
        cekLogin = Auth.loginAdmin(uname, upass);
        
        if(cekLogin != -1){
            menuAdmin(); 
        }else{
            logonAdmin();
        }
    }
    
    
    public static void logonUser(){
        Scanner  scan = new Scanner(System.in);
        System.out.println("\n=========================" + Auth.getJumlUser());
        System.out.println("======  L O G I N  ======");
        System.out.println("=========================");
        System.out.print("Username : ");
        uname = scan.next();
        System.out.print("Password : ");
        upass = scan.next();
        cekLogin = Auth.loginUser(uname, upass);
        
        if(cekLogin != -1){
            menuUser(); 
        }else{
            logonUser();
        }
    }
    
     private static void menuAdmin(){
        Scanner  scan = new Scanner(System.in);
        System.out.println("Selamat Datang " + Auth.getIsLogin());
        System.out.println("");
        do{
            System.out.println("\n========================");
            System.out.println("\n====== A D M I N =======");
            System.out.println("\n========================");
            System.out.println("1. Tambah Matauang");
            System.out.println("2. Ubah Matauang");
            System.out.println("3. Lihat Matauang");
            System.out.println("4. Hapus Matauang");
            System.out.println("5. Tambah User");
            System.out.println("6. Lihat User");
            System.out.println("0. Log Out");
            System.out.println("\n========================");
            System.out.print("Pilih : ");
            pil = scan.nextInt();
            scan.nextLine();
            switch(pil){
                case 1:
                    System.out.println("Tambah");
                   // insertPeserta();
                    break;
                case 2:
                    System.out.println("Ubah");
                    //updatePeserta();
                    break;
                case 3:
                    //viewPeserta();
                    break;
                case 4:
                    //deletePeserta();
                    break;
                case 5:
                    tambahUser();
                    break;
                case 6:
                    lihatUser();
                    break;
            }
        }while(pil != 0);
    }
     
     
     private static void menuUser(){
        Scanner  scan = new Scanner(System.in);
        System.out.println("Selamat Datang " + Auth.getIsLogin());
        System.out.println("");
        do{
            System.out.println("\n========================");
            System.out.println("\n======  U S E R  =======");
            System.out.println("\n========================");
            System.out.println("1. Deposit");
            System.out.println("2. Tukar uang");
            System.out.println("3. Lihat Saldo");
            System.out.println("0. Log Out");
            System.out.println("\n========================");
            System.out.print("Pilih : ");
            pil = scan.nextInt();
            scan.nextLine();
            switch(pil){
                case 1:
                    System.out.println("Deposit");
                   // insertPeserta();
                    break;
                case 2:
                    System.out.println("Tukar uang");
                    //updatePeserta();
                    break;
                case 3:
                    //viewPeserta();
                    break;
            }
        }while(pil != 0);
    }
     
     private static void tambahUser(){
        Scanner scan = new Scanner(System.in);
        String unm,nm,almt,psw;
        int pil, idx;
        
        System.out.println("Buat Username Login : ");
        unm = scan.nextLine();
        System.out.println("Buat Password Login : ");
        psw =  scan.nextLine();
        System.out.println("Masukkan Nama Anda : ");
        nm =  scan.nextLine();
        System.out.println("Masukkan Alamat Anda : ");
        almt =  scan.nextLine();
        System.out.println("\n========================");
        idx =  Auth.dataUser(unm, nm, almt, psw);
        lihatUser(idx);
        menuAdmin();
     }
     
     private static void lihatUser(){
        User user[] = Auth.getUser();
        for(int i = 0; i < Auth.getJumlUser(); i++){
            System.out.println("\n==================================");
            System.out.println("Nama  : " + user[i].getNama()
                + "\nAlamat : " + user[i].getAlamat()
                + "\nUser : " + user[i].getUsername()
                + "\nPass : " + user[i].getPassword()
            );
            System.out.println("==================================");
        }
     }
     
     
     private static void lihatUser(int index){
        User user[] = Auth.getUser();
            System.out.println("\n==================================");
            System.out.println("Nama  : " + user[index].getNama()
                + "\nAlamat : " + user[index].getAlamat()
                + "\nUser : " + user[index].getUsername()
                + "\nPass : " + user[index].getPassword()
            );
            System.out.println("==================================");
     }
}
