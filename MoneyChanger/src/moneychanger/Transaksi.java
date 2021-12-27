/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneychanger;

/**
 *
 * @author GENESIS
 */public class Transaksi {
   private Uang kelasUang;
   private String echenel;
   private int jual, beli;
   public Transaksi(Uang KelasUang, String Echeneel, int jual, int beli ){
       this.kelasUang = kelasUang;
       this.echenel = echenel;
       this.jual = jual;
       this.beli = beli;
   }
   
   public void setKelasUang(Uang kelasUang){
      this.kelasUang = kelasUang;
   }
   public Uang getKelasUang(){
       return kelasUang;
   }
   public void setEchenel(String echenel){
      this.echenel = echenel;
   }
   public String getEchenel(){
       return echenel;
   }
   public void setJual(int jual){
      this.jual = jual;
   }
   public int getJual(){
       return jual;
   }
   public void setBeli(int beli){
      this.beli = beli;
   }
   public int getBeli(){
       return beli;
   }
 }