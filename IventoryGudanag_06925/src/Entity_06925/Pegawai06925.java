/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity_06925;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public  class Pegawai06925 extends User06925 {
   private String nama,noTelp;
   private String total;
   //private Date tanggal;
    private String tanggal;
//    SimpleDateFormat date = new SimpleDateFormat("YY-MM-DD");
//    Date tang = date.parse(tanggal);
   public Pegawai06925(){}
    public Pegawai06925(String password, String kode, String nama, String noTelp){
         super(password,kode,nama);
          this.noTelp = noTelp;
           this.nama = nama;
          
    }    
    
    public String getTotal(){
       return total;
   }
   
   public void setTotal(String total){
       this.total = total;
   }
    
//   public Date getTanggal(){
//       return tanggal;
//   }
//   
//   public void setTanggal(Date tanggal){
//       this.tanggal = tanggal;
//   }
    
     public String getNoTelp(){
        return noTelp;
    }
    
     public void setNoTelp(String noTelp){
         this.noTelp = noTelp;
    }
   @Override
     public String getNama(){
        return nama;
    }
    
   @Override
     public void setNama(String nama){
         this.nama = nama;
    }
       public String getTanggal(){
       return tanggal;
   }
   
   public void setTanggal(String tanggal){
       this.tanggal = tanggal;
   } 
    
}
