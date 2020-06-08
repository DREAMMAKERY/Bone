package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 患者情况信息对象 patientinfo
 * 
 * @author ruoyi
 * @date 2019-10-10
 */
public class Patientinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long patientid;

    /** 患者编号 */
    @Excel(name = "患者编号")
    private String patientid2;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String patientname;

    /** 性别 */
    @Excel(name = "性别")
    private String patientsex;

    /** 年龄 */
    @Excel(name = "年龄")
    private String patientage;

    /** 全颌曲面断层X光片 */
    @Excel(name = "全颌曲面断层X光片")
    private String patientx1;

    /** 头颅侧位X光片 */
    @Excel(name = "头颅侧位X光片")
    private String patientx2;

    /** 上牙列 */
    @Excel(name = "上牙列")
    private String patientuptooth;

    /** 下牙列 */
    @Excel(name = "下牙列")
    private String patientdowntooth;

    /** 右侧磨牙关系 */
    @Excel(name = "右侧磨牙关系")
    private String patientrighttooth;

    /** 左侧磨牙关系 */
    @Excel(name = "左侧磨牙关系")
    private String patientlefttooth;

    /** 前牙咬合 */
    @Excel(name = "前牙咬合")
    private String patientforwordtooth;

    /** 正面 */
    @Excel(name = "正面")
    private String patientpositive;

    /** 正面微笑 */
    @Excel(name = "正面微笑")
    private String patientposivemile;

    /** 左侧面 */
    @Excel(name = "左侧面")
    private String patientleftofside;

    /** 右侧面 */
    @Excel(name = "右侧面")
    private String patientrightofside;

    /** 口腔扫描数据 */
    @Excel(name = "口腔扫描数据")
    private String patientscandata;

    /** 骨密度数据 */
    @Excel(name = "骨密度数据")
    private String patientbonedensity;

    /** 是否有快递数据 */
    @Excel(name = "是否有快递数据")
    private String patientsenddata;

    /** 快递单号 */
    @Excel(name = "快递单号")
    private String patientorderid;

    /** 医嘱 */
    @Excel(name = "医嘱")
    private String doctoradvice;

    /** 提交时间 */
    @Excel(name = "提交时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date docotorsendtime;

    /** 医生 */
    @Excel(name = "医生")
    private String doctor;

    /** 诊所 */
    @Excel(name = "诊所")
    private String clinic;

    /** 地区 */
    @Excel(name = "地区")
    private String region;

    /** 上传者 */
    @Excel(name = "上传者")
    private String fileuploader;

    /** 备注 */
    @Excel(name = "备注")
    private String others;

    public void setPatientid(Long patientid) 
    {
        this.patientid = patientid;
    }

    public Long getPatientid() 
    {
        return patientid;
    }
    public void setPatientid2(String patientid2) 
    {
        this.patientid2 = patientid2;
    }

    public String getPatientid2() 
    {
        return patientid2;
    }
    public void setPatientname(String patientname) 
    {
        this.patientname = patientname;
    }

    public String getPatientname() 
    {
        return patientname;
    }
    public void setPatientsex(String patientsex) 
    {
        this.patientsex = patientsex;
    }

    public String getPatientsex() 
    {
        return patientsex;
    }
    public void setPatientage(String patientage) 
    {
        this.patientage = patientage;
    }

    public String getPatientage() 
    {
        return patientage;
    }
    public void setPatientx1(String patientx1) 
    {
        this.patientx1 = patientx1;
    }

    public String getPatientx1() 
    {
        return patientx1;
    }
    public void setPatientx2(String patientx2) 
    {
        this.patientx2 = patientx2;
    }

    public String getPatientx2() 
    {
        return patientx2;
    }
    public void setPatientuptooth(String patientuptooth) 
    {
        this.patientuptooth = patientuptooth;
    }

    public String getPatientuptooth() 
    {
        return patientuptooth;
    }
    public void setPatientdowntooth(String patientdowntooth) 
    {
        this.patientdowntooth = patientdowntooth;
    }

    public String getPatientdowntooth() 
    {
        return patientdowntooth;
    }
    public void setPatientrighttooth(String patientrighttooth) 
    {
        this.patientrighttooth = patientrighttooth;
    }

    public String getPatientrighttooth() 
    {
        return patientrighttooth;
    }
    public void setPatientlefttooth(String patientlefttooth) 
    {
        this.patientlefttooth = patientlefttooth;
    }

    public String getPatientlefttooth() 
    {
        return patientlefttooth;
    }
    public void setPatientforwordtooth(String patientforwordtooth) 
    {
        this.patientforwordtooth = patientforwordtooth;
    }

    public String getPatientforwordtooth() 
    {
        return patientforwordtooth;
    }
    public void setPatientpositive(String patientpositive) 
    {
        this.patientpositive = patientpositive;
    }

    public String getPatientpositive() 
    {
        return patientpositive;
    }
    public void setPatientposivemile(String patientposivemile) 
    {
        this.patientposivemile = patientposivemile;
    }

    public String getPatientposivemile() 
    {
        return patientposivemile;
    }
    public void setPatientleftofside(String patientleftofside) 
    {
        this.patientleftofside = patientleftofside;
    }

    public String getPatientleftofside() 
    {
        return patientleftofside;
    }
    public void setPatientrightofside(String patientrightofside) 
    {
        this.patientrightofside = patientrightofside;
    }

    public String getPatientrightofside() 
    {
        return patientrightofside;
    }
    public void setPatientscandata(String patientscandata) 
    {
        this.patientscandata = patientscandata;
    }

    public String getPatientscandata() 
    {
        return patientscandata;
    }
    public void setPatientsenddata(String patientsenddata) 
    {
        this.patientsenddata = patientsenddata;
    }

    public String getPatientbonedensity()
    {
        return patientbonedensity;
    }
    public void setPatientbonedensity(String patientbonedensity)
    {
        this.patientbonedensity = patientbonedensity;
    }

    public String getPatientsenddata() 
    {
        return patientsenddata;
    }
    public void setPatientorderid(String patientorderid) 
    {
        this.patientorderid = patientorderid;
    }

    public String getPatientorderid() 
    {
        return patientorderid;
    }
    public void setDoctoradvice(String doctoradvice) 
    {
        this.doctoradvice = doctoradvice;
    }

    public String getDoctoradvice() 
    {
        return doctoradvice;
    }
    public void setDocotorsendtime(Date docotorsendtime) 
    {
        this.docotorsendtime = docotorsendtime;
    }

    public Date getDocotorsendtime() 
    {
        return docotorsendtime;
    }
    public void setDoctor(String doctor) 
    {
        this.doctor = doctor;
    }

    public String getDoctor() 
    {
        return doctor;
    }
    public void setClinic(String clinic) 
    {
        this.clinic = clinic;
    }

    public String getClinic() 
    {
        return clinic;
    }
    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }
    public void setFileuploader(String fileuploader) 
    {
        this.fileuploader = fileuploader;
    }

    public String getFileuploader() 
    {
        return fileuploader;
    }
    public void setOthers(String others) 
    {
        this.others = others;
    }

    public String getOthers() 
    {
        return others;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("patientid", getPatientid())
            .append("patientid2", getPatientid2())
            .append("patientname", getPatientname())
            .append("patientsex", getPatientsex())
            .append("patientage", getPatientage())
            .append("patientx1", getPatientx1())
            .append("patientx2", getPatientx2())
            .append("patientuptooth", getPatientuptooth())
            .append("patientdowntooth", getPatientdowntooth())
            .append("patientrighttooth", getPatientrighttooth())
            .append("patientlefttooth", getPatientlefttooth())
            .append("patientforwordtooth", getPatientforwordtooth())
            .append("patientpositive", getPatientpositive())
            .append("patientposivemile", getPatientposivemile())
            .append("patientleftofside", getPatientleftofside())
            .append("patientrightofside", getPatientrightofside())
            .append("patientscandata", getPatientscandata())
             .append("patientbonedensity", getPatientbonedensity())
            .append("patientsenddata", getPatientsenddata())
            .append("patientorderid", getPatientorderid())
            .append("doctoradvice", getDoctoradvice())
            .append("docotorsendtime", getDocotorsendtime())
            .append("doctor", getDoctor())
            .append("clinic", getClinic())
            .append("region", getRegion())
            .append("fileuploader", getFileuploader())
            .append("others", getOthers())
            .toString();
    }
}
