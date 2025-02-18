class Solution {
    public String removeDuplicateLetters(String s) {
       // 중복 문자를 제거한 것 중 사전순으로 가장 앞에 오는 문자열을 만들어라
       // bcabc
       // abc  
       // 문자열 내 존재하는 모든 단어를 포함해야 하고
       // 무조건 하나는 포함해야 함

       // bcabc
       // abc
       // cbacdcbc
       // acdb
    
       // c b a c
       // c b a c d
       // c b a c d c
       
       // 문자열 입력이 주어지면 문자 하나씩 순회한다.
       // 이전에 발견한 적 없는 문자면 추가한다. 
       // 만약 중복 문자가 들어오면 두 가지를 고려한다.
       // 1. 앞에 단어를 버릴 것 인가
       // 2. 뒤에 단어를 버릴 것 인가
       // 앞서 저장해둔 문자들과 이전에 기록한 문자를 제거하고 새로운 문자를 추가한 문자열을 비교하여 사전순으로 빠른 문자열을 유지시킨다.
       // 이 단계를 끝날 떄 까지 반복한다. 

       // 사전순은 A.compareTo(B) -1 이면 사전순으로 가장 적음 
       // LinkedHashMap -> c b a c, HashMap에서 지우고 합친 것과, 넣고 비교 한 것 중 사전순을 찾으면 될듯?
       // 이 선택지가 정말 정답일까?

       // 만약에 그리디 처럼 최적 선택을 골랐을 때 문제가 없을까? 

       // ArrayDeque<XC HashSet<Character, Integer> 를 선언한다
       // 문자열 입력이 주어지면 문자 단위로 순회한다. 
       
        // 각 문자 등장 횟수를 기록
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        // 스택 역할을 할 StringBuilder와 문자가 스택에 포함되었는지 여부를 체크하는 배열
        StringBuilder stack = new StringBuilder();
        boolean[] inStack = new boolean[26];
        
        // 문자열의 각 문자에 대해 반복
        for (char c : s.toCharArray()) {
            // 현재 문자의 등장 횟수 감소
            count[c - 'a']--;
            
            // 이미 스택에 있다면 넘어간다.
            if (inStack[c - 'a']) {
                continue;
            }
            
            // 스택의 맨 뒤에 있는 문자와 비교하여
            // 현재 문자가 더 작고, 스택의 맨 뒤 문자가 이후에도 등장한다면 스택에서 제거
            while (stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > c &&
                   count[stack.charAt(stack.length() - 1) - 'a'] > 0) {
                // 스택에서 제거할 문자를 표시 해제
                inStack[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }
            
            // 현재 문자를 스택에 추가하고 표시
            stack.append(c);
            inStack[c - 'a'] = true;
        }
        
        return stack.toString();
    }
}