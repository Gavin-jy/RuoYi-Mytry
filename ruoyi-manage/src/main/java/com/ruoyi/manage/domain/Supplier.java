package com.ruoyi.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商家管理对象 supplier
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public class Supplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商家id */
    private Long supplierId;

    /** 商家名称 */
    @Excel(name = "商家名称")
    private String supplierName;

    /** 商家电话 */
    @Excel(name = "商家电话")
    private String supplierPhone;

    /** 商家logo保存的地址 */
    @Excel(name = "商家logo保存的地址")
    private String supplierSupplog;

    /** 商家发货地址 */
    @Excel(name = "商家发货地址")
    private String address;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatime;

    /** 删除标记 */
    private Integer delFlag;

    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setSupplierPhone(String supplierPhone) 
    {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierPhone() 
    {
        return supplierPhone;
    }
    public void setSupplierSupplog(String supplierSupplog) 
    {
        this.supplierSupplog = supplierSupplog;
    }

    public String getSupplierSupplog() 
    {
        return supplierSupplog;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
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
            .append("supplierId", getSupplierId())
            .append("supplierName", getSupplierName())
            .append("supplierPhone", getSupplierPhone())
            .append("supplierSupplog", getSupplierSupplog())
            .append("address", getAddress())
            .append("creatime", getCreatime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .toString();
    }
}
