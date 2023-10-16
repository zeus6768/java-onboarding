package onboarding;

import java.util.*;

public class Problem7 {

    private static final int SHARED_FRIEND_SCORE = 10;

    private static List<String> answer = new ArrayList<>();
    private static Map<String, Set<String>> relationships = new HashMap<>();
    private static Map<String, Integer> scores = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        initializeRelationships(friends);
        initializeScores(user, visitors);
        applySharedFriendScore(user);
        List<String> scoreKeys = sortedKeysOf();
        for (int i = 0; i < 5 && i < scoreKeys.size(); i++) {
            String name = scoreKeys.get(i);
            if (scores.get(name) != 0){
                answer.add(name);
            }
        }
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

    private static void initializeScores(String user, List<String> visitors) {
        for (String visitor : visitors) {
            if (!relationships.get(user).contains(visitor)) {
                scores.computeIfPresent(visitor, (k, v) -> v + 1);
                scores.putIfAbsent(visitor, 1);
            }
        }
        for (String name : relationships.keySet()) {
            if (!(name.equals(user) || relationships.get(user).contains(name))) {
                scores.putIfAbsent(name, 0);
            }
        }
    }

    private static void applySharedFriendScore(String user) {
        for (String candidate : scores.keySet()) {
            if (relationships.containsKey(candidate)) {
                scores.compute(candidate, (k, v) -> v + sharedFriendCountOf(user, candidate) * SHARED_FRIEND_SCORE);
            }
        }
    }

    private static int sharedFriendCountOf(String user, String candidate) {
        Set<String> sharedFriends = new HashSet<>(relationships.get(user));
        sharedFriends.retainAll(relationships.get(candidate));
        return sharedFriends.size();
    }

    private static List<String> sortedKeysOf() {
        List<String> scoreKeys = new ArrayList<>(scores.keySet());
        scoreKeys.sort((o1, o2) -> {
            if (scores.get(o1).compareTo(scores.get(o2)) == 0)
                return o1.compareTo(o2);
            return scores.get(o2).compareTo(scores.get(o1));
        });
        return scoreKeys;
    }
}
