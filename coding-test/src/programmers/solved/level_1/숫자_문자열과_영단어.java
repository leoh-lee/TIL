package programmers.solved.level_1;

public class 숫자_문자열과_영단어 {
    class Solution {
        public int solution(String s) {
            return Integer.parseInt(convertAll(s));
        }

        private String convertAll(String s) {
            String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

            for (int i = 0; i < 10; i++) {
                s = s.replaceAll(digits[i], String.valueOf(i));
            }

            return s;
        }
    }
}
