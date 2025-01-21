import java.util.Scanner;

public class p2442 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        int n = sn.nextInt();

        for (int i=1; i<=n; i++) {
            int k = ((n * 2 - 1) - (i * 2 - 1))/2;
            for (int l=1; l<=k; l++) {
                System.out.print(" ");
            }

            for (int j=1; j<=2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}

