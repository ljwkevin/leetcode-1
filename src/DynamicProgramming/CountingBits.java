package DynamicProgramming;

/**
 * 1的个数按 1,2,4，8...的间隔递增1 </br>
 * https://leetcode.com/problems/counting-bits/
 *
 * @author mindw
 * @date 2016年12月14日
 */
public class CountingBits {
	public int[] countBits(int num) {
		int[] r = new int[num + 1];
		int index = 1;
		int offset = 1;
		while (index <= num) {
			for (int i = 0; i < offset; ++i) {
				r[index] = r[index - offset] + 1;
				index++;
				if (index > num)
					break;
			}
			offset *= 2;
		}
		return r;
	}
}
