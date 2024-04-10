class Solution {
    public int findKthLargest(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>((i1,i2) -> i2 - i1);
        var size = 0; 
        while(size < nums.length) pq.offer(nums[size++]);
        while(k-- > 1) pq.poll();
        return pq.poll();

    }
}