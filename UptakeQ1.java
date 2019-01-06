import java.util.Stack;

class UptakeQ1 { 
    public int solution(int[] A){
    	int count =0;
    	
        int o = 0; //complexity track
    	
    	// O(n) --> n-1 to be specific
    	Stack<Integer> stack = new Stack<>();
        int hLen = A.length;
        // push first element
        stack.push(A[0]);
        for (int i = 1 ; i < hLen; i++) {
        	//check last value in stack
            int peekVal = stack.peek();
            if (peekVal < A[i]) {
                // if less then current, push
                stack.push(A[i]);
            } else if (peekVal > A[i]) {
            	// if more than current, pop extras as count
            	// since 1 for each unit
                int val1 = stack.pop()-A[i];
                count = count+val1;
                
                // if stack still not empty, remove all until 
                // now as only numbers less than last exist
                while (!stack.empty()) {
                	stack.pop();
                }
                // push current value to stack
                stack.push(A[i]);
            }
            o++;
        }
        count = count+stack.pop();
    
    	/*
    	// like Tetris
    	// Trying to make every unit 0
    	// O(nk)  -> k = maximum height + 1

    	// number of zeroes 
        int zeroes = 0;
        // Array to keep track of 0s
        int[] B = new int[A.length];
        
        //do until all blocks are 0
        //while(zeroes!=A.length){
        while(zeroes!=A.length){
            //flag for counting ongoing painting
            int p_on = 0;
            for(int i=0;i<A.length;i++){
                
                if(A[i]!= 0){
                    //reduce each block by 1
                    A[i]=A[i]-1;
                    p_on = 1;
                } else {
                    // hit a 0
                    if (p_on!=0){
                        // count 1 that was reduced 
                        count =count+1;
                    }
                    if(B[i] !=1){
                        // increment 0 count
                        zeroes = zeroes+1;
                        B[i] =1;
                    }
                    // paint finished, new brushstroke 
                    p_on =0;
                }
                o++;
            }
            //if paint was on going while end, count it
            if(p_on==1)
                count =count+1;
        }
        */
        
        System.out.println(o);
        return count;
    } 
    public static void main (String[] args) 
    { 
    	UptakeQ1 newOb = new UptakeQ1();

    	//int[] a = {5,8};
    	//int[] a = {5,4,3,8,0,3,2,1};
    	//int[] a = {5,1,0,8,0,2,3,2,0,1};
    	//int[] a = {1,1,0,1,1};
    	//int[] a = {0,0,0,0};
    	int[] a = {2,0,0,0,0,5};
		int b = newOb.solution(a);
		System.out.println("OUTPUT " + b);
    }
    
}
