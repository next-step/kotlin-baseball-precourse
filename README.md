# kotlin-baseball-precourse
카카오 테크 캠퍼스 2기 Android 트랙 미니과제1

## 기능 요구사항
- 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임
- 같은 수가 같은 자리에 있으면 스트라이크, 
- 다른 자리에 있으면 볼, 
- 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
```
예) 상대방(컴퓨터)의 수가 425일 때
    - 123을 제시한 경우 : 1스트라이크
    - 456을 제시한 경우 : 1볼
    - 789를 제시한 경우 : 낫싱
```
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터가 생각하고 있는 숫자와 비교한 결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료


## 구현 기능 목록
- 종료(2) 시까지 반복
  - 랜덤 숫자 생성하기
  - 사용자가 숫자를 맞힐 때 까지 반복
    - 사용자에게 숫자 입력 받기
      - 잘못된 값 입력시 IllegalArgumentException
    - 숫자에 대해 응답 값(볼, 스트라이크, 낫싱)을 계산하기
      - 랜덤값과 입력값을 비교하여 볼을 계산
      - 랜덤값과 입력값을 비교하여 스트라이크 계산
      - 랜덤값과 입력값을 비교하여 낫싱 계산
    - 데이터 포매팅을 거친 후 이를 출력하기
      - 만약 맞힌다면 게임 종료
      - 게임 재시작 선택 메시지 출력
        - 1 이면 재시작, 2면 프로그램 종료
