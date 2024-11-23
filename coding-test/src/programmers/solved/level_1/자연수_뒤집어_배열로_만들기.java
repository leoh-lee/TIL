package programmers.solved.level_1;

public class 자연수_뒤집어_배열로_만들기 {
    class Solution {
        public int[] solution(long n) {
            String strLong = String.valueOf(n);

            StringBuilder sb = new StringBuilder(strLong);

            return sb.reverse().chars().map(c -> c - '0').toArray();
        }
    }
}
