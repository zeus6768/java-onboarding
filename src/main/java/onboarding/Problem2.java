package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (isRedundant(cryptogram)) {
            cryptogram = trim(cryptogram);
        }
        return cryptogram;
    }

    private static boolean isRedundant(String string) {
        if (!string.isEmpty()) {
            char previous = string.charAt(0);
            for (int i = 1; i < string.length(); i++) {
                if (previous == string.charAt(i)) {
                    return true;
                }
                previous = string.charAt(i);
            }
        }
        return false;
    }

    private static String trim(String string) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : string.toCharArray()) {
            if (!stack.empty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}
