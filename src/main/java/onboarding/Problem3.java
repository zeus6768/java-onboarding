package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        final List<Integer> number369 = List.of(3, 6, 9);
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int tmp = i;
            while (tmp != 0) {
                if (number369.contains(tmp % 10)) {
                    answer++;
                }
                tmp /= 10;
            }
        }
        return answer;
    }
}
