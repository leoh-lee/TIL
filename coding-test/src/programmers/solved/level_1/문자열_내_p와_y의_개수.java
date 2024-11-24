package programmers.solved.level_1;

public class 문자열_내_p와_y의_개수 {
    class Solution {
        boolean solution(String s) {
//         s = s.toUpperCase();

//         if (!s.contains("P") && !s.contains("Y")) {
//             return true;
//         }

//         if (countOf2(s, "P") == countOf2(s, )) {
//             return true;
//         }

//         return false;

            int ps = 0;
            int ys = 0;

            for (char c : s.toCharArray()) {
                switch (c) {
                    case 'p', 'P' -> ps++;
                    case 'y', 'Y' -> ys++;
                }
            }

            return ps == ys;

        }

        private int countOf(String str, char target) {
            int count = 0;
            for (char c : str.toCharArray()) {
                if (c == target) {
                    count++;
                }
            }
            return count;
        }

        private int countOf2(String str, String target) {
            int beforeLength = str.length();

            str = str.replaceAll(target, "");

            return beforeLength - str.length();
        }
    }
}
