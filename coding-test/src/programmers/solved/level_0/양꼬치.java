package programmers.solved.level_0;

public class 양꼬치 {
    class Solution {
        public int solution(int n, int k) {
            int service = (int) n / 10;
            return (12_000 * n) + (2_000 * (k - service));
        }
    }
}
