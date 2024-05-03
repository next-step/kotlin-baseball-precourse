# kotlin-baseball-precourse
# 목차
1. 과제 설명  
2. 과제 진행 요구 사항
3. 기능 요구 사항  
4. 프로그래밍 요구 사항 
5. 실행 결과  
6. 과제 진행 소감  
***  

## 과제 설명     
카카오 테크 캠퍼스의 1차 미니 과제로 숫자 야구를 코틀린으로 구현해 내는 것이 목표이다.  
또한 과제 진행 요구 사항, 기능 요구 사항, 프로그래밍 요구 사항 3가지로 구성되어 있다.  

## 과제 진행 요구 사항  
미션은 [숫자 야구](https://github.com/next-step/kotlin-baseball-precourse/tree/main) 저장소를 포크하고 클론하는 것으로 시작한다.  
기능을 구현하기 전 README.md 에 구현할 기능 목록을 정리해 추가한다.
Git의 커밋 단위는 앞 단계에서 README.md 에 정리한 기능 목록 단위로 추가한다.
[AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.  
자세한 과제 진행 방법은 미니과제 진행 가이드 문서를 참고한다.  

## 기능 요구 사항  
- 기본적으로 숫자 야구는 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의
  수를 맞추면 승리한다.
```bash
e.g.
상대방(컴퓨터)의 수가 425일 때,
- 123을 제시한 경우: 1스트라이크
- 456을 제시한 경우: 1볼 1스트라이크
- 789를 제시한 경우: 낫싱
```
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 한다

## 프로그래밍 요구 사항  
- Kotlin 1.9.0에서 실행 가능해야 한다.
- Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.
- 프로그램 실행의 시작점은 Application 의 main() 이다.
- build.gradle.kts 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit() 또는 exitProcess() 를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.  
- 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
  + 기본적으로 Kotlin Coding conventions(https://kotlinlang.org/docs/coding-conventions.html)를 원칙으로 한다.  
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다. 
  + 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  + 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다. 
  + 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다. 
    + JUnit 5 User Guide(https://junit.org/junit5/docs/current/user-guide)
    + AssertJ User Guide(https://assertj.github.io/doc)
    + AssertJ Exception Assertions(https://www.baeldung.com/assertj-exception-assertion)
    + Guide to JUnit 5 Parameterized Tests(https://www.baeldung.com/parameterized-tests-junit-5)  

