package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.Businessevaluation;

/**
 * 系统商家评价Service接口
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public interface IBusinessevaluationService 
{
    /**
     * 查询系统商家评价
     * 
     * @param businessEvaluationId2 系统商家评价主键
     * @return 系统商家评价
     */
    public Businessevaluation selectBusinessevaluationByBusinessEvaluationId2(Long businessEvaluationId2);

    /**
     * 查询系统商家评价列表
     * 
     * @param businessevaluation 系统商家评价
     * @return 系统商家评价集合
     */
    public List<Businessevaluation> selectBusinessevaluationList(Businessevaluation businessevaluation);

    /**
     * 新增系统商家评价
     * 
     * @param businessevaluation 系统商家评价
     * @return 结果
     */
    public int insertBusinessevaluation(Businessevaluation businessevaluation);

    /**
     * 修改系统商家评价
     * 
     * @param businessevaluation 系统商家评价
     * @return 结果
     */
    public int updateBusinessevaluation(Businessevaluation businessevaluation);

    /**
     * 批量删除系统商家评价
     * 
     * @param businessEvaluationId2s 需要删除的系统商家评价主键集合
     * @return 结果
     */
    public int deleteBusinessevaluationByBusinessEvaluationId2s(Long[] businessEvaluationId2s);

    /**
     * 删除系统商家评价信息
     * 
     * @param businessEvaluationId2 系统商家评价主键
     * @return 结果
     */
    public int deleteBusinessevaluationByBusinessEvaluationId2(Long businessEvaluationId2);
}
