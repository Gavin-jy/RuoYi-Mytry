package com.ruoyi.manage.mapper;

import java.util.List;
import com.ruoyi.manage.domain.Supplier;

/**
 * 商家管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public interface SupplierMapper 
{
    /**
     * 查询商家管理
     * 
     * @param supplierId 商家管理主键
     * @return 商家管理
     */
    public Supplier selectSupplierBySupplierId(Long supplierId);

    /**
     * 查询商家管理列表
     * 
     * @param supplier 商家管理
     * @return 商家管理集合
     */
    public List<Supplier> selectSupplierList(Supplier supplier);

    /**
     * 新增商家管理
     * 
     * @param supplier 商家管理
     * @return 结果
     */
    public int insertSupplier(Supplier supplier);

    /**
     * 修改商家管理
     * 
     * @param supplier 商家管理
     * @return 结果
     */
    public int updateSupplier(Supplier supplier);

    /**
     * 删除商家管理
     * 
     * @param supplierId 商家管理主键
     * @return 结果
     */
    public int deleteSupplierBySupplierId(Long supplierId);

    /**
     * 批量删除商家管理
     * 
     * @param supplierIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSupplierBySupplierIds(Long[] supplierIds);
}
