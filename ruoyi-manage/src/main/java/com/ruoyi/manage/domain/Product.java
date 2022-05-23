package com.ruoyi.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品对象 product
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public class Product extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品编号id */
    private Long productId;

    /** 商家id */
    @Excel(name = "商家id")
    private Long supplierId;

    /** 商品类型id */
    @Excel(name = "商品类型id")
    private Long productTypeId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String productPicture;

    /** 商品零售价格 */
    @Excel(name = "商品零售价格")
    private Long productPrice;

    /** 商品的产地 */
    @Excel(name = "商品的产地")
    private String productAddress;

    /** 商品数目 */
    @Excel(name = "商品数目")
    private Long productNum;

    /** 商品的状态（上架/下架） */
    @Excel(name = "商品的状态", readConverterExp = "上=架/下架")
    private Integer productSituation;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatime;

    /** 删除标记 */
    private Integer delFlag;

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setProductTypeId(Long productTypeId) 
    {
        this.productTypeId = productTypeId;
    }

    public Long getProductTypeId() 
    {
        return productTypeId;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setProductPicture(String productPicture) 
    {
        this.productPicture = productPicture;
    }

    public String getProductPicture() 
    {
        return productPicture;
    }
    public void setProductPrice(Long productPrice) 
    {
        this.productPrice = productPrice;
    }

    public Long getProductPrice() 
    {
        return productPrice;
    }
    public void setProductAddress(String productAddress) 
    {
        this.productAddress = productAddress;
    }

    public String getProductAddress() 
    {
        return productAddress;
    }
    public void setProductNum(Long productNum) 
    {
        this.productNum = productNum;
    }

    public Long getProductNum() 
    {
        return productNum;
    }
    public void setProductSituation(Integer productSituation) 
    {
        this.productSituation = productSituation;
    }

    public Integer getProductSituation() 
    {
        return productSituation;
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
            .append("productId", getProductId())
            .append("supplierId", getSupplierId())
            .append("productTypeId", getProductTypeId())
            .append("productName", getProductName())
            .append("productPicture", getProductPicture())
            .append("productPrice", getProductPrice())
            .append("productAddress", getProductAddress())
            .append("productNum", getProductNum())
            .append("productSituation", getProductSituation())
            .append("creatime", getCreatime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .toString();
    }
}
