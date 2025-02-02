class Solution {  
    public String[] reorderLogFiles(String[] logs) {  
        // 첫 번째 단어는 식별자  
        // 두 종류의 로그가 있음  
        // 1번은 문자 로그  
        // 정수 로그  
        // 재배열  
        // 문자 로그가 정수 로그보다 먼저와야 함  
        // 문자 로그는 내용이 사전순으로 정렬  
        // 같은 문자가 있으면 식별자 순으로  
        // 정수 로그는 순서 유지  
  
        var letterLists = new ArrayList<String>();  
        var digitLists = new ArrayList<String>();  
  
        for(var log: logs) {  
            if(Character.isAlphabetic(log.charAt(log.indexOf(" ") + 1))) letterLists.add(log);  
            else digitLists.add(log);  
        }  
  
  
        Collections.sort(letterLists, (s1, s2) -> {  
            var t1 = s1.split(" ", 2);  
            var t2 = s2.split(" ", 2);  
  
            var compare = t1[1].compareTo(t2[1]);  
  
            if(compare == 0) {  
                return t1[0].compareTo(t2[0]);  
            }  
  
            return compare;  
        });  
  
  
        letterLists.addAll(digitLists);  
        return letterLists.toArray(String[]::new);  
    }
}