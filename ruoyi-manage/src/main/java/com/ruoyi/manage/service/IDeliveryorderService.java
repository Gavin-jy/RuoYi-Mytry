package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.Deliveryorder;

/**
 * 物流订单Service接口
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public interface IDeliveryorderService 
{
    /**
     * 查询物流订单
     * 
     * @param deliveryOrderId3 物流订单主键
     * @return 物流订单
     */
    public Deliveryorder selectDeliveryorderByDeliveryOrderId3(Long deliveryOrderId3);

    /**
     * 查询物流订单列表
     * 
     * @param deliveryorder 物流订单
     * @return 物流订单集合
     */
    public List<Deliveryorder> selectDeliveryorderList(Deliveryorder deliveryorder);

    /**
     * 新增物流订单
     * 
     * @param deliveryorder 物流订单
     * @return 结果
     */
    public int insertDeliveryorder(Deliveryorder deliveryorder);

    /**
     * 修改物流订单
     * 
     * @param deliveryorder 物流订单
     * @return 结果
     */
    public int updateDeliveryorder(Deliveryorder deliveryorder);

    /**
     * 批量删除物流订单
     * 
     * @param deliveryOrderId3s 需要删除的物流订单主键集合
     * @return 结果
     */
    public int deleteDeliveryorderByDeliveryOrderId3s(Long[] deliveryOrderId3s);

    /**
     * 删除物流订单信息
     * 
     * @param deliveryOrderId3 物流订单主键
     * @return 结果
     */
    public int deleteDeliveryorderByDeliveryOrderId3(Long deliveryOrderId3);
}
