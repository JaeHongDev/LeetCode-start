class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();

        var visited = new boolean[1001];

        for(var num: nums1){
            
            var left = 0;
            var right = nums2.length -1; 
            
            if(visited[num]) continue; 

            while(left <= right){
                var mid = left + (right - left) / 2;

                if(nums2[mid] == num) {
                    visited[num] = true;
                    list.add(num);
                    break;
                }
                if(nums2[mid] < num) left = mid + 1;
                else right = mid - 1;
            }
        } 
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}