package test;

import java.util.Date;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/9/26 15:23
 * @Tags
 **/
public class VersionInfo implements Comparable{

    private int appId;

    private Date createTime;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public VersionInfo(int appId, Date createTime) {
        this.appId = appId;
        this.createTime = createTime;
    }

    @Override
    public int compareTo(Object o) {
        VersionInfo other = (VersionInfo) o;
        return other.getCreateTime().compareTo(this.getCreateTime());
    }
}
