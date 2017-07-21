package HashTable;

import java.util.Hashtable;

import org.junit.Test;
/**
 * @ClassName: ContainsDuplicateII 
 * @author �ɴ�Ϊ
 * @date 2015��6��23��
 * @Description
 * ����˼·
 * <li>һ�α�����ʹ�ü��ϴ�����Ϣ 
 */
public class ContainsDuplicateII {
	 public boolean containsNearbyDuplicate(int[] nums, int k) {
		 Hashtable<Integer,Integer> hTable = new Hashtable<>();
		 for(int i=0;i<nums.length;++i){
			 if(hTable.get(nums[i])!=null){
				if(Math.abs(hTable.get(nums[i])-i)<=k)
					return true;
			 }
			 hTable.put(nums[i], i);
		 }
		 return false;
	 }
	 
	 @Test
	 public void main(){
		 System.out.println(containsNearbyDuplicate(new int[]{99,99}, 2));
	 }
}
