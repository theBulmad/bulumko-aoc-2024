import kotlin.math.abs

fun main() {

    fun splitInput(input: List<String>): Pair<List<Int>, List<Int>> =
        input.map {it.split("   ").let { parts -> parts[0].toInt() to parts[1].toInt()}}.unzip()

    fun part1(input: List<String>): Int {

        val (firstList, secondList) = splitInput(input)

        return firstList.sortedBy { it }.zip(secondList.sortedBy { it })
            .sumOf { abs(it.first - it.second) }
    }

    fun part2(input: List<String>): Int {

        val (firstList, secondList) = splitInput(input)

        return firstList
            .sumOf {
                it * secondList.filter { e -> e == it }.size
            }

    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
