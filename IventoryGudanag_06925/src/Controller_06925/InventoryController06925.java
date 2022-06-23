/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_06925;
import Entity_06925.*;
import java.util.ArrayList;
import java.util.Date;
public class InventoryController06925{

public void insertBarang(int idTransaksi, int idJenis, String nama, String stok, String harga){
    Barang06925 barang = new Barang06925();
    barang.setIdTransaksi(idTransaksi);
    barang.setIdJenis(idJenis);
    barang.setNama(nama);
    barang.setStok(stok);
    barang.setHarga(harga);
    AllObjectModel06925.BarangModel.InsertDataBarang(barang);
}    
public void insertJenis(int idKategori, String jenis){
    Barang06925 barang = new Barang06925();
    barang.setId(idKategori);
    barang.setJenis(jenis);
    AllObjectModel06925.BarangModel.InsertDataJenis(barang);
}   
public void insertKategori(String kategori){
    Barang06925 barang = new Barang06925();
    barang.setKategori(kategori);
    AllObjectModel06925.BarangModel.InsertDataKategori(barang);
}   

public ArrayList<Barang06925> getBarangKategori(){
    return AllObjectModel06925.BarangModel.getBarangKategori();
}
public ArrayList<Barang06925> getBarangJenis(){
        return AllObjectModel06925.BarangModel.getBarangJenis();
    }
 

  public void updateNama(int id, String nama){
        AllObjectModel06925.BarangModel.updateNama(nama,id);
    }
    public void updateStok(String stok, int id){
        AllObjectModel06925.BarangModel.updateStok(stok,id);
    }
    public void updateHarga(String harga, int id){
        AllObjectModel06925.BarangModel.updateHarga(harga,id);
    }
    public void updateJenisBRG(String jenis, int id){
        AllObjectModel06925.BarangModel.updateJenisBRG(jenis,id);
    }
    public void updateKategoriBrg(String kategori, int id){
        AllObjectModel06925.BarangModel.updateKategoriBrg(kategori,id);
    }
}
