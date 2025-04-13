package model;

public class Pengguna {
    protected String nama, username, password, role;

    public Pengguna(String nama, String username, String password, String role) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getNama() { 
        return nama; }

    public String getRole() { 
        return role; }
    
    public void setRole(String role) { 
        this.role = role; }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Peran: " + role);
    }

    // Overloading 
    public void tampilkanInfo(boolean tampilkanUsername) {
        tampilkanInfo();
        if (tampilkanUsername) {
            System.out.println("Username: " + username);
        }
    }
}

