import engine.BaseBall

fun main() {
    var generator = RandomNumberGenerator()
    var console = Console();

    BaseBall(generator, console, console).run()
}