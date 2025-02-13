###  자바 코드의 구조
```java
// 클래스 블록
public class 클래스명(Sample) {

  // 메서드 블록
  // public → protected → default → private 순으로 접근 범위가 좁아진다.
  [public|protected|default|private] [static] (리턴자료형|void) 메서드명1 (입력자료형 매개변수, ...) {
    명령문(statement);
  }
  
  // 속성
  private String message;
  
  // 생성자
  Sample(String message) {
      this.message = message;
  }
  
  public static void main(String[] args) {
      System.out.println("printing");
  }
}
```
클래스의 기본 접근제어자는 default(package-private)이다.  
클래스 내부 멤버(변수, 메서드)의 기본 접근제어자도 default(package-private)이다.

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
    // => print things 3
    
    System.out.println(String.format("print things %s", "three"));
    // => print things three
    ```
- 변수 대입 (1 또는 2개 이상)
    ```java
    int num = 3;
    String str = "test";
    
    System.out.println(String.format("Me %d and do %s", num, str));
   // => Me 3 and do test
    ```
- 문자열 포맷 코드   

  | 코드 | 설명 | 특징                                                                                                                           |  
  | --- | --- |------------------------------------------------------------------------------------------------------------------------------|  
  | %s | String | 자동으로 전달되는 파라미터 값을 문자열로 바꾸어 사용. 따라서 3이나 3.14는 %d, %f를 사용해야하지만 %s를 사용해 문자열로 전달 가능. <br/>%10s나 %-10s처럼 전체길이를 지정해서 남은 공간은 공백으로 처리 가능. |  
  | %c | Character |                                                                                                                              |  
  | %d | Integer |                                                                                                                              |  
  | %f | Floating-Point | %.4f처럼하면 원하는 소숫점 자리까지만 출력 가능하게 할 수 있음. <br/>%10.4f의 의미는 총 10자리수인데 오른쪽 정렬하고 소숫점 4자리까지만 출력하고 나머지는 공백으로 처리.                          |  
  | %o | 8진수 |                                                                                                                              |  
  | %x | 16진수 |                                                                                                                              |  
  | %% | Literal % | 문자열 포맷 코드가 없다면 그냥 %만 단독으로 사용 가능.                                                                                             |  

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

### 리스트
- 리스트 자료형 : ArrayList, Vector, LinkedList 등이 있다.
- ArrayList a = new ArrayList();
  - a.add(b); a.add(n, b); → (맨 뒤 또는 n번째 위치에) b 추가
  - a.get(n); → n번째 요소 리턴
  - a.size(); → 갯수 리턴
  - a.contains(b) → b가 있는지 확인 후 boolean 리턴
  - a.remove(b); a.remove(n); → (객체 b 또는 n번째 요소를) 삭제 → 이후 객체는 boolean을, 인덱스는 요소값을 리턴
- 제네릭스 도입
  - 이유 : 자료형을 강제로 바꿀 때 생기는 캐스팅 오류 감소
  - ArrayList<String> a = new ArrayList<>();
  - 제네릭스를 사용하지 않을시 모든 객체는 Object 자료형으로 인식되는데, 모든 객체가 상속중인 기본적인 자료형이므로, 특정 자료형의 변수에 값을 옮겨 넣을 때는 해당 자료형으로 캐스팅을 해줘야 함.  
    String b = (String) a.get(0);
- ArrayList 객체에 add를 사용하지 않고 바로 요소 추가하는 방법   
  ArrayList<int> a = new ArrayList<>(Arrays.asList(1,2,3));  
  (Arrays.asList()안에 배열 변수를 넣어도 됨)  

### String.join 메서드
리스트 또는 문자열 배열의 각 요소에 구분자를 넣을 수 있다.
- 리스트
  ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3));  
  String.join(”-”, a); → 1-2-3  
- 문자열 배열
  String[ ] a = new String[ ]{”1”, “2”, “3”};  
  String.join(”,”, a); → 1,2,3  

### 리스트 정렬
ArrayList객체.sort(Comparator.naturalOrder()); → 오름차순 정렬됨  
ArrayList객체.sort(Comparator.reverseOrder()); → 내림차순 정렬됨

### Map (Hash) 자료형
- 맵 자료형에는 HashMap, LinkedHashMap, TreeMap 등이 있다.
- key와 value가 쌍을 이뤄 구성되었다. 순서에 의존하지 않는다.
- HashMap<String, Integer> a = new HashMap<>();
  - a.put(”apple”, 3);
  - a.get(”apple”); → 3 리턴  
    a.get(”banana”); → (없는 값이라) null 리턴  
    a.getOrDefault(”banana”, 0); → (없지만 설정해둔 기본값) 0 리턴  
  - a.containsKey(”cookie”); → boolean 리턴
  - a.remove(”apple”); → 해당 key를 삭제하고 value 리턴
  - a.size(); → 맵 요소 개수 리턴
  - a.keySet(); → 맵의 모든 key를 모아서 [ ]로 리턴
- 입력된 순서대로 데이터를 저장하고 싶을 때 : LinkedHashMap 사용
- 입력된 key의 오름차순으로 데이터를 저장하고 싶을 때 : TreeMap 사용

### Set 자료형
- 집합 자료형에는 HashSet, LinkedHashSet, TreeSet 등이 있다.
- 중복을 허용하지 않는다. 순서가 없다.
- HashSet<Integer> a = new HashSet<>(Arrays.asList(1,2,3));  
  HashSet<Integer> b = new HashSet<>(Arrays.asList(3,4,5));
  - 교집합 (원본 데이터 유지하며)  
    HashSet<Integer> A = new HashSet<>(a);  
    A.retainAll(b);
  - 데이터 1개씩 추가  
    a.add(100);
  - 합집합 (원본 데이터 유지하며) (한 번에 값 추가에도 사용)  
    HashSet<Integer> A = new HashSet<>(a);  
    A.addAll(b);
  - 차집합  (원본 데이터 유지하며) (특정 값 제거에도 사용)  
    HashSet<Integer> A = new HashSet<>(a);  
    A.removeAll(b);
- 입력된 순서대로 데이터를 저장하고 싶을 때 : LinkedHashSet 사용
- 입력된 key의 오름차순으로 데이터를 저장하고 싶을 때 : TreeSet 사용

### enum (상수 집합)
- 내부적으로 0부터 시작하는 정수값을 가진다.
  ```java
  enum Sample {
    AMERICANO,
    ICE_AMERICANO,
    CAFE_LATTE
  };
  ```
- Sample.AMERICANO → AMERICANO  리턴  
  Sample.AMERICANO.name() → AMERICANO  리턴
- for 문에서 enum 사용하기  
  for(Sample a: Sample.values()) {System.out.println(a);}

### 형변환
- 숫자로
  - Integer.parseInt(st);
  - Double.parseDouble(st);
  - Float.parseFloat(st);
- 문자열로
  - Integer.toString(n);
  - String.valueOf(n);
- double → int로 (반대는 캐스팅 필요 없음)
  - double d = 3.45;  
    int i = (int) d; → 3 리턴
- 실수인 문자열을 정수로 바꿀때 나타나는 오류는 NumberFormatException이다.

### final  
값을 한번 설정하면 재할당 할 수 없다.  
리스트가 final인 경우 add나 remove는 가능하다. 이 마저 금지하고 싶다면 리스트를 만들 때 List.of를 사용해서 만들면 된다.   
final List<Integer> a = List.of(1, 2);  
a.add(3); → UnsupportedOperationException 오류 발생

### if 문
elif 아니고 else if 이다.

### while 문
Ctrl-C를 눌러서 무한 루프를 빠져나올 수 있다.  
break와 continue가 있다.

### for 문
continue가 있다.

### print vs println vs printf
print → 줄바꿈 없이 출력  
println → 자동 줄바꿈해서 출력  
printf → System.out.println(System.format())와 동일 (문자열 포매팅)

### for each 문
for ([자료형] [변수명]: [객체명]) { 여기서 변수명 사용 }

### 객체지향 메서드
void인 메서드에서는 출력 값 없이 return을 단독으로 사용해서 메서드를 즉시 빠져나갈 수 있다.

### 상속
extends로 상속 받는다.  
A가 B의 상위개념 이라서, ‘B는 A이다’라고 말할 수 있는 관계를 IS-A(상속)관계라고 한다.  
B 클래스의 객체를 A 클래스 자료형으로 사용한다면, B 클래스에 구현된 변수와 메서드는 사용하지 못한다.  
A클래스의 객체를 B 클래스 자료형으로 선언하면 컴파일 오류가 난다.
- 메서드 오버라이딩
  - 메서드의 이름, 매개변수, 리턴 타입이 모두 동일해야 한다.
  - 접근 제어자(public, protected 등)는 상위 클래스의 메서드보다 더 좁은 범위로 변경할 수 없다.
    - public → protected → default → private 순으로 접근 범위가 좁아진다.
    - 예: 상위 클래스가 protected면 하위 클래스는 protected나 public만 가능
  - 예외(Exception)는 상위 클래스의 메서드보다 더 큰 범위의 예외를 던질 수 없다.
  - @Override 어노테이션을 사용하면 오버라이딩이 제대로 되었는지 컴파일러가 체크해준다.
- 메서드 오버로딩
  - 같은 클래스 내에서 동일한 이름의 메서드를 여러 개 정의하는 것이다.
  - 메서드 오버로딩 규칙
    - 메서드 이름이 같아야 한다.
    - 매개변수의 개수나 타입이 달라야 한다.
    - 매개변수는 같고 리턴 타입만 다른 경우는 오버로딩이 성립하지 않는다.
    - 접근 제어자는 영향을 주지 않는다.
- 자바는 다중상속을 지원하지 않는다.

### 생성자
클래스명과 메서드명이 같고, 리턴 타입을 정의하지 않는다(void도 안됨).  
생성자를 구현하고서 디폴트 생성자도 사용하고 싶다면 직접 작성해줘야한다.  
생성자 오버로딩이 가능하다.

### 인터페이스
```java
// 선언
interface Fruit {
  String getColor(); // implements한 클래스들이 강제로 구현하도록 함
  (pulblic) defualt void printColor() { // 디폴트 자료형으로 구현체 가짐 
    System.out.printf("my color is %s\n", getFood());
  }
}

// 사용
class Apple extends Food implements Fruit {
  public String getColor() {
    return "red";
  }
}
class Banana extends Food implements Fruit {
  public String getColor() {
    return "yellow";
  }
}

// 샘플
void eat(Apple a) { } // YES (but BAD)
void eat(Fruit f) { } // YES
```
다른 클래스에서 Apple이나 Banana 클래스의 객체를 넘겨받을 때, 각각의 클래스 자료형이 아니라 implements 받은 Fruit 인터페이스 자료형으로 묶어서 받을 수 있다.  
인터페이스에서는 구현체가 없는 메서드를 선언하므로써 implements한 클래스에서 강제로 구현하도록 할 수 있다.  
디폴트 메서드를 사용하면 구현체를 가진 메서드를 인터페이스에서 선언할 수 있으며, 오버 라이딩이 가능하다.  
콤마(,)를 이용하여 인터페이스를 여러개 implements할 수 있다. (하나의 객체가 여러 개의 자료형 타입을 가질 수 있고, 이것을 다형성이라고 한다.)  
장점은 복잡한 분기문을 간단하게 처리할 수 있다.  
만약 서로 다른 인터페이스의 메서드를 사용하고 싶다면,  
  - 두 인터페이스를 구현한 특정 클래스의 객체를 그대로 사용하거나
  - 두 인터페이스를 extends한 새로운 interface를 만들어서 사용한다.
 
interface는 일반 클래스와 달리 extends를 이용하여 다중 상속을 받을 수 있다.

### 추상 클래스
인터페이스의 역할도 하면서 클래스의 기능도 가지고 있다.
```java
abstract class Apple extends Food {
  abstract String getColor();
  void printColor() {
    // 구현체    
  }
}
```

### interface vs abstract class
- 클래스를 정의할 때
  - 인터페이스 → interface [클래스 이름]
  - 추상 클래스 → abstract class [클래스 이름]
- interface
  - 객체변수x
  - 본인: extends로 다른 인터페이스 가능 (다중상속o)  
    다른 클래스: implements로 다형성 가능
    ```java
    // 추상 메서드 (구현체x)
    (public abstract) [자료형] [메서드명];
    
    // 구현체o
    (public) default [자료형] [메서드명]; -- 재정의 가능
    (public) static [자료형] [메서드명]; -- 재정의 불가능 
    private [자료형] [메서드명]; -- default, static에서 사용 가능. 외부접근, 재정의 x. 
    ```
- abstract class
  - 객체변수o, 생성자o
  - 단독으로 객체 생성x, 반드시 상속 통해서. 
  - 본인: extends로 다른 클래스 상속 가능 (다중상속x)  
    다른 클래스: extends로 상속 가능  
    class Sample extends SamAbsCla { }
    ```java
    // 추상 메서드 (구현체x)
    (default)[public|protected] abstract [자료형] [메서드명]; -- private 불가능
    
    // 구현체o
    (default)[public|protected|private] [자료형] [메서드명]; -- 모두 가능
    ```

### 콘솔 입력
```java
InputStream a = System.in;
InputStreamReader b = new InputStreamReader(a);
BufferReader c = new BufferReader(b);

String z = c.readLine();
System.out.println(z);
```
- InputStream : byte를 읽는다  
  → byte[ ] x = new byte[3]; a.read(x); System.out.println(x[0]); [abc → a]
- InputStreamReader : character를 읽는다   
  → char [ ] y = new char[3]; b.read(y); System.out.println(y); [abc → abc]
- Scanner (b, c, z 과정을 합체)
    ```java
    Scanner sc = new Scanner(System.in);
    System.out.println(sc.next());
    ```
  - next: 입력된 값을 공백을 기준으로 string타입으로 리턴
  - nextLine: 입력된 값 한줄을 string타입으로 리턴
  - nextInt: 입력된 값을 integer타입으로 리턴
  - 외에도 nextBigDecimal, nextBigInteger, nextByte 등이 있다. 

### 파일 쓰기
- FileOutputStream  
  만약 파일 생성 경로가 c:/로 시작되지 않는다면 java.exe을 실행하는 폴더 내에 생성된다.  
  (윈도우) \r\n로 줄바꿈.  
  getByte() 사용 필요.  
    ```java
    FileOutputStream a = new FileOutputStream("파일 생성 경로");
    a.write(String변수.getByte());
    a.close();
    ```
- FileWriter  
  (윈도우) \r\n로 줄바꿈.  
  getByte() 필요 없음.  
    ```java
    FileWriter a = new FileWriter("파일 생성 경로");
    a.write(String변수);
    a.close();
    
    // 내용 추가 (write 동일)
    FileWriter a2 = new FileWriter("원본 파일 경로", true);
    ```
- PrintWriter  
  (윈도우) \r\n 필요 없음. println로 자동 줄바꿈. (이유: System.out 대신 PrintWriter 객체 이용)  
  getByte() 필요 없음.  
    ```java
    PrintWriter a = new PrintWriter("파일 생성 경로");
    a.println(String변수);
    a.close();
    
    // 내용 추가 (println 동일)
    PrintWriter a2 = new PrintWriter(new FileWriter("원본 파일 경로", true));
    ```

### 파일 읽기
- FileInputStream 클래스가 있는데, 이건 byte로 읽어와서 그 배열을 new String을 통해 문자열로 바꾸는 번거로움이 있다. (PASS)
- FileReader와 BufferedReader 조합  
    ```java
    BufferedReader a = new BufferedReader(new FileReader("원본 파일 경로"));
    while(true) {
    	String line = a.readLine();
    	if (line == null) break;
    	System.out.println(line);
    }
    a.close();
    ```

### 패키지
- 패키지 파일을 생성하고, 거기서 자바 클래스 생성.
- 상단에 package 패키지명 <<을 추가한다.
- 서브 패키지는 상위패지키명.하위패키지명 <<으로 만든다.

### 스태틱
- 변경이 안되게 하고 싶은 스태틱 → final static [자료형] 변수명
- 스태틱 메서드는 크래스를 통해 호출한다.
- 내부에서 스태틱 변수가 아닌 변수는 사용 불가능하다.
- 싱글톤 패턴은 단 하나의 객체만을 생성하게 하는 것이다. 생성자를 private 접근제어자로 설정하여 다른 클래스에서 new를 이용하여 객체를 생성할 수 없게 하는 것이다.
    ```java
    class Sample {
    	private static Sample a;
    	private static Sample() { };
    	
    	// 외부 클래스에서 이 메서드를 호출해서 private static 생성자에 접근한다. 
    	public static Sample getInstance() {
    		if(a == null) {
    			a = new Sample();
    		}
    		return a;
    	}
    }
    ```

### 예외 처리
- FileNotFoundExceptoin → 존재하지 않는 파일 접근시 발생
- ArithmeticException → 0으로 나눗셈할 때 발생
- ArrayIndexOutOfBoundsException → 배열 크기를 벗어났을 때 발생
```java
int c;
try {
    c = 4 / 0;
    System.out.println("BAD");  // 예외 발생시 수행되지 않는다.
} catch (ArithmeticException e) {
    c = -1;
} finally {
    System.out.println("OK");  // 예외에 상관없이 무조건 수행된다.
}
```
- 메서드 내에서 예외 발생 (throw 사용)
  - RuntimeException → 실행 시 발생하는 예외 (발생할 수도 않을 수도 있는 경우에 사용)  
    클래스에서 extends로 상속받아 커스텀 예외를 만들 수 있다.  
    특징 : 바로 throw new A(); 호출 가능  
      ```java
      class A extends RuntimeException { }
      
      class Sample {
          if(조건) {
              throw new A(); 
          }
      }
      ```
  - Exception → 컴파일 시 발생하는 예외 (예측이 가능한 경우에 사용)  
    클래스에서 extends로 상속받아 커스텀 예외를 만들 수 있다.  
    특징 : try-catch문에서 throw new A(); 호출 가능  
      ```java
      class A extends Exception { }
      
      class Sample {
          try {
              if(조건) {
                  throw new A();
              }
          } catch(A e) {
              // 실행문
          }
      }
      ```
- 메서드 외에서 예외 발생 (throws 사용)  
  해당 메서드가 처리하지 않은 예외를 호출자(주로 main)에게 전달한다.  
    ```java
    class A extends Exception {
    }
    
    public class Sample {
        public void 메서드(파라미터) throws A { // 여기서 throws로 예외 호출하면 
            if(조건) {
                throw new A();
            }
        }
    
        public static void main(String[] args) { // Sample 객체를 호출한 여기서 예외 처리하게 된다. 
            Sample sample = new Sample();
            try {
                sample.메서드(인수);
                sample.메서드(인수);
            } catch (A e) {
                System.err.println("A이 발생했습니다.");
            }
        }
    }
    
    ```
- 트랜잭션  
  트랜잭션은 하나의 작업단위로써 롤백을 통해 데이터들의 값이 서로 일관성 있게 일치하도록 한다.

### 스레드
- Thread라는 클래스 자체가 있고 extends로 상속받아서 사용한다.
- Thread 상속시 반드시 run 메서드를 구현해야한다.
- run 메서드는 객체의 start 메서드로 실행한다.  
  `Thread t = new Sample(인수);`
- 스레드는 순서대로 실행되지 않으며, main 메서드가 종료되어도 본인 할일을 하다가 종료된다.
- 특정 스레드가 종료될 때까지 기다리고 싶으면 객체의 join 메서드를 사용한다.
- Thread를 상속받게 되면 다른 클래스를 상속받지 못 하니까 이때 Thread 상속 대신 Runnable 인터페이스를 implements 받는 방법이 있다.
- Runnable 인터페이스는 동일하게 run 메서드를 구현하도록 강제한다.
- Runnable 인터페이스 사용시 객체 생성은 다음과 같다.  
  `Thread t = new Thread(new Sample(인수));`

### 함수형 프로그래밍
- 람다와 스트림을 사용하는 이유는 코드의 양이 줄어들고 읽기 쉬운 코드를 만들 수 있기 때문이다.
- 람다
  - 익명함수이다. 따라서 인터페이스의 메서드를 구현할 때 굳이 implements 하는 클래스 없이, 해당 인터페이스의 메서드를 람다로 구현해서 사용할 수 있다. 람다로 인터페이스 메서드를 구현하는 경우, 반드시 메서드는 하나만 있어야 가능하며, 이를 인터페이스에 @FunctionalInterface 어노테이션을 사용하여 명시해준다. (함수형 인터페이스임을 표시하며 하나의 메서드만 가질 수 있게 한다.)
      ```java
      @FunctionalInterface
      interface A {int sum(int x, int y)}
      
      // main 메서드
      A sample = (int x, int y) -> x+y; // 람다로 메서드 구현
      sample.sum(1,2);
      
      // 람다 축약
      // 1
      A sample = (x, y) => x+y; // 자료형이 이미 인터페이스의 파라미터로 입력되어있으니 생략 가능
      // 2
      A sample = Integer::sum; // Integer의 sum 함수와 구현 내용이 같으므로 이렇게 작성 가능
      // 이때 (클래스명)::(메서드명) 이렇게 구분한다. 
      ```
- 스트림  
  같은 데이터를 갖고 여러 작업을 진행후 결과를 내야할 때 스트림을 이용하면 간결하게 작업을 진행할 수 있다.  
  .stream으로 스트림 생성시 원시타입으로 생성되니 warraped로 생성하고 싶드면 이후에 .boxed()로 해줘야한다.  
  스트림을 생성하고 boxed, filter, distinct, sorted, mapToInt 등 스트림 가공 메서드를 사용할 수 있다.  

### 기타
- A를 extends한 B의 객체인지 확인하기 → i instanceof B
