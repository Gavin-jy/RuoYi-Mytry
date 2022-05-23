package com.ruoyi.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 系统物流评价对象 deliverevaluation
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public class Deliverevaluation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评价编号 */
    private Long logisticsEvaluationId2;

    /** 评价的物流编号 */
    @Excel(name = "评价的物流编号")
    private Long deliverId;

    /** 评价日期  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "评价日期 ", width = 30, dateFormat = "yyyy-MM-dd")
    private Date logisticsEvaluationEvadite2;

    /** 评价内容 */
    @Excel(name = "评价内容")
    private String logisticsEvaluationComment2;

    /** 分数 */
    @Excel(name = "分数")
    private Long logisticsEvaluationScore2;

    public void setLogisticsEvaluationId2(Long logisticsEvaluationId2) 
    {
        this.logisticsEvaluationId2 = logisticsEvaluationId2;
    }

    public Long getLogisticsEvaluationId2() 
    {
        return logisticsEvaluationId2;
    }
    public void setDeliverId(Long deliverId) 
    {
        this.deliverId = deliverId;
    }

    public Long getDeliverId() 
    {
        return deliverId;
    }
    public void setLogisticsEvaluationEvadite2(Date logisticsEvaluationEvadite2) 
    {
        this.logisticsEvaluationEvadite2 = logisticsEvaluationEvadite2;
    }

    public Date getLogisticsEvaluationEvadite2() 
    {
        return logisticsEvaluationEvadite2;
    }
    public void setLogisticsEvaluationComment2(String logisticsEvaluationComment2) 
    {
        this.logisticsEvaluationComment2 = logisticsEvaluationComment2;
    }

    public String getLogisticsEvaluationComment2() 
    {
        return logisticsEvaluationComment2;
    }
    public void setLogisticsEvaluationScore2(Long logisticsEvaluationScore2) 
    {
        this.logisticsEvaluationScore2 = logisticsEvaluationScore2;
    }

    public Long getLogisticsEvaluationScore2() 
    {
        return logisticsEvaluationScore2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("logisticsEvaluationId2", getLogisticsEvaluationId2())
            .append("deliverId", getDeliverId())
            .append("logisticsEvaluationEvadite2", getLogisticsEvaluationEvadite2())
            .append("logisticsEvaluationComment2", getLogisticsEvaluationComment2())
            .append("logisticsEvaluationScore2", getLogisticsEvaluationScore2())
            .toString();
    }
}
