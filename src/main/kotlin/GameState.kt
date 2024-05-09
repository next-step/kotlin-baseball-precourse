sealed class GameState {
    data object IsLoading : GameState() // 1. 게임 시작 전  2. 게임 종료 후 플레이어에게 상태를 입력받기 전
    data object OnGoing : GameState()
    data object End : GameState()
}