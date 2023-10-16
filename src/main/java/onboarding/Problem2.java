package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
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
}
