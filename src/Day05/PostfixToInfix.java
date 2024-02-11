package Day05;

import java.util.Stack;

public class PostfixToInfix {
    static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }

    static String postfixToInfix(String s) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isOperand(ch)) {
                st.push(String.valueOf(ch));
            } else {
                String operand2 = st.pop();
                String operand1 = st.pop();
                String expression = "(" + operand1 + ch + operand2 + ")";
                st.push(expression);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String ss = "953+4*6/-";
        String newString = PostfixToInfix.postfixToInfix(ss);
        System.out.println(newString);
}
}
