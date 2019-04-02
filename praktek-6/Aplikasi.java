public class Aplikasi {

    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa();
        m1.nama = "tamami";
        Mahasiswa.namaStatic = "tamami-static";

        System.out.println(m1.nama);
        System.out.println(m1.namaStatic);

        Mahasiswa m2 = new Mahasiswa();
        m2.nama = "diva";
        m2.namaStatic = "diva-static";

        System.out.println(m2.nama);
        System.out.println(m2.namaStatic);
        System.out.println(m1.nama);
        System.out.println(m1.namaStatic);
    }

    class Matematika {
        public int add(int a, int b) {
            return a + b;
        }
    }

}