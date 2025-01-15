class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Step 1: 문자열을 변환 ("abc" -> "^#a#b#c#$")
        String t = preprocess(s);
        int n = t.length();
        int[] p = new int[n];  // 팰린드롬 반지름 배열
        int center = 0, right = 0;  // 중심과 오른쪽 끝
        int maxLen = 0, centerIndex = 0;

        for (int i = 1; i < n - 1; i++) {
            // Step 2: i의 미러 인덱스를 계산
            int mirror = 2 * center - i;
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Step 3: 중심을 기준으로 확장
            while (t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) {
                p[i]++;
            }

            // Step 4: 중심과 오른쪽 경계를 업데이트
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // Step 5: 가장 긴 팰린드롬 길이 갱신
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        // Step 6: 원래 문자열에서 팰린드롬 부분 문자열 추출
        int start = (centerIndex - maxLen) / 2;  // 변환된 인덱스를 원래 인덱스로 변환
        return s.substring(start, start + maxLen);
    }

    // 문자열을 변환하는 함수: "abc" -> "^#a#b#c#$"
    private String preprocess(String s) {
        StringBuilder sb = new StringBuilder("^");
        for (char c : s.toCharArray()) {
            sb.append('#').append(c);
        }
        sb.append("#$");
        return sb.toString();
    }
}
