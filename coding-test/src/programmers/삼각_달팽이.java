package programmers;

import java.nio.charset.Charset;
import java.util.Arrays;

public class 삼각_달팽이 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(6)));
    }

    static class Solution {
        private static final int[] dx = {0, 1, -1};
        private static final int[] dy = {1, 0, -1};

        public int[] solution(int n) {
            int[][] triangle = new int[n][n];

            int x = 0;
            int y = 0;
            int d = 0;  // 방향
            int v = 1;

            int nx = 0;
            int ny = 0;

            while (true) {
                triangle[y][x] = v++;

                nx = x + dx[d];
                ny = y + dy[d];

                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                    d = (d + 1) % 3;
                    nx = x + dx[d];
                    ny = y + dy[d];

                    if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                        break;
                    }
                }

                x = nx;
                y = ny;
            }

            int[] answer = new int[v-1];

            int index = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<i+1; j++) {
                    answer[index++] = triangle[i][j];
                }
            }

            return answer;
        }
    }

}
