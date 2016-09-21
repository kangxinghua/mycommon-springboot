package org.mycommon.springboot.model;

/**
 * Created by KangXinghua on 2016/9/19.
 */
public class IdModel {
    protected String id;
    protected Boolean deleted; // 删除标记（0：正常；1：删除；）
    protected Integer version; //版本控制

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
