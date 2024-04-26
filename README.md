# kotlin-baseball-precourse

## 기능 목록

숫자 야구는 Model-View-Controller model을 따라 구현되었습니다.

### Model (User)

- number: 상대방이 맞출 숫자

- setRandomNum: number를 각 자리 숫자가 1에서 9까지의 서로 다른 임의의 수로 이루어진 3자리 숫자로 설정한다.

- compareNum : 숫자를 받아서 User의 number와 비교하여 상태를 반환한다.

### View

- input: 사용자에게 입력을 받아 반환한다.

- output: message를 받아 출력한다.

### Controller

- run: 숫자 야구 애플리케이션을 실행한다.

- game: 숫자 야구 게임을 진행한다. 컴퓨터가 선택한 숫자를 모두 맞히면 게임이 종료된다.

- inputNewGame: 사용자에게 새로운 게임을 시작 여부를 입력받는다. 사용자가 잘못된 값을 입력할 경우 예외 `IllegalArgumentException`를 발생시키고 종료한다.

- inputUserNum: 사용자에게 숫자를 입력받는다. 사용자가 잘못된 값을 입력할 경우 예외 `IllegalArgumentException`를 발생시키고 종료한다.

- outputState: 사용자가 맞춘 숫자 상태를 출력한다. 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻는다.
