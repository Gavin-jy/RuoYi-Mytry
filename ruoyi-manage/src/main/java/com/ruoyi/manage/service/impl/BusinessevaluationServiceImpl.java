package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.BusinessevaluationMapper;
import com.ruoyi.manage.domain.Businessevaluation;
import com.ruoyi.manage.service.IBusinessevaluationService;

/**
 * 系统商家评价Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
@Service
public class BusinessevaluationServiceImpl implements IBusinessevaluationService 
{
    @Autowired
    private BusinessevaluationMapper businessevaluationMapper;

    /**
     * 查询系统商家评价
     * 
     * @param businessEvaluationId2 系统商家评价主键
     * @return 系统商家评价
     */
    @Override
    public Businessevaluation selectBusinessevaluationByBusinessEvaluationId2(Long businessEvaluationId2)
    {
        return businessevaluationMapper.selectBusinessevaluationByBusinessEvaluationId2(businessEvaluationId2);
    }

    /**
     * 查询系统商家评价列表
     * 
     * @param businessevaluation 系统商家评价
     * @return 系统商家评价
     */
    @Override
    public List<Businessevaluation> selectBusinessevaluationList(Businessevaluation businessevaluation)
    {
        return businessevaluationMapper.selectBusinessevaluationList(businessevaluation);
    }

    /**
     * 新增系统商家评价
     * 
     * @param businessevaluation 系统商家评价
     * @return 结果
     */
    @Override
    public int insertBusinessevaluation(Businessevaluation businessevaluation)
    {
        return businessevaluationMapper.insertBusinessevaluation(businessevaluation);
    }

    /**
     * 修改系统商家评价
     * 
     * @param businessevaluation 系统商家评价
     * @return 结果
     */
    @Override
    public int updateBusinessevaluation(Businessevaluation businessevaluation)
    {
        return businessevaluationMapper.updateBusinessevaluation(businessevaluation);
    }

    /**
     * 批量删除系统商家评价
     * 
     * @param businessEvaluationId2s 需要删除的系统商家评价主键
     * @return 结果
     */
    @Override
    public int deleteBusinessevaluationByBusinessEvaluationId2s(Long[] businessEvaluationId2s)
    {
        return businessevaluationMapper.deleteBusinessevaluationByBusinessEvaluationId2s(businessEvaluationId2s);
    }

    /**
     * 删除系统商家评价信息
     * 
     * @param businessEvaluationId2 系统商家评价主键
     * @return 结果
     */
    @Override
    public int deleteBusinessevaluationByBusinessEvaluationId2(Long businessEvaluationId2)
    {
        return businessevaluationMapper.deleteBusinessevaluationByBusinessEvaluationId2(businessEvaluationId2);
    }
}
