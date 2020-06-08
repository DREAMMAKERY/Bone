package com.ruoyi.web.controller.system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.utils.file.FileUploadUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Patientreport;
import com.ruoyi.system.service.IPatientreportService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 患者报告单Controller
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Controller
@RequestMapping("/system/patientreport")
public class PatientreportController extends BaseController
{
    private String prefix = "system/patientreport";

    @Autowired
    private IPatientreportService patientreportService;
    @Autowired

    private ServerConfig serverConfig;
    AjaxResult ajax = AjaxResult.success();
    ArrayList arrayList=new ArrayList();



    @RequiresPermissions("system:patientreport:view")
    @GetMapping()
    public String patientreport()
    {
        return prefix + "/patientreport";
    }

    /**
     * 查询患者报告单列表
     */
    @RequiresPermissions("system:patientreport:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Patientreport patientreport)
    {
        startPage();
        List<Patientreport> list = patientreportService.selectPatientreportList(patientreport);
        return getDataTable(list);
    }

    /**
     * 导出患者报告单列表
     */
    @RequiresPermissions("system:patientreport:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Patientreport patientreport)
    {
        List<Patientreport> list = patientreportService.selectPatientreportList(patientreport);
        ExcelUtil<Patientreport> util = new ExcelUtil<Patientreport>(Patientreport.class);
        return util.exportExcel(list, "patientreport");
    }

    /**
     * 新增患者报告单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存患者报告单
     */
    @RequiresPermissions("system:patientreport:add")
    @Log(title = "患者报告单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Patientreport patientreport)
    {
        String patientphotourl=ajax.get("patientphotourl").toString();
        patientreport.setPatientphoto(patientphotourl);
        String patientvideourl=ajax.get("patientvideourl").toString();
        patientreport.setPatientvideo(patientvideourl);
        return toAjax(patientreportService.insertPatientreport(patientreport));
    }

    /**
     * 新增保存患者情况反馈
     */
    @RequiresPermissions("system:patientinfo:add")
    @Log(title = "患者情况信息", businessType = BusinessType.INSERT)
    @PostMapping("/uploadpatientphoto")
    @ResponseBody
    public AjaxResult uploadpatientphoto(MultipartFile patientphoto) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, patientphoto);
        String url = serverConfig.getUrl() + fileName;
        ajax.put("fileName", fileName);
        ajax.put("patientphotourl", url);

        return ajax;
        // return toAjax(patientinfoService.insertPatientinfo(patientinfo));
    }
    /**
     * 新增保存患者矫治步骤视频
     */
    @RequiresPermissions("system:patientinfo:add")
    @Log(title = "患者情况信息", businessType = BusinessType.INSERT)
    @PostMapping("/uploadpatientvideo")
    @ResponseBody
    public AjaxResult uploadpatientvideo(MultipartFile patientvideo) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
     //   String fileName = FileUploadUtils.upload(filePath, patientvideo);

        String  fileName=FileUploadUtils.videoUpload(filePath, patientvideo);
        String url = serverConfig.getUrl() + fileName;
        ajax.put("fileName", fileName);
        ajax.put("patientvideourl", url);

        return ajax;
        // return toAjax(patientinfoService.insertPatientinfo(patientinfo));
    }

    /**
     * 修改患者报告单
     */
    @GetMapping("/edit/{reportid}")
    public String edit(@PathVariable("reportid") Long reportid, ModelMap mmap)
    {
        Patientreport patientreport = patientreportService.selectPatientreportById(reportid);
        mmap.put("patientreport", patientreport);
        return prefix + "/edit";
    }

    /**
     * 修改保存患者报告单
     */
    @RequiresPermissions("system:patientreport:edit")
    @Log(title = "患者报告单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Patientreport patientreport)
    {
        return toAjax(patientreportService.updatePatientreport(patientreport));
    }

    /**
     * 删除患者报告单
     */
    @RequiresPermissions("system:patientreport:remove")
    @Log(title = "患者报告单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(patientreportService.deletePatientreportByIds(ids));
    }
}
