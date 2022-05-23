package com.ruoyi.consumer.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 我的评价对象 custevaluation
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
public class Custevaluation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评价编号 */
    private Long custEvaluationId2;

    /** 客户id */
    @Excel(name = "客户id")
    private String userId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private Long custEvaluationOrderkey2;

    /** 评价日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "评价日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date custEvaluationEvadate2;

    /** 评价内容 */
    @Excel(name = "评价内容")
    private String custEvaluationComment2;

    /** 商家分数，0-100 */
    @Excel(name = "商家分数，0-100")
    private Long custEvaluationSuppscore2;

    /** 商品分数，0-100 */
    @Excel(name = "商品分数，0-100")
    private Long custEvaluationGoodsscore2;

    /** 物流分数，0-100 */
    @Excel(name = "物流分数，0-100")
    private Long custEvaluationDelievryscore2;

    public void setCustEvaluationId2(Long custEvaluationId2) 
    {
        this.custEvaluationId2 = custEvaluationId2;
    }

    public Long getCustEvaluationId2() 
    {
        return custEvaluationId2;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setCustEvaluationOrderkey2(Long custEvaluationOrderkey2) 
    {
        this.custEvaluationOrderkey2 = custEvaluationOrderkey2;
    }

    public Long getCustEvaluationOrderkey2() 
    {
        return custEvaluationOrderkey2;
    }
    public void setCustEvaluationEvadate2(Date custEvaluationEvadate2) 
    {
        this.custEvaluationEvadate2 = custEvaluationEvadate2;
    }

    public Date getCustEvaluationEvadate2() 
    {
        return custEvaluationEvadate2;
    }
    public void setCustEvaluationComment2(String custEvaluationComment2) 
    {
        this.custEvaluationComment2 = custEvaluationComment2;
    }

    public String getCustEvaluationComment2() 
    {
        return custEvaluationComment2;
    }
    public void setCustEvaluationSuppscore2(Long custEvaluationSuppscore2) 
    {
        this.custEvaluationSuppscore2 = custEvaluationSuppscore2;
    }

    public Long getCustEvaluationSuppscore2() 
    {
        return custEvaluationSuppscore2;
    }
    public void setCustEvaluationGoodsscore2(Long custEvaluationGoodsscore2) 
    {
        this.custEvaluationGoodsscore2 = custEvaluationGoodsscore2;
    }

    public Long getCustEvaluationGoodsscore2() 
    {
        return custEvaluationGoodsscore2;
    }
    public void setCustEvaluationDelievryscore2(Long custEvaluationDelievryscore2) 
    {
        this.custEvaluationDelievryscore2 = custEvaluationDelievryscore2;
    }

    public Long getCustEvaluationDelievryscore2() 
    {
        return custEvaluationDelievryscore2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("custEvaluationId2", getCustEvaluationId2())
            .append("userId", getUserId())
            .append("custEvaluationOrderkey2", getCustEvaluationOrderkey2())
            .append("custEvaluationEvadate2", getCustEvaluationEvadate2())
            .append("custEvaluationComment2", getCustEvaluationComment2())
            .append("custEvaluationSuppscore2", getCustEvaluationSuppscore2())
            .append("custEvaluationGoodsscore2", getCustEvaluationGoodsscore2())
            .append("custEvaluationDelievryscore2", getCustEvaluationDelievryscore2())
            .toString();
    }
}
