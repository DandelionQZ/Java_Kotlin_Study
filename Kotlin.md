### 파일 구조
- xml : layout
- kt : code

### 위젯 배치
- wrap content
- fixed
- match constraint
 
### kt 파일 작성
- setContentView(R.layout.activitiy_main)  
  => 해당 xml 파일을 불러옴 
- 변수명 : 타입
- findViewById(R.id.idName)으로 위젯 지정
- 변수명.get... 등의 함수를 찾아서 사용

### 실시간 변경 내용을 바로 UI에 적용
- runOnUiThread{} 사용

### list
- 수정이 가능한 리스트를 만들고 싶으면 mutableListOf 사용
```kotlin
val arr = mutableListOf<Int>{1, 10, 23}
arr.add(0)
```

### 디자인
- 배경 색상 변경 : background 
- 버튼배경 색상 변경 : backgroundTint
- kt 파일에서 요소의 색상 변경 가능
  ```kotlin
  val 변수명 : ConstraintLayout/Button/Textview 등 = findViewById(R.id.idName)
  // 전체 배경인 경우 ConstraintLayout (xml 파일 코드 참고)
  변수명.setBackgroundColor(Color.parseColor("#ff84c6"))
  ```

### 폰트 적용 (중요ㅎㅎ)  
[참고](https://bongcando.tistory.com/12)  
1. 폰트 디렉토리 생성  
   res/font/
2. .ttf 파일을 넣어주는데, 폰트명을 반드시 전부 소문자로 바꿔주어야 한다.  
3. 글꼴 일괄 적용  
   font 폴더에 font resource file을 생성한다.  
4. font resource file 구현  
   font resource file은 API 26 이상부터 지원하기 때문에 이전 버전에서도 사용가능하게 하도록 하기위해 app namespace를 사용한다.  
   custom font-family 작성.  
   - font : 사용할 글꼴의 리소스 위치
   - fontStyle : 해당 글꼴의 스타일
   - fontWeight : 글꼴의 굵기
   ```kotlin
    <?xml version="1.0" encoding="utf-8"?>
    <font-family
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto">
    
        <!--regular-->
        <font
            android:font="@font/nanumbarunpenregular"
            android:fontStyle="normal"
            android:fontWeight="400"
            app:font="@font/nanumbarunpenregular"
            app:fontStyle="normal"
            app:fontWeight="500" />
    
        <!--bold-->
        <font
            android:font="@font/nanumbarunpenbold"
            android:fontStyle="normal"
            android:fontWeight="700"
            app:font="@font/nanumbarunpenbold"
            app:fontStyle="normal"
            app:fontWeight="1000" />
    
    
    </font-family>
   ```
   
5. custom font-family 적용  
   위치: res/values/themes/themes.xml
   위젯마다 커스텀 스타일을 만들어줌 
   ```kotlin
   // 다음 내용을 추가
       <!-- Custom font 적용 -->
    <style name="customTextViewFontStyle" parent="@android:style/Widget.DeviceDefault.TextView">
        <item name="android:fontFamily">여기에는 4번에서 작성한 font 디렉터리의 font resource file 파일 경로</item>
    </style>

    <style name="customButtonFontStyle" parent="@android:style/Widget.DeviceDefault.Button">
        <item name="android:fontFamily">@font/custom_font_family</item>
    </style>

    <style name="customEditTextFontStyle" parent="@android:style/Widget.DeviceDefault.EditText">
        <item name="android:fontFamily">@font/custom_font_family</item>
    </style>

    <style name="customRadioButtonFontStyle" parent="@android:style/Widget.DeviceDefault.CompoundButton.RadioButton">
        <item name="android:fontFamily">@font/custom_font_family</item>
    </style>

    <style name="customCheckboxFontStyle" parent="@android:style/Widget.DeviceDefault.CompoundButton.CheckBox">
        <item name="android:fontFamily">@font/custom_font_family</item>
    </style>
   ```
   
6. 5번과 같은 파일(res/values/themes/themes.xml)의 첫 style 태그안에 다음 커스텀 item 태그들을 추가한다.
   ```kotlin
   <!--custom font-family 적용-->
   <item name="android:textViewStyle">@style/customTextViewFontStyle</item>
   <item name="android:buttonStyle">@style/customButtonFontStyle</item>
   <item name="android:editTextStyle">@style/customEditTextFontStyle</item>
   <item name="android:radioButtonStyle">@style/customRadioButtonFontStyle</item>
   <item name="android:checkboxStyle">@style/customCheckboxFontStyle</item>
   ```

7. GUI 상에서 변경하기
   xml 파일의 Design에서 Common Attributes의 style에서 project의 커스텀 스타일 선택 
