package com.ruoyi.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.manage.domain.Producttype;
import com.ruoyi.manage.service.IProducttypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品类型Controller
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
@RestController
@RequestMapping("/manage/producttype")
public class ProducttypeController extends BaseController
{
    @Autowired
    private IProducttypeService producttypeService;

    /**
     * 查询商品类型列表
     */
    @PreAuthorize("@ss.hasPermi('manage:producttype:list')")
    @GetMapping("/list")
    public TableDataInfo list(Producttype producttype)
    {
        startPage();
        List<Producttype> list = producttypeService.selectProducttypeList(producttype);
        return getDataTable(list);
    }

    /**
     * 导出商品类型列表
     */
    @PreAuthorize("@ss.hasPermi('manage:producttype:export')")
    @Log(title = "商品类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Producttype producttype)
    {
        List<Producttype> list = producttypeService.selectProducttypeList(producttype);
        ExcelUtil<Producttype> util = new ExcelUtil<Producttype>(Producttype.class);
        util.exportExcel(response, list, "商品类型数据");
    }

    /**
     * 获取商品类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:producttype:query')")
    @GetMapping(value = "/{productTypeId}")
    public AjaxResult getInfo(@PathVariable("productTypeId") Long productTypeId)
    {
        return AjaxResult.success(producttypeService.selectProducttypeByProductTypeId(productTypeId));
    }

    /**
     * 新增商品类型
     */
    @PreAuthorize("@ss.hasPermi('manage:producttype:add')")
    @Log(title = "商品类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Producttype producttype)
    {
        return toAjax(producttypeService.insertProducttype(producttype));
    }

    /**
     * 修改商品类型
     */
    @PreAuthorize("@ss.hasPermi('manage:producttype:edit')")
    @Log(title = "商品类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Producttype producttype)
    {
        return toAjax(producttypeService.updateProducttype(producttype));
    }

    /**
     * 删除商品类型
     */
    @PreAuthorize("@ss.hasPermi('manage:producttype:remove')")
    @Log(title = "商品类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{productTypeIds}")
    public AjaxResult remove(@PathVariable Long[] productTypeIds)
    {
        return toAjax(producttypeService.deleteProducttypeByProductTypeIds(productTypeIds));
    }
}
