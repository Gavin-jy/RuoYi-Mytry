package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.DeliveryorderMapper;
import com.ruoyi.manage.domain.Deliveryorder;
import com.ruoyi.manage.service.IDeliveryorderService;

/**
 * 物流订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
@Service
public class DeliveryorderServiceImpl implements IDeliveryorderService 
{
    @Autowired
    private DeliveryorderMapper deliveryorderMapper;

    /**
     * 查询物流订单
     * 
     * @param deliveryOrderId3 物流订单主键
     * @return 物流订单
     */
    @Override
    public Deliveryorder selectDeliveryorderByDeliveryOrderId3(Long deliveryOrderId3)
    {
        return deliveryorderMapper.selectDeliveryorderByDeliveryOrderId3(deliveryOrderId3);
    }

    /**
     * 查询物流订单列表
     * 
     * @param deliveryorder 物流订单
     * @return 物流订单
     */
    @Override
    public List<Deliveryorder> selectDeliveryorderList(Deliveryorder deliveryorder)
    {
        return deliveryorderMapper.selectDeliveryorderList(deliveryorder);
    }

    /**
     * 新增物流订单
     * 
     * @param deliveryorder 物流订单
     * @return 结果
     */
    @Override
    public int insertDeliveryorder(Deliveryorder deliveryorder)
    {
        return deliveryorderMapper.insertDeliveryorder(deliveryorder);
    }

    /**
     * 修改物流订单
     * 
     * @param deliveryorder 物流订单
     * @return 结果
     */
    @Override
    public int updateDeliveryorder(Deliveryorder deliveryorder)
    {
        return deliveryorderMapper.updateDeliveryorder(deliveryorder);
    }

    /**
     * 批量删除物流订单
     * 
     * @param deliveryOrderId3s 需要删除的物流订单主键
     * @return 结果
     */
    @Override
    public int deleteDeliveryorderByDeliveryOrderId3s(Long[] deliveryOrderId3s)
    {
        return deliveryorderMapper.deleteDeliveryorderByDeliveryOrderId3s(deliveryOrderId3s);
    }

    /**
     * 删除物流订单信息
     * 
     * @param deliveryOrderId3 物流订单主键
     * @return 结果
     */
    @Override
    public int deleteDeliveryorderByDeliveryOrderId3(Long deliveryOrderId3)
    {
        return deliveryorderMapper.deleteDeliveryorderByDeliveryOrderId3(deliveryOrderId3);
    }
}
