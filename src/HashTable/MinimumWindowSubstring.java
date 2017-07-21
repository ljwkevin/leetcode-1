package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月22日
 * @Description
 * 题目描述<br/>
 * Given a string S and a string T, find the minimum window in S
 * which will contain all the characters in T in complexity O(n).
 * <br/><br/>
 * 解题思路:<br/>
 * 1 线排除非符合字符，然后轮流选中一个为起点，求其余部分.<br/>
 * 2 参考  http://www.cnblogs.com/ganganloveu/p/4153041 .<br/>
 */
public class MinimumWindowSubstring {
	class Node{
		int bg;  // 开始位置
		int ed;  // 结束位置
		int gs;  // 需要获得个数
		Map<String,Integer> map = new HashMap<>();
		Node(int i,String str,int gs,Map<String,Integer> mapStrs){
			for(Map.Entry<String, Integer> entry:mapStrs.entrySet())
				map.put(entry.getKey(), entry.getValue());
			this.gs=gs;
			map.put(str,mapStrs.get(str)-1);
			this.gs--;
			bg = i;
			ed = i;
		}
		boolean update(int i,String str){
			int cs = map.get(str);
			if(cs>0){
				map.put(str, cs-1);
				gs--;
				ed = i;
				if(gs==0)
					return true;
			}
			return false;
		}
	}
	// O(n)
	public String minWindow1(String s, String t) {
		String rtStr  = "";
		Map<String,Integer> mapStrs = new HashMap<>();
		for(int i=0;i<t.length();++i){
			String str = t.substring(i,i+1);
			if(!mapStrs.containsKey(str))
				mapStrs.put(str, 1);
			else
				mapStrs.put(str, mapStrs.get(str)+1);
		}
		
		int gs = t.length();
		int len = Integer.MAX_VALUE;
		int bg = -1;
		int ed = -1;
		
		List<Node> ls = new LinkedList<>();
		
		for(int i=0;i<s.length();++i){
			String str = s.substring(i,i+1);
			if(mapStrs.containsKey(str)){
				Node node = new Node(i,str,gs,mapStrs);
				Iterator<Node> iterator = ls.iterator();
				while(iterator.hasNext()){
					Node nod = iterator.next();
					if(nod.update(i, str)){
						if(nod.ed-nod.bg+1<len){
							len = nod.ed-nod.bg+1;
							bg = nod.bg;
							ed = nod.ed;
						}
						iterator.remove();
					}else{
						if(i+2-nod.bg>=len)
							iterator.remove();
					}
				}
				if(gs==1){
					return t; 
				}
				ls.add(node);
			}
		}
		
		if(bg!=-1)
			rtStr=s.substring(bg,ed+1);
		return rtStr;
	}
	
	void find(Map<String, List<Integer>> map_s, Map<String, Integer> map_t,
			List<String> ls, int pos, int bg, int ed, Integer minLen,
			String rtStr,String s) {
		
		System.out.println("pos:"+pos);
		if(pos>=2)
			return;
		if(ed-bg+1>minLen)
			return;
		
		String str = ls.get(pos);
		List<Integer> integers = map_s.get(str);
		int len = map_t.get(str);
		
		for(int i =0;i+len<=integers.size();i++){
			int t_bg = Math.min(bg,integers.get(i));
			int t_ed = Math.max(ed,integers.get(i+len-1));
			if(pos==ls.size()-1){
				if(ed-bg+1<minLen){
					minLen = ed-bg+1;
					rtStr = s.substring(bg,ed+1);
				}
			}else{
				find(map_s, map_t, ls,pos+1,t_bg,t_ed,minLen,rtStr,s); 
			}
		}
		
	}

