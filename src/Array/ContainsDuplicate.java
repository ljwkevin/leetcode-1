package Array;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int num:nums)
			if(set.contains(num))
				return true;
			else
				set.add(num);
		return false;
    }
	
	@Test
	public void main(){
		int nums[] = {12000,12012,12001};
		System.out.println(containsDuplicate(nums));
	}
}
