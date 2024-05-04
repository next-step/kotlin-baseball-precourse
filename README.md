# 숫자 야구 게임

## 구현 기능 목록
1. 각 자리 수가 겹치지 않는 랜덤한 3자리 수 설
2. 세자리 숫자를 입력받고 한 자리 씩 리스트에 삽입
3. 입력받은 수, 랜덤으로 생성된 수를 **자리 수** 마다 비교
    - 같은 자리 + 같은 숫자 = 스트라이크
    - 같은 숫자 + 다른 자리 = 볼
4. 스트라이크, 볼 변수 생성하여 위의 2가지 경우일 때 +1
5. 스트라이크, 볼, 낫싱 출력
6. 3 스트라이크 = 게임 종료
7. 재시작 or 종료 입력 (1: 재시작, 2: 종료)

## 구현 순서
1. 랜덤한 3자리 숫자 생성
2. 세자리 숫자 입력
3. 입력한 숫자를 한 자리씩 리스트에 삽입
4. 랜덤 숫자와 입력 숫자를 각 자리와 비교
   - 입력 숫자 첫 번째부터 탐색
     - 자리까지 같으면 스트라이크 카운트 +1
     - 존재하지만 자리가 같지 않으면 볼 카운트 +1
5. 숫자를 입력할 때마다 스트라이크와 볼 카운트 출력
   - 문자열 포멧팅 사용
6. 입력 숫자 예외 처리 코드
   1. 입력한 숫자가 3자리 수가 아님 (ex. 1234)
      
   2. 1부터 9까지의 수가 아님 (ex. 404)
      
   3. 같은 숫자가 중복됨 (ex. 232)
