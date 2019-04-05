package service;

import entity.*;
import java.util.*;

public class ServiceMahasiswa {

    private static List<Mahasiswa> data = new LinkedList<Mahasiswa>();

    public void tambahData(Mahasiswa mhs) {
        ServiceMahasiswa.data.add(mhs);
        System.out.println("data telah tersimpan");
    }

    public void ubahData(Mahasiswa mhs) {
        int result = data.indexOf(mhs);
        if(result >= 0) {
            data.set(result, mhs);
            System.out.println("data telah berubah");
        }
    }

    public void hapusData(String nim) {
        int idx = data.indexOf(new Mahasiswa(nim, "", ""));
        if(idx >= 0) {
            data.remove(idx);
            System.out.println("Data telah terhapus");
        } else {
            System.out.println("Datanya memang tidak ada");
        }
    }

    public void cetakData() {
        System.out.println("--- cetak data");
        int i=1;
        for(Mahasiswa mhs : data) {
            System.out.println("data ke-" + i++);
            System.out.println("   nim : " + mhs.getNim());
            System.out.println("   nama : " + mhs.getNama());
            System.out.println("   kelas : " + mhs.getKelas());
        }
    }

}