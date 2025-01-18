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

