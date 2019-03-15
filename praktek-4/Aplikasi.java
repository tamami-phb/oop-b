import entitas.*;

public class Aplikasi {

    public static void main(String[] args) {
        Mahasiswa[] dataMhs = {
          new Mahasiswa("19001", "tamami"),
          new Mahasiswa("19002", "diva"),
          new Mahasiswa("19003", "nabila")
        };

        for(Personal personal : dataMhs) {
            personal.cetak();
        }

        //Personal p1 = new Personal("1984001", "honda");
        //p1.cetak();

        System.out.println();
        Dosen d1 = new Dosen();
        Dosen d2 = new Dosen();
        d1.setNid("1984001");
        d2.setNid("1989001");
        d1.setNama("honda");
        d2.setNama("shizuka");
        d1.cetak();
        d2.cetak();
    }

}