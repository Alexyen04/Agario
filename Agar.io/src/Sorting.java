import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world");
	
		
		/*
		 * pick a random value from your "list"
		 * pick another random value and swap the two
		 * keep doing that until it's sorted
		 * 
		 */
		int[] nums = {3 , -5, 20, 50, 21};
		System.out.println(Arrays.toString(nums));
		boolean sorted = false;
		while(!sorted) {
			int num1 = (int)(Math.random()*(nums.length));
			int num2 = (int)(Math.random()*(nums.length));
			
			//swap the two number
			int temp = nums[num1];
			nums[num1] = nums[num2];
			nums[num2] = temp;
			
			//check if it's sorted
			boolean finish = true;
			for(int i =0; i<nums.length-1; i++) {
				if(nums[i]>nums[i+1]) {
					finish = false;
					break;
					
				}
			}
			if(finish) {
				break;
			}
		}
		//System.out.println(Arrays.toString(nums));
		
		boolean swapped = false;
		for(int i =0; i <nums.length; i++) {
			swapped = false;
			for(int j =0; j<nums.length-1; j++) {
				if(nums[j]>nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

}
