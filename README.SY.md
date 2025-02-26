# REST API

## GET

- 서버에 특정 데이터를 요청, 클라이언트가 응답
- 0 또는 1 비트 단위의 데이터가 전달되는 것
- 서버에서 어떤 문자 데이터를 만들어내느냐가 중요하다
- `@RestController` : REST API Controller임을 지정
- `@RequestMapping` : API 주소를 지정
- `@GetMapping` : 클라이언트에서 해당 주소로 GET Method를 통해 데이터를 보낸다

### Path Variable

- 주소 내에 정보를 전달하는 방법
  - (예) https://www.foo.bar/user-d/100
- 주소가 노출되기 때문에 주소에 대한 값을 변환시킬 수 있으므로 보안이 취약하다

```java
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(@PathVariable String message,
        @PathVariable int age,
        @PathVariable boolean isMan
    ) {
        System.out.println("echo message: " + message);
        System.out.println("echo age: " + age);
        System.out.println("echo isMan: " + isMan);
        return message.toUpperCase();
    }
```

### Query Parameer

- 특정 정보의 필터링을 걸 때 사용한다
- `?`로 시작하고 이어주는 형태는 `&`로 묶어준다
  - (예) https://www.foo.bar/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31

```java
    @GetMapping("/book")
    public void queryParam(
        @RequestParam String category,
        @RequestParam String issuedYear,
        @RequestParam(name = "issued-month") String issuedMonth,
        @RequestParam String issuedDay
    ) {
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }

    @GetMapping("/book2")
    public void queryParamDTO(
        BookQueryParam bookQueryParam
    ) {
        System.out.println(bookQueryParam);
    }

```

- 변수가 많을 경우 객체를 통해 파싱할 수 있다.

<br/>
<br/>

## POST

### HTTP BODY

- 특정한 메시지를 담을 수 있다. (TEXT, HTML, JSON 등)
- 외부 주소에는 해당 데이터가 노출되지 않는다
- JSON 형식을 가장 많이 쓴다.
- `@RequestBody` : POST, PUT Method에서 쓰이며 `HTTP Body`로 들어오는 데이터를 해당 객체에 매핑해준다.

```java
    // return type 에 따라 달라진다
    @PostMapping("/post")
    public String post(@RequestBody BookRequest bookRequest) {
        System.out.println(bookRequest);
        return bookRequest.toString();
    }
```

- return type에 따라 달라진다.

### JSON 형식

```JSON
{
	"key": "value",
	"array": [
		10,
		20,
		30
	],
	"string_array": [
		"홍길동", "이순신", "유관순"
	],
	"object_array": [
		{
			"name: "홍길동"
		},
		{
			"name: "이순신"
		},
		{
			"name: "유관순"
		}
	]
}
```

- `key-value` 형식이다.
- String, Number, Boolean, obejct({}), array([]) 등을 추가할 수 있다.

<br/>
<br/>

## PUT

- 해당 데이터가 존재한다면 갱신, 존재하지 않는다면 생성
- 요청할 때마다 데이터가 바뀌므로 안정성은 없다

```java
    @PutMapping("/put")
    public void put(@RequestBody UserRequest userRequest) {
        log.info("Request: {}", userRequest);
    }
```

<br/>
<br/>

## DELETE

- 리소스 삭제
- 몇 번이나 요청해도 동일 = 멱등성 O

```java
    @DeleteMapping(path = {"/user/{userName}/delete", "/user/{userName}/del"})
    public void delete(@PathVariable String userName) {
        log.info("user-name: {}", userName);
    }
```

<br/>
<br/>

# 추가 공부 내용

## 변수 작성하기

### Snake Case

- `_`로 구분
- user_name, user_age
- camel case에서 snake case로 변경하기
  ```java
  @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
  ```
  - JSON 형식에서 snake case로 작성해도 인식되도록 한다.
  - (예) userName = user_name

### Camel Case

- 소문자로 시작, 대문자로 구분
- userName, userAge

## `@Slf4j`

- `System.out.print`
  - 콘솔에 출력을 하고 실행되기 때문에 서버의 진행 속도가 저하가 된다.
- `log`로 찍기
  - buffer의 내용이 찍히므로 진행 속도에 영향을 많이 주지 않는다
- 가능하면 해당 어노테이션을 적용하여 `log.info` 등으로 콘솔을 찍는 것이 좋다.
