public class Mahasiswa {

    String nim;
    String nama;

    //Mahasiswa() {
    //    nim = "19000";
    //    nama = "tidak ada nama";
    //}

    Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    void cetak() {
        System.out.println(nim + " : " + nama);
    }

}