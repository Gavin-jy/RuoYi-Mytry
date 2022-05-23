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
import com.ruoyi.manage.domain.VipInformation;
import com.ruoyi.manage.service.IVipInformationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员信息Controller
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
@RestController
@RequestMapping("/manage/information")
public class VipInformationController extends BaseController
{
    @Autowired
    private IVipInformationService vipInformationService;

    /**
     * 查询会员信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:information:list')")
    @GetMapping("/list")
    public TableDataInfo list(VipInformation vipInformation)
    {
        startPage();
        List<VipInformation> list = vipInformationService.selectVipInformationList(vipInformation);
        return getDataTable(list);
    }

    /**
     * 导出会员信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:information:export')")
    @Log(title = "会员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VipInformation vipInformation)
    {
        List<VipInformation> list = vipInformationService.selectVipInformationList(vipInformation);
        ExcelUtil<VipInformation> util = new ExcelUtil<VipInformation>(VipInformation.class);
        util.exportExcel(response, list, "会员信息数据");
    }

    /**
     * 获取会员信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:information:query')")
    @GetMapping(value = "/{vipId}")
    public AjaxResult getInfo(@PathVariable("vipId") String vipId)
    {
        return AjaxResult.success(vipInformationService.selectVipInformationByVipId(vipId));
    }

    /**
     * 新增会员信息
     */
    @PreAuthorize("@ss.hasPermi('manage:information:add')")
    @Log(title = "会员信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VipInformation vipInformation)
    {
        return toAjax(vipInformationService.insertVipInformation(vipInformation));
    }

    /**
     * 修改会员信息
     */
    @PreAuthorize("@ss.hasPermi('manage:information:edit')")
    @Log(title = "会员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VipInformation vipInformation)
    {
        return toAjax(vipInformationService.updateVipInformation(vipInformation));
    }

    /**
     * 删除会员信息
     */
    @PreAuthorize("@ss.hasPermi('manage:information:remove')")
    @Log(title = "会员信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{vipIds}")
    public AjaxResult remove(@PathVariable String[] vipIds)
    {
        return toAjax(vipInformationService.deleteVipInformationByVipIds(vipIds));
    }
}
