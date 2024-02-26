class Solution {
    public String[] reorderLogFiles(String[] logs) {

        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (var log : logs) {
            var split = log.split(" ");
            if (Character.isDigit(split[1].charAt(0)))  digitLogs.add(log);
            else letterLogs.add(log);
        }

        Collections.sort(letterLogs, (s1, s2) -> {
            var p = s1.substring(s1.indexOf(" ") + 1);
            var q = s2.substring(s2.indexOf(" ") + 1);

            var compared = p.compareTo(q);

            if (compared == 0) return s1.substring(0, s1.indexOf(" ") - 1).compareTo(s2.substring(0, s2.indexOf(" ") - 1));
            return compared;
        });

        letterLogs.addAll(digitLogs);

        return letterLogs.toArray(String[]::new);
    }
}

/*
 * 
 * 첫 번째 단어는 식별자임
 * 
 * 문자 로그는: 모든 문자들은 알파벳 소문자로 구성
 * 숫자로그: 모든 문자들이 숫자로 구성
 * 
 * 재 정렬 해야 함
 * 
 * 문자 로그는 숫자로그 보다 먼저와야 함
 * 문자 로그는 사전순으로 정렬 돼야 함
 * 사전순으로 동일하면 식별자를 기준으로 사전순
 * 
 * 숫자 로그는 그대로 유지
 */