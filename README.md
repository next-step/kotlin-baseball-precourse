# 숫자 야구 게임

카카오 테크 캠퍼스 2기 Android 트랙 1st 미니과제
## 기능 요구사항
- 1부터 9까지 **서로 다른 수**로 이루어진 3자리의 수를 맞추는 게임이다.
- ***같은 수가 같은 자리***에 있으면 스트라이크, ***다른 자리***에 있으면 볼, 같은 수가 ***전혀 없으면*** 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
- 예) 상대방(컴퓨터)의 수가 425일 때
  - 123을 제시한 경우 : 1스트라이크
  - 456을 제시한 경우 : 1볼
  - 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터가 생각하고 있는 숫자와 비교한 결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료


## 구현한 기능 목록
- [x] 컴퓨터가 정답 랜덤으로 생성.
- [ ] 사용자로부터 표준 입력 받기.
  - [ ] 사용자로부터 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력받는다.
  - [ ] 잘못된 값 입력시 예외 호출 및 종료
  - [ ] 사용자로부터 게임을 다시 시작하거나 완전히 종료할 수 있는 메뉴를 입력받는다.
- [ ] 입력 받은 수와 컴퓨터가 생성한 수를 비교하여 결과 출력.
  - [ ] 같은 수가 같은 자리에 있으면 스트라이크
  - [ ] 다른 자리에 있으면 볼
  - [ ] 같은 수가 전혀 없으면 낫싱
- [ ] 정답을 맞힐 시 게임 종료 후 게임을 다시 시작하거나 완전히 종료할 수 있는 메뉴 출력.