package programmers.solved.level_1;

public class 이진_변환_반복하기 {
    class Solution {
        public int[] solution(String s) {
            int tryCount = 0;
            int removedZeroCount = 0;

            while (!s.equals("1")) {
                int beforeLength = s.length();
                s = s.replaceAll("0", "");
                int afterLength = s.length();
                removedZeroCount += (beforeLength - afterLength);

                s = Integer.toString(afterLength, 2);
                tryCount++;
            }

            return new int[]{tryCount, removedZeroCount};
        }
    }
}
