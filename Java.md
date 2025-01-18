###  자바 코드의 구조
```java
// 클래스 블록
public class 클래스명(Sample) {

    // 메서드 블록
    [default|public|private|protected] [static] (리턴자료형|void) 메서드명1 (입력자료형 매개변수, ...) {
        명령문(statement);	
    }
	
    // 속성
    private String message;
    
    // 생성자
    public Sample(String message) {
        this.message = message
    }
    
    public static void main(String[] args) {
        System.out.println("printing");
    }
}
```

### 이름 규칙
- ChocoCookie → 파스칼 케이스 → 클래스 이름
- chocoCookie → 카멜 케이스 → 메서드 이름, 변수 이름

### 자료형 String의 내장 메서드
- a.equals(b) → a와 b가 같은지 비교후 boolean을 리턴
- a.indexOf(b) → a에서 b가 있는 위치 인덱스 값 int를 리턴
- a.contians(b) → a에 b가 있는지 확인후 boolean을 리턴
- a.charAt(b) → a에서 b 인덱스 위치의 문자 char을 리턴
- a.replaceAll(x, y) → a에서 모든 x를 y로 변경해서 문자열 리턴
- a.substring(x, y) → a에서 x부터 y-1번째 인덱스까지 문자열을 리턴 (x ≤ a < y)
- a.toUpperCase() → a의 문자열을 전부 대문자로 변경해서 문자열 리턴
- a.split(”b”) → a에서 b를 기준으로 문자열을 나누고, 문자열 배열을 리턴 (b는 반드시 지정필요. 기본값 없음)

### 자료형 String의 문자열 포매팅
- 문자열 리턴/포맷 메서드 (아래 두 개는 같은 역할을 함)
    - System.out.println(System.format())
    - System.out.printf()
- 숫자/문자열 대입 (문자열 포맷 코드 이용)
    ```java
    System.out.println(String.format("print things %d", 3));
    => print things 3
    
    System.out.println(String.format("print things %s", "three"));
    => print things three
    ```
- 변수 대입 (1 또는 2개 이상)
    ```java
    int num = 3;
    String str = "test";
    
    System.out.println(String.format("Me %d and do %s", num, str));
    => Me 3 and do test
    ```
- 문자열 포맷 코드   

| 코드 | 설명 | 특징 |  
| --- | --- | --- |  
| %s | String | 자동으로 전달되는 파라미터 값을 문자열로 바꾸어 사용. 따라서 3이나 3.14는 %d, %f를 사용해야하지만 %s를 사용해 문자열로 전달 가능.  
%10s나 %-10s처럼 전체길이를 지정해서 남은 공간은 공백으로 처리 가능. |  
| %c | Character |  |  
| %d | Integer |  |  
| %f | Floating-Point | %.4f처럼하면 원하는 소숫점 자리까지만 출력 가능하게 할 수 있음.  
%10.4f의 의미는 총 10자리수인데 오른쪽 정렬하고 소숫점 4자리까지만 출력하고 나머지는 공백으로 처리.  |  
| %o | 8진수 |  |  
| %x | 16진수 |  |  
| %% | Literal % | 문자열 포맷 코드가 없다면 그냥 %만 단독으로 사용 가능.  |  

### StringBuffer (mutable)
- StringBuffer a = new StringBuffer();로 객체 생성
- append, insert, substring 메서드 사용해서 수정
  - a.append(”test”);로 문자열 추가
      - String 변수에서도 + 연산으로 문자열 추가 가능하지만, 다른점은 String은 연산이 될 때마다 객체를 새로 만들고, StringBuffer는 처음 생성 객체만 사용한다는 점이다. 또한 StringBuffer가 무거운 편이므로 메모리 사용량도 많다.
  - a.insert(n, b);로 n번째에 문자열 b 추가
- String b = a.toString();으로 문자열 자료형으로 변경

### StringBuilder
StringBuffer와 비슷한 자료형이며 사용법도 같다.  
StringBuffer보다 성능이 우수하다.  
동기화를 고려할 필요가 없다면 StringBulider를 사용하는 것이 유리하다.

### substring
String 자료형의 substring 메서드와 동일하게 작동한다.
a.substring(x, y);로 사용하고 문자열 x ≤ a < y를 뽑아낸다.

### 배열
int[ ] a = {1, 2};  
String[ ] a = new String[7];  
a[0] = “apple”;  
a[1] = “banana”;  
길이를 구할 때는 a.length로 구한다.  
설정된 배열값을 넘어서면 나타나는 오류는 ArrayIndexOutOfBoundsException이다.
