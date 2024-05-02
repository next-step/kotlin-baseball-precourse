# kotlin-baseball-precourse
## 구현할 기능 목록
### 1. main
- play가 true일 때 computer 숫자 생성 (3번)
- play 숫자 야구 (2번)
- end 후 게임 play 여부 선택 (9번)
### 2. play 숫자야구기능
- end가 아닐 때 숫자 input받기 (4번)
- input 받은 숫자가 조건 만족하는지 확인 (만족x -> illegal throw, 종료), list로 바꿈 (5,6번)
- strikes, balls 계산 (7번)
- strikes가 3이면 게임 종료, end = true / strikes, balls 중 하나라도 0이 아니면 결과 print (8번) / 둘 다 0이면 print 낫싱
### 3. computer 숫자 생성 기능
- 1~10까지의 중복 허용 없이 3개의 숫자 랜덤 선택, list
### 4. 숫자 input 받는 기능
- 입력 없을 시 illegal throw
### 5. input 받은 숫자가 조건을 만족하는지 확인하는 기능
- 숫자 길이3, 모든 숫자가 1~9 사이, 중복 숫자 미포함 따라 true, false
### 6. input 받은 숫자를 list로 바꾸는 기능
- 정수로 변환하여 list에 담기
### 7. strike, ball 계산 기능
- index와 해당 index에 있는 숫자 동일 -> strikes ++, set에 index 추가
- index가 set에 없고 숫자 동일 -> balls ++
### 8. 게임 결과 print 기능
- balls 볼 strikes 스트라이크 출력
### 9. 게임 play 여부 선택 기능
- 1이면 true, 2이면 false return