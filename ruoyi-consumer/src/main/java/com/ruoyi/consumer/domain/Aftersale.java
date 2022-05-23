package com.ruoyi.consumer.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 我的售后对象 aftersale
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
public class Aftersale extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 售后订单编号id */
    private Long aftersaleId;

    /** 订单编号id */
    @Excel(name = "订单编号id")
    private Long myorderId;

    /** 售后维护情况（0表示已退货已退款，1表示已退货，2表示已退款） */
    @Excel(name = "售后维护情况", readConverterExp = "0=表示已退货已退款，1表示已退货，2表示已退款")
    private Long aftersaleSituation;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatime;

    /** 删除标记 */
    private Integer delFlag;

    public void setAftersaleId(Long aftersaleId) 
    {
        this.aftersaleId = aftersaleId;
    }

    public Long getAftersaleId() 
    {
        return aftersaleId;
    }
    public void setMyorderId(Long myorderId) 
    {
        this.myorderId = myorderId;
    }

    public Long getMyorderId() 
    {
        return myorderId;
    }
    public void setAftersaleSituation(Long aftersaleSituation) 
    {
        this.aftersaleSituation = aftersaleSituation;
    }

    public Long getAftersaleSituation() 
    {
        return aftersaleSituation;
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
            .append("aftersaleId", getAftersaleId())
            .append("myorderId", getMyorderId())
            .append("aftersaleSituation", getAftersaleSituation())
            .append("creatime", getCreatime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .toString();
    }
}
