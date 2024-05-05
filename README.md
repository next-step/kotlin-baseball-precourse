# kotlin-baseball-precourse

## 목표
숫자야구 기능 구현

## 숫자야구란?
기본적으로 1부터 9까 서로 다른 수 이루어진 3가의 수를 맞추는 게임이다.

같은 수 같은 자리에 있으면 스트라이, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면

낫싱이라는 힌트를 얻고, 그 힌트를 이용해서 상대의 수를 맞추면 승리하는 게임이다.


## 기능 구현
### 1.  1부 9까지 서로 다른 3가지 수를 랜덤으로 정하기
---
   
   selectRandomnumber() 
   
   함수를 만들어 먼저 플레이어가 맞출 3자라 숫자를 정해준다.

---
   
### 2.  player input number

---
   inputNumber()

   
   사용자로부터 숫자를 입력받고 그 수가 111~999 사이에 포함 되어 있지 않으면 IllegalArgumentException 에러 발생 후 종료시킨다.


   ---
### 3. check input number is not out of range
---

  checkInputNumber()
    
   직접적으로 IllegalArgumentException 에러를 발생시키는 함수 부분이다.


   ---
### 4. check restart baseball game
---

   restartCheck()

   게임 종료 후 다시 게임을 시작 할것인지 판단하는 함수로 1,2 이외의 수를 입력 받으면  IllegalArgumentException 에러 발생 후 종료시킨다.


   ---
### 5. baseball game start
---

   gameStart()

   숫자야구의 알고리즘이 구현되어 있는 함수다.


   ---
### 6. start main function
---

    위의 gameStart()를 실행시키는 함수다.
   
