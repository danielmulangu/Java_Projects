import java.util.Stack;

public class InfixToPostfixEvaluator {

    public static String infixToPostfix(String expression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            char c = token.charAt(0);

            if (Character.isDigit(c)) {
                postfix.append(token).append(" ");
            } else if ("+-*/^".contains(token)) {
                while (!operatorStack.isEmpty() && precedence(token) <= precedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(token.charAt(0));
            } else if (token.equals("(")) {
                operatorStack.push('(');
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    public static int evaluatePostfix(String postfixExpression) {
        String[] tokens = postfixExpression.split(" ");
        Stack<Integer> operandStack = new Stack<>();

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                operandStack.push(Integer.parseInt(token));
            } else if ("+-*/^".contains(token)) {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                int result = 0;
                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                    case "^":
                        result = (int) Math.pow(operand1, operand2);
                        break;
                }
                operandStack.push(result);
            }
        }

        if (!operandStack.isEmpty()) {
            return operandStack.pop();
        } else {
            throw new IllegalArgumentException("Invalid postfix expression");
        }
    }

    private static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String infixExpression = "3 + 4 * ( 2 - 1 )";
        String postfixExpression = infixToPostfix(infixExpression);
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Infix: " + infixExpression);
        System.out.println("Postfix: " + postfixExpression);
        System.out.println("Result: " + result);
    }
}
