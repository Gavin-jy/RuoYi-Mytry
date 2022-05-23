package com.ruoyi.manage.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.ProducttypeMapper;
import com.ruoyi.manage.domain.Producttype;
import com.ruoyi.manage.service.IProducttypeService;

/**
 * 商品类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
@Service
public class ProducttypeServiceImpl implements IProducttypeService 
{
    @Autowired
    private ProducttypeMapper producttypeMapper;

    /**
     * 查询商品类型
     * 
     * @param productTypeId 商品类型主键
     * @return 商品类型
     */
    @Override
    public Producttype selectProducttypeByProductTypeId(Long productTypeId)
    {
        return producttypeMapper.selectProducttypeByProductTypeId(productTypeId);
    }

    /**
     * 查询商品类型列表
     * 
     * @param producttype 商品类型
     * @return 商品类型
     */
    @Override
    public List<Producttype> selectProducttypeList(Producttype producttype)
    {
        return producttypeMapper.selectProducttypeList(producttype);
    }

    /**
     * 新增商品类型
     * 
     * @param producttype 商品类型
     * @return 结果
     */
    @Override
    public int insertProducttype(Producttype producttype)
    {
        return producttypeMapper.insertProducttype(producttype);
    }

    /**
     * 修改商品类型
     * 
     * @param producttype 商品类型
     * @return 结果
     */
    @Override
    public int updateProducttype(Producttype producttype)
    {
        producttype.setUpdateTime(DateUtils.getNowDate());
        return producttypeMapper.updateProducttype(producttype);
    }

    /**
     * 批量删除商品类型
     * 
     * @param productTypeIds 需要删除的商品类型主键
     * @return 结果
     */
    @Override
    public int deleteProducttypeByProductTypeIds(Long[] productTypeIds)
    {
        return producttypeMapper.deleteProducttypeByProductTypeIds(productTypeIds);
    }

    /**
     * 删除商品类型信息
     * 
     * @param productTypeId 商品类型主键
     * @return 结果
     */
    @Override
    public int deleteProducttypeByProductTypeId(Long productTypeId)
    {
        return producttypeMapper.deleteProducttypeByProductTypeId(productTypeId);
    }
}
