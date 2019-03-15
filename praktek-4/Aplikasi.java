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

        System.out.println("\nexperiment");
        Personal personal = new Personal("1984001", "tamami");
        Personal p1 = new Personal("1988001", "honda");
        Personal p2 = new Personal("1988001", "honda");
        System.out.println(personal);
        System.out.println(personal.getNama() + " : " +
                personal.hashCode());
        System.out.println(p1.getNama() + " : " +
                p1.hashCode());
        System.out.println(p2.getNama() + " : " +
                p2.hashCode());

        System.out.println();
        System.out.println(new Personal("1988001", "honda").hashCode());
        System.out.println(new Personal("1988001", "honda").hashCode());
    }

}