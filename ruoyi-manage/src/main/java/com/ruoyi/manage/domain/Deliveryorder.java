package com.ruoyi.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物流订单对象 deliveryorder
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public class Deliveryorder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物流订单编号 */
    private Long deliveryOrderId3;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long deliverId;

    /** 退货标记，0表示未退货，1表示退货 */
    @Excel(name = "退货标记，0表示未退货，1表示退货")
    private Integer deliveryOrderReturnflag2;

    /** 发货地址 */
    @Excel(name = "发货地址")
    private String deliveryOrderDeliveryadd2;

    /** 发货状态，0表示未发货，1表示已发货 */
    @Excel(name = "发货状态，0表示未发货，1表示已发货")
    private Integer deliveryOrderDeliverystatus2;

    /** 发货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryOrderDeliverydate2;

    /** 运输方式 */
    @Excel(name = "运输方式")
    private String deliveryOrderShiptype2;

    /** 签收地址 */
    @Excel(name = "签收地址")
    private String deliveryOrderReceiptadd2;

    /** 签收状态，0表示未签收，1表示已签收 */
    @Excel(name = "签收状态，0表示未签收，1表示已签收")
    private Integer deliveryOrderReceiptstatus2;

    /** 签收日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "签收日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryOrderReceiptdate2;

    /** 总运费 */
    @Excel(name = "总运费")
    private Long deliveryOrderShipprice2;

    /** 总运输时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "总运输时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryOrderShiptime2;

    public void setDeliveryOrderId3(Long deliveryOrderId3) 
    {
        this.deliveryOrderId3 = deliveryOrderId3;
    }

    public Long getDeliveryOrderId3() 
    {
        return deliveryOrderId3;
    }
    public void setDeliverId(Long deliverId) 
    {
        this.deliverId = deliverId;
    }

    public Long getDeliverId() 
    {
        return deliverId;
    }
    public void setDeliveryOrderReturnflag2(Integer deliveryOrderReturnflag2) 
    {
        this.deliveryOrderReturnflag2 = deliveryOrderReturnflag2;
    }

    public Integer getDeliveryOrderReturnflag2() 
    {
        return deliveryOrderReturnflag2;
    }
    public void setDeliveryOrderDeliveryadd2(String deliveryOrderDeliveryadd2) 
    {
        this.deliveryOrderDeliveryadd2 = deliveryOrderDeliveryadd2;
    }

    public String getDeliveryOrderDeliveryadd2() 
    {
        return deliveryOrderDeliveryadd2;
    }
    public void setDeliveryOrderDeliverystatus2(Integer deliveryOrderDeliverystatus2) 
    {
        this.deliveryOrderDeliverystatus2 = deliveryOrderDeliverystatus2;
    }

    public Integer getDeliveryOrderDeliverystatus2() 
    {
        return deliveryOrderDeliverystatus2;
    }
    public void setDeliveryOrderDeliverydate2(Date deliveryOrderDeliverydate2) 
    {
        this.deliveryOrderDeliverydate2 = deliveryOrderDeliverydate2;
    }

    public Date getDeliveryOrderDeliverydate2() 
    {
        return deliveryOrderDeliverydate2;
    }
    public void setDeliveryOrderShiptype2(String deliveryOrderShiptype2) 
    {
        this.deliveryOrderShiptype2 = deliveryOrderShiptype2;
    }

    public String getDeliveryOrderShiptype2() 
    {
        return deliveryOrderShiptype2;
    }
    public void setDeliveryOrderReceiptadd2(String deliveryOrderReceiptadd2) 
    {
        this.deliveryOrderReceiptadd2 = deliveryOrderReceiptadd2;
    }

    public String getDeliveryOrderReceiptadd2() 
    {
        return deliveryOrderReceiptadd2;
    }
    public void setDeliveryOrderReceiptstatus2(Integer deliveryOrderReceiptstatus2) 
    {
        this.deliveryOrderReceiptstatus2 = deliveryOrderReceiptstatus2;
    }

    public Integer getDeliveryOrderReceiptstatus2() 
    {
        return deliveryOrderReceiptstatus2;
    }
    public void setDeliveryOrderReceiptdate2(Date deliveryOrderReceiptdate2) 
    {
        this.deliveryOrderReceiptdate2 = deliveryOrderReceiptdate2;
    }

    public Date getDeliveryOrderReceiptdate2() 
    {
        return deliveryOrderReceiptdate2;
    }
    public void setDeliveryOrderShipprice2(Long deliveryOrderShipprice2) 
    {
        this.deliveryOrderShipprice2 = deliveryOrderShipprice2;
    }

    public Long getDeliveryOrderShipprice2() 
    {
        return deliveryOrderShipprice2;
    }
    public void setDeliveryOrderShiptime2(Date deliveryOrderShiptime2) 
    {
        this.deliveryOrderShiptime2 = deliveryOrderShiptime2;
    }

    public Date getDeliveryOrderShiptime2() 
    {
        return deliveryOrderShiptime2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deliveryOrderId3", getDeliveryOrderId3())
            .append("deliverId", getDeliverId())
            .append("deliveryOrderReturnflag2", getDeliveryOrderReturnflag2())
            .append("deliveryOrderDeliveryadd2", getDeliveryOrderDeliveryadd2())
            .append("deliveryOrderDeliverystatus2", getDeliveryOrderDeliverystatus2())
            .append("deliveryOrderDeliverydate2", getDeliveryOrderDeliverydate2())
            .append("deliveryOrderShiptype2", getDeliveryOrderShiptype2())
            .append("deliveryOrderReceiptadd2", getDeliveryOrderReceiptadd2())
            .append("deliveryOrderReceiptstatus2", getDeliveryOrderReceiptstatus2())
            .append("deliveryOrderReceiptdate2", getDeliveryOrderReceiptdate2())
            .append("deliveryOrderShipprice2", getDeliveryOrderShipprice2())
            .append("deliveryOrderShiptime2", getDeliveryOrderShiptime2())
            .toString();
    }
}
