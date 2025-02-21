import java.util.Stack;

public class BalancedBrackets {
    String balancedBrackets(String input) {
        Stack<Integer> stack = new Stack<>();
        int len = input.length();
        int curr;
        for (int i = 0; i < len; i++) {
            curr = input.charAt(i);
            if (curr == 40 || curr == 91 || curr == 123) {
                stack.push(curr);
            } else if (curr <= stack.peek() + 2) {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        }
        return "NO";
    }
}