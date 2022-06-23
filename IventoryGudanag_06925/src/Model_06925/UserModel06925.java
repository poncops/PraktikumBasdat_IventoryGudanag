/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_06925;
import Entity_06925.Pegawai06925;
import java.sql.*;
import java.util.ArrayList;
public class UserModel06925 extends  ModelAbstract {
private String sql;

public ArrayList<Pegawai06925> getTransaksi(){
    ArrayList<Pegawai06925> arraylistpegawai = new ArrayList <>();
    try {
        Statement stat = conn.createStatement();
         sql ="select pegawai.id_pegawai, pegawai.nama_pegawai, transaksi.id_transaksi, transaksi.total_barang, "
                 + "transaksi.tgl_pengeluaran from pegawai right join transaksi on "
                 + "pegawai.id_pegawai=transaksi.id_pegawai";
         ResultSet rs = stat.executeQuery(sql);
         while(rs.next())
         {
              Pegawai06925 goods = new Pegawai06925();
                goods.setId(rs.getInt("id_pegawai"));
                goods.setNama(rs.getString("nama_pegawai"));
                goods.setId(rs.getInt("id_transaksi"));
                goods.setTotal(rs.getString("total_barang"));
                goods.setTanggal(rs.getString("tgl_pengeluaran"));
               arraylistpegawai.add(goods);
         }
    } catch (Exception e) {
        System.out.println(e);
    }
    return arraylistpegawai;         
  } 
  
public ArrayList<Pegawai06925> getPegawai(){
    ArrayList<Pegawai06925> arraylistpegawai = new ArrayList <>();
    try {
        Statement stat = conn.createStatement();
         sql = "select * from pegawai;";
         ResultSet rs = stat.executeQuery(sql);
         while(rs.next())
         {
              Pegawai06925 goods = new Pegawai06925();
                goods.setId(rs.getInt("id_pegawai"));
                goods.setNama(rs.getString("nama_pegawai"));
                goods.setNoTelp(rs.getString("noTelp"));
                goods.setKode(rs.getString("kode_pegawai"));
                goods.setPassword(rs.getString("password"));
               arraylistpegawai.add(goods);
         }
    } catch (Exception e) {
        System.out.println(e);
    }
    return arraylistpegawai;         
  }
    public void InsertDataPegawai(Pegawai06925 Pegawai06925){ 
        try {
            sql = "Insert Into  pegawai (nama_pegawai, noTelp, kode_pegawai, password) "
                    + "Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
             stat.setString(1, Pegawai06925.getNama());
             stat.setString(2, Pegawai06925.getNoTelp());
             stat.setString(3, Pegawai06925.getKode());
             stat.setString(4, Pegawai06925.getPassword());
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println("Gagal Input Data!!!");
            e.printStackTrace();
        }
    }
    public void InsertDataTransaksi(Pegawai06925 Pegawai06925){ 
        try {
            sql = "Insert Into Transaksi (id_pegawai, total_barang, tgl_pengeluaran) "
                    + "Values(?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
             stat.setInt(1, Pegawai06925.getId());
             stat.setString(2, Pegawai06925.getTotal());
            stat.setString(3, Pegawai06925.getTanggal());
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println("Gagal Input Data!!!");
            e.printStackTrace();
        }
    }
    public void updateTanggal(String tanggal, int id){         
        try {
            sql = "update Transaksi Set tgl_pengeluaran = '?' where id_transaksi = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(id, tanggal);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL Rubah Tanggal Pengeluaran!!!");
            e.printStackTrace();
      }
    }
    
    public void updateTotal(String total, int id){ 
        try {
            sql = "update Transaksi Set total_barang = ? where id_transaksi = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, total);
            stat.setInt(2, id);
            stat.executeUpdate();
        } catch (SQLException e){
            System.out.println("GAGAL Rubah Total Barang Keluar!!!");
            e.printStackTrace();
      }
    }
    public void insertData(Pegawai06925 pegawai06925){
        try {
            sql="Insert Into Pegawai(nama, password, noTelp, kode_pegawai) Values(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, pegawai06925.getNama());
            stat.setString(2, pegawai06925.getPassword());
            stat.setString(3, pegawai06925.getNoTelp());
            stat.setString(4, pegawai06925.getKode());
        } catch (SQLException e) {
            System.out.println("Gagal Input Data!!!");
        }
    }
    
    @Override
    public void updatePassword(String password, int id) {
        try{
         sql = "Update Pegawai Set password = ? Where id_pegawai = ? ";
         PreparedStatement stat = conn.prepareStatement(sql);
         stat.setString(1,password);
         stat.setInt(2,id);
         stat.executeUpdate();
         System.out.println("Berhasi RUBAH pasword");
              }catch(SQLException e){
            System.out.println("GAGAL RUBAH pasword !!!");
            System.out.println(e);
              }
    }

    @Override
    public int CekLogin(String kode, String password) {
        int cek = 0;
        try {
            sql = "Select * From Pegawai where  kode_pegawai = ? and password = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kode);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            if (rs.next()) {
                cek = rs.getInt("id_pegawai");
                String nama = rs.getString("nama_pegawai");
                System.out.println("Selamat Datang" +nama);
            }else{
                cek = 0;
            }
        } catch (SQLException e){ 
            e.printStackTrace();
      }return cek;
   }
    public void deleteData(String nama){
        try {
            sql = "DELETE FROM pegawai WHERE nama_pegawai = ? ";
         PreparedStatement stat = conn.prepareStatement(sql);
         stat.setString(1, nama);
         stat.executeUpdate();
         System.out.println("Berhasil MENGHAPUS DATA");
        } catch (SQLException e) {
          System.out.println("GAGAL MENGHAPUS DATA");
          System.out.println(e);
        }
    }
    public void deleteDataTransaksi(int id){
        try {
            sql = "DELETE FROM transaksi WHERE id_transaksi = ? ";
         PreparedStatement stat = conn.prepareStatement(sql);
         stat.setInt(1,id);
         stat.executeUpdate();
        } catch (SQLException e) {
          System.out.println("GAGAL MENGHAPUS DATA");
          System.out.println(e);
        }
    }
}
