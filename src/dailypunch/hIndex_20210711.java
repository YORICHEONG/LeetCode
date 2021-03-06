package dailypunch;
public class hIndex_20210711 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int total = 0;
        int[] counter = new int[n+1];
        for (int i = 0; i < n; i++) {
            if(citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            total += counter[i];
            if(total >= i) {
                return i;
            }
        }
        return 0;
    }
}
