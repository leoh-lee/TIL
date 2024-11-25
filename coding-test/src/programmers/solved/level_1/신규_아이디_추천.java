package programmers.solved.level_1;

public class 신규_아이디_추천 {
    class Solution {
        public String solution(String newId) {
            newId = newId.toLowerCase();
            newId = newId.replaceAll("[^a-z0-9\\-_.]", "");
            newId = newId.replaceAll("\\.+", ".");
            newId = newId.replaceAll("^\\.+|\\.+$", "");

            if (newId.equals("")) {
                newId = "a";
            }

            if (newId.length() >= 16) {
                newId = newId.substring(0, 15);
                newId = newId.replaceAll("\\.+$", "");
            }

            while (newId.length() < 3) {
                newId += newId.charAt(newId.length() - 1);
            }

            return newId;
        }
    }
}
