import java.util.ArrayList;
import java.util.Scanner;
import model.Barang;
import model.Pengguna;

public class ManajemenToko {
    private static ArrayList<Pengguna> daftarPengguna = new ArrayList<>();
    private static ArrayList<Barang> daftarBarang = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opsi;

        do {
            System.out.println("\n===                   ADMIN DATANG                  ===");
            System.out.println("\n===                       KE                        ===");
            System.out.println("\n=== SISTEM MANAJEMEN INVENTARIS TOKO BANGUNAN YURPA ===");
            System.out.println("1. Kelola Pengguna");
            System.out.println("2. Kelola Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            opsi = input.nextInt();

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
            opsi = input.nextInt();

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
        } while (opsi != 0);
    }

    private static void tambahPengguna(Scanner input) {
        input.nextLine(); 
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Username: ");
        String username = input.nextLine();
        System.out.print("Masukkan Password: ");
        String password = input.nextLine();
        System.out.print("Masukkan Peran (admin/karyawan): ");
        String peran = input.nextLine();

        daftarPengguna.add(new Pengguna(nama, username, password, peran));
        System.out.println("Pengguna berhasil ditambahkan!");
    }

    private static void tampilkanPengguna() {
        if (daftarPengguna.isEmpty()) {
            System.out.println("Tidak ada pengguna terdaftar.");
        } else {
            for (Pengguna p : daftarPengguna) {
                System.out.println("Nama: " + p.nama + ", Peran: " + p.role);
            }
        }
    }

    private static void perbaruiPengguna(Scanner input) {
        input.nextLine();
        System.out.print("Masukkan Nama Pengguna yang akan diperbarui: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Peran Baru: ");
        String peranBaru = input.nextLine();

        for (Pengguna p : daftarPengguna) {
            if (p.nama.equals(nama)) {
                p.role = peranBaru;
                System.out.println("Data pengguna berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Pengguna tidak ditemukan.");
    }

    private static void hapusPengguna(Scanner input) {
        input.nextLine();
        System.out.print("Masukkan Nama Pengguna yang akan dihapus: ");
        String nama = input.nextLine();

        daftarPengguna.removeIf(p -> p.nama.equals(nama));
        System.out.println("Pengguna berhasil dihapus!");
    }

    private static void menuBarang(Scanner input) {
        int opsi;
        do {
            System.out.println("\n=== MANAJEMEN BARANG ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Barang");
            System.out.println("3. Perbarui Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            opsi = input.nextInt();

            switch (opsi) {
                case 1:
                    tambahBarang(input);
                    break;
                case 2:
                    tampilkanBarang();
                    break;
                case 3:
                    perbaruiBarang(input);
                    break;
                case 4:
                    hapusBarang(input);
                    break;
                case 0:
                    System.out.println("Kembali ke menu utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (opsi != 0);
    }

    private static void tambahBarang(Scanner input) {
        input.nextLine();
        System.out.print("Masukkan Nama Barang: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Harga: ");
        double harga = input.nextDouble();
        System.out.print("Masukkan Stok: ");
        int stok = input.nextInt();
        input.nextLine();
        System.out.print("Masukkan Deskripsi: ");
        String deskripsi = input.nextLine();

        daftarBarang.add(new Barang(nama, harga, stok, deskripsi));
        System.out.println("Barang berhasil ditambahkan!");
    }

    private static void tampilkanBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Tidak ada barang tersedia.");
        } else {
            for (Barang b : daftarBarang) {
                System.out.println("Nama: " + b.nama_barang + ", Stok: " + b.stok);
            }
        }
    }

    private static void perbaruiBarang(Scanner input) {
        input.nextLine();
        System.out.print("Masukkan Nama Barang yang akan diperbarui: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Stok Baru: ");
        int stokBaru = input.nextInt();

        for (Barang b : daftarBarang) {
            if (b.nama_barang.equals(nama)) {
                b.stok = stokBaru;
                System.out.println("Data barang berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    private static void hapusBarang(Scanner input) {
        input.nextLine();
        System.out.print("Masukkan Nama Barang yang akan dihapus: ");
        String nama = input.nextLine();
        daftarBarang.removeIf(b -> b.nama_barang.equals(nama));
        System.out.println("Barang berhasil dihapus!");
    }
}
