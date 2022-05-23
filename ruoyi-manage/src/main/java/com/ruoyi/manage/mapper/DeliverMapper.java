package com.ruoyi.manage.mapper;

import java.util.List;
import com.ruoyi.manage.domain.Deliver;

/**
 * 物流公司Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public interface DeliverMapper 
{
    /**
     * 查询物流公司
     * 
     * @param deliverId 物流公司主键
     * @return 物流公司
     */
    public Deliver selectDeliverByDeliverId(Long deliverId);

    /**
     * 查询物流公司列表
     * 
     * @param deliver 物流公司
     * @return 物流公司集合
     */
    public List<Deliver> selectDeliverList(Deliver deliver);

    /**
     * 新增物流公司
     * 
     * @param deliver 物流公司
     * @return 结果
     */
    public int insertDeliver(Deliver deliver);

    /**
     * 修改物流公司
     * 
     * @param deliver 物流公司
     * @return 结果
     */
    public int updateDeliver(Deliver deliver);

    /**
     * 删除物流公司
     * 
     * @param deliverId 物流公司主键
     * @return 结果
     */
    public int deleteDeliverByDeliverId(Long deliverId);

    /**
     * 批量删除物流公司
     * 
     * @param deliverIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeliverByDeliverIds(Long[] deliverIds);
}
