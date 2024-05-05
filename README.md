# kotlin-baseball-precourse

## 기능 목록
### GameStateManager
- 변수
  - gameStatus
- 기능
  - 게임 상태 변경
  - 게임 상태 가져오기

### RandomNumberGenerator
- 기능
  - 1부터 9까지 서로 다른 수로 이루어진 3자리수 생성

### Computer
- 변수
  - number
- 기능
  - 플레이어의 입력에 대한 컴퓨터의 결과 출력
      - 볼: 숫자는 맞지만 위치가 다른 경우
      - 스트라이크: 숫자도 맞고 위치도 맞은 경우
      - 낫싱: 볼과 스트라이크 모두 없는 경우

### Player
- 기능
  - 1부터 9까지 서로 다른 수로 이루어진 3자리 수 입력
  - 게임 종료 후 1 또는 2 입력

### InputChecker
- 기능
  - 입력된 값이 1부터 9까지 서로 다른 수로 이루어진 3자리수인지 확인
  - 입력된 값이 1 또는 2인지 확인

### GameManager
- 기능
  - 게임 시작 및 종료