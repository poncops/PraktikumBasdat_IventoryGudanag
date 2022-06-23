/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity_06925;

/**
 *
 * @author ASUS
 */
public abstract class User06925 {
    private  String password,nama,kode;
   private int id;
   public User06925(){};
   public User06925(String password, String kode, String nama){
       this.password = password;
       this.kode = kode;
       this.nama= nama;
   }
   public String getPassword(){
        return password;
    }
    
     public void setPassword(String password){
         this.password = password;
    }
     
     public String getKode(){
        return kode;
    }
    
     public void setKode(String kode){
         this.kode = kode;
    }
     
     public int getId(){
        return id;
    }
    
     public void setId(int id){
         this.id = id;
    }
     public String getNama(){
        return nama;
    }
    
     public void setNama(String nama){
         this.nama = nama;
    }
     
}