	public String minWindow(String s, String t) {
		String rtStr  = "";
		Map<String,Integer> map_t = new HashMap<>(); 
		for(int i=0;i<t.length();++i){
			String str = t.substring(i, i+1);
			if(map_t.containsKey(str)){
				map_t.put(str, map_t.get(str)+1);
			}else{
				map_t.put(str, 1);
			}
		}
		
		Map<String,List<Integer>> map_s = new HashMap<>(); 
		for(int i=0;i<s.length();++i){
			String str =s.substring(i,i+1);
			if(map_t.containsKey(str)){
				if(!map_s.containsKey(str))		
					map_s.put(str, new ArrayList<>());
				map_s.get(str).add(i);
			}
		}
	
		// ensure need todo
		for(Map.Entry<String, Integer> entry : map_t.entrySet()){
			if(!map_s.containsKey(entry.getKey())||map_s.get(entry.getKey()).size()<entry.getValue()){
				return rtStr;
			}
		}
		
		List<String> ls = new ArrayList<String>();
		for(String str : map_t.keySet())
			ls.add(str);
		//ls.sort((s1,s2)->{return map_s.get(s1).size()-map_s.get(s2).size();});
		//System.out.println(map_s.get(ls.get(0)).size()+" "+map_s.get(ls.get(1)).size());
		
		Integer minLen = s.length();
		rtStr = s;
			
		for(String str0 : ls){	
			
			List<Integer> ints0 = map_s.get(str0);
			int len0 = map_t.get(str0);
			
			for (int j = 0; j + len0 - 1 < ints0.size(); ++j) {

				int bg = ints0.get(j);
				int ed = ints0.get(j + len0 - 1);

				//boolean isFit = true;
				boolean isFit = true;
				for (String str : ls) {
					if (str.equals(str0))
						continue;
					List<Integer> ints = map_s.get(str);
					int len = map_t.get(str);
					isFit = false;
					
					int left = 0;
					int right = ints.size()-1;
					while(left<=right){
						int mid = (left+right)>>1;
						if(ints.get(mid)>bg){
							right = mid-1;
						}else{
							left = mid+1;
						}
					}
					
					int i = left;
					
					if (i < ints.size()&&ints.get(i) > bg) {
						if (i + len - 1 < ints.size()) {
							ed = Math.max(ed, ints.get(i + len - 1));
							if((ed - bg + 1) < minLen)
								isFit = true;
						}
					}
				
					if (!isFit)
						break;
				}

				if (isFit) {
					if ((ed - bg + 1) < minLen) {
						minLen = ed - bg + 1;
						rtStr = s.substring(bg, ed + 1);
					}
				}

			}
				
		}
		
		
		return rtStr; 
	}

