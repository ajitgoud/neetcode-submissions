class MinStack() {

    val stack = ArrayDeque<Int>()
    val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.addLast(`val`)
        if(minStack.isEmpty()){
            minStack.addLast(`val`)
        }else{
            minStack.addLast(minOf(`val`, minStack.last()))
        }
    }

    fun pop() {
        stack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
        return stack.peekLast()
    }

    fun getMin(): Int {
        return minStack.peekLast()
    }
}
