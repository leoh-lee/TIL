package programmers.solved.level_1;

public class 삼진법_뒤집기 {
    class Solution {
        public int solution(int n) {
            String ternary = Integer.toString(n, 3);

            String reversedTernary = new StringBuilder(ternary).reverse().toString();

            return Integer.parseInt(reversedTernary, 3);
        }

        private int[] test() {
            return new int[]{1, 2};
        }
    }
}
