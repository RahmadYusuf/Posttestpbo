package model;

public class Admin extends Pengguna {
    public Admin(String nama, String username, String password) {
        super(nama, username, password, "admin");
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Ini adalah akun Admin.");
    }
}
