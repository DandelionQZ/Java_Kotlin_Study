import java.util.Scanner;
import java.util.StringTokenizer;

public class p5698{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringTokenizer st;
    String str;
    char prev;
    boolean r;

    while (sc.hasNextLine()) {
      str = sc.nextLine();
      if (str.equals("*") || str.equals("\n")) break;
      r = true;

      str = str.toUpperCase();
      st = new StringTokenizer(str);

      if (str.trim().isEmpty()) continue;
      prev = st.nextToken().charAt(0);

      while (st.hasMoreTokens()) {
        if (prev != st.nextToken().charAt(0)) {
          r = false;
          break;
        }
      }

      if (r) {
        System.out.println("Y");
      } else {
        System.out.println("N");
      }
    }
  }
}
