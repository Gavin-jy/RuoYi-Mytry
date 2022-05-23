package com.ruoyi.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 系统商品评价对象 goodsevaluation
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public class Goodsevaluation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评价编号 */
    private Long goodsEvaluationId2;

    /** 商品编号id */
    @Excel(name = "商品编号id")
    private Long productId;

    /** 商品编号 */
    @Excel(name = "商品编号")
    private Long goodsEvaluationGoodskey2;

    /** 评价日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "评价日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date goodsEvaluationEvedate2;

    /** 评价内容 */
    @Excel(name = "评价内容")
    private String goodsEvaluationComment2;

    /** 总分数 */
    @Excel(name = "总分数")
    private Long goodsEvaluationScore2;

    public void setGoodsEvaluationId2(Long goodsEvaluationId2) 
    {
        this.goodsEvaluationId2 = goodsEvaluationId2;
    }

    public Long getGoodsEvaluationId2() 
    {
        return goodsEvaluationId2;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setGoodsEvaluationGoodskey2(Long goodsEvaluationGoodskey2) 
    {
        this.goodsEvaluationGoodskey2 = goodsEvaluationGoodskey2;
    }

    public Long getGoodsEvaluationGoodskey2() 
    {
        return goodsEvaluationGoodskey2;
    }
    public void setGoodsEvaluationEvedate2(Date goodsEvaluationEvedate2) 
    {
        this.goodsEvaluationEvedate2 = goodsEvaluationEvedate2;
    }

    public Date getGoodsEvaluationEvedate2() 
    {
        return goodsEvaluationEvedate2;
    }
    public void setGoodsEvaluationComment2(String goodsEvaluationComment2) 
    {
        this.goodsEvaluationComment2 = goodsEvaluationComment2;
    }

    public String getGoodsEvaluationComment2() 
    {
        return goodsEvaluationComment2;
    }
    public void setGoodsEvaluationScore2(Long goodsEvaluationScore2) 
    {
        this.goodsEvaluationScore2 = goodsEvaluationScore2;
    }

    public Long getGoodsEvaluationScore2() 
    {
        return goodsEvaluationScore2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("goodsEvaluationId2", getGoodsEvaluationId2())
            .append("productId", getProductId())
            .append("goodsEvaluationGoodskey2", getGoodsEvaluationGoodskey2())
            .append("goodsEvaluationEvedate2", getGoodsEvaluationEvedate2())
            .append("goodsEvaluationComment2", getGoodsEvaluationComment2())
            .append("goodsEvaluationScore2", getGoodsEvaluationScore2())
            .toString();
    }
}
