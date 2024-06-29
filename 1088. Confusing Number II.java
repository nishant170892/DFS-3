// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: DFS - on the confusing numbers.

// 1088. Confusing Number II

import java.util.HashMap;

class Solution {
    HashMap<Integer,Integer> map;
    int count = 0;
    public int confusingNumberII(int n) {
        map = new HashMap<>();
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        map.put(0,0);
        dfs(0l,n);
        return count;
    }
    private void dfs(long curr, int n){
        if(curr > n) return;
        //logic
        if(Confusing((int)curr)) {
            count++;
        }
        for(int digit : map.keySet()){
            long newNum = curr*10+digit;
            if(newNum != 0){
                dfs(newNum,n);
            }
        }
    }
    private boolean Confusing(int num){
        int temp = num;
        int result = 0;
        while(num > 0){
            int digit = num%10;
            result = result*10 + map.get(digit);
            num = num/10;
        }
    return temp != result;
    }
}
