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
public class Barang06925 extends User06925 {  
    private String stok;
    private String harga; 
    private String kategori;
    private String jenis;
    private String nama;
    private int idJenis,idTransaksi,idKategori;
    public Barang06925(){
        
    }

    @Override
    public String getNama(){
        return nama;
    }
    
    @Override
     public void setNama(String nama){
         this.nama = nama;
    }
   public String getStok(){
       return stok;
   }
   
   public void setStok(String stok){
       this.stok = stok;
   }
   
   public String getHarga(){
       return harga;
   }
   
   public void setHarga(String harga){
       this.harga = harga;
   }
   
   public String getKategori(){
       return kategori;
   }
   
   public void setKategori(String kategori){
       this.kategori = kategori;
   }
   
   public String getJenis(){
        return jenis;
    }
    
     public void setJenis(String jenis){
          this.jenis = jenis;
    }
     
    public int getIdJenis(){
        return idJenis;
    }
     public void setIdJenis(int idJenis){
         this.idJenis = idJenis;
    }
     
    public int getIdTransaksi(){
        return idTransaksi;
    }    
     public void setIdTransaksi(int idTransaksi){
         this.idTransaksi = idTransaksi;
    }
     
    public int getIdKategori(){
        return idKategori;
    }    
     public void setIdKategori(int idKategori){
         this.idKategori = idKategori;
    }
}


