package com.ruoyi.consumer.mapper;

import java.util.List;
import com.ruoyi.consumer.domain.Myorder;

/**
 * 我的订单Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
public interface MyorderMapper 
{
    /**
     * 查询我的订单
     * 
     * @param myorderId 我的订单主键
     * @return 我的订单
     */
    public Myorder selectMyorderByMyorderId(Long myorderId);

    /**
     * 查询我的订单列表
     * 
     * @param myorder 我的订单
     * @return 我的订单集合
     */
    public List<Myorder> selectMyorderList(Myorder myorder);

    /**
     * 新增我的订单
     * 
     * @param myorder 我的订单
     * @return 结果
     */
    public int insertMyorder(Myorder myorder);

    /**
     * 修改我的订单
     * 
     * @param myorder 我的订单
     * @return 结果
     */
    public int updateMyorder(Myorder myorder);

    /**
     * 删除我的订单
     * 
     * @param myorderId 我的订单主键
     * @return 结果
     */
    public int deleteMyorderByMyorderId(Long myorderId);

    /**
     * 批量删除我的订单
     * 
     * @param myorderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMyorderByMyorderIds(Long[] myorderIds);
}
