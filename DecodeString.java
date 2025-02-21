import java.util.Stack;

public class DecodeString {
    String decodeString(String input) {
        Stack<Integer> stack = new Stack<>();
        String res = "";
        char curr;
        for (int i = 0; i < input.length(); i++) {
            curr = input.charAt(i);
            if (curr >= 48 && curr <= 57) {
                int j = 0;
                while (input.charAt(i + j) != '[') {
                    j++;
                }
                stack.push(Integer.valueOf(input.substring(i, i + j)));
                stack.push(res.length());
                i += j;
            } else if (curr >= 97 && curr <= 122) {
                res += input.charAt(i);
            } else if (curr == ']') {
                String add = res.substring(stack.pop());
                for (int j = 1; j < stack.peek(); j++) {
                    res += add;
                }
                stack.pop();
            }
        }
        return res;
    }
}
