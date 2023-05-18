public class HW {
    public static void printMe()
    {
        System.out.println("Printing...");
        printMe();
    }

    public static void main(String[] args) {
        printMe();
    }
}