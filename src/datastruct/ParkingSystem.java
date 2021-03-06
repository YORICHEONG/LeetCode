package datastruct;

import java.util.HashMap;
import java.util.Map;
/**
 * @author YORICHEONG
 * @date 2021-07-12 09:33:19
 * @description 请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
 * 
 */
public class ParkingSystem {

    private Map<Integer,Integer> parkingMap;

    public ParkingSystem(int big, int medium, int small) {
        parkingMap = new HashMap<>();
        parkingMap.put(1, big);
        parkingMap.put(2, medium);
        parkingMap.put(3, small);
    }
    
    public boolean addCar(int carType) {
        parkingMap.put(carType, parkingMap.get(carType)-1);
        return parkingMap.get(carType) >= 0;
    }
}
/**
 * 使用二进制压缩存储各个车位的数量
 */
class ParkingSystem2{
    int cnt;
    public ParkingSystem2(int big, int medium, int small) {
        for (int i = 0; i < 30; i++) {
            int cur = 0;
            if(i < 10) {
                cur = (big >> i) & 1;
            } else if(i < 20) {
                cur = (medium >> (i-10)) & 1;
            } else if(i < 30) {
                cur = (small << (i-20)) & 1;
            }
            cnt += cur == 1 ? 1 << i : 0;
        }
    }

    public boolean addCar(int ct) {
        int cur = countOfType(ct);
        if(cur > 0) {
            setCount(ct,cur-1);
            return true;
        }
        return false;
    }

    public int countOfType(int cnt) {
        int ans = 0;
        int start = --cnt * 10;
        int end = start + 10;
        for (int s = start; s < end; s++) {
            if(((cnt >> s) & 1) == 1) {
               ans += (1<<(s-start));
            }
        }
        return ans;
    }

    public void setCount(int ct, int pc) {
        int start = --ct * 10;
        int end = start+10;
        for (int i = start; i < end; i++) {
            if( ((pc>>(i-start))&1) == 1) {
                cnt |= (1<<i);
            } else {
                cnt &= ~(1<<i);
            }
        }
    }
}