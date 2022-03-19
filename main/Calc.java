package project2;

/**
 * Contains methods convertToPostfix, which converts infix expressions to
 * postfix and evaluatePostfix which evaluates the value of a postfix
 * expression given values of variables
 * 
 * @author Rebecca Glatts, Yvonne Li, Jessica Ortega
 * 
 */
public class Calc {

    /**
     * Converts an infix expression to an equivalent postfix expression.
     * operatorStack = a new empty stack
     * 
     * @param infix the infix expression to be converted to postfix expression
     * @author
     * @return the postfix value converted from infix
     */
    private static String convertToPostFix(String infix) {
        StackInterface<Character> operatorStack = new LinkedStack<>();
        String postfix = "";

        int spot = 0;
        int end = infix.length() - 1;
        char nextCharacter = infix.charAt(0);

        while (spot <= end) {
            nextCharacter = infix.charAt(spot);
            switch (nextCharacter) {
                case '^':
                    operatorStack.push(nextCharacter);
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!operatorStack.isEmpty()
                            && (opPrecedence(nextCharacter) <= opPrecedence(operatorStack.peek()))) {
                        postfix += operatorStack.peek();
                        operatorStack.pop();
                    }
                    operatorStack.push(nextCharacter);
                    break;
                case '(':
                    operatorStack.push(nextCharacter);
                    break;
                case ')':
                    char topOperator = operatorStack.pop();
                    while (topOperator != '(') {
                        postfix += topOperator;
                        topOperator = operatorStack.pop();
                    }
                    break;
                default:
                    break;
            }
        }
        while (!operatorStack.isEmpty()) {
            char topOperator = operatorStack.pop();
            postfix += topOperator;
        }
        return postfix;

    }

    /**
     * Takes in an operator and returns the precedence of it. 0 for +, -, 1 for *,
     * /, and 2 for ^
     * 
     * @author
     * @param operator the operator
     * @return the precendence of the operator
     */
    private static int opPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
            case '^':
                return 2;
        }
        return operator;
    }

    /**
     * Given a postfix expression, it evaluates it using the values of the variables
     * and returns the value of the evaluated expression
     * 
     * @author Rebecca Glatts
     * @param postfix The postfix expression to be
     * @return the value from the evaluated postfix expression
     */
    public static String evaluatePostfix(String postfix) {
        // Evaluates a postfix expression.
        ResizeableArrayStack<String> valueStack = new ResizeableArrayStack<>();
        Float operandOne;
        Float operandTwo;
        String result;
        // for the length of the string, get each character and evaluate it
        for (int i = 0; i < postfix.length(); i++) {
            char nextCharacter = postfix.charAt(i);

            switch (nextCharacter) {
                // if the character is a variable it pushes the value of the
                // variable to the stack
                case 'a':
                    valueStack.push("2");
                    break;
                case 'b':
                    valueStack.push("3");
                    break;
                case 'c':
                    valueStack.push("4");
                    break;
                case 'd':
                    valueStack.push("5");
                    break;
                case 'e':
                    valueStack.push("6");
                    break;
                // it adds the two top operands from the stack together if the char
                // is a +
                case '+':
                    operandTwo = Float.parseFloat(valueStack.pop());
                    operandOne = Float.parseFloat(valueStack.pop());
                    result = String.valueOf(operandOne + operandTwo);
                    valueStack.push(result);
                    break;
                // subtracts top two operands from stack if -
                case '-':
                    operandTwo = Float.parseFloat(valueStack.pop());
                    operandOne = Float.parseFloat(valueStack.pop());
                    result = String.valueOf(operandOne - operandTwo);
                    valueStack.push(result);
                    break;
                // multiplies top two operands from stack if *
                case '*':
                    operandTwo = Float.parseFloat(valueStack.pop());
                    operandOne = Float.parseFloat(valueStack.pop());
                    result = String.valueOf(operandOne * operandTwo);
                    valueStack.push(result);
                    break;
                // divides top two operands from stack if /
                case '/':
                    operandTwo = Float.parseFloat(valueStack.pop());
                    operandOne = Float.parseFloat(valueStack.pop());
                    result = String.valueOf(operandOne / operandTwo);
                    valueStack.push(result);
                    break;
                // puts the value of operandOne to the power of operandTwo if ^
                case '^':
                    operandTwo = Float.parseFloat(valueStack.pop());
                    operandOne = Float.parseFloat(valueStack.pop());
                    result = String.valueOf(Math.pow(operandOne, operandTwo));
                    valueStack.push(result);
                    break;
                // if the character is unexpected or whitespace, it ignores it
                default:
                    break; // Ignore unexpected characters
            }

        }
        return valueStack.peek();

    }

    // main method
    public void main() {
        String infix = "a*b / (c - a) + d * e";
        String postfix = "";
        String result = "";
        System.out.println(infix);
        postfix = convertToPostFix("Infix expression: " + infix);
        System.out.println("Postfix expression: " + postfix);
        result = evaluatePostfix(postfix);
        System.out.println("Result: " + result);

    }

}
