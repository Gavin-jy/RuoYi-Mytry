package com.ruoyi.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品类型对象 producttype
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public class Producttype extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品类型id */
    private Long productTypeId;

    /** 商品类型名称 */
    @Excel(name = "商品类型名称")
    private String productTypeName;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatime;

    /** 删除标记 */
    private Integer delFlag;

    public void setProductTypeId(Long productTypeId) 
    {
        this.productTypeId = productTypeId;
    }

    public Long getProductTypeId() 
    {
        return productTypeId;
    }
    public void setProductTypeName(String productTypeName) 
    {
        this.productTypeName = productTypeName;
    }

    public String getProductTypeName() 
    {
        return productTypeName;
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
            .append("productTypeId", getProductTypeId())
            .append("productTypeName", getProductTypeName())
            .append("creatime", getCreatime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .toString();
    }
}
