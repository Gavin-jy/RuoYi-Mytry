package com.ruoyi.manage.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.VipInformationMapper;
import com.ruoyi.manage.domain.VipInformation;
import com.ruoyi.manage.service.IVipInformationService;

/**
 * 会员信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
@Service
public class VipInformationServiceImpl implements IVipInformationService 
{
    @Autowired
    private VipInformationMapper vipInformationMapper;

    /**
     * 查询会员信息
     * 
     * @param vipId 会员信息主键
     * @return 会员信息
     */
    @Override
    public VipInformation selectVipInformationByVipId(String vipId)
    {
        return vipInformationMapper.selectVipInformationByVipId(vipId);
    }

    /**
     * 查询会员信息列表
     * 
     * @param vipInformation 会员信息
     * @return 会员信息
     */
    @Override
    public List<VipInformation> selectVipInformationList(VipInformation vipInformation)
    {
        return vipInformationMapper.selectVipInformationList(vipInformation);
    }

    /**
     * 新增会员信息
     * 
     * @param vipInformation 会员信息
     * @return 结果
     */
    @Override
    public int insertVipInformation(VipInformation vipInformation)
    {
        return vipInformationMapper.insertVipInformation(vipInformation);
    }

    /**
     * 修改会员信息
     * 
     * @param vipInformation 会员信息
     * @return 结果
     */
    @Override
    public int updateVipInformation(VipInformation vipInformation)
    {
        vipInformation.setUpdateTime(DateUtils.getNowDate());
        return vipInformationMapper.updateVipInformation(vipInformation);
    }

    /**
     * 批量删除会员信息
     * 
     * @param vipIds 需要删除的会员信息主键
     * @return 结果
     */
    @Override
    public int deleteVipInformationByVipIds(String[] vipIds)
    {
        return vipInformationMapper.deleteVipInformationByVipIds(vipIds);
    }

    /**
     * 删除会员信息信息
     * 
     * @param vipId 会员信息主键
     * @return 结果
     */
    @Override
    public int deleteVipInformationByVipId(String vipId)
    {
        return vipInformationMapper.deleteVipInformationByVipId(vipId);
    }
}
