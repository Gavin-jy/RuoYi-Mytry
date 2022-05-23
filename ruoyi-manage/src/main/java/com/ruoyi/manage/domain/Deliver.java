package com.ruoyi.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物流公司对象 deliver
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public class Deliver extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物流编号 */
    private Long deliverId;

    /** 物流名称 */
    @Excel(name = "物流名称")
    private String deliverName;

    /** 物流手机号 */
    @Excel(name = "物流手机号")
    private String deliverPhone;

    public void setDeliverId(Long deliverId) 
    {
        this.deliverId = deliverId;
    }

    public Long getDeliverId() 
    {
        return deliverId;
    }
    public void setDeliverName(String deliverName) 
    {
        this.deliverName = deliverName;
    }

    public String getDeliverName() 
    {
        return deliverName;
    }
    public void setDeliverPhone(String deliverPhone) 
    {
        this.deliverPhone = deliverPhone;
    }

    public String getDeliverPhone() 
    {
        return deliverPhone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deliverId", getDeliverId())
            .append("deliverName", getDeliverName())
            .append("deliverPhone", getDeliverPhone())
            .toString();
    }
}
