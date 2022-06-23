/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventoryGudang;
import Controller_06925.*;
import Entity_06925.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static InventoryController06925 brg = new InventoryController06925();
    public static UserController06925 use = new UserController06925();
    public static void main(String[] args) {
        int pilih;
        do {
            System.out.println("Inventory Gudang");
            System.out.println("1. Login");
            System.out.println("2. Keluar");
            pilih = input.nextInt();
            switch (pilih) {
                 case 1:
                    loginUser();
                    break;
                case 2:
                   System.out.println("exit");
                    break;
            }
        } while (pilih<=1);
    }
    
      static void showKategori(){
        for (Barang06925 barang : brg.getBarangKategori()) {
            System.out.println("------------------------");
            System.out.println("Jenis Barang    : "+barang.getNama());
            System.out.println("ID Jenis        : "+barang.getId());
            System.out.println("Kategori Barang : "+barang.getHarga());
            System.out.println("ID Kategori     : "+barang.getId());  
        }
    }
     static void showBarangJenis(){
        for (Barang06925 barang : brg.getBarangJenis()) {
            System.out.println("------------------------");
            System.out.println("Nama         : "+barang.getNama());
            System.out.println("STOCK        : "+barang.getStok());
            System.out.println("Harga        : "+barang.getHarga()); 
            System.out.println("ID Transaksi : "+barang.getId());
            System.out.println("Jenis Barang : "+barang.getNama());
            System.out.println("ID Kategori  : "+barang.getId()); 
        }
    } 
    
  public static void showTransaksi(){
        for (Pegawai06925 Trans : use.getTransaksi()) {
            System.out.println("------------------------");
            System.out.println("ID Pegawai      : "+Trans.getId());
            System.out.println("Nama         : "+Trans.getNama());
            System.out.println("ID Transaksi : "+Trans.getId());
            System.out.println("Total        : "+Trans.getTotal());
            System.out.println("Tanggal      : "+Trans.getTanggal());
            
        }
    }
   static void showData(){
        for (Pegawai06925 barang : use.getPegawai()) {
            System.out.println("------------------------");
            System.out.println("ID Pegawai      : "+barang.getId());
            System.out.println("Nama Pegawai   : "+barang.getNama());
            System.out.println("No Telpon      : "+barang.getNoTelp());
            System.out.println("Kode Pegawai   : "+barang.getKode());
            System.out.println("Password       :  "+barang.getKode());  
        }
    }
   
    public static void loginUser(){
        System.out.println("Kode :");
        String kode = input.next();
        System.out.println("password :");
        String password = input.next();
        int cek = use.login(kode, password);
        if (cek != 0) {
            System.out.println("berhasil Login");
            int pilih;
            do {
                
                System.out.println("1. Hapus Pegawai");
                System.out.println("2. Update Data");
                System.out.println("3. Register");
                System.out.println("4. Ubah Password User Admin");
                System.out.println("5. Tambah Barang");
                System.out.println("6. View");
                System.out.println("7. Keluar");
                 pilih= input.nextInt();
            switch (pilih) {
                case 1:
                    deleteData();
                    break;
                case 2:
                    updateData();
                    break;
                case 3:
                    insertAdmin();
                    break;
                case 4:
                    updatePassAdmin(cek);
                    break;
                case 5:
                    DataInsert();
                    break;
                case 6:
                    Data();
                    break;
                case 7:
                    deleteDataTran();
                    break;
                case 8:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("input salah");
                    break;
            }
        } while (pilih<=7);
        }else{
            System.out.println("gagal login");
        }   
    }
    static void updateData(){
        int pil;
        do {
            System.out.println("pilihan data di Update");
            System.out.println("1. nama barang");
            System.out.println("2. Stock");
            System.out.println("3. Haraga Barang");
            System.out.println("4. Jenis Barang");
            System.out.println("5. Kategori");
            System.out.println("6. Tanggal Pengeluaran");
            System.out.println("7. Total Barang");
            System.out.println("8. Exit");
            pil= input.nextInt();
            switch (pil) {
                case 1:
                    updateNama();
                    break;
                case 2:
                    updateStok();
                    break;
                case 3:
                    updateHarga();
                    break;
                case 4:
                    updateJenis();
                    break;
                case 5:
                    updateKategori();
                    break;
                case 6:
                    updateTotal();
                    break;
                case 7:
                    updateTotal();
                    break;
                case 8:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("input salah");
                    break;
            }
        } while (pil<=7);  
    }
     static void Data(){
        int pil;
        do {
            System.out.println("pilihan data diLihat");
            System.out.println("1. View barang");
            System.out.println("2. View Transaksi");
            System.out.println("3. Exit");
            pil= input.nextInt();
            switch (pil) {
                case 1:
                   showBarangJenis();
                    break;
                case 2:
                    showTransaksi();
                    break;
                case 3:
                    System.out.println("EXIT");
                    break;
                default:
                    System.out.println("input salah");
                    break;
            }
        } while (pil<=2);  
    }
    
    static void insertAdmin(){
        showData();
        System.out.println("Nama : ");
        String nama = input.next();
        System.out.println("no hp : ");
        String noTelp = input.next();
        System.out.println("Kode : ");
        String kode = input.next();
        System.out.println("password : ");
        String password = input.next();
        use.insertPegawai(nama, noTelp, kode, password);
    }
    
    static void insertBarang(){
        System.out.println("ID Transaksi    : ");
        int idTransaksi = input.nextInt();
        System.out.println("ID Jenis    : ");
        int idJenis = input.nextInt();
        System.out.println("Nama Barang : ");
        String nama = input.next();
        System.out.println("Stok        : ");
        String stok = input.next();
        System.out.println("Harga       : ");
        String harga = input.next();
        brg.insertBarang(idTransaksi, idJenis, nama, stok, harga);
    }
        static void insertJenis(){
      System.out.println("ID Kategori   :  ");
      int idKategori = input.nextInt();
        System.out.println("Jenis Barang: ");
        String jenis = input.next();
        brg.insertJenis(idKategori, jenis);
    }
    
  static void insertKategori(){
        System.out.println("Kategori Barang : ");
        String kategori = input.next();
        brg.insertKategori(kategori);
    }
    static void insertTransaksi() {
        System.out.println("ID Pegawai :    ");
        int id = input.nextInt();
        System.out.println("Total Barang Keluar :   ");
        String total = input.next();
        System.out.println("Tanggal Pengeluaran :   ");
       String tanggal = input.next();
        use.insertTransasksi(id, total, tanggal);
    }

    static void DataInsert(){
        int pil;
        do {
            System.out.println("pilihan data diTambah");
            System.out.println("1. Insert barang");
            System.out.println("2. Insert Transaksi");
            System.out.println("3. insert Jenis");
            System.out.println("4. insert Kategori");
            System.out.println("5. Exit");
            pil= input.nextInt();
            switch (pil) {
                case 1:
                    insertBarang();
                    break;
                case 2:
                    insertTransaksi();
                    break;
                case 3:
                    insertJenis();
                    break;
                case 4:
                    insertKategori();
                    break;
                case 5:
                    System.out.println("EXIT");
                    break;
       
                default:
                    System.out.println("input salah");
                    break;
            }
        } while (pil<=4);  
    }
    
    private static void updatePassAdmin(int cek) {
        System.out.println("password baru = ");
        String pass = input.next();
        use.updatePassword(pass, cek);
    }
    private static void updateNama() {
       System.out.println("ID Barang :");
       int id = input.nextInt();
        System.out.println("nama :");
        String nama = input.next();
        brg.updateNama(id, nama);
    }
    private static void updateStok() {
       System.out.println("ID Barang :");
        int id = input.nextInt();
        System.out.println("stok :");
        String stok = input.next();
        brg.updateStok(stok, id);
    }
    private static void updateHarga() {
       System.out.println("ID Barang :");
        int id = input.nextInt();
        System.out.println("harga :");
        String harga = input.next();
        brg.updateHarga(harga, id);
    }
    private static void updateJenis() {
       System.out.println("ID Barang :");
        int id = input.nextInt();
        System.out.println("jenis :");
        String jenis = input.next();
        brg.updateJenisBRG(jenis, id);
    }
    private static void updateKategori() {
       System.out.println("ID Barang :");
        int id = input.nextInt();
        System.out.println("kategori :");
        String kategori = input.next();
        brg.updateKategoriBrg(kategori, id);
    }
    private static void updateTotal() {
       System.out.println("ID Transaksi :");
        int id = input.nextInt();
        System.out.println("Total :");
        String total = input.next();
        use.updateTotal(total, id);
    }
    private static void updateTanggal() {
        
       System.out.println("ID Transaksi :");
        int id = input.nextInt();
        System.out.println("Tanggal :");
        String tanggal = input.next();
        use.updateTanggal(tanggal, id);
    }
    static void deleteData(){
       showData();
        System.out.print("hapus nama = ");
        String nama = input.next();
        use.deleteData(nama);
    }
    static void deleteDataTran(){
        showTransaksi();
        System.out.print("hapus id = ");
        int id= input.nextInt();
        use.deleteDataTran(id);
    }
  }

