import java.util.Scanner;

public class Hit_ball_game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String xo[][] = new String[3][3];
        for (int z = 0; z < xo.length; z++) {
            System.out.println("enter X");
            int x = in.nextInt();
            System.out.println("enter Y");
            int y = in.nextInt();
            for (int j = 0; j < xo[z].length; j++) {
                xo[z][j] = "#";
                System.out.print(xo[z][j]);
            }
            System.out.println();
        }
    }
}

