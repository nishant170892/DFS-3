class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        long sum = 0;
        for(int i : matchsticks){
            sum += i;
        }
        if(sum % 4 != 0 && n < 4) return false;
        long target = sum/4;
        Arrays.sort(matchsticks);
        return helper(matchsticks,n-1,0,0,0,0,target);
    }
    private boolean helper(int[] arr,int i,long sum1, long sum2, long sum3, long sum4,long target){
        if(sum1 > target || sum2 > target || sum3 > target || sum4 > target) return false;
        if(i < 0){
            if(sum1 == target && sum2 == target && sum3 == target && sum4 == target){
                return true;
            }
            else{
                return false;
            }
        }
        return helper(arr,i-1,sum1+arr[i],sum2,sum3,sum4,target) || 
        helper(arr,i-1,sum1,sum2+arr[i],sum3,sum4,target) || 
        helper(arr,i-1,sum1,sum2,sum3+arr[i],sum4,target) || 
        helper(arr,i-1,sum1,sum2,sum3,sum4+arr[i],target);
    }
}
