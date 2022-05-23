package com.ruoyi.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 系统商家评价对象 businessevaluation
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public class Businessevaluation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评价编号 */
    private Long businessEvaluationId2;

    /** 商家id */
    @Excel(name = "商家id")
    private Long supplierId;

    /** 商家编号 */
    @Excel(name = "商家编号")
    private Long businessEvaluationSuppkey2;

    /** 评价日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "评价日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date businessEvaluationEvadate2;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String businessEvaluationComment2;

    /** 分数 */
    @Excel(name = "分数")
    private Long businessEvaluationScore2;

    public void setBusinessEvaluationId2(Long businessEvaluationId2) 
    {
        this.businessEvaluationId2 = businessEvaluationId2;
    }

    public Long getBusinessEvaluationId2() 
    {
        return businessEvaluationId2;
    }
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setBusinessEvaluationSuppkey2(Long businessEvaluationSuppkey2) 
    {
        this.businessEvaluationSuppkey2 = businessEvaluationSuppkey2;
    }

    public Long getBusinessEvaluationSuppkey2() 
    {
        return businessEvaluationSuppkey2;
    }
    public void setBusinessEvaluationEvadate2(Date businessEvaluationEvadate2) 
    {
        this.businessEvaluationEvadate2 = businessEvaluationEvadate2;
    }

    public Date getBusinessEvaluationEvadate2() 
    {
        return businessEvaluationEvadate2;
    }
    public void setBusinessEvaluationComment2(String businessEvaluationComment2) 
    {
        this.businessEvaluationComment2 = businessEvaluationComment2;
    }

    public String getBusinessEvaluationComment2() 
    {
        return businessEvaluationComment2;
    }
    public void setBusinessEvaluationScore2(Long businessEvaluationScore2) 
    {
        this.businessEvaluationScore2 = businessEvaluationScore2;
    }

    public Long getBusinessEvaluationScore2() 
    {
        return businessEvaluationScore2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("businessEvaluationId2", getBusinessEvaluationId2())
            .append("supplierId", getSupplierId())
            .append("businessEvaluationSuppkey2", getBusinessEvaluationSuppkey2())
            .append("businessEvaluationEvadate2", getBusinessEvaluationEvadate2())
            .append("businessEvaluationComment2", getBusinessEvaluationComment2())
            .append("businessEvaluationScore2", getBusinessEvaluationScore2())
            .toString();
    }
}
