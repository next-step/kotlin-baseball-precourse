import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName

class UserTest {
    val user = User()

    fun checkNum(num: String): Boolean {
        if (num.length != 3)
            return false
        if (num[0] == num[1])
            return false
        if (num[1] == num[2])
            return false
        if (num[2] == num[0])
            return false
        return true
    }

    @Test
    @DisplayName("각 자리 수가 다른 3자리 수를 생성하는 테스트")
    fun setRandomNumTest() {
        val _number = user.javaClass.getDeclaredField("_number")
        _number.trySetAccessible()

        for (i in 0..10000) {
            user.setRandomNum()
            val num = _number.get(user).toString()
            assertThat(checkNum(num)).isEqualTo(true)
        }
    }

    @Test
    @DisplayName("올바른 state값 테스트")
    fun compareNumTest() {
        val _number = user.javaClass.getDeclaredField("_number")
        _number.trySetAccessible()
        _number.set(user, "123")

        // 3 strike
        assertThat(user.compareNum("123")).isEqualTo(30)

        // 2 strike 0 ball
        assertThat(user.compareNum("124")).isEqualTo(20)
        assertThat(user.compareNum("423")).isEqualTo(20)
        assertThat(user.compareNum("143")).isEqualTo(20)

        // 1 strike 2 ball
        assertThat(user.compareNum("132")).isEqualTo(12)
        assertThat(user.compareNum("321")).isEqualTo(12)
        assertThat(user.compareNum("213")).isEqualTo(12)

        // 1 strike 1 ball
        assertThat(user.compareNum("134")).isEqualTo(11)
        assertThat(user.compareNum("421")).isEqualTo(11)
        assertThat(user.compareNum("243")).isEqualTo(11)

        // 1 strike 0 ball
        assertThat(user.compareNum("144")).isEqualTo(10)
        assertThat(user.compareNum("424")).isEqualTo(10)
        assertThat(user.compareNum("443")).isEqualTo(10)

        // 3 ball
        assertThat(user.compareNum("312")).isEqualTo(3)
        assertThat(user.compareNum("231")).isEqualTo(3)

        // 2 ball
        assertThat(user.compareNum("431")).isEqualTo(2)
        assertThat(user.compareNum("241")).isEqualTo(2)
        assertThat(user.compareNum("234")).isEqualTo(2)

        // 1 ball
        assertThat(user.compareNum("441")).isEqualTo(1)
        assertThat(user.compareNum("244")).isEqualTo(1)
        assertThat(user.compareNum("434")).isEqualTo(1)

        // nothing
        assertThat(user.compareNum("456")).isEqualTo(0)
        assertThat(user.compareNum("789")).isEqualTo(0)
    }
}