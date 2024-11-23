package programmers.solved.level_1;

public class 이상한_문자_만들기 {
    class Solution {
        public String solution(String s) {
            char[] cArr = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            int index = 0;

            for (char c : cArr) {
                if (!Character.isAlphabetic(c)) {
                    index = 0;
                    sb.append(c);
                    continue;
                }

                sb.append((index % 2 == 0) ? Character.toUpperCase(c) : Character.toLowerCase(c));

                index++;
            }

            return sb.toString();
        }
    }
}
