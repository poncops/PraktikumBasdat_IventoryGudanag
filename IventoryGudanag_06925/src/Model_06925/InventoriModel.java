/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_06925;
import Entity_06925.Barang06925;
import java.sql.*;
import java.util.ArrayList;
import koneksi_06925.Koneksidb_06925;

public class InventoriModel {
private  String sql;

public ArrayList<Barang06925> getBarangKategori(){
    ArrayList<Barang06925> arraylistbarang = new ArrayList <>();
    try {
        Connection conn = Koneksidb_06925.getconection();
        Statement stat = conn.createStatement();
         sql = "SELECT jenisbarang.nama_jenis,jenisbarang.id_jenis,kategori_barang.kategori "
                 + "kategori_barang.id_kategori from jenisbarang inner join kategori_barang on "
                 + "jenisbarang.id_kategori = kategori_barang.id_kategori;";
         ResultSet rs = stat.executeQuery(sql);
         while(rs.next()){
              Barang06925 goods = new Barang06925();
              goods.setNama(rs.getString("nama_jenis"));
              goods.setIdJenis(rs.getInt("id_jenis"));
              goods.setKategori(rs.getString("kategori"));
               goods.setIdKategori(rs.getInt("id_kategori"));
                arraylistbarang.add(goods);
         }
    } catch (Exception e) {
        System.out.println(e);
    }
    return arraylistbarang;          
} 
public ArrayList<Barang06925> getBarang(){
    ArrayList<Barang06925> arraylistbarang = new ArrayList <>();
    try {
        Connection conn = Koneksidb_06925.getconection();
        Statement stat = conn.createStatement();
         sql = "SELECT * FROM Barang";
         ResultSet rs = stat.executeQuery(sql);
         while(rs.next()){
         
              Barang06925 goods = new Barang06925();
                goods.setId(rs.getInt("id_barang"));
                goods.setNama(rs.getString("nama_barang"));
               goods.setStok(rs.getString("Stok"));
                goods.setHarga(rs.getString("Harga"));
                arraylistbarang.add(goods);
         }
    } catch (Exception e) {
        System.out.println(e);
    }
    return arraylistbarang;          
} 
    public ArrayList<Barang06925> getBarangJenis(){
    ArrayList<Barang06925> arraylistbarang = new ArrayList <>();
    try {
        Connection conn = Koneksidb_06925.getconection();
        Statement stat = conn.createStatement();
         sql = "select barang.nama_barang, barang.stok, barang.harga, barang.id_transaksi, "
                 + "jenisbarang.nama_jenis, jenisbarang.id_kategori "
                 + "from barang right join jenisbarang on "
                 + "barang.id_jenis = jenisbarang.id_jenis;";
         ResultSet rs = stat.executeQuery(sql);
         while(rs.next()){
              Barang06925 goods = new Barang06925();
               goods.setNama(rs.getString("nama_barang"));
               goods.setStok(rs.getString("Stok"));
               goods.setHarga(rs.getString("Harga"));
               goods.setId(rs.getInt("id_transaksi"));
               goods.setNama(rs.getString("nama_jenis"));
               goods.setId(rs.getInt("id_kategori"));
               arraylistbarang.add(goods);
         }
    } catch (Exception e) {
        System.out.println(e);
    }
    return arraylistbarang;          
    }
  
    public void InsertDataBarang(Barang06925 Barang06925){
        Connection conn = Koneksidb_06925.getconection();
        try {
            sql = "Insert Into barang (id_transaksi, id_jenis, nama_barang, stok, harga) "
                    + "Values(?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
             stat.setInt(1, Barang06925.getIdTransaksi());
             stat.setInt(2, Barang06925.getIdJenis());
            stat.setString(3, Barang06925.getNama());
            stat.setString(4, Barang06925.getStok());
            stat.setString(5, Barang06925.getHarga());
            int rows = stat.executeUpdate();
        } catch (Exception e) {
            System.out.println("Gagal Input Data!!!");
            e.printStackTrace();
        }
    }
    public void InsertDataKategori(Barang06925 Barang06925){
        Connection conn = Koneksidb_06925.getconection();
        try {
            sql = "Insert Into Kategori_Barang (kategori) Values(?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, Barang06925.getKategori());
            int rows = stat.executeUpdate();
        } catch (Exception e) {
            System.out.println("Gagal Input Data!!!");
            e.printStackTrace();
        }
    }
    public void InsertDataJenis(Barang06925 Barang06925){
        Connection conn = Koneksidb_06925.getconection();
        try {
            sql = "Insert Into JenisBarang (id_kategori, nama_jenis) Values(?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, Barang06925.getId());
            stat.setString(2, Barang06925.getJenis());
            int rows = stat.executeUpdate();
        } catch (Exception e) {
            System.out.println("Gagal Input Data!!!");
            e.printStackTrace();
        }
    }
    public void updateNama(String nama, int id){
        try {
            Connection conn = Koneksidb_06925.getconection();
            sql = "update Barang Set nama_barang = ? where id_barang = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nama);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL Rubah Nama Barang");
            e.printStackTrace();
      }
    }
    public void updateStok(String stok, int id){     
        try {
            Connection conn = Koneksidb_06925.getconection();
            sql = "update Barang Set stok = ? where id_barang = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, stok);
            stat.setInt(2, id);
            int rows = stat.executeUpdate();
        } catch (SQLException e){  
            System.out.println("GAGAL Rubah STOCK!!!");
            e.printStackTrace();
      }
    }
    
    public void updateHarga(String harga, int id){
        Connection conn = Koneksidb_06925.getconection();
        try {
            sql = "update Barang Set harga = ? where id_barang = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, harga);
            stat.setInt(2, id);
            stat.executeUpdate();
             
        } catch (SQLException e){  
            System.out.println("GAGAL Rubah Harga!!!");
            e.printStackTrace();
      }
    }
    
    public void updateJenisBRG(String jenis, int id){
        Connection conn = Koneksidb_06925.getconection();
        try {
            sql = "update jenisbarang Set nama_jenis = ? where id_jenis = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
             stat.setString(1, jenis);
            stat.setInt(2, id);
            stat.executeUpdate();   
        } catch (SQLException e){  
            System.out.println("GAGAL Rubah Jenis Barang!!!");
            e.printStackTrace();
      }
    }
    
    public void updateKategoriBrg(String kategori, int id){
        Connection conn = Koneksidb_06925.getconection();
        try {
            sql = "update Kategori_Barang Set kategori = ? where id_kategori = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kategori );
             stat.setInt(2, id);
            stat.executeUpdate();          
        } catch (SQLException e){  
            System.out.println("GAGAL Rubah kategori Barang!!!");
            e.printStackTrace();
      }
        
    }
    
    
}        