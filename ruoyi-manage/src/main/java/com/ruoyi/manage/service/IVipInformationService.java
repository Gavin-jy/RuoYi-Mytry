package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.VipInformation;

/**
 * 会员信息Service接口
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public interface IVipInformationService 
{
    /**
     * 查询会员信息
     * 
     * @param vipId 会员信息主键
     * @return 会员信息
     */
    public VipInformation selectVipInformationByVipId(String vipId);

    /**
     * 查询会员信息列表
     * 
     * @param vipInformation 会员信息
     * @return 会员信息集合
     */
    public List<VipInformation> selectVipInformationList(VipInformation vipInformation);

    /**
     * 新增会员信息
     * 
     * @param vipInformation 会员信息
     * @return 结果
     */
    public int insertVipInformation(VipInformation vipInformation);

    /**
     * 修改会员信息
     * 
     * @param vipInformation 会员信息
     * @return 结果
     */
    public int updateVipInformation(VipInformation vipInformation);

    /**
     * 批量删除会员信息
     * 
     * @param vipIds 需要删除的会员信息主键集合
     * @return 结果
     */
    public int deleteVipInformationByVipIds(String[] vipIds);

    /**
     * 删除会员信息信息
     * 
     * @param vipId 会员信息主键
     * @return 结果
     */
    public int deleteVipInformationByVipId(String vipId);
}
