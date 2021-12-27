/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneychanger;
import java.util.Scanner;
/**
 *
 * @author GENESIS
 */
 public class  Auth{
    private  Admin[] admin = new Admin[100];
    private  User[] user = new User[100];
    private  int jumUser = 1, index=0;
    private  String isLogin="";
            
    
     public int dataAdmin() {
        String userAdmin = "admin";
        String namaAdmin = "Admin";
        String alamatAdmin = "Surabaya";
        String passAdmin = "123456";
        admin[index] = new Admin(userAdmin, namaAdmin, alamatAdmin, passAdmin);            
        user[index] = new User(userAdmin, namaAdmin, alamatAdmin, passAdmin);
        return 1;
    }
    
    public  int dataUser() {
        return user.length;
    }
     public  int dataUser(String unm, String nm, String alm, String password) {
        user[jumUser] = new User(unm, nm, alm, password);
        index = index + 1;
        jumUser = jumUser + 1;
        return jumUser-1;
    }
     
      public  Admin[] getAdmin(){
        return admin;
    }
      
    
    public  User[] getUser(){
        return user;
    }
    
     int loginAdmin(String nama, String password){
        int loop = 0;
           try{
            for(int i=0; i <= dataAdmin(); i++){
                if(admin[i].getUsername().equals(nama) && admin[i].getPassword().equals(password)){
                    isLogin = admin[i].getUsername();
                    break;
                }
               loop++;
            }
        } catch (Exception e){
             loop = -1;
             System.err.println("Gagal Login");
        }
        return loop;
    }
    int loginUser(String nama, String password){
        int loop = 0;
           try{
            for(int i=0; i <= jumUser; i++){
                if(user[i].getUsername().equals(nama) && user[i].getPassword().equals(password)){
                    isLogin = user[i].getUsername();
                    index = i;
                    break;
                }
               loop++;
            }
        } catch (Exception e){
             loop = -1;
             System.err.println("Gagal Login ");
        }
        return loop;
    }
    
    
    protected String logout(User usr){
       isLogin = "";
       return isLogin;
    }
     public  String getIsLogin(){
       return isLogin;
    }
    
     
     public  int getJumlUser(){
       return jumUser;
    }
     
}
