package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.DeliverevaluationMapper;
import com.ruoyi.manage.domain.Deliverevaluation;
import com.ruoyi.manage.service.IDeliverevaluationService;

/**
 * 系统物流评价Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
@Service
public class DeliverevaluationServiceImpl implements IDeliverevaluationService 
{
    @Autowired
    private DeliverevaluationMapper deliverevaluationMapper;

    /**
     * 查询系统物流评价
     * 
     * @param logisticsEvaluationId2 系统物流评价主键
     * @return 系统物流评价
     */
    @Override
    public Deliverevaluation selectDeliverevaluationByLogisticsEvaluationId2(Long logisticsEvaluationId2)
    {
        return deliverevaluationMapper.selectDeliverevaluationByLogisticsEvaluationId2(logisticsEvaluationId2);
    }

    /**
     * 查询系统物流评价列表
     * 
     * @param deliverevaluation 系统物流评价
     * @return 系统物流评价
     */
    @Override
    public List<Deliverevaluation> selectDeliverevaluationList(Deliverevaluation deliverevaluation)
    {
        return deliverevaluationMapper.selectDeliverevaluationList(deliverevaluation);
    }

    /**
     * 新增系统物流评价
     * 
     * @param deliverevaluation 系统物流评价
     * @return 结果
     */
    @Override
    public int insertDeliverevaluation(Deliverevaluation deliverevaluation)
    {
        return deliverevaluationMapper.insertDeliverevaluation(deliverevaluation);
    }

    /**
     * 修改系统物流评价
     * 
     * @param deliverevaluation 系统物流评价
     * @return 结果
     */
    @Override
    public int updateDeliverevaluation(Deliverevaluation deliverevaluation)
    {
        return deliverevaluationMapper.updateDeliverevaluation(deliverevaluation);
    }

    /**
     * 批量删除系统物流评价
     * 
     * @param logisticsEvaluationId2s 需要删除的系统物流评价主键
     * @return 结果
     */
    @Override
    public int deleteDeliverevaluationByLogisticsEvaluationId2s(Long[] logisticsEvaluationId2s)
    {
        return deliverevaluationMapper.deleteDeliverevaluationByLogisticsEvaluationId2s(logisticsEvaluationId2s);
    }

    /**
     * 删除系统物流评价信息
     * 
     * @param logisticsEvaluationId2 系统物流评价主键
     * @return 结果
     */
    @Override
    public int deleteDeliverevaluationByLogisticsEvaluationId2(Long logisticsEvaluationId2)
    {
        return deliverevaluationMapper.deleteDeliverevaluationByLogisticsEvaluationId2(logisticsEvaluationId2);
    }
}
