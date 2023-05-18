import java.util.Scanner;

public class num {
    public static void num(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = 1000;
        int num1000_01 = a / 1000;
        int num100_01 = a / 100 ;
        int num10_01 = a / 10 ;
        int num1_01 = a % 10;
        System.out.println(num100_01);

    }
}