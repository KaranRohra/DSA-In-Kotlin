package data_structures.arrays.stack

class Conversions {
    fun infixToPostfix(input: String): String {
        val infix = input.toCharArray()
        val postfix = CharArray(infix.size*2)
        val opStack = MyStack<Char>()
        val n=infix.size
        var k=0
        var i=0
        while (i<n){
            if(infix[i] in '0'..'9') {
                while (i < n && infix[i] in '0'..'9')
                    postfix[k++] = infix[i++]
                postfix[k++] = ' '
            }
            else {
                while (i < n && !opStack.isEmpty() && priority(opStack.peek() as Char) >= priority(infix[i])) {
                    postfix[k++] = opStack.pop() as Char
                    postfix[k++] = ' '
                }
                opStack.push(infix[i])
                i++
            }
        }
        while(!opStack.isEmpty()) {
            postfix[k++] = opStack.pop() as Char
            if(k<n*2)
            postfix[k++] = ' '
        }
        println(postfix)
        return String(postfix)
    }
    fun infixToPostfixWithParentheses(infix:String): String{
        val postfix = CharArray(infix.length*2)
        val n = infix.length
        val s = MyStack<Char>()
        var k = 0
        var i = 0
        while(i<n){
            if(infix[i] in '0'..'9') {
                while(i<n && infix[i] in '0'..'9')
                    postfix[k++] = infix[i++]
                postfix[k++]=' '
            }
            else if(i<n && infix[i]=='(')
                s.push(infix[i++])
            else{
                while(i<n && !s.isEmpty() && priority(s.peek() as Char)>=priority(infix[i])){
                    val c=s.pop()
                    if(c=='(')
                        break
                    else {
                        postfix[k++] = c as Char
                        if(k<n*2)
                        postfix[k++]=' '
                    }
                }
                if(infix[i]!=')')
                    s.push(infix[i])
                i++
            }
        }
        while(k<n*2 && !s.isEmpty()) {
            postfix[k++] = s.pop() as Char
            if(k<n*2)
                postfix[k++]=' '
        }
        postfix[k]='#'
        return String(postfix)
    }
    fun postfixEvaluation(postfix: String): Int{
        val operand=MyStack<Int>()
        var i=0
        loop@while(postfix[i]!='#'){
            when {
                postfix[i]==' ' -> i++
                postfix[i] in '0'..'9' -> {
                    var m=0
                    while(postfix[i] in '0'..'9'){
                        m = m*10 + (postfix[i]-'0')
                        i++
                    }
                    operand.push(m)
                }
                else-> {
                    val val1 = operand.pop() as Int
                    val val2 = operand.pop() as Int
                    val value = when(postfix[i]) {
                        '+' -> val2+val1
                        '-' -> val2-val1
                        '*' -> val2*val1
                        '/' -> val2/val1
                        else -> 0
                    }
                    operand.push(value)
                    i++
                }
            }
        }
        return operand.pop() as Int
    }
    fun infixToPrefix(infix: CharArray): CharArray{
        infix.reverse()
        val postfix = CharArray(infix.size)
        val s = MyStack<Char>()
        var k=0
        for(i in infix){
            if(i in 'A'..'Z' || i in 'a'..'z' || i in '0'..'9')
                postfix[k++]=i
            else{
                while (!s.isEmpty() && priority(s.peek() as Char)>priority(i))
                    postfix[k++]=s.pop() as Char
                s.push(i)
            }
        }
        while(!s.isEmpty())
            postfix[k++]=s.pop() as Char
        return postfix
    }
    fun infixToPrefixWithParentheses(infix: CharArray){

    }
    private fun priority(symbol: Char): Int =
        when(symbol){
        '+' -> 1
        '-' -> 1
        '*' -> 2
        '/' -> 2
        else -> 0
    }
}