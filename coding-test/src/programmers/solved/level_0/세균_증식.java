package programmers.solved.level_0;

public class 세균_증식 {
    class Solution {
        public int solution(int n, int t) {
            for (int i=0; i<t; i++) {
                n *= 2;
            }

            return n;
        }
    }
}
