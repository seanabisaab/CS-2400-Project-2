import java.util.Scanner;

public class Calculator
{
    /** Tests the implementation of convertToPostfix by using the
     * infix expression given from the project prompt (Task #3)
     * while also testing the implementation of evaluatePostfix
     * by using the postfix expression that was returned by
     * convertToPostfix method and the variable values that were
     * given in the project prompt (Task #6).
     @param args The command line arguments. */
    public static void main(String args[])
    {
        char userChoice;
        String infix = "a*b/(c-a)+d*e";
        Scanner keyboard = new Scanner(System.in);

        // prompt the user to enter their choice.
        System.out.print("Would you like to convert the infix expression " + infix);
        System.out.println(" to postfix expression? (Y/N)");
        userChoice = keyboard.next().charAt(0);
        userChoice = Character.toUpperCase(userChoice);
        // clear the buffer.
        keyboard.nextLine();

        // check to see if the user entered 'y' for yes.
        if (userChoice == 'Y')
        {
            // if so, perform convertToPostfix.
            System.out.println("Converting " + infix + " to postfix...");
            String postfix = convertToPostfix(infix);
            System.out.println("The postfix expression is: " + postfix);

            // then, perform evaluatePostfix.
            System.out.print("\nEvaluating " + postfix);
            System.out.println(" when a=2, b=3, c=4, d=5, and e=6...");
            int result = evaluatePostfix(postfix);
            System.out.println("The evaluated answer: " + result);
        }
        // otherwise, terminate the program.
        else
        {
            System.out.println("Terminating the program... Goodbye!");
            System.exit(0);
        }
    } // end of main

    /** Converts an infix expression to an equivalent postfix expression
     * by using a LinkedStack class instance.
     @param infix An infix expression that was given in project prompt.
     @return A postfix expression. */
    public static String convertToPostfix(String infix)
    {
        LinkedStack<Character> operatorStack = new LinkedStack<>();
        String postfix = "";
        char topOperator;
        int index = 0;

        while (index < infix.length())
        {
            // get the next non-blank character in the infix expression.
            char nextChar = infix.charAt(index);

            // determine whether the next character in the infix
            // expression is an alphabet or not. if so, we will
            // simplify the next character to be 'a' for alphabet.
            // if not, we will leave it as it is.
            if (Character.isLetter(nextChar))
            {
                nextChar = 'a';
            }

            switch (nextChar)
            {
                case 'a' :
                    // if the next character in the infix expression is
                    // an alphabet, append it to the postfix expression.
                    postfix = postfix + infix.charAt(index);
                    break;
                case '+' :
                case '-' :
                case '*' :
                case '/' :
                case '^' :    
                    while (!operatorStack.isEmpty()
                    && (checkPrecedence(nextChar) <= checkPrecedence(operatorStack.peek())))
                    {
                        // sanitize user inputs by verifying that the mathematical
                        // operators from the infix expression are valid.
                        if ((checkPrecedence(nextChar) != -1)
                                && (checkPrecedence(operatorStack.peek())) != -1)
                        // append the operators in the top of the operator stack
                        // to the postfix expression while the operator stack is
                        // not empty and the precedence of the next operator in
                        // infix expression is less than or equal to the precedence
                        // of the operators in the top of the operator stack.
                        postfix = postfix + operatorStack.pop();
                    }
                    // then, push the next operator onto the operator stack.
                    operatorStack.push(nextChar);
                    break;
                case '(' :
                    operatorStack.push(nextChar);
                    break;
                case ')' :
                    // Assertion: stack is not empty because the infix
                    // expression will always be valid.
                    topOperator = operatorStack.pop();
                    // pop all the operators from the operator stack and
                    // append them to the forming postfix expression until
                    // we pop the matching open parenthesis.
                    while (topOperator != '(')
                    {
                        // append the top operator to the postfix expression.
                        postfix = postfix + topOperator;
                        // retrieve the next operator in the operator stack
                        // while also removing that operator.
                        topOperator = operatorStack.pop();
                    }
                    break;
                default :
                    // ignore unexpected characters.
                    break;
            } // end switch
            index++;
        } // end while

        // pop all the operators from the operator stack and
        // append them to the forming postfix expression.
        while (!operatorStack.isEmpty())
        {
            topOperator = operatorStack.pop();
            // append the top operator to the postfix expression.
            postfix = postfix + topOperator;
        }

        // return the final postfix expression back to the caller.
        return postfix;
    } // end of "convertToPostfix"

    /** Evaluates a postfix expression by using a ResizableArrayStack class instance.
     @param postfix A postfix expression.
     @return An integer value obtained after evaluating the postfix expression. */
    public static int evaluatePostfix(String postfix)
    {
        ResizableArrayStack<Integer> valueStack = new ResizableArrayStack<>();
        int index = 0;
        int result = 0;

        while (index < postfix.length())
        {
            char nextChar = postfix.charAt(index);

            switch (nextChar)
            {
                case 'a' :
                    valueStack.push(2);
                    break;
                case 'b' :
                    valueStack.push(3);
                    break;
                case 'c' :
                    valueStack.push(4);
                    break;
                case 'd' :
                    valueStack.push(5);
                    break;
                case 'e' :
                    valueStack.push(6);
                    break;
                case '+' :
                case '-' :
                case '*' :
                case '/' :
                case '^' :
                    int operandTwo = valueStack.pop();
                    int operandOne = valueStack.pop();
                    // perform the mathematical operation on the two operands
                    // using the operator from the postfix expression.
                    result = performOperation(nextChar, operandOne, operandTwo);
                    valueStack.push(result);
                default :
                    // ignore unexpected characters, including blank characters.
                    break;
            } // end switch
            ++index;
        } // end while

        // return the final result in the value stack
        // after evaluating the postfix expression.
        return valueStack.peek();

    } // end of "evaluatePostfix"

    // checks the precedence of the mathematical operator.
    // returns 1 if the operator that was passed in as an
    // argument was used for addition or subtraction. it will
    // return 2 instead if the operator is used for multiplication
    // or division. lastly, it will return 3 if the operator is 
    // used for exponentiation. it will return -1 otherwise.
    private static int checkPrecedence(char mathOperator)
    {
        switch (mathOperator)
        {
            case '+' :
            case '-' :
                return 1;
            case '*' :
            case '/' :
                return 2;
            case '^' :
                return 3;
        }

        // if the mathematical operator that was passed
        // as an argument is invalid, return -1.
        return -1;

    } // end of "checkPrecedence"

    // performs the mathematical operator on the
    // two operands that were passed in as arguments.
    private static int performOperation(char mathOperator, int val1, int val2)
    {
        int result = 0;

        switch (mathOperator)
        {
            case '+' :
                // perform addition.
                result = val1 + val2;
                break;
            case '-' :
                // perform subtraction.
                result = val1 - val2;
                break;
            case '*' :
                // perform multiplication.
                result = val1 * val2;
                break;
            case '/' :
                // perform division.
                result = val1 / val2;
                break;
            case '^' :
                result = (int) Math.pow(val1,val2);
                break;
            default :
                // Assertion: only one out of the five mathematical operators
                // from above options will be used.
                break;
        } // end switch

        return result;
    } // end of "performOperation"

} // end of "Calculator" class
