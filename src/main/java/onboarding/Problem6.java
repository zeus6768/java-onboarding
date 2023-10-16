package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new TreeSet<>();
        Map<String, String> nicknames = new HashMap<>();
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            for (int i = 0; i < nickname.length() - 1; i++) {
                String substring = nickname.substring(i, i+2);
                if (nicknames.containsKey(substring)) {
                    answer.add(email);
                    answer.add(nicknames.get(substring));
                } else {
                    nicknames.put(substring, email);
                }
            }
        }
        return new ArrayList<>(answer);
    }
}
