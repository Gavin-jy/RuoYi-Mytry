package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.Deliverevaluation;

/**
 * 系统物流评价Service接口
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public interface IDeliverevaluationService 
{
    /**
     * 查询系统物流评价
     * 
     * @param logisticsEvaluationId2 系统物流评价主键
     * @return 系统物流评价
     */
    public Deliverevaluation selectDeliverevaluationByLogisticsEvaluationId2(Long logisticsEvaluationId2);

    /**
     * 查询系统物流评价列表
     * 
     * @param deliverevaluation 系统物流评价
     * @return 系统物流评价集合
     */
    public List<Deliverevaluation> selectDeliverevaluationList(Deliverevaluation deliverevaluation);

    /**
     * 新增系统物流评价
     * 
     * @param deliverevaluation 系统物流评价
     * @return 结果
     */
    public int insertDeliverevaluation(Deliverevaluation deliverevaluation);

    /**
     * 修改系统物流评价
     * 
     * @param deliverevaluation 系统物流评价
     * @return 结果
     */
    public int updateDeliverevaluation(Deliverevaluation deliverevaluation);

    /**
     * 批量删除系统物流评价
     * 
     * @param logisticsEvaluationId2s 需要删除的系统物流评价主键集合
     * @return 结果
     */
    public int deleteDeliverevaluationByLogisticsEvaluationId2s(Long[] logisticsEvaluationId2s);

    /**
     * 删除系统物流评价信息
     * 
     * @param logisticsEvaluationId2 系统物流评价主键
     * @return 结果
     */
    public int deleteDeliverevaluationByLogisticsEvaluationId2(Long logisticsEvaluationId2);
}
