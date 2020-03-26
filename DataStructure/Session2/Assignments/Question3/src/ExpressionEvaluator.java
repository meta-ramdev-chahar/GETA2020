import java.util.HashMap;

/**
 * 
 * @author Ramdev 
 * This Class contain method to evaluate expressions
 */
public class ExpressionEvaluator 
{

    private HashMap<String, Integer> operatorPrecedence = new HashMap<String, Integer>();

    /**
     * To set priority of operators
     */
    public ExpressionEvaluator() 
    {
        prioritySetter();
    }

    /**
     * To evaluate infix expression
     * @param <T>
     * @param infixExpression String containing infix expression
     * @return value after evaluation or return null if any exception occurred.
     */
    public <T> Double infixExpressionEvaluator(String infixExpression) throws Exception 
    {
        try {
            infixExpression = infixExpression.replaceAll(" ", "");
            
             // Stack for numbers: 'values' 
            Stack<Double> values = new StackImplementation<>();

             // Stack for Operators: 'operaterStack'
            Stack<String> operaterStack = new StackImplementation<>();

            int index = 0;
            while (index < infixExpression.length()) 
            {
                 // if Current token is a number, push it to stack for numbers
                if (infixExpression.charAt(index) >= '0' && infixExpression.charAt(index) <= '9') 
                {
                    StringBuffer stringBuffer = new StringBuffer();
                   
                    while (index < infixExpression.length() && infixExpression.charAt(index) >= '0' && infixExpression.charAt(index) <= '9')
                        stringBuffer.append(infixExpression.charAt(index++));
                    values.push(Double.parseDouble(stringBuffer.toString()));
                }

                
                 //if Current token is an opening brace, push it to 'operaterStack'
                else if (infixExpression.charAt(index) == '(') 
                {
                    operaterStack.push(infixExpression.charAt(index) + "");
                    index++;
                }

                
                 //if Closing brace encountered, solve entire brace 
                else if (infixExpression.charAt(index) == ')') 
                {
                    while (!"(".equals(operaterStack.peek())) 
                    {
                        values.push(evaluateOperater(values.pop(), values.pop(), operaterStack.pop()));
                    }
                    operaterStack.pop();
                    index++;
                }

                
                 //if Current token is an operator. 
                else if ((infixExpression.charAt(index) + "" ).matches("[+-/*&=!><|]")) 
                {
                    if ((infixExpression.charAt(index + 1) + "").matches("[&=|]")) 
                    {
                        String tempOperator = infixExpression.charAt(index) + "" + infixExpression.charAt(index + 1);
                        
                        while (!operaterStack.isEmpty() && (!("(".equals(operaterStack.peek()))) && (operatorPrecedence.get(tempOperator) < operatorPrecedence.get(operaterStack.peek()))) 
                        {
                            values.push(evaluateOperater(values.pop(), values.pop(), operaterStack.pop()));
                        }
                        
                         // Push current token to 'operaterStack'.
                        operaterStack.push(tempOperator);
                        index += 2;

                    }
                    else 
                    {

                        /**
                         * While top of 'operaterStack' has same or greater precedence to current token,
                         * which is an operator. Apply operator on top of 'operaterStack' to top two
                         * elements in values stack
                         */
                        while (!operaterStack.isEmpty() && (!("(".equals(operaterStack.peek())))
                                && (operatorPrecedence.get(infixExpression.charAt(index) + "") < operatorPrecedence.get(operaterStack.peek()))) 
                        {	
                            values.push(evaluateOperater(values.pop(), values.pop(), operaterStack.pop()));
                        }

                         // Push current token to 'operaterStack'.
                        operaterStack.push(infixExpression.charAt(index) + "");
                        index++;
                    }
                }
            }

            /**
             * Entire expression has been parsed at this point, apply remaining
             * operaterStack to remaining values
             */
            while (!operaterStack.isEmpty()) 
            {
                values.push(evaluateOperater(values.pop(), values.pop(), operaterStack.pop()));
            }

            return values.pop();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * To perform specified operation on operands and return value
     * @param Operand  First
     * @param Operand  Second
     * @param Operator
     * @return final Result
     */
    private Double evaluateOperater(Double operandFirst, Double operandSecond, String operator) 
    {
        switch (operator) {

            case "+": {
                return (operandFirst + operandSecond) / 1.0;
            }
            case "-": {
                return (operandSecond - operandFirst);
            }
            case "*": {
                return (operandFirst * operandSecond);
            }
            case "/": {
                return (operandSecond / operandFirst);
            }
            case "==": {
                if (Double.compare(operandFirst, operandSecond) == 0) {
                    return 1.0;
                }
                return 0.0;
            }
            case "!=": {
                if (Double.compare(operandFirst, operandSecond) != 0) {
                    return 0.0;
                }
                return 1.0;
            }
            case "<": {
                if (Double.compare(operandFirst, operandSecond) == 1) {
                    return 1.0;
                }
                return 0.0;
            }
            case ">": {
                if (Double.compare(operandFirst, operandSecond) == -1) {
                    return 1.0;
                }
                return 0.0;
            }
            case "<=": {
                if (Double.compare(operandFirst, operandSecond) != -1) {
                    return 1.0;
                }
                return 0.0;
            }
            case ">=": {
                if (Double.compare(operandFirst, operandSecond) != 1) {
                    return 1.0;
                }
                return 0.0;
            }
            case "&&": {
                if ((operandFirst > 0) && (operandSecond > 0)) {
                    return 1.0;
                }
                return 0.0;
            }
            case "||": {
                if ((operandFirst > 0) || (operandSecond > 0)) {
                    return 1.0;
                }
                return 0.0;
            }
        }
        return 0.0;
    }

    /**
     * To Set Priorities of different Operators
     */
    private void prioritySetter() 
    {
        operatorPrecedence.put("||", 1);
        operatorPrecedence.put("&&", 2);
        operatorPrecedence.put("==", 3);
        operatorPrecedence.put("!=", 3);
        operatorPrecedence.put("<", 4);
        operatorPrecedence.put(">", 4);
        operatorPrecedence.put("<=", 4);
        operatorPrecedence.put(">=", 4);
        operatorPrecedence.put("+", 5);
        operatorPrecedence.put("-", 5);
        operatorPrecedence.put("*", 6);
        operatorPrecedence.put("/", 6);
    }

   public static void main(String[] args) 
   {
        ExpressionEvaluator e = new ExpressionEvaluator();
        try 
        {
            System.out.println(e.infixExpressionEvaluator("4>4+10"));
        } catch (Exception e1) 
        {
            e1.printStackTrace();
        }
    }
}