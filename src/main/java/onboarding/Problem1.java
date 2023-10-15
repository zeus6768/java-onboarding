package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            int pobiScore = scoreOf(pobi);
            int crongScore = scoreOf(crong);
            if (pobiScore < crongScore) {
                return 2;
            }
            if (pobiScore > crongScore) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    private static int addPageDigits(int page) {
        int result = 0;
        while (page != 0) {
            result += page % 10;
            page /= 10;
        }
        return result;
    }

    private static int multiplyPageDigits(int page) {
        int result = 1;
        while (page != 0) {
            result *= page % 10;
            page /= 10;
        }
        return result;
    }

    private static int scoreOf(List<Integer> player) {
        int leftPage = Math.max(addPageDigits(player.get(0)), multiplyPageDigits(player.get(0)));
        int rightPage = Math.max(addPageDigits(player.get(1)), multiplyPageDigits(player.get(1)));
        return Math.max(leftPage, rightPage);
    }
}