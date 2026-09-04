class Solution {
    fun isValid(s: String): Boolean {
       val stack = ArrayDeque<Char>()
       for(ch in s){
        when(ch){
            '(','[','{'-> stack.addLast(ch)
            ')'-> {
                if(stack.isEmpty()|| stack.pollLast() != '(') return false
                
            }
            ']'->{
                if(stack.isEmpty()|| stack.pollLast() != '[') return false
            }
            '}'->{
                if(stack.isEmpty()|| stack.pollLast() != '{') return false
            }
            else->{}
        }
       }
       return stack.isEmpty()
    }
}
