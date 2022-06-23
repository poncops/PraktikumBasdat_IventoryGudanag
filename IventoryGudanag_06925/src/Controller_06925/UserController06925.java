/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_06925;
import Entity_06925.Pegawai06925;
import java.util.ArrayList;
public class UserController06925 implements ControllerInterface{

public void insertTransasksi(int id,  String total, String tanggal){
    Pegawai06925 transaksi = new Pegawai06925();
    transaksi.setId(id);
    transaksi.setTotal(total);
    transaksi.setTanggal(tanggal);
    AllObjectModel06925.UserModel.InsertDataTransaksi(transaksi);
}   
public void insertPegawai(String nama, String noTelp, String kode, String password){
    Pegawai06925 pegawai = new Pegawai06925();
    pegawai.setNama(nama);
    pegawai.setNoTelp(noTelp);
    pegawai.setKode(kode);
    pegawai.setPassword(password);
    AllObjectModel06925.UserModel.InsertDataPegawai(pegawai);
}  
    @Override
    public int login(String kode, String password) {
      int log = AllObjectModel06925.UserModel.CekLogin(kode, password);
        return log;
    }
    public void deleteData(String nama){
        AllObjectModel06925.UserModel.deleteData(nama);
    }
    public void deleteDataTran(int id){
        AllObjectModel06925.UserModel.deleteDataTransaksi(id);
    }
    public void updatePassword(String password, int id){
        AllObjectModel06925.UserModel.updatePassword(password, id);
    }
    
    public ArrayList<Pegawai06925> getTransaksi(){
        return AllObjectModel06925.UserModel.getTransaksi();
    }
    public ArrayList<Pegawai06925> getPegawai(){
        return AllObjectModel06925.UserModel.getPegawai();
    }
    public void updateTanggal(String tanggal, int id){
        AllObjectModel06925.UserModel.updateTanggal(tanggal, id);
    }
    public void updateTotal(String total, int id){
        AllObjectModel06925.UserModel.updateTotal(total, id);
    }
}
