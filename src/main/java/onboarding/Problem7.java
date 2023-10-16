package onboarding;

import java.util.*;

public class Problem7 {

    private static List<String> answer = Collections.emptyList();
    private static Map<String, Set<String>> relationships = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        initializeRelationships(friends);
        return answer;
    }

    private static void initializeRelationships(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String a = friend.get(0);
            String b = friend.get(1);
            relationships.putIfAbsent(a, new HashSet<>());
            relationships.get(a).add(b);
            relationships.putIfAbsent(b, new HashSet<>());
            relationships.get(b).add(a);
        }
    }
}
