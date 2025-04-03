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
            this.role = role.toLowerCase();
        } else {
            throw new IllegalArgumentException("Peran tidak valid! Harus 'admin' atau 'karyawan'.");
        }
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Username: " + username);
        System.out.println("Peran: " + role);
    }
}

class Admin extends Pengguna {

    public Admin(String nama, String username, String password) {
        super(nama, username, password, "admin"); 
    }

    public void manageUsers() {
        System.out.println("Admin dapat mengelola pengguna lainnya.");
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Ini adalah akun Admin.");
    }
}

class Karyawan extends Pengguna {

    public Karyawan(String nama, String username, String password) {
        super(nama, username, password, "karyawan"); 
    }

    public void viewTasks() {
        System.out.println("Karyawan dapat melihat dan mengerjakan tugas.");
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Ini adalah akun Karyawan.");
    }
}
