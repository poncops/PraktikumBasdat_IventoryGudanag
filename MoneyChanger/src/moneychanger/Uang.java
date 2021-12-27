/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneychanger;
public class Uang {
    private String negara, mataUang;
    private double nominal,saldo,rupiah, nilaiTukar;

    public Uang(String nama, double nominal){
        this.nominal = nominal;
        this.mataUang = nama;
    }
    
    protected double getNominal()
    {
        return nominal;
    }
    
    protected void setSaldo(double sld){
        this.saldo = sld;
    }
    
    protected double getSaldo(){
        return saldo;
    }
    
    protected void setNilaiTukar(double nltkr){
        this.nilaiTukar = nltkr;
    }
    
    protected double getNilaiTukar(){
        return nilaiTukar;
    }
    
    protected double getRupiah(){
        rupiah = getNominal()*getSaldo();
        return rupiah;
    }
    
    protected  String getNegara(){
        return this.negara;
    }
}
