import java.util.*;

public class Aplikasi {

    public static void main(String[] args) {
        List<String> data = new LinkedList<String>();
        data.add("Nasi Goreng");
        data.add("Mie Goreng");
        data.add("Es Kopyor");
        data.add("Es Teh");
        data.add("Es Jeruk");

        System.out.println("data asli:");
        for(String s : data) {
            System.out.println(s);
        }

        Collections.sort(data);
        System.out.println("\ndata hasil urut:");
        for(String s : data) {
            System.out.println(s);
        }

        int result = Collections.binarySearch(data, "Es Teh");
        System.out.println("ada di : " + result);
        result = Collections.binarySearch(data, "Lemon Tea");
        System.out.println("ada di : " + result);
    }

}