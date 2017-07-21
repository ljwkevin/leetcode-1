package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月22日
 * @Description
 * 寻找重复子串，利用{@code HashMap}存放记录次数.<br/>
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> ls = new ArrayList<>();
    	Map<String,Integer> map = new HashMap<>();
    	int len = 10;
    	for(int i=0;i<=s.length()-len;++i){
    		String str = s.substring(i, i+len);
    		if(!map.containsKey(str)){
    			map.put(str,1);
    		}else{
    			if(map.get(str)==1){
    				map.put(str, 2);
    				ls.add(str);
    			}		
    		}
    	}
        return ls;
    }
	
	@Test
	public void main(){
		String s = "AAAAAAAAAAAA";
		List<String> ls = findRepeatedDnaSequences(s);
		for(String str : ls)
			System.out.println(str);
	}
}
