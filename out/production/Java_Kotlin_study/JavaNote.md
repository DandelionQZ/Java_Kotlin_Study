# 문자 <-> 숫자
일단 `charAt(a)-'0'`라는게 있다.  
`charAt(a)`는 문자열의 a번째 문자를 갖고 온다.  
문자끼리 가감을 하게되면 유니코드 값을 계산하게 되는데,
100부터 시작된 숫자값을 구할 때 107-100으로 7을 구하는 것과 같은 방법이다.
```java
String line = '1010';
char a = line.charAt(0); //'1'
int A = a - '0'; // 1
```
숫자로 문자 만들기
```java
char a = (char) 97;
```

# String 빈줄 무시
str.trim().isEmpty()