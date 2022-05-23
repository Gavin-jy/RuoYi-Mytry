package com.ruoyi.consumer.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.consumer.mapper.MyorderMapper;
import com.ruoyi.consumer.domain.Myorder;
import com.ruoyi.consumer.service.IMyorderService;

/**
 * 我的订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
@Service
public class MyorderServiceImpl implements IMyorderService 
{
    @Autowired
    private MyorderMapper myorderMapper;

    /**
     * 查询我的订单
     * 
     * @param myorderId 我的订单主键
     * @return 我的订单
     */
    @Override
    public Myorder selectMyorderByMyorderId(Long myorderId)
    {
        return myorderMapper.selectMyorderByMyorderId(myorderId);
    }

    /**
     * 查询我的订单列表
     * 
     * @param myorder 我的订单
     * @return 我的订单
     */
    @Override
    public List<Myorder> selectMyorderList(Myorder myorder)
    {
        return myorderMapper.selectMyorderList(myorder);
    }

    /**
     * 新增我的订单
     * 
     * @param myorder 我的订单
     * @return 结果
     */
    @Override
    public int insertMyorder(Myorder myorder)
    {
        return myorderMapper.insertMyorder(myorder);
    }

    /**
     * 修改我的订单
     * 
     * @param myorder 我的订单
     * @return 结果
     */
    @Override
    public int updateMyorder(Myorder myorder)
    {
        myorder.setUpdateTime(DateUtils.getNowDate());
        return myorderMapper.updateMyorder(myorder);
    }

    /**
     * 批量删除我的订单
     * 
     * @param myorderIds 需要删除的我的订单主键
     * @return 结果
     */
    @Override
    public int deleteMyorderByMyorderIds(Long[] myorderIds)
    {
        return myorderMapper.deleteMyorderByMyorderIds(myorderIds);
    }

    /**
     * 删除我的订单信息
     * 
     * @param myorderId 我的订单主键
     * @return 结果
     */
    @Override
    public int deleteMyorderByMyorderId(Long myorderId)
    {
        return myorderMapper.deleteMyorderByMyorderId(myorderId);
    }
}
