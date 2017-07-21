package HashTable;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月23日
 * @Description
 * 参考：https://leetcode.com/problems/count-primes/
 */
public class CountPrimes {
	boolean isPrime(int n){
		if(n==1)
			return false;
		for(int i = 2;i*i<n;++i){
			if(n%i==0)
				return false;
		}
		return true;	
	}
	
	public int countPrimes(int n) {
		boolean[] isPrime = new boolean[n];
		for(int i=1;i<n;++i)
			isPrime[i]=true;
		
		for(int i=2;i*i<n;++i){
			if(!isPrime[i])
				continue;
			for(int j=i*i;j<n;j+=i){
				isPrime[j]=false;
			}
		}
	
		int num = 0;
		for(int i=2;i<n;++i)
			if(isPrime[i])
				num++;
		return num;
    }
	
	
	@Test
	public void main(){
		System.out.println(countPrimes(1500000));
	}
}
