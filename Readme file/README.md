### Application 내부 기능
1. computer의 답이 될 난수 형성
2. 사용자와의 상호 작용 담당 기능( 사용자의 입력 처리 )
3. 예외처리 기능 ( 문제의 범위 제약, 출력 등을 따로 관리하면 유지 및 보수가 용이 )

1, 2 => computer, player 객체 형성 필요
2 => 각 상황에 따라 ball과 strike 등 적절한 출력을 해야 함
3 => 예외 상황을 다루는 경우 IllegalArdumentException 발생시키고 프로그램의 동작을 멈춰야 함

