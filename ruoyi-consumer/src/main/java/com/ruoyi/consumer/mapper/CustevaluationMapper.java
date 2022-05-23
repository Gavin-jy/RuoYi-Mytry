package com.ruoyi.consumer.mapper;

import java.util.List;
import com.ruoyi.consumer.domain.Custevaluation;

/**
 * 我的评价Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
public interface CustevaluationMapper 
{
    /**
     * 查询我的评价
     * 
     * @param custEvaluationId2 我的评价主键
     * @return 我的评价
     */
    public Custevaluation selectCustevaluationByCustEvaluationId2(Long custEvaluationId2);

    /**
     * 查询我的评价列表
     * 
     * @param custevaluation 我的评价
     * @return 我的评价集合
     */
    public List<Custevaluation> selectCustevaluationList(Custevaluation custevaluation);

    /**
     * 新增我的评价
     * 
     * @param custevaluation 我的评价
     * @return 结果
     */
    public int insertCustevaluation(Custevaluation custevaluation);

    /**
     * 修改我的评价
     * 
     * @param custevaluation 我的评价
     * @return 结果
     */
    public int updateCustevaluation(Custevaluation custevaluation);

    /**
     * 删除我的评价
     * 
     * @param custEvaluationId2 我的评价主键
     * @return 结果
     */
    public int deleteCustevaluationByCustEvaluationId2(Long custEvaluationId2);

    /**
     * 批量删除我的评价
     * 
     * @param custEvaluationId2s 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCustevaluationByCustEvaluationId2s(Long[] custEvaluationId2s);
}
