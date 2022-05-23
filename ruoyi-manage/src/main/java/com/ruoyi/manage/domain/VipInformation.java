package com.ruoyi.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会员信息对象 vip_information
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public class VipInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 会员编号 */
    private String vipId;

    /** 客户id */
    @Excel(name = "客户id")
    private String userId;

    /** 1表示普通会员，2表示尊贵会员，3表示超级会员 */
    @Excel(name = "1表示普通会员，2表示尊贵会员，3表示超级会员")
    private Long vipLevel;

    /** 例：0.80表示打8折 */
    @Excel(name = "例：0.80表示打8折")
    private Long vipDiscount;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatime;

    /** 删除标记 */
    private Integer delFlag;

    public void setVipId(String vipId) 
    {
        this.vipId = vipId;
    }

    public String getVipId() 
    {
        return vipId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setVipLevel(Long vipLevel) 
    {
        this.vipLevel = vipLevel;
    }

    public Long getVipLevel() 
    {
        return vipLevel;
    }
    public void setVipDiscount(Long vipDiscount) 
    {
        this.vipDiscount = vipDiscount;
    }

    public Long getVipDiscount() 
    {
        return vipDiscount;
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
            .append("vipId", getVipId())
            .append("userId", getUserId())
            .append("vipLevel", getVipLevel())
            .append("vipDiscount", getVipDiscount())
            .append("creatime", getCreatime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .toString();
    }
}
