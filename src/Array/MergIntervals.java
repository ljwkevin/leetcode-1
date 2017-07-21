package Array;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月1日
 * @Description 解题思路： 
 * <li> 直接比较合并
 * <li> 最好先排序</br>
 * 参考：
 * package com.soszou.java.leetcode;
 <code>
    public class MergeIntervals {
	    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		   if (intervals == null || intervals.size() <= 1)
			   return intervals;

	    	// sort intervals by using self-defined Comparator
		    Collections.sort(intervals, new IntervalComparator());

		    ArrayList<Interval> result = new ArrayList<Interval>();

		    Interval prev = intervals.get(0);
		    for (int i = 1; i < intervals.size(); i++) {
			    Interval curr = intervals.get(i);

			    if (prev.end >= curr.start) {
				    // merged case
				    Interval merged = new Interval(prev.start, Math.max(prev.end,
						    curr.end));
				    prev = merged;
			    } else {
				    result.add(prev);
				    prev = curr;
			    }
		    }

		    result.add(prev);
			return result;
	    }
    }

    class IntervalComparator implements Comparator<Interval> {
	    public int compare(Interval i1, Interval i2) {
		    return i1.start - i2.start;
	    }
    }
</code>
 */
public class MergIntervals {
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

	public boolean isOverlapped(Interval interval1, Interval interval2) {
		if (interval1.start >= interval2.start
				&& interval1.start <= interval2.end)
			return true;
		if (interval2.start >= interval1.start
				&& interval2.start <= interval1.end)
			return true;
		return false;
	}

	public Interval mergeIntervals(Interval interval1, Interval interval2) {
		int start = Math.min(interval1.start, interval2.start);
		int end = Math.max(interval1.end, interval2.end);
		return new Interval(start, end);
	}

	public List<Interval> merge(List<Interval> intervals) {
		boolean isNext = true;
		while (isNext) {
			isNext = false;
			for (int i = 0; i < intervals.size(); ++i) {
				for (int j = i + 1; j < intervals.size(); ++j) {
					Interval interval1 = intervals.get(i);
					Interval interval2 = intervals.get(j);
					if (isOverlapped(interval1, interval2)) {
						Interval interval = mergeIntervals(interval1, interval2);
						intervals.remove(interval1);
						intervals.remove(interval2);
						intervals.add(interval);
						isNext = true;
						break;
					}
				}
				if (isNext)
					break;
			}
		}
		return intervals;
	}

	@Test
	public void main() {
		int[][] nums = { { 1, 4 }, { 0, 2 }, { 3, 5 } };

		List<Interval> intervals = new LinkedList<>();

		for (int i = 0; i < nums.length; ++i) {
			Interval interval = new Interval(nums[i][0], nums[i][1]);
			intervals.add(interval);
		}

		merge(intervals);

		intervals.forEach(e -> {
			System.out.println(e.start + " " + e.end);
		});

	}
}
