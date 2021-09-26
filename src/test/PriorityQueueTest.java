package test;

import jdk.nashorn.internal.runtime.Version;

import java.sql.ResultSet;
import java.util.*;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/9/26 15:05
 * @Tags
 **/
public class PriorityQueueTest {
    public static void main(String[] args) {
        // 这个用来存储500游戏ID最终要存储到要删除表中的数据
        List<VersionInfo> result = new ArrayList<>();
        // 假设这个是更加500个游戏ID从版本表中的查找的记录
        List<VersionInfo> searchInfo = new ArrayList<>();
        // 建立这个Map，用来将查询的到的数据根据AppId进行分组
        Map<Integer, List<VersionInfo>> versionMap = new HashMap<>();

        // 遍历查询到的版本信息集合，然后使用Map来进行分组
        for (VersionInfo versionInfo:
             searchInfo) {
            List<VersionInfo> versionInfoList = versionMap.getOrDefault(new ArrayList<VersionInfo>().add(versionInfo), versionMap.get(versionInfo.getAppId()));
            versionInfoList.add(versionInfo);
            versionMap.put(versionInfo.getAppId(), versionInfoList);
        }

        // 遍历按游戏ID来进行划分的Map
        for(Map.Entry<Integer, List<VersionInfo>> entry : versionMap.entrySet()) {
            List<VersionInfo> versionInfoList = entry.getValue();
            // 如果这个游戏一年前下载的游戏版本小于两个就直接跳过
            if (versionInfoList.size() <= 2) {
                continue;
            }
            // 将这个游戏的历史下架版本添加到一个优先队列中
            PriorityQueue<VersionInfo> priorityQueue = new PriorityQueue<>(versionInfoList);
            // 将这个优先队列中的历史下架版本取出，只留两个，取出来版本存入到一个list中
            while (priorityQueue.size() > 2) {
                // 可以在这里添加最终要删除的时间
                result.add(priorityQueue.poll());
            }
            priorityQueue = null;
        }
        // 最后将 result 这个list中的信息加入到要删除表中
    }
}
