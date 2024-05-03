package engine.io

interface NumberGenerator {
    fun generate(count: Int): List<Int>
}