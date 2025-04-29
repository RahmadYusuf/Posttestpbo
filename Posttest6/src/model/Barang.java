package model;

public final class Barang {
    private String nama_barang;
    private double harga;
    private int stok;
    private String deskripsi;

    public Barang(String nama_barang, double harga, int stok, String deskripsi) {
        this.nama_barang = nama_barang;
        this.harga = harga;
        this.stok = stok;
        this.deskripsi = deskripsi;
    }

    public String getNamaBarang() {
        return nama_barang;
    }

    public void setNamaBarang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Harga tidak boleh negatif!");
        }
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        } else {
            System.out.println("Stok tidak boleh negatif!");
        }
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void tampilkanInfoBarang() {
        System.out.println("\n=== DETAIL BARANG ===");
        System.out.println("Nama     : " + this.nama_barang);
        System.out.println("Harga    : Rp" + this.harga);
        System.out.println("Stok     : " + this.stok);
        System.out.println("Deskripsi: " + this.deskripsi);
    }
    public boolean cekStokBarang() {
        return stok > 0;
    }
}