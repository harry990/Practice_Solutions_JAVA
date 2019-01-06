import java.util.*;

public class bitManipulation {
	// single number - exactly 1 single number
	// all numbers appear twice in array, find the one num
	// that appear once
	public int singleNumber(int[] nums) {
		// XOR ("this or that, but not both!")
	    // a XOR a = 0;
	    // a XOR 0 = a;
		// a^b^a => (a^a)^b = b;
		int a = 0;
        for(int i:nums) a^=i; 
        return a;
    }
	/* Missing number - exactly 1 missing number
	 *  start = 0, end = n (eg below:4)
	missing_num
			=4^(0^0)^(1^1)^(2^3)^(3^4)
			=(4^4)^(0^0)^(1^1)^(3^3)^2
			=0^0^0^0^2
			=2
	​*/	
	public int missingNumber(int[] nums) {
		int sum = nums.length;
        for(int i=0; i<nums.length; i++) sum^=i^nums[i]; 
        return sum;
    }
	
	// all missing numbers in array [1,n]
	public List<Integer> allMissingNumbers(int[] nums) {
		// [0,1,2,3,4,5,6,7] - index
		// [4,3,2,7,8,2,3,1] - nums
		// [3,2,1,6,7,1,2,0] - val
		// [1,1,1,1,0,0,1,1] - marker=> nums[val]=-nums[val] ; 1 means negative
		/*
		List<Integer> res = new ArrayList<Integer>();
		
		for(int i=0;i<nums.length;i++) {
			int val = Math.abs(nums[i])-1;
			if(nums[val]>0) nums[val]=-nums[val];
		}
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0) res.add(i+1);
		}
		return res;
		*/
	 	
		// [0 ,1 ,2 ,3 ,4 ,5 ,6 ,7] - index
		// [4 ,3 ,2 ,7 ,8 ,2 ,3 ,1] - nums
		// [3 ,2 ,1 ,6 ,7 ,1 ,2 ,0] - (nums[i]-1) % n
		// [12,19,18,15,0 ,0 ,11,9] - final
		 List<Integer> res = new ArrayList<>();
         int n = nums.length;
         for (int i = 0; i < nums.length; i ++) nums[(nums[i]-1) % n] += n;
         for (int i = 0; i < nums.length; i ++) if (nums[i] <= n) res.add(i+1);
         //for(int i:nums) System.out.println(i);
         return res;
		 
    }
	public static void main (String[] args) 
    { 
		bitManipulation newOb = new bitManipulation();

		int[] a = {4 ,3 ,2 ,7 ,8 ,2 ,3 ,1};
		//newOb.allMissingNumbers(a);
		//System.out.println(newOb.allMissingNumbers(a));
    }
}
