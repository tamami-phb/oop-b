import entity.*;
import service.*;
import java.util.*;

public class Aplikasi {

    private static ServiceMahasiswa service;
    private static Scanner scanner;

    public static void main(String[] args) {
        service = new ServiceMahasiswa();

        int opsi = 5;
        do {
            cetakMenu();
            scanner = new Scanner(System.in);
            opsi = scanner.nextInt();
            prosesMenu(opsi);
        } while(opsi != 5);
    }

    private static void prosesMenu(int opsi) {
        switch(opsi) {
            case 1:
                formTambahData();
                break;
            case 2:
                formUbahData();
                break;
            case 3:
                formHapusData();
                break;
            case 4:
                service.cetakData();
                break;
        }
    }

    private static void formHapusData() {
        System.out.println("\nForm Hapus Data");
        scanner = new Scanner(System.in);
        System.out.print("NIM : ");
        String nim = scanner.nextLine();
        service.hapusData(nim);
    }

    private static void formUbahData() {
        String nim, nama, kelas;
        System.out.println("\nForm Ubah Data");
        scanner = new Scanner(System.in);
        System.out.print("NIM : ");
        nim = scanner.nextLine();
        System.out.print("NAMA : ");
        nama = scanner.nextLine();
        System.out.print("KELAS : ");
        kelas = scanner.nextLine();
        service.ubahData(new Mahasiswa(nim, nama, kelas));
    }

    private static void formTambahData() {
        String nim, nama, kelas;
        System.out.println("\nForm Tambah Data");
        scanner = new Scanner(System.in);
        System.out.print("NIM : ");
        nim = scanner.nextLine();
        System.out.print("NAMA : ");
        nama = scanner.nextLine();
        System.out.print("KELAS : ");
        kelas = scanner.nextLine();
        simpanDataBaru(new Mahasiswa(nim, nama, kelas));
    }

    private static void simpanDataBaru(Mahasiswa mhs) {
        service.tambahData(mhs);
    }

    private static void cetakMenu() {
        System.out.println("--- Aplikasi Mahasiswa =---");
        System.out.println("1. tambah data");
        System.out.println("2. ubah data");
        System.out.println("3. hapus data");
        System.out.println("4. tampilkan data");
        System.out.println("5. KELUAR");
        System.out.println("-------------");
        System.out.print  ("Pilihan > ");
    }

}