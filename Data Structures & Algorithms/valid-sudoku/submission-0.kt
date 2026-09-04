class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9){HashSet<Char>()}
        val cols = Array(9){HashSet<Char>()}
        val boxes = Array(9){HashSet<Char>()}

        for(row in 0 until 9){
            for (col in 0 until 9){
                val value = board[row][col]
                if(value=='.') continue
                val boxIndex = (row/3)*3 + (col/3)
                if(!rows[row].add(value)) return false
                if(!cols[col].add(value)) return false
                if(!boxes[boxIndex].add(value)) return false
            }
        }

        return true
    }
}