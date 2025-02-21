import java.util.Stack;

public class InfixToPostfix {
    String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        String postfix = "";
        char curr;
        for (int i = 0; i < infix.length(); i++) {
            curr = infix.charAt(i);
            if (curr >= 97 && curr <= 122) {
                postfix += curr;
            } else if (curr == '(') {
                stack.push(curr);
            } else if (curr == ')') {
                while (stack.peek() != '(') {
                    postfix += stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(curr)) {
                    postfix += stack.pop();
                }
                stack.push(curr);
            }
        }
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }
        return postfix;
    }

    public static int precedence(char op) {
        if (op == '^') {
            return 3;
        }
        if (op == '*' || op == '/') {
            return 2;
        }
        if (op == '+' || op == '-') {
            return 1;
        }
        return -1;
    }
}
