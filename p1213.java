import java.io.*;

public class p1213 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 문자별로 나누기
    int[] arrAlpha = new int[26];
    for (int i=0; i<str.length(); i++) {
      arrAlpha[str.charAt(i)-'A']++;
    }

    // 홀수 갯수 검사 (2개 이상이면 쏘리 한수)
    int oddIdx = -1;
    int oddCnt = 0;
    for (int j=0; j<arrAlpha.length; j++) {
      if (arrAlpha[j]%2 == 1) {
        oddIdx = j;
        oddCnt++;
      }
    }
    if (oddCnt < 2) {
      // 홀수 갯수가 1개 이하일 때 팰린드롬 진행
      String c;
      for (int k=0; k< arrAlpha.length; k++) {
        c = String.valueOf((char) (k+'A'));
        bw.write(c.repeat(arrAlpha[k]/2));
      }
      if (oddIdx >= 0) bw.write(String.valueOf((char) (oddIdx+'A')));
      for (int l=arrAlpha.length-1; l>=0; l--) {
        c = String.valueOf((char) (l+'A'));
        bw.write(c.repeat(arrAlpha[l]/2));
      }
      bw.flush();
      bw.close();
    } else {
      System.out.print("I'm Sorry Hansoo");
    }
  }
}
