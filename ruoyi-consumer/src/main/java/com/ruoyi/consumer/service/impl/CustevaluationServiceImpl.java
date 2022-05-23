package com.ruoyi.consumer.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.consumer.mapper.CustevaluationMapper;
import com.ruoyi.consumer.domain.Custevaluation;
import com.ruoyi.consumer.service.ICustevaluationService;

/**
 * 我的评价Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
@Service
public class CustevaluationServiceImpl implements ICustevaluationService 
{
    @Autowired
    private CustevaluationMapper custevaluationMapper;

    /**
     * 查询我的评价
     * 
     * @param custEvaluationId2 我的评价主键
     * @return 我的评价
     */
    @Override
    public Custevaluation selectCustevaluationByCustEvaluationId2(Long custEvaluationId2)
    {
        return custevaluationMapper.selectCustevaluationByCustEvaluationId2(custEvaluationId2);
    }

    /**
     * 查询我的评价列表
     * 
     * @param custevaluation 我的评价
     * @return 我的评价
     */
    @Override
    public List<Custevaluation> selectCustevaluationList(Custevaluation custevaluation)
    {
        return custevaluationMapper.selectCustevaluationList(custevaluation);
    }

    /**
     * 新增我的评价
     * 
     * @param custevaluation 我的评价
     * @return 结果
     */
    @Override
    public int insertCustevaluation(Custevaluation custevaluation)
    {
        return custevaluationMapper.insertCustevaluation(custevaluation);
    }

    /**
     * 修改我的评价
     * 
     * @param custevaluation 我的评价
     * @return 结果
     */
    @Override
    public int updateCustevaluation(Custevaluation custevaluation)
    {
        return custevaluationMapper.updateCustevaluation(custevaluation);
    }

    /**
     * 批量删除我的评价
     * 
     * @param custEvaluationId2s 需要删除的我的评价主键
     * @return 结果
     */
    @Override
    public int deleteCustevaluationByCustEvaluationId2s(Long[] custEvaluationId2s)
    {
        return custevaluationMapper.deleteCustevaluationByCustEvaluationId2s(custEvaluationId2s);
    }

    /**
     * 删除我的评价信息
     * 
     * @param custEvaluationId2 我的评价主键
     * @return 结果
     */
    @Override
    public int deleteCustevaluationByCustEvaluationId2(Long custEvaluationId2)
    {
        return custevaluationMapper.deleteCustevaluationByCustEvaluationId2(custEvaluationId2);
    }
}
