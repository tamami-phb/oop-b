public class Aplikasi {
    public static void main(String[] args) {
        int angka = 0;

        if(args.length == 1) {
            angka = Integer.parseInt(args[0]);
            String hasil =
                    (angka % 2 == 0) ? "genap" : "ganjil";
            System.out.println(angka + " : " + hasil);
        } else {
            System.out.println("Gunakan : java Aplikasi {angka}");
        }

        Mahasiswa mhs[] = {
          new Mahasiswa("19001", "tamami"),
          new Mahasiswa("19002", "diva"),
          new Mahasiswa("19003", "nabila")
        };
        System.out.println("for");
        int i=0;
        for(; i < mhs.length;) {
            mhs[i].cetak();
            i++;
        }

        System.out.println("\n\nanother for");
        for(Mahasiswa data : mhs) {
            data.cetak();
        }
    }
}