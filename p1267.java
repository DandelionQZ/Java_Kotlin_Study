import java.io.*;
import java.util.StringTokenizer;

public class p1267 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int cnt = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int[] sec = new int[cnt];

    for (int i=0; i<cnt; i++) {
      sec[i] = Integer.parseInt(st.nextToken());
    }

    int Y = 0; // 30s 10w
    int M = 0; // 60s 15w
    for (int j=0; j<cnt; j++) {
      Y += sec[j]/30;
      Y++;

      M += sec[j]/60;
      M++;
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    if (Y*10>M*15) {
      bw.write("M "+M*15);
    } else if (Y*10<M*15) {
      bw.write("Y "+Y*10);
    } else {
      bw.write("Y M "+Y*10);
    }
    bw.flush();
    bw.close();
  }
}
