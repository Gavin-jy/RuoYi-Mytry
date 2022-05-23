package com.ruoyi.consumer.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 我的收藏对象 mycollect
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
public class Mycollect extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 收藏列表编号id */
    private Long mycollectId;

    /** 客户id */
    @Excel(name = "客户id")
    private String userId;

    /** 收藏的类型（0为书籍，1为店铺） */
    @Excel(name = "收藏的类型", readConverterExp = "0=为书籍，1为店铺")
    private Long mycollectType;

    /** 收藏店铺的id */
    @Excel(name = "收藏店铺的id")
    private Long mycollectStoreId;

    /** 收藏书籍的id */
    @Excel(name = "收藏书籍的id")
    private Long mycollectBookId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatime;

    /** 删除标记 */
    private Integer delFlag;

    public void setMycollectId(Long mycollectId) 
    {
        this.mycollectId = mycollectId;
    }

    public Long getMycollectId() 
    {
        return mycollectId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setMycollectType(Long mycollectType) 
    {
        this.mycollectType = mycollectType;
    }

    public Long getMycollectType() 
    {
        return mycollectType;
    }
    public void setMycollectStoreId(Long mycollectStoreId) 
    {
        this.mycollectStoreId = mycollectStoreId;
    }

    public Long getMycollectStoreId() 
    {
        return mycollectStoreId;
    }
    public void setMycollectBookId(Long mycollectBookId) 
    {
        this.mycollectBookId = mycollectBookId;
    }

    public Long getMycollectBookId() 
    {
        return mycollectBookId;
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
            .append("mycollectId", getMycollectId())
            .append("userId", getUserId())
            .append("mycollectType", getMycollectType())
            .append("mycollectStoreId", getMycollectStoreId())
            .append("mycollectBookId", getMycollectBookId())
            .append("creatime", getCreatime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .toString();
    }
}
