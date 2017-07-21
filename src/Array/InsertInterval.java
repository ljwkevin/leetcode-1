package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/** 
 * @author �ɴ�Ϊ 
 * @date 2015��7��16��
 * @Description
 * ��Ŀ������</br>
 * Given a set of non-overlapping intervals, insert a new 
 * interval into the intervals (merge if necessary).You 
 * may assume that the intervals were initially sorted 
 * according to their start times.</br>
 * </br>
 * ����˼·��</br>
 * 1�����ص����֣��ҵ��Ƴ���������ʼ�㣬Ȼ������µ㣬Ȼ�����򡣣�Ч�ʽϵͣ�</br>
 * 2�Ż��Ŀɲο���http://blog.csdn.net/worldwindjp/article/details/21612731
 */
public class InsertInterval {
	public class Interval {
		int start;
		int end;
		Interval() {
			start = 0;
			end = 0;
		}
		Interval(int s, int e) {
			start = s;
			end = e;
		}
		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
		
	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		
		int st = newInterval.start;
		int ed = newInterval.end;
		
		List<Interval> lsIntervals = new ArrayList<>();
		for(Interval interval :intervals){
			if(interval.start>ed||interval.end<st){
				lsIntervals.add(interval);
				continue;
			}
			st = Math.min(st, interval.start);
			ed = Math.max(ed, interval.end);
		}
		lsIntervals.add(new Interval(st,ed));
		Collections.sort(lsIntervals, (i1,i2)->{
			return i1.start-i2.start;}
		);
		return lsIntervals;
	}
	
	@Test
	public void main(){
		
		int[][] olds = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] news = {4,9};
		List<Interval> intervals = new ArrayList<>();
		for(int[] nums:olds){
			intervals.add(new Interval(nums[0], nums[1]));
		}
		Interval newInterval = new Interval(news[0], news[1]);
		
		List<Interval>  lsIntervals = insert(intervals, newInterval);
		for(Interval interval : lsIntervals)
			System.out.println(interval);
		
	}
	
}
