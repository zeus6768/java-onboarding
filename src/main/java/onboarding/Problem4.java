package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (char c : word.toCharArray()) {
            answer.append(translate(c));
        }
        return answer.toString();
    }

    private static char translate(char c) {
        if (65 <= (int) c && (int) c <= 90) {
            return (char) (155 - (int) c);
        }
        if (97 <= (int) c && (int) c <= 122) {
            return (char) (219 - (int) c);
        }
        return c;
    }
}
