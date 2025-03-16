package model;

public class Pengguna {
    public String nama;
    public String username;
    public String password;
    public String role;

   
    public Pengguna( String nama, String username, String password, String role) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}