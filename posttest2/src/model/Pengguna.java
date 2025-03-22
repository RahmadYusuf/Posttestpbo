package model;

public class Pengguna {
    private String nama;
    private String username;
    private String password;
    protected String role; 

    public Pengguna(String nama, String username, String password, String role) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("karyawan")) {
            this.role = role;
        } else {
            System.out.println("Role tidak valid! Harus 'admin' atau 'karyawan'.");
        }
    }
}
