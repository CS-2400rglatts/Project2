package project2;

/**
 * @author Rebecca Glatts, Yvonne Li, Jessica Ortega
 * 
 */
public class Calc {

    //basic algorithm from 5.18 
    static Algorithm evaluatePostfix(postfix){
        // Evaluates a postfix expression.
        valueStack = new ResizeableArrayStack<>();
        while (postfix has characters left to parse)
        {
        nextCharacter = next nonblank character of postfix

        switch (nextCharacter)
        {
        case variable:
            valueStack.push(value of the variable nextCharacter);
            break;

        case '+' :
            operandTwo = valueStack.pop();
            operandOne = valueStack.pop();
            result = operandOne + operandTwo;
            valueStack.push(result);
            break;
        case '-' : 
            operandTwo = valueStack.pop();
            operandOne = valueStack.pop();
            result = operandOne - operandTwo;
            valueStack.push(result);
            break;
        case '*' : 
            operandTwo = valueStack.pop();
            operandOne = valueStack.pop();
            result = operandOne * operandTwo;
            valueStack.push(result);
            break;
        case '/' : 
            operandTwo = valueStack.pop();
            operandOne = valueStack.pop();
            result = operandOne / operandTwo;
            valueStack.push(result);
            break;
        case '^' :
            operandTwo = valueStack.pop();
            operandOne = valueStack.pop();
            result = operandOne ^ operandTwo;
            valueStack.push(result);
            break;

        default: break // Ignore unexpected characters
}

}return valueStack.peek();

}

}
