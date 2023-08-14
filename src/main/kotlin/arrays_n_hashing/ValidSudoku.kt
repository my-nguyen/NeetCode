package arrays_n_hashing

fun main() {
    val boards = listOf(
        arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        ),
        arrayOf(
            charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        ),
    )
    for (board in boards) {
        println("valid sudoku? ${validSudoku(board)}")
    }
}

fun validSudoku(board: Array<CharArray>): Boolean {
    return isValidHorizontal(board) && isValidVertical(board) && isValidSubBox(board)
}

private fun isValidHorizontal(board: Array<CharArray>): Boolean {
    for (row in board) {
        val set = mutableSetOf<Char>()
        for (c in row) {
            if (c == '.')
                continue
            if (set.contains(c))
                return false
            set.add(c)
        }
    }
    return true
}

private fun isValidVertical(board: Array<CharArray>): Boolean {
    for (j in 0 until 9) {
        val set = mutableSetOf<Char>()
        for (i in 0 until 9) {
            val c = board[i][j]
            if (c == '.')
                continue
            if (set.contains(c))
                return false
            set.add(c)
        }
    }
    return true
}

private fun isValidSubBox(board: Array<CharArray>): Boolean {
    for (i in 0 until 3) {
        for (j in 0 until 3) {
            if (!isValidSubBox(board, i*3, j*3))
                return false
        }
    }
    return true
}

private fun isValidSubBox(board: Array<CharArray>, row: Int, col: Int): Boolean {
    val set = mutableSetOf<Char>()
    for (i in row until row+3) {
        for (j in col until col+3) {
            val c = board[i][j]
            if (c == '.')
                continue
            if (set.contains(c))
                return false
            set.add(c)
        }
    }
    return true
}