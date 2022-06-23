/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_06925;
import koneksi_06925.Koneksidb_06925;
import java.sql.Connection;
public abstract class ModelAbstract {
    Connection conn = Koneksidb_06925.getconection();
    public abstract void updatePassword(String password,int id);
    public abstract int CekLogin(String kode, String password);
}
