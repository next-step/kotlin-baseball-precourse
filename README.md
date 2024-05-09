# kotlin-baseball-precourse

## 프로그램 설명
코틀린 언어를 사용하여 작성한 숫자야구 프로그램입니다.

100~999범위에 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임입니다.

같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의
수를 맞추면 승리한다.

## 기능 구현

난수 생성 - 100~999범위에 서로 다른 수를 가지고 있는 수를 생성합니다.

숫자 비교 - 사용자로부터 숫자를 받아와 생성한 난수와 비교합니다.
- 숫자가 정확하고 위치도 정확하면 스트라이크
- 숫자가 정확하지만 위치가 부정확할시 볼
- 세개의 숫자가 정확하지 않으면 낫싱

결과 - 숫자를 모두 맞히면 게임이 종료됩니다. 그 후 게임을 다시 시작하거나 완전히 종료가 가능합니다.

- 예외 상황
  사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 합니다.


## 구현한 기능 목록
1. main함수를 작성합니다. main함수는 게임을 시작할지 안할지 구별합니다.
2. createdRandomNumber 난수 생성 함수를 구현하여 중복을 난수를 생성합니다.
3. withoutOverlapping 함수를 구현하여 중복 제거 기능을 추가합니다.
3. inputUserNumber 함수를 구현하여 사용자로부터 숫자를 입력습니다.
4. strikeAndBallDecisions 함수를 구현하여  스트라이크와 볼의 개수를 확인합니다.
5. judgmentOfResult 함수를 구현하여 낫싱 or n스트라이크 n볼을 출력합니다.
6. userNumberCheck와 isItPossibleToUse 함수를 구현하여 사용자가 입력한 숫자가 제대로된 숫자인지 확인합니다.
7. 사용자가 입력을 잘못하면 IllegalArgumentException를 발생시킵니다. 
