
public class sortColors {
	public void sortColorArr(int[] nums) {
        if (nums.length ==0) return;
        
        //record position of first element of each color
        // red would be trivially 0 unless no red exists;
        //int r=-1;
        int w=-1; 
        int b=-1;
        
        // NOT STABLE
        for (int i=0;i<nums.length;i++){
            if(nums[i]==0){
                //if(r==-1) r=0;
                //swap 0 with first 1
                if(w!=-1) {
                    nums[w]=0;
                    //swap 1 with first 2
                    if(b!=-1) {
                        nums[b]=1;
                        nums[i]=2;
                        b=b+1;
                    } else {
                        nums[i]=1;
                    }
                    w=w+1;
                } else if(b!=-1) {
                    nums[b]=0;
                    nums[i]=2;
                    b=b+1;
                } 
                
            } else if (nums[i]==1){
                //swap 1 with first 2
                if(b!=-1) {
                    nums[b]=1;
                    nums[i]=2;
                    if(w==-1) w=b; 
                    b=b+1;
                } else {
                    if(w==-1) w=i;
                }
            } else if (nums[i]==2){
                if(b==-1) b=i;
            } else {
                //invalid color
            }
        }
    }
	public static void main (String[] args) 
    { 
		sortColors newOb = new sortColors();
        
		int[] arr = {2,0,2,1,1,0};
		newOb.sortColorArr(arr);
		for (int a:arr)
			System.out.println(a);
    }
	
}
