# kotlin-baseball-precourse

## Application 내부 기능

1. computer의 답이 될 난수 형성
2. 사용자와의 상호 작용 담당 기능( 사용자의 입력 처리 )
3. 예외처리 기능 ( 문제의 범위 제약, 출력 등을 따로 관리하면 유지 및 보수가 용이할 것 )

- 1번, 2번 => computer, player 객체 형성 필요

- 2번 => 각 상황에 따라 ball과 strike 등 적절한 출력을 해야 함

- 3번 => 예외 상황을 다루는 경우 IllegalArdumentException 발생시키고 프로그램의 동작을 멈춰야 함


## 기능 및 요구사항

### 기능

1. 게임 시작 기능 구현하기
2. 숫자 3개로 이루어진 랜덤값 형성하기
3. 사용자의 입력 처리 기능
   - 길이가 3인가
   - 1부터 9까지의 서로 다른 숫자로 이루어져 있는가
   - 이외의 입력에 대해서는 IllegalArgumentException으로 처리할 것
   - 정답을 입력하면 재시작(1)을 하거나 종료(2)하도록 처리
4. 입력을 추론하는 것을 돕는 기능 구현
   ex) 1볼 2스트라이크, 낫싱
--------------------------------------------------------------------------------------------

### 요구사항

## 프로그래밍 요구 사항 1

- **Kotlin 1.9.0**에서 실행 가능해야 한다
- **Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- build.gradle.kts 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit() 또는 exitProcess() 를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.

## 프로그래밍 요구 사항 2

- 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
- 기본적으로 Kotlin Coding conventions를 원칙으로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
   함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.

[JUnit5 User guide](https://junit.org/junit5/docs/current/user-guide/)

[Assertj user guide](https://assertj.github.io/doc/)

[AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)

[Guide to JUnit5 parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)
