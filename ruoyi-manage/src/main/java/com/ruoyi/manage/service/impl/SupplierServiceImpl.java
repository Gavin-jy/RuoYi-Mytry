package com.ruoyi.manage.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.SupplierMapper;
import com.ruoyi.manage.domain.Supplier;
import com.ruoyi.manage.service.ISupplierService;

/**
 * 商家管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
@Service
public class SupplierServiceImpl implements ISupplierService 
{
    @Autowired
    private SupplierMapper supplierMapper;

    /**
     * 查询商家管理
     * 
     * @param supplierId 商家管理主键
     * @return 商家管理
     */
    @Override
    public Supplier selectSupplierBySupplierId(Long supplierId)
    {
        return supplierMapper.selectSupplierBySupplierId(supplierId);
    }

    /**
     * 查询商家管理列表
     * 
     * @param supplier 商家管理
     * @return 商家管理
     */
    @Override
    public List<Supplier> selectSupplierList(Supplier supplier)
    {
        return supplierMapper.selectSupplierList(supplier);
    }

    /**
     * 新增商家管理
     * 
     * @param supplier 商家管理
     * @return 结果
     */
    @Override
    public int insertSupplier(Supplier supplier)
    {
        return supplierMapper.insertSupplier(supplier);
    }

    /**
     * 修改商家管理
     * 
     * @param supplier 商家管理
     * @return 结果
     */
    @Override
    public int updateSupplier(Supplier supplier)
    {
        supplier.setUpdateTime(DateUtils.getNowDate());
        return supplierMapper.updateSupplier(supplier);
    }

    /**
     * 批量删除商家管理
     * 
     * @param supplierIds 需要删除的商家管理主键
     * @return 结果
     */
    @Override
    public int deleteSupplierBySupplierIds(Long[] supplierIds)
    {
        return supplierMapper.deleteSupplierBySupplierIds(supplierIds);
    }

    /**
     * 删除商家管理信息
     * 
     * @param supplierId 商家管理主键
     * @return 结果
     */
    @Override
    public int deleteSupplierBySupplierId(Long supplierId)
    {
        return supplierMapper.deleteSupplierBySupplierId(supplierId);
    }
}
