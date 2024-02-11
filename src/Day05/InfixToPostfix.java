package Day05;

import java.util.Stack;
public class InfixToPostfix{
    static int precedence(char ch){
        if(ch=='^')
            return 3;
        else if(ch=='/'||ch=='*')
            return 2;
        else if(ch=='+'||ch=='-')
            return 1;
        else
            return -1;
    }
    static String infixToPostfix(String s){
        Stack<Character> st = new Stack<>();
        StringBuilder postFixExp = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')||(ch>='0'&&ch<='9')){
                postFixExp.append(ch);
            }
            else if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                while (st.peek()!='(') {
                    postFixExp.append(st.pop());
                }
                st.pop();
            }
            else{
                while (!st.isEmpty()&&precedence(s.charAt(i))<=precedence(st.peek())) {
                    postFixExp.append(st.pop());
                }
                st.push(ch);
            }
        }
        while (!st.isEmpty()) {
            postFixExp.append(st.pop());
        }
        return postFixExp.toString();
    }
    public static void main(String[] args) {
        String ss ="X/((6/y)*(5-z))";
        String newString = InfixToPostfix.infixToPostfix(ss);
        System.out.println(newString);
    }
}

//infix topostfixabove
