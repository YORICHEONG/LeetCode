package byday.code_2022.code_01.day_11;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/11 14:18
 * @Tags
 **/
public class IsEscapePossible {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {

        return false;
    }
}
/**
 * 在一个 106 x 106 的网格中，每个网格上方格的坐标为 (x, y) 。
 *
 * 现在从源方格source = [sx, sy]开始出发，意图赶往目标方格target = [tx, ty] 。
 *
 * 数组 blocked 是封锁的方格列表，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。
 *
 * 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表blocked上。同时，不允许走出网格。
 *
 * 只有在可以通过一系列的移动从源方格source 到达目标方格target 时才返回true。否则，返回 false。
 */