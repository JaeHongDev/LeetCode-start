class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // 식별자는 순서 영향 X
        // 문자로 구성된 로그가 숫자 로그보다 앞에 와야 함 문자 로그는 숫자로 옴
        // 문자가 동일한 경우 식별자 순으로
        // 숫자로그는 입력 순서 그대로 저장

        var digitLogs = new ArrayList<String>();
        var letterLogs = new ArrayList<String>();

        for(var log: logs) {
            if(Character.isDigit(log.split(" ")[1].charAt(0))) digitLogs.add(log);
            else letterLogs.add(log);
        }

        letterLogs.sort((s1, s2) -> { 
            var splitted1 = s1.split(" ", 2);
            var splitted2 = s2.split(" ", 2);

            var compare = splitted1[1].compareTo(splitted2[1]);

            if(compare == 0) return splitted1[0].compareTo(splitted2[0]);
            return compare; 
        });

        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(String[]::new);
    
    }

}

// 첫 단어는 식벼랒
// letter log 소문자로 구성
// digit log 숫자로 구성
// 문자로그는 숫자 전에 온ㄷ;ㅏ.
// 문자로그는 사전순으로 정렬 됨
// 같은 단어로 정렬되어 있다면 사전순으로 정렬 할 것
// 숫자 로그의 위치는 유지할 것 