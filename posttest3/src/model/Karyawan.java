package model;

public class Karyawan extends Pengguna {
    public Karyawan(String nama, String username, String password) {
        super(nama, username, password, "karyawan");
    }

    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Ini adalah akun Karyawan.");
    }
}
