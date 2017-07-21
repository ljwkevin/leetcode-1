package HashTable;

import org.junit.Test;

/**
 * @author 闵大为
 * @date 2015年7月23日
 * @Description
 * 求在直线上的较多的点，注意判断是否在一条直线上.<br/>
 */
public class MaxPointsOnALine {
	
	class Point {
		 int x;
		 int y;
		 Point() { x = 0; y = 0; }
		 Point(int a, int b) { x = a; y = b; }
	}
	
	
	Double A ;Double B;Double C;
	void getLine(Point p1 ,Point p2) {
		int x1 = p1.x;
		int y1 = p1.y;
		int x2 = p2.x;
		int y2 = p2.y;
		if(x2==x1){
			A = 1.0;
			B = 0.0;
			C = -1.0*x1;
		}else{
			A = (y2-y1)*1.0/(x2-x1);
			B = (-1.0);
			C = (y1-A*x1);
		}
		System.out.println("A: "+A+" B: "+B+" C: "+C);
		
	}
	
    public int maxPoints(Point[] points) {
    	if(points.length<=2)
    		return points.length;
    	
    	int maxNum = 2;
   
    	for(int i=0;i<points.length;++i){
    		for(int j=i+1;j<points.length;++j){
    			
    			int num = 1;
    			while(points[i].x==points[j].x&&points[i].y==points[j].y){
    				j++;
    				num++;
    				if(j==points.length)
    					break;
    			}
    			if(j==points.length){
    				if(num>maxNum)
        				maxNum=num;
    				break;
    			}
    			num=2;		
    			int dx0 = points[j].x-points[i].x;
    			int dy0 = points[j].y-points[i].y;
    			
    			for(int k=0;k<points.length;++k){
    				if(k==i||k==j)
    					continue;
    				int dx = points[k].x-points[i].x;
    				int dy = points[k].y-points[i].y;
        				
    				if(dx0*dy==dy0*dx){
    					num++;
    				}
    			}
    			if(num>maxNum)
    				maxNum=num;
    		}
    	}
        return maxNum;
    }
    

    
    @Test
    public void main(){
      	
    	int[][] pos = {
    			{40,-23},{9,138},{429,115},{50,-17},{-3,80},{-10,33},{5,-21},{-3,80},{-6,-65},{-18,26},{-6,-65},{5,72},{0,77},{-9,86},{10,-2},{-8,85},{21,130},{18,-6},{-18,26},{-1,-15},{10,-2},{8,69},{-4,63},{0,3},{-4,40},{-7,84},{-8,7},{30,154},{16,-5},{6,90},{18,-6},{5,77},{-4,77},{7,-13},{-1,-45},{16,-5},{-9,86},{-16,11},{-7,84},{1,76},{3,77},{10,67},{1,-37},{-10,-81},{4,-11},{-20,13},{-10,77},{6,-17},{-27,2},{-10,-81},{10,-1},{-9,1},{-8,43},{2,2},{2,-21},{3,82},{8,-1},{10,-1},{-9,1},{-12,42},{16,-5},{-5,-61},{20,-7},{9,-35},{10,6},{12,106},{5,-21},{-5,82},{6,71},{-15,34},{-10,87},{-14,-12},{12,106},{-5,82},{-46,-45},{-4,63},{16,-5},{4,1},{-3,-53},{0,-17},{9,98},{-18,26},{-9,86},{2,77},{-2,-49},{1,76},{-3,-38},{-8,7},{-17,-37},{5,72},{10,-37},{-4,-57},{-3,-53},{3,74},{-3,-11},{-8,7},{1,88},{-12,42},{1,-37},{2,77},{-6,77},{5,72},{-4,-57},{-18,-33},{-12,42},{-9,86},{2,77},{-8,77},{-3,77},{9,-42},{16,41},{-29,-37},{0,-41},{-21,18},{-27,-34},{0,77},{3,74},{-7,-69},{-21,18},{27,146},{-20,13},{21,130},{-6,-65},{14,-4},{0,3},{9,-5},{6,-29},{-2,73},{-1,-15},{1,76},{-4,77},{6,-29}};
    	
    	
    	Point[] points = new Point[pos.length];
    	
    	for(int i = 0 ;i < pos.length ; ++i){
    		points[i] = new Point(pos[i][0], pos[i][1]);
    	}
    	//System.out.println(points.length);
    	System.out.println(maxPoints(points));
	
    	
    }
    
}