	@Test
	public void main(){
		String s = "kgfidhktkjhlkb1gjkylgdracfzjdquy4554cghkomrb13bkoo111wqwgauriz2l54iesjnveoxmv3121312t454jdjaepdqftmvs3uyoogoqbrutahogxnvuxyezevfuaaiyufwjtezuxtpycfgasburzytdvazwakuxpsiiyhewctwgycgsgdkhdfnzfmvhwrellmvjvzfzsdgqgolorxvxciwjxtqvmxhxlcijeqiytqrzfcpyzlvbvrksmcoybxxpbgyfwgepzvrezgcytabptnjgpxgtweiykgfiolxniqthzwfswihpvtxlseepkopwuueiidyquratphnnqxflqcyiiezssoomlsxtyxlsolngtctjzywrbvajbzeuqsiblhwlehfvtubmwuxyvvpwsrhutlojgwktegekpjfidgwzdvxyrpwjgfdzttizquswcwgshockuzlzulznavzgdegwyovqlpmnluhsikeflpghagvcbujeapcyfxosmcizzpthbzompvurbrwenflnwnmdncwbfebevwnzwclnzhgcycglhtbfjnjwrfxwlacixqhvuvivcoxdrfqazrgigrgywdwjgztfrbanwiiayhdrmuunlcxstdsrjoapntugwutuedvemyyzusogumanpueyigpybjeyfasjfpqsqotkgjqaxspnmvnxbfvcobcudxflmvfcjanrjfthaiwofllgqglhkndpmiazgfdrfsjracyanwqsjcbakmjubmmowmpeuuwznfspjsryohtyjuawglsjxezvroallymafhpozgpqpiqzcsxkdptcutxnjzawxmwctltvtiljsbkuthgwwbyswxfgzfewubbpowkigvtywdupmankbndyligkqkiknjzchkmnfflekfvyhlijynjlwrxodgyrrxvzjhoroavahsapdiacwjpucnifviyohtprceksefunzucdfchbnwxplhxgpvxwrmpvqzowgimgdolirslgqkycrvkgshejuuhmvvlcdxkinvqgpdnhnljeiwmadtmzntokqzmtyycltuukahsnuducziedbscqlsbbtpxrobfhxzuximncrjgrrkwvdalqtoumergsulbrmvrwjeydpguiqqdvsrmlfgylzedtrhkfebbohbrwhnhxfmvxdhjlpjwopchgjtnnvodepwdylkxqwsqczznqklezplhafuqcitizslzdvwwupmwqnlhxwlwozdogxekhasisehxbdtvuhrlucurbhppgsdoriyykricxpbyvxupencbqwsreiimclbuvbufudjrslsnkofobhptgkmmuuywizqddllxowpijhytvdkymzsulegfzfcjguojhzhxyyghhgbcllazmuuyzafahjjqgxznzinxgvgnbhrmuuljohjpkqpraahgajvzriyydengofskzgtppefzvwrvxadxjaydjydocqvsxpdyxyondvmy22rfvqiaptanwll11baquxirmlqkmgzp33bnputmldmcwoqvadwavqxeilraxdiwulmlffxsilvgcnbcsyeoqdsaolcorkmlxyzfdyznkuwmjxqcxusoxmqlxtzofocdmbiqzhflebzpbprajjqivhuvcvlhjnkwquosevfkzfzcwtcietqcamxcikltawrsshkydsiexkgvdidjbuldgkfqvrkxpdpjlakqsuurecmjkstomgrutzlqsxnjacuneedyzzrfbgpoykcmsvglwtdoqqztvugzakazlrhnxwdxifjccsozlrpckpxfldglpgnbauqzstxcaiecaudmotqyknfvsliiuvlurbvjwulwdsadmerazjyjydgrrobnmmjdpeplzcjcujhhpbhqmizlnhcgwftkrcnghctifcmbnvifwsvjcxwpeyycdrmwucedexnlbznquxvtpretoaluajxfajdwnhbugofjpuzmuxflolfenqynzxubjxawgbqmsyvhuwvotaajnfpaxqnwnjzwgzvmdnaxlxeiucwpcyzqfoqcegaspcqybnmgbndomkwgmvyqvxgblzfshimykeynslutaxjmjgvvdtmysubfvjxcrjddobsgombomkdvsatvvfwnzxsvgszzbccrgxzulclzpqvhsqfnvbcwywrfotgsxlldilatnntcfqmxgrkdsozsktzbogtlrerzrtuhiplnfxknqwsikudwncxdiqozxhaoavximjvuihjzdcjpwmmlploxeezbmzrmwrxlauficojhqtxohlzwwpwcuvfgwzuvqrgqmlaozmxshuiohingzjitgobcnwzdpfvdsxrujroqlwhvgubgdlzjzdnozptqwqurqnlzezssvznctokybljdoyrppngmdcdvpqvuppmmqbqlrajsmuvcupskcawhcbdrrangrbuhcnstndobzjgtyydcabkccpvtpjbgmyprljkamaelkkgkkmnknzosojnfupnhncyalkazlemxoshaewkuvymjkzqeqdlfflfsygrjmdidypdcmoyjoktykldapqiwenpcviniovnmkqqygpivbdvloaoftwcxltzhbmrrhedtuuudleamjvaxwqfrohozcpidbzxkfafcwbfjffwocyoaotrccfdeumjxngjthrvfsapyhnojlcmbxddzlidhwnhktqdcjykcazcjoqszveaskfsvnxckkjwgczknzupbvtkjmeihlkzvptqfrurdgnjkouxpqpqmicvugebrqdmgyenpbethrerhaqwrfodoqaiyemqxredpjqhkwctpgmwjcsaiifyyfiwmuojntmdeemqaolpwxnfbffjpmjnssleocncxbhbhttjjeyfdllessqjfzwxtjdilsmivvlcqglzmlepyrwskmbrnzqhivrwnfgiasmsaxrnkxeipaaboduccklmfckuhrcjlqblnuaxrfhihjlwofyqrleynpswiwhvmigbejavojgvsrtgztysefrrulpekwzwghakqaigkocehxnirlbvqspmfgqpdrolzowrqgycuchdzumqhnmyhdmojfeowsaxiypyenbapidoerhletlnyychdgwbayziwoicbjcsth";
		String t = "kgfidhkqqqqaktaasaskaaaakk3kkddd3ddd1kff2kkkk1k";
		
		//String s = "a";
		//String t = "b";
		
		long t1 = System.currentTimeMillis();
		String s1 = minWindow1(s, t);
		long t2 = System.currentTimeMillis();
		String s2 = minWindow(s, t);
		long t3 = System.currentTimeMillis();
		System.out.println((t2-t1)+"ms");
		System.out.println(s1.length());
		System.out.println((t3-t2)+"ms");
		System.out.println(s2.length());
		System.out.println(s1.equals(s2));
		
		
	}
}
