package DailyPunch;
/*
 *  2021-06-24 15:41:50
 *	YORICHEONG
 *	Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 */
import java.util.*;
class Solution {
    public int maxPoints(int[][] points) {
		int n = points.length;
		if(n <= 2) {
			return n;
		}

		int ret = 0;

		for(int i = 0; i<n; i++) {
			// get the advance enough object
			if(ret >= n-i || ret > n/2) {
				break;
			}
			// use the map to save the accross the same line count
			Map<Integer,Integer> map = new HashMap<Integer,Integer>();
			// iterator the other point to acculate the slope and do compare
			for(int j = i+1; j < n; j++) {
				int x = points[i][0] - points[j][0];
				int y = points[i][1] - points[j][1];

				//Handling the special situations
				if(x == 0) {
					y = 1;
				} else if(y == 0) {
					x = 1;
				} else {
					if(y < 0) {
						x = -x;
						y = -y;
					}
					int gcdXY = gcd(Math.abs(x), Math.abs(y));
					x /= gcdXY;
					y /= gcdXY;
				}
				// generate the map the key, and use this key to acculate the same point value
				int key = x+y*20001;
				map.put(key, map.getOrDefault(key, 0)+1);
			}
			int maxN = 0;
			for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
				int num = entry.getValue();
				maxN = Math.max(maxN, num+1);
			}
			ret = Math.max(ret, maxN);
		}
		return ret;
    }
	/**
	 * get the greatest common divisor
	 * @param a
	 * @param b
	 * @return
	 */
	private int gcd(int a, int b) {
		return b!=0 ? gcd(b, a%b):a;
	}
}