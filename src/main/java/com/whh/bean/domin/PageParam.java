package com.whh.bean.domin;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * @author admin
 * @Date: 2018/12/14 16:49
 * @Description:
 */
public class PageParam implements Serializable {

    private static final long serialVersionUID = -7909847796025869634L;
    private int pageSize;
    private int pageNum;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("pageSize", pageSize)
                .add("pageNum", pageNum)
                .toString();
    }
}
