package com.ruoyi.consumer.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 我的订单对象 myorder
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
public class Myorder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单编号id */
    private Long myorderId;

    /** 客户id */
    @Excel(name = "客户id")
    private String userId;

    /** 订单发生时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "订单发生时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date myorderTime;

    /** 订单订购的书的id */
    @Excel(name = "订单订购的书的id")
    private Long myorderBookid;

    /** 订单的状态，待付款为0，待收货为1，待评价为2 */
    @Excel(name = "订单的状态，待付款为0，待收货为1，待评价为2")
    private Long myorderSituation;

    /** 订购的数目 */
    @Excel(name = "订购的数目")
    private Long myorderNumber;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatime;

    /** 删除标记 */
    private Integer delFlag;

    public void setMyorderId(Long myorderId) 
    {
        this.myorderId = myorderId;
    }

    public Long getMyorderId() 
    {
        return myorderId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setMyorderTime(Date myorderTime) 
    {
        this.myorderTime = myorderTime;
    }

    public Date getMyorderTime() 
    {
        return myorderTime;
    }
    public void setMyorderBookid(Long myorderBookid) 
    {
        this.myorderBookid = myorderBookid;
    }

    public Long getMyorderBookid() 
    {
        return myorderBookid;
    }
    public void setMyorderSituation(Long myorderSituation) 
    {
        this.myorderSituation = myorderSituation;
    }

    public Long getMyorderSituation() 
    {
        return myorderSituation;
    }
    public void setMyorderNumber(Long myorderNumber) 
    {
        this.myorderNumber = myorderNumber;
    }

    public Long getMyorderNumber() 
    {
        return myorderNumber;
    }
    public void setCreatime(Date creatime) 
    {
        this.creatime = creatime;
    }

    public Date getCreatime() 
    {
        return creatime;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("myorderId", getMyorderId())
            .append("userId", getUserId())
            .append("myorderTime", getMyorderTime())
            .append("myorderBookid", getMyorderBookid())
            .append("myorderSituation", getMyorderSituation())
            .append("myorderNumber", getMyorderNumber())
            .append("creatime", getCreatime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .toString();
    }
}
