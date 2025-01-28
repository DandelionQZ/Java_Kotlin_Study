import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3003 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] pc = new int[]{1, 1, 2, 2, 2, 8};
    for (int i=0; i<pc.length; i++) {
      pc[i] -= Integer.parseInt(st.nextToken());
      System.out.print(pc[i]+" ");
    }
  }
}
