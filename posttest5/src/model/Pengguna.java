package model;

public abstract class Pengguna {
    protected String nama;
    protected final String username;
    protected String password, role;

    public Pengguna(String nama, String username, String password, String role) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public final String getNama() {
        return nama;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Peran: " + role);
    }

    public void tampilkanInfo(boolean tampilkanUsername) {
        tampilkanInfo();
        if (tampilkanUsername) {
            System.out.println("Username: " + username);
        }
    }

    public abstract void hakAkses();
}

