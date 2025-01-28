import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2839 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int kg = Integer.parseInt(br.readLine());
    int total;
    int bag = 0;
    for (int i=kg/5; i>=0; i--) {
      total = kg;
      total -= i*5;

      if (total%3 == 0) {
        bag = i + total/3;
        break;
      } else {
        bag = -1;
      }
    }

    System.out.println(bag);
  }
}
