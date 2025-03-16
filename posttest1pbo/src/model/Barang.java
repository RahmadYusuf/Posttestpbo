package model;

public class Barang {
    public String nama_barang;
    public double harga;
    public int stok;
    public String deskripsi;


    public Barang(String nama_barang, double harga, int stok, String deskripsi) {

        this.nama_barang = nama_barang;
        this.harga = harga;
        this.stok = stok;
        this.deskripsi = deskripsi;
    }
}