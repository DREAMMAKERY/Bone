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
import com.ruoyi.system.domain.Patientinfo;
import com.ruoyi.system.service.IPatientinfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 患者情况信息Controller
 *
 * @author ruoyi
 * @date 2019-10-10
 */
@Controller
@RequestMapping("/system/patientinfo")
public class PatientinfoController extends BaseController
{
    private String prefix = "system/patientinfo";

    @Autowired
    private IPatientinfoService patientinfoService;
    @Autowired
    private ServerConfig serverConfig;
    AjaxResult ajax = AjaxResult.success();
    ArrayList arrayList=new ArrayList();

    @RequiresPermissions("system:patientinfo:view")
    @GetMapping()
    public String patientinfo()
    {
        return prefix + "/patientinfo";
    }

    /**
     * 查询患者情况信息列表
     */
    @RequiresPermissions("system:patientinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Patientinfo patientinfo)
    {
        startPage();
        List<Patientinfo> list = patientinfoService.selectPatientinfoList(patientinfo);
        return getDataTable(list);
    }

    /**
     * 导出患者情况信息列表
     */
    @RequiresPermissions("system:patientinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Patientinfo patientinfo)
    {
        List<Patientinfo> list = patientinfoService.selectPatientinfoList(patientinfo);
        ExcelUtil<Patientinfo> util = new ExcelUtil<Patientinfo>(Patientinfo.class);
        return util.exportExcel(list, "patientinfo");
    }

    /**
     * 新增患者情况信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存患者情况信息
     */
    @RequiresPermissions("system:patientinfo:add")
    @Log(title = "患者情况信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HttpServletRequest request, Patientinfo patientinfo)

    {
//        String  patientID2=getRequest().getParameter("patientID2");
//        patientinfo.setPatientid2(patientID2);
        String patientID2=getRequest().getParameter("patientID2");
        patientinfo.setPatientid2(patientID2);
//        String patientSex=getRequest().getParameter("patientSex");
//        patientinfo.setPatientsex(patientSex);
        //X光片
        String patientx1url=ajax.get("patientx1url").toString();
        patientinfo.setPatientx1(patientx1url);
        String patientx2url=ajax.get("patientx2url").toString();
        patientinfo.setPatientx2(patientx2url);
        //牙齿
        String patientuptoothurl=ajax.get("patientuptoothurl").toString();
        patientinfo.setPatientuptooth(patientuptoothurl);
        String patientdowntoothurl=ajax.get("patientdowntoothurl").toString();
        patientinfo.setPatientdowntooth(patientdowntoothurl);
        String patientrighttoothurl=ajax.get("patientrighttoothurl").toString();
        patientinfo.setPatientrighttooth(patientrighttoothurl);
        String patientlefttoothurl=ajax.get("patientlefttoothurl").toString();
        patientinfo.setPatientlefttooth(patientlefttoothurl);
        String patientforwordtoothurl=ajax.get("patientforwordtoothurl").toString();
        patientinfo.setPatientforwordtooth(patientforwordtoothurl);

        //面部
        String patientpositiveurl=ajax.get("patientpositiveurl").toString();
        patientinfo.setPatientpositive(patientpositiveurl);
        String patientposivemileurl=ajax.get("patientposivemileurl").toString();
        patientinfo.setPatientposivemile(patientposivemileurl);
        String patientleftofsideurl=ajax.get("patientleftofsideurl").toString();
        patientinfo.setPatientleftofside(patientleftofsideurl);
        String patientrightofsideurl=ajax.get("patientrightofsideurl").toString();
        patientinfo.setPatientrightofside(patientrightofsideurl);
        //扫描数据
        Object patientscandataurl=ajax.get("patientscandataurl");
        if (patientscandataurl != null){
            patientinfo.setPatientscandata(patientscandataurl.toString());
        }

        //扫描数据
        Object patientbonedensityurl=ajax.get("patientbonedensityurl");
        if (patientbonedensityurl != null){
            patientinfo.setPatientbonedensity(patientbonedensityurl.toString());
        }

        System.out.print(patientx1url);
        System.out.print(patientx2url);

        return toAjax(patientinfoService.insertPatientinfo(patientinfo));
    }
    /**
     * 新增保存患者全颌曲面断层X光片
     */
    @RequiresPermissions("system:patientinfo:add")
    @Log(title = "患者情况信息", businessType = BusinessType.INSERT)
    @PostMapping("/uploadpatientx1")
    @ResponseBody
    public AjaxResult uploadpatientx1(MultipartFile patientx1) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, patientx1);
        String url = serverConfig.getUrl() + fileName;
        ajax.put("fileName", fileName);
        ajax.put("patientx1url", url);
//            arrayList.add(0,"patientx1url");
        return ajax;
        // return toAjax(patientinfoService.insertPatientinfo(patientinfo));
    }

    /**
     * 新增保存患者头颅侧位X光片
     */
    @RequiresPermissions("system:patientinfo:add")
    @Log(title = "患者情况信息", businessType = BusinessType.INSERT)
    @PostMapping("/uploadpatientx2")
    @ResponseBody
    public AjaxResult uploadpatientx2(MultipartFile patientx2) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, patientx2);
        String url = serverConfig.getUrl() + fileName;
//        AjaxResult ajax = AjaxResult.success();
        ajax.put("patientx2Name", fileName);
        ajax.put("patientx2url", url);
        return ajax;
        // return toAjax(patientinfoService.insertPatientinfo(patientinfo));
    }
    /**
     * 新增保存患者上牙列
     */
    @RequiresPermissions("system:patientinfo:add")
    @Log(title = "患者情况信息", businessType = BusinessType.INSERT)
    @PostMapping("/uploadpatientuptooth")
    @ResponseBody
    public AjaxResult uploadpatientuptooth(MultipartFile patientuptooth) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, patientuptooth);
        String url = serverConfig.getUrl() + fileName;
//        AjaxResult ajax = AjaxResult.success();
        ajax.put("fileName", fileName);
        ajax.put("patientuptoothurl", url);
        return ajax;
        // return toAjax(patientinfoService.insertPatientinfo(patientinfo));
    }
    /**
     * 新增保存患者下牙列
     */
    @RequiresPermissions("system:patientinfo:add")
    @Log(title = "患者情况信息", businessType = BusinessType.INSERT)
    @PostMapping("/uploadpatientdowntooth")
    @ResponseBody
    public AjaxResult uploadpatientdowntooth(MultipartFile patientdowntooth) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, patientdowntooth);
        String url = serverConfig.getUrl() + fileName;
//        AjaxResult ajax = AjaxResult.success();
        ajax.put("fileName", fileName);
        ajax.put("patientdowntoothurl", url);
        return ajax;
        // return toAjax(patientinfoService.insertPatientinfo(patientinfo));
    }
    /**
     * 新增保存患者右牙列
     */
    @RequiresPermissions("system:patientinfo:add")
    @Log(title = "患者情况信息", businessType = BusinessType.INSERT)
    @PostMapping("/uploadpatientrighttooth")
    @ResponseBody
    public AjaxResult uploadpatientrighttooth(MultipartFile patientrighttooth) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, patientrighttooth);
        String url = serverConfig.getUrl() + fileName;
//        AjaxResult ajax = AjaxResult.success();
        ajax.put("fileName", fileName);
        ajax.put("patientrighttoothurl", url);
        return ajax;
        // return toAjax(patientinfoService.insertPatientinfo(patientinfo));
    }
    /**
     * 新增保存患者左牙列
     */
    @RequiresPermissions("system:patientinfo:add")
    @Log(title = "患者情况信息", businessType = BusinessType.INSERT)
    @PostMapping("/uploadpatientlefttooth")
    @ResponseBody
    public AjaxResult uploadpatientlefttooth(MultipartFile patientlefttooth) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, patientlefttooth);
        String url = serverConfig.getUrl() + fileName;
//        AjaxResult ajax = AjaxResult.success();
        ajax.put("fileName", fileName);
        ajax.put("patientlefttoothurl", url);
        return ajax;
        // return toAjax(patientinfoService.insertPatientinfo(patientinfo));
    }
    /**
     * 新增保存患者前牙列
     */

    @RequiresPermissions("system:patientinfo:add")
    @Log(title = "患者情况信息", businessType = BusinessType.INSERT)
    @PostMapping("/uploadpatientforwordtooth")
    @ResponseBody
    public AjaxResult uploadpatientforwordtooth(MultipartFile patientforwordtooth) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, patientforwordtooth);
        String url = serverConfig.getUrl() + fileName;
//        AjaxResult ajax = AjaxResult.success();
        ajax.put("fileName", fileName);
        ajax.put("patientforwordtoothurl", url);
        return ajax;
        // return toAjax(patientinfoService.insertPatientinfo(patientinfo));
    }

    /**
     * 新增保存患者正面
     */

    @RequiresPermissions("system:patientinfo:add")
    @Log(title = "患者情况信息", businessType = BusinessType.INSERT)
    @PostMapping("/uploadpatientpositive")
    @ResponseBody
    public AjaxResult uploadpatientpositive(MultipartFile patientpositive) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, patientpositive);
        String url = serverConfig.getUrl() + fileName;
//        AjaxResult ajax = AjaxResult.success();
        ajax.put("fileName", fileName);
        ajax.put("patientpositiveurl", url);
        return ajax;
        // return toAjax(patientinfoService.insertPatientinfo(patientinfo));
    }
    /**
     * 新增保存患者正面微笑
     */


    @RequiresPermissions("system:patientinfo:add")
    @Log(title = "患者情况信息", businessType = BusinessType.INSERT)
    @PostMapping("/uploadpatientposivemile")
    @ResponseBody
    public AjaxResult uploadpatientposivemile(MultipartFile patientposivemile) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, patientposivemile);
        String url = serverConfig.getUrl() + fileName;
//        AjaxResult ajax = AjaxResult.success();
        ajax.put("fileName", fileName);
        ajax.put("patientposivemileurl", url);
        return ajax;
        // return toAjax(patientinfoService.insertPatientinfo(patientinfo));
    }
    /**
     * 新增保存患者左侧
     */


    @RequiresPermissions("system:patientinfo:add")
    @Log(title = "患者情况信息", businessType = BusinessType.INSERT)
    @PostMapping("/uploadpatientleftofside")
    @ResponseBody
    public AjaxResult uploadpatientleftofside(MultipartFile patientleftofside) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, patientleftofside);
        String url = serverConfig.getUrl() + fileName;
//        AjaxResult ajax = AjaxResult.success();
        ajax.put("fileName", fileName);
        ajax.put("patientleftofsideurl", url);
        return ajax;
        // return toAjax(patientinfoService.insertPatientinfo(patientinfo));
    }
    /**
     * 新增保存患者右侧
     */
    @RequiresPermissions("system:patientinfo:add")
    @Log(title = "患者情况信息", businessType = BusinessType.INSERT)
    @PostMapping("/uploadpatientrightofside")
    @ResponseBody
    public AjaxResult uploadpatientrightofside(MultipartFile patientrightofside) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, patientrightofside);
        String url = serverConfig.getUrl() + fileName;
//        AjaxResult ajax = AjaxResult.success();
        ajax.put("fileName", fileName);
        ajax.put("patientrightofsideurl", url);
        return ajax;
        // return toAjax(patientinfoService.insertPatientinfo(patientinfo));
    }
    /**
     * 新增保存患者上传数据
     */
    @RequiresPermissions("system:patientinfo:add")
    @Log(title = "患者情况信息", businessType = BusinessType.INSERT)
    @PostMapping("/uploadpatientscandataurl")
    @ResponseBody
    public AjaxResult uploadpatientscandata(MultipartFile patientscandata) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, patientscandata);
        String url = serverConfig.getUrl() + fileName;
//        AjaxResult ajax = AjaxResult.success();
        ajax.put("fileName", fileName);
        ajax.put("patientscandataurl", url);
        return ajax;
        // return toAjax(patientinfoService.insertPatientinfo(patientinfo));
    }
    /**
     * 新增保存骨密度数据
     */
    @RequiresPermissions("system:patientinfo:add")
    @Log(title = "患者情况信息", businessType = BusinessType.INSERT)
    @PostMapping("/uploadpatientbonedensityurl")
    @ResponseBody
    public AjaxResult uploadpatientbonedensity(MultipartFile patientbonedensity) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, patientbonedensity);
        String url = serverConfig.getUrl() + fileName;
//        AjaxResult ajax = AjaxResult.success();
        ajax.put("fileName", fileName);
        ajax.put("patientbonedensityurl", url);
        return ajax;
        // return toAjax(patientinfoService.insertPatientinfo(patientinfo));
    }
     /**
     * 修改患者情况信息
     */
    @GetMapping("/edit/{patientid}")
    public String edit(@PathVariable("patientid") Long patientid, ModelMap mmap)
    {
        Patientinfo patientinfo = patientinfoService.selectPatientinfoById(patientid);
        mmap.put("patientinfo", patientinfo);
        return prefix + "/edit";
    }
    /**
     * 修改保存患者情况信息
     */
    @RequiresPermissions("system:patientinfo:edit")
    @Log(title = "患者情况信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Patientinfo patientinfo)
    {
        return toAjax(patientinfoService.updatePatientinfo(patientinfo));
    }

    /**
     * 删除患者情况信息
     */
    @RequiresPermissions("system:patientinfo:remove")
    @Log(title = "患者情况信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(patientinfoService.deletePatientinfoByIds(ids));
    }
}
