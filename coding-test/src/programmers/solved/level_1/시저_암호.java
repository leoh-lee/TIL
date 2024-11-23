package programmers.solved.level_1;

public class 시저_암호 {
    class Solution {
        public String solution(String s, int n) {
            char[] charArr = s.toCharArray();

            for (int i = 0; i < charArr.length; i++) {
                char c = charArr[i];
                if (!Character.isAlphabetic(c)) {
                    continue;
                }

                int start;
                int offset;
                if (c >= 'A' && c <= 'Z') {
                    start = 'A';
                    offset = 'Z';
                } else if (c >= 'a' && c <= 'z') {
                    start = 'a';
                    offset = 'z';
                } else {
                    continue;
                }

                if (c + n > offset) {
                    charArr[i] = (char) (((c + n) - offset) + (start - 1));
                    continue;
                }

                charArr[i] = (char) (c + n);
            }

            return String.valueOf(charArr);
        }
    }
}
