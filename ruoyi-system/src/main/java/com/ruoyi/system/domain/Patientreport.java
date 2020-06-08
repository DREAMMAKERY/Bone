package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 患者报告单对象 patientreport
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
public class Patientreport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 回执单编号 */
    private Long reportid;

    /** 患者编号 */
    @Excel(name = "患者编号")
    private String patientid;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String patientname;

    /** 医生 */
    @Excel(name = "医生")
    private String doctor;

    /** 患者情况反馈 */
    @Excel(name = "患者情况反馈")
    private String patientinfomation;

    /** 患者方案 */
    @Excel(name = "患者方案")
    private String patientprogramme;

    /** 患者照片 */
    @Excel(name = "患者照片")
    private String patientphoto;

    /** 患者状态 */
    @Excel(name = "患者状态")
    private String patientstatus;

    /** 诊所 */
    @Excel(name = "诊所")
    private String clinic;

    /** 地区 */
    @Excel(name = "地区")
    private String area;

    /** 时间 */
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 矫治步骤视频 */
    @Excel(name = "矫治步骤视频")
    private String patientvideo;

    /** 备注 */
    @Excel(name = "备注")
    private String others;

    public void setReportid(Long reportid) 
    {
        this.reportid = reportid;
    }

    public Long getReportid() 
    {
        return reportid;
    }
    public void setPatientid(String patientid) 
    {
        this.patientid = patientid;
    }

    public String getPatientid() 
    {
        return patientid;
    }
    public void setPatientname(String patientname) 
    {
        this.patientname = patientname;
    }

    public String getPatientname() 
    {
        return patientname;
    }
    public void setDoctor(String doctor) 
    {
        this.doctor = doctor;
    }

    public String getDoctor() 
    {
        return doctor;
    }
    public void setPatientinfomation(String patientinfomation) 
    {
        this.patientinfomation = patientinfomation;
    }

    public String getPatientinfomation() 
    {
        return patientinfomation;
    }

    public void setPatientprogramme(String patientprogramme)
    {
        this.patientprogramme = patientprogramme;
    }
    public String getPatientprogramme()
    {
        return patientprogramme;
    }




    public void setPatientphoto(String patientphoto)
    {
        this.patientphoto = patientphoto;
    }

    public String getPatientphoto() 
    {
        return patientphoto;
    }
    public void setPatientstatus(String patientstatus) 
    {
        this.patientstatus = patientstatus;
    }

    public String getPatientstatus() 
    {
        return patientstatus;
    }
    public void setClinic(String clinic) 
    {
        this.clinic = clinic;
    }

    public String getClinic() 
    {
        return clinic;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setPatientvideo(String patientvideo) 
    {
        this.patientvideo = patientvideo;
    }

    public String getPatientvideo() 
    {
        return patientvideo;
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
            .append("reportid", getReportid())
            .append("patientid", getPatientid())
            .append("patientname", getPatientname())
            .append("doctor", getDoctor())
            .append("patientinfomation", getPatientinfomation())
            .append("patientphoto", getPatientphoto())
            .append("patientstatus", getPatientstatus())
            .append("clinic", getClinic())
            .append("area", getArea())
            .append("time", getTime())
            .append("patientvideo", getPatientvideo())
            .append("others", getOthers())
            .toString();
    }
}
