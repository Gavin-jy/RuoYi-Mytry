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
import com.ruoyi.manage.domain.Goodsevaluation;
import com.ruoyi.manage.service.IGoodsevaluationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 系统商品评价Controller
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
@RestController
@RequestMapping("/manage/goodsevaluation")
public class GoodsevaluationController extends BaseController
{
    @Autowired
    private IGoodsevaluationService goodsevaluationService;

    /**
     * 查询系统商品评价列表
     */
    @PreAuthorize("@ss.hasPermi('manage:goodsevaluation:list')")
    @GetMapping("/list")
    public TableDataInfo list(Goodsevaluation goodsevaluation)
    {
        startPage();
        List<Goodsevaluation> list = goodsevaluationService.selectGoodsevaluationList(goodsevaluation);
        return getDataTable(list);
    }

    /**
     * 导出系统商品评价列表
     */
    @PreAuthorize("@ss.hasPermi('manage:goodsevaluation:export')")
    @Log(title = "系统商品评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Goodsevaluation goodsevaluation)
    {
        List<Goodsevaluation> list = goodsevaluationService.selectGoodsevaluationList(goodsevaluation);
        ExcelUtil<Goodsevaluation> util = new ExcelUtil<Goodsevaluation>(Goodsevaluation.class);
        util.exportExcel(response, list, "系统商品评价数据");
    }

    /**
     * 获取系统商品评价详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:goodsevaluation:query')")
    @GetMapping(value = "/{goodsEvaluationId2}")
    public AjaxResult getInfo(@PathVariable("goodsEvaluationId2") Long goodsEvaluationId2)
    {
        return AjaxResult.success(goodsevaluationService.selectGoodsevaluationByGoodsEvaluationId2(goodsEvaluationId2));
    }

    /**
     * 新增系统商品评价
     */
    @PreAuthorize("@ss.hasPermi('manage:goodsevaluation:add')")
    @Log(title = "系统商品评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Goodsevaluation goodsevaluation)
    {
        return toAjax(goodsevaluationService.insertGoodsevaluation(goodsevaluation));
    }

    /**
     * 修改系统商品评价
     */
    @PreAuthorize("@ss.hasPermi('manage:goodsevaluation:edit')")
    @Log(title = "系统商品评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Goodsevaluation goodsevaluation)
    {
        return toAjax(goodsevaluationService.updateGoodsevaluation(goodsevaluation));
    }

    /**
     * 删除系统商品评价
     */
    @PreAuthorize("@ss.hasPermi('manage:goodsevaluation:remove')")
    @Log(title = "系统商品评价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{goodsEvaluationId2s}")
    public AjaxResult remove(@PathVariable Long[] goodsEvaluationId2s)
    {
        return toAjax(goodsevaluationService.deleteGoodsevaluationByGoodsEvaluationId2s(goodsEvaluationId2s));
    }
}
