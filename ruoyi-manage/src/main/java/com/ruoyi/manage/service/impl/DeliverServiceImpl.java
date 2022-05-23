package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.DeliverMapper;
import com.ruoyi.manage.domain.Deliver;
import com.ruoyi.manage.service.IDeliverService;

/**
 * 物流公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
@Service
public class DeliverServiceImpl implements IDeliverService 
{
    @Autowired
    private DeliverMapper deliverMapper;

    /**
     * 查询物流公司
     * 
     * @param deliverId 物流公司主键
     * @return 物流公司
     */
    @Override
    public Deliver selectDeliverByDeliverId(Long deliverId)
    {
        return deliverMapper.selectDeliverByDeliverId(deliverId);
    }

    /**
     * 查询物流公司列表
     * 
     * @param deliver 物流公司
     * @return 物流公司
     */
    @Override
    public List<Deliver> selectDeliverList(Deliver deliver)
    {
        return deliverMapper.selectDeliverList(deliver);
    }

    /**
     * 新增物流公司
     * 
     * @param deliver 物流公司
     * @return 结果
     */
    @Override
    public int insertDeliver(Deliver deliver)
    {
        return deliverMapper.insertDeliver(deliver);
    }

    /**
     * 修改物流公司
     * 
     * @param deliver 物流公司
     * @return 结果
     */
    @Override
    public int updateDeliver(Deliver deliver)
    {
        return deliverMapper.updateDeliver(deliver);
    }

    /**
     * 批量删除物流公司
     * 
     * @param deliverIds 需要删除的物流公司主键
     * @return 结果
     */
    @Override
    public int deleteDeliverByDeliverIds(Long[] deliverIds)
    {
        return deliverMapper.deleteDeliverByDeliverIds(deliverIds);
    }

    /**
     * 删除物流公司信息
     * 
     * @param deliverId 物流公司主键
     * @return 结果
     */
    @Override
    public int deleteDeliverByDeliverId(Long deliverId)
    {
        return deliverMapper.deleteDeliverByDeliverId(deliverId);
    }
}
