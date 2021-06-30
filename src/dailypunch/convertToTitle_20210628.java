package dailypunch;
/**
 * @date 2021-06-29 09:32:36
 * @author YORICHEONG
 */
public class convertToTitle_20210628 {
    /**
     * 
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while(columnNumber != 0) {
            columnNumber--;
            sb.append((char) (columnNumber%26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
