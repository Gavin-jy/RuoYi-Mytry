package com.ruoyi.manage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户 对象 user
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户id */
    private String userId;


    /** 客户电话 */
    @Excel(name = "客户电话")
    private String userPhone;

    /** 客户登录密码 */
    @Excel(name = "客户登录密码")
    private String userPassword;

    /** 客户贡献度，float类型，客户每购买一件商品，贡献度就加商品价格的10% */
    @Excel(name = "客户贡献度，float类型，客户每购买一件商品，贡献度就加商品价格的10%")
    private Long userContribution;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatime;

    /** 删除标记 */
    private Integer delFlag;

    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }

    public void setUserPhone(String userPhone) 
    {
        this.userPhone = userPhone;
    }

    public String getUserPhone() 
    {
        return userPhone;
    }
    public void setUserPassword(String userPassword) 
    {
        this.userPassword = userPassword;
    }

    public String getUserPassword() 
    {
        return userPassword;
    }
    public void setUserContribution(Long userContribution) 
    {
        this.userContribution = userContribution;
    }

    public Long getUserContribution() 
    {
        return userContribution;
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
            .append("userId", getUserId())
            .append("userPhone", getUserPhone())
            .append("userPassword", getUserPassword())
            .append("userContribution", getUserContribution())
            .append("creatime", getCreatime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .toString();
    }
}
