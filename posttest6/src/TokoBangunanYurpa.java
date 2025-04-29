import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class TokoBangunanYurpa {
    private static ArrayList<Pengguna> daftarPengguna = new ArrayList<>();
    private static ArrayList<Barang> daftarBarang = new ArrayList<>();
    private static int totalBarang = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opsi;

        do {
            System.out.println("\n=== SISTEM MANAJEMEN INVENTARIS TOKO BANGUNAN YURPA ===");
            System.out.println("1. Kelola Pengguna");
            System.out.println("2. Kelola Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            
            try {
                opsi = input.nextInt();
                input.nextLine(); // Clear buffer

                switch (opsi) {
                    case 1:
                        menuPengguna(input);
                        break;
                    case 2:
                        menuBarang(input);
                        break;
                    case 0:
                        System.out.println("Terima kasih telah menggunakan sistem ini.");
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia!");
                }
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                input.nextLine();
                opsi = -1;
            }
        } while (opsi != 0);

        input.close();
    }

    private static void menuPengguna(Scanner input) {
        int opsi;
        do {
            System.out.println("\n=== MANAJEMEN PENGGUNA ===");
            System.out.println("1. Tambah Pengguna");
            System.out.println("2. Lihat Pengguna");
            System.out.println("3. Perbarui Pengguna");
            System.out.println("4. Hapus Pengguna");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            
            try {
                opsi = input.nextInt();
                input.nextLine(); // Clear buffer

                switch (opsi) {
                    case 1:
                        tambahPengguna(input);
                        break;
                    case 2:
                        tampilkanPengguna();
                        break;
                    case 3:
                        perbaruiPengguna(input);
                        break;
                    case 4:
                        hapusPengguna(input);
                        break;
                    case 0:
                        System.out.println("Kembali ke menu utama.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                input.nextLine();
                opsi = -1;
            }
        } while (opsi != 0);
    }

    private static void tambahPengguna(Scanner input) {
        try {
            System.out.print("Masukkan Nama: ");
            String nama = input.nextLine().trim();
            System.out.print("Masukkan Username: ");
            String username = input.nextLine().trim();
            System.out.print("Masukkan Password: ");
            String password = input.nextLine().trim();
            System.out.print("Masukkan Peran (admin/karyawan): ");
            String peran = input.nextLine().trim().toLowerCase();

            if (nama.isEmpty() || username.isEmpty() || password.isEmpty()) {
                System.out.println("Input tidak boleh kosong!");
                return;
            }

            if (peran.equals("admin")) {
                daftarPengguna.add(new Admin(nama, username, password));
            } else if (peran.equals("karyawan")) {
                daftarPengguna.add(new Karyawan(nama, username, password));
            } else {
                System.out.println("Peran tidak valid. Pengguna tidak ditambahkan.");
                return;
            }

            System.out.println("Pengguna berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    private static void tampilkanPengguna() {
        if (daftarPengguna.isEmpty()) {
            System.out.println("Tidak ada pengguna terdaftar.");
        } else {
            System.out.println("\nDaftar Pengguna:");
            System.out.println("----------------------------------------");
            for (Pengguna p : daftarPengguna) {
                p.tampilkanInfo(true);
                p.hakAkses();
                System.out.println("----------------------------------------");
            }
        }
    }

    private static void perbaruiPengguna(Scanner input) {
        try {
            if (daftarPengguna.isEmpty()) {
                System.out.println("Tidak ada pengguna terdaftar.");
                return;
            }
    
            System.out.print("Masukkan Username Pengguna yang akan diperbarui: ");
            String username = input.nextLine().trim();
            System.out.print("Masukkan Peran Baru (admin/karyawan): ");
            String peranBaru = input.nextLine().trim().toLowerCase();
    
            if (!peranBaru.equals("admin") && !peranBaru.equals("karyawan")) {
                System.out.println("Peran tidak valid!");
                return;
            }
    
            for (Pengguna p : daftarPengguna) {
                if (p.getUsername().equalsIgnoreCase(username)) {
                    p.setRole(peranBaru);
                    System.out.println("Data pengguna berhasil diperbarui!");
                    return;
                }
            }
            System.out.println("Pengguna tidak ditemukan.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
    

    private static void hapusPengguna(Scanner input) {
        try {
            if (daftarPengguna.isEmpty()) {
                System.out.println("Tidak ada pengguna terdaftar.");
                return;
            }

            System.out.print("Masukkan Username Pengguna yang akan dihapus: ");
            String username = input.nextLine().trim();

            boolean removed = daftarPengguna.removeIf(p -> p.getUsername().equals(username));

            if (removed) {
                System.out.println("Pengguna berhasil dihapus!");
            } else {
                System.out.println("Pengguna tidak ditemukan!");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    private static void menuBarang(Scanner input) {
        int opsi;
        do {
            System.out.println("\n=== MANAJEMEN BARANG ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Daftar Barang");
            System.out.println("3. Perbarui Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Lihat Detail Barang");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            
            try {
                opsi = input.nextInt();
                input.nextLine(); // Clear buffer
                
                switch (opsi) {
                    case 1:
                        tambahBarang(input);
                        break;
                    case 2:
                        tampilkanDaftarBarang();
                        break;
                    case 3:
                        perbaruiBarang(input);
                        break;
                    case 4:
                        hapusBarang(input);
                        break;
                    case 5:
                        tampilkanDetailBarang(input);
                        break;
                    case 0:
                        System.out.println("Kembali ke menu utama.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid! Silakan pilih 0-5.");
                }
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                input.nextLine();
                opsi = -1;
            }
        } while (opsi != 0);
    }

    private static void tambahBarang(Scanner input) {
        try {
            System.out.print("Masukkan Nama Barang: ");
            String nama = input.nextLine().trim();
            System.out.print("Masukkan Harga: ");
            double harga = input.nextDouble();
            System.out.print("Masukkan Stok: ");
            int stok = input.nextInt();
            input.nextLine();
            System.out.print("Masukkan Deskripsi: ");
            String deskripsi = input.nextLine().trim();

            if (nama.isEmpty() || deskripsi.isEmpty()) {
                System.out.println("Nama dan deskripsi tidak boleh kosong!");
                return;
            }

            if (harga <= 0 || stok < 0) {
                System.out.println("Harga harus positif dan stok tidak boleh negatif!");
                return;
            }

            Barang barangBaru = new Barang(nama, harga, stok, deskripsi);
            daftarBarang.add(barangBaru);
            totalBarang++;
            System.out.println("Barang berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Input tidak valid! Pastikan format input benar.");
            input.nextLine();
        }
    }

    private static void perbaruiBarang(Scanner input) {
        try {
            if (daftarBarang.isEmpty()) {
                System.out.println("Tidak ada barang tersedia.");
                return;
            }
            
            System.out.print("Masukkan Nama Barang yang akan diperbarui: ");
            String nama = input.nextLine().trim();
            
            for (Barang b : daftarBarang) {
                if (b.getNamaBarang().equalsIgnoreCase(nama)) {
                    System.out.print("Masukkan Harga Baru: ");
                    double hargaBaru = input.nextDouble();
                    System.out.print("Masukkan Stok Baru: ");
                    int stokBaru = input.nextInt();
                    input.nextLine();
                    System.out.print("Masukkan Deskripsi Baru: ");
                    String deskripsiBaru = input.nextLine().trim();
                    
                    if (hargaBaru <= 0 || stokBaru < 0) {
                        System.out.println("Harga harus positif dan stok tidak boleh negatif!");
                        return;
                    }
                    
                    b.setHarga(hargaBaru);
                    b.setStok(stokBaru);
                    b.setDeskripsi(deskripsiBaru);
                    
                    System.out.println("Data barang berhasil diperbarui!");
                    return;
                }
            }
            System.out.println("Barang tidak ditemukan.");
        } catch (Exception e) {
            System.out.println("Input tidak valid!");
            input.nextLine();
        }
    }

    private static void hapusBarang(Scanner input) {
        try {
            if (daftarBarang.isEmpty()) {
                System.out.println("Tidak ada barang tersedia.");
                return;
            }
            
            System.out.print("Masukkan Nama Barang yang akan dihapus: ");
            String nama = input.nextLine().trim();

            boolean removed = daftarBarang.removeIf(b -> b.getNamaBarang().equalsIgnoreCase(nama));
            
            if (removed) {
                totalBarang--;
                System.out.println("Barang berhasil dihapus!");
            } else {
                System.out.println("Barang tidak ditemukan!");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    private static void tampilkanDaftarBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Tidak ada barang tersedia.");
        } else {
            System.out.println("\nDaftar Barang:");
            System.out.println("--------------------------------------------------");
            System.out.printf("| %-20s | %-10s | %-5s |\n", "Nama Barang", "Harga", "Stok");
            System.out.println("--------------------------------------------------");
            
            for (Barang b : daftarBarang) {
                System.out.printf("| %-20s | %-10.2f | %-5d |\n", 
                    b.getNamaBarang(), b.getHarga(), b.getStok());
            }
            System.out.println("--------------------------------------------------");
        }
    }

    private static void tampilkanDetailBarang(Scanner input) {
        try {
            if (daftarBarang.isEmpty()) {
                System.out.println("Tidak ada barang tersedia.");
                return;
            }
            
            System.out.print("Masukkan nama barang yang ingin dilihat: ");
            String nama = input.nextLine().trim();
            
            for (Barang barang : daftarBarang) {
                if (barang.getNamaBarang().equalsIgnoreCase(nama)) {
                    barang.tampilkanInfoBarang(); 
                    System.out.println("Status Stok: " + 
                        (barang.cekStokBarang() ? "Tersedia" : "Habis"));
                    return;
                }
            }
            System.out.println("Barang tidak ditemukan.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}