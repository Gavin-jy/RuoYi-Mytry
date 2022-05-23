package com.ruoyi.consumer.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.consumer.mapper.AftersaleMapper;
import com.ruoyi.consumer.domain.Aftersale;
import com.ruoyi.consumer.service.IAftersaleService;

/**
 * 我的售后Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
@Service
public class AftersaleServiceImpl implements IAftersaleService 
{
    @Autowired
    private AftersaleMapper aftersaleMapper;

    /**
     * 查询我的售后
     * 
     * @param aftersaleId 我的售后主键
     * @return 我的售后
     */
    @Override
    public Aftersale selectAftersaleByAftersaleId(Long aftersaleId)
    {
        return aftersaleMapper.selectAftersaleByAftersaleId(aftersaleId);
    }

    /**
     * 查询我的售后列表
     * 
     * @param aftersale 我的售后
     * @return 我的售后
     */
    @Override
    public List<Aftersale> selectAftersaleList(Aftersale aftersale)
    {
        return aftersaleMapper.selectAftersaleList(aftersale);
    }

    /**
     * 新增我的售后
     * 
     * @param aftersale 我的售后
     * @return 结果
     */
    @Override
    public int insertAftersale(Aftersale aftersale)
    {
        return aftersaleMapper.insertAftersale(aftersale);
    }

    /**
     * 修改我的售后
     * 
     * @param aftersale 我的售后
     * @return 结果
     */
    @Override
    public int updateAftersale(Aftersale aftersale)
    {
        aftersale.setUpdateTime(DateUtils.getNowDate());
        return aftersaleMapper.updateAftersale(aftersale);
    }

    /**
     * 批量删除我的售后
     * 
     * @param aftersaleIds 需要删除的我的售后主键
     * @return 结果
     */
    @Override
    public int deleteAftersaleByAftersaleIds(Long[] aftersaleIds)
    {
        return aftersaleMapper.deleteAftersaleByAftersaleIds(aftersaleIds);
    }

    /**
     * 删除我的售后信息
     * 
     * @param aftersaleId 我的售后主键
     * @return 结果
     */
    @Override
    public int deleteAftersaleByAftersaleId(Long aftersaleId)
    {
        return aftersaleMapper.deleteAftersaleByAftersaleId(aftersaleId);
    }
}
