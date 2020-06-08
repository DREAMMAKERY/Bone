package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Patientinfo;
import java.util.List;

/**
 * 患者情况信息Mapper接口
 * 
 * @author ruoyi
 * @date 2019-10-10
 */
public interface PatientinfoMapper 
{
    /**
     * 查询患者情况信息
     * 
     * @param patientid 患者情况信息ID
     * @return 患者情况信息
     */
    public Patientinfo selectPatientinfoById(Long patientid);

    /**
     * 查询患者情况信息列表
     * 
     * @param patientinfo 患者情况信息
     * @return 患者情况信息集合
     */
    public List<Patientinfo> selectPatientinfoList(Patientinfo patientinfo);

    /**
     * 新增患者情况信息
     * 
     * @param patientinfo 患者情况信息
     * @return 结果
     */
    public int insertPatientinfo(Patientinfo patientinfo);

    /**
     * 修改患者情况信息
     * 
     * @param patientinfo 患者情况信息
     * @return 结果
     */
    public int updatePatientinfo(Patientinfo patientinfo);

    /**
     * 删除患者情况信息
     * 
     * @param patientid 患者情况信息ID
     * @return 结果
     */
    public int deletePatientinfoById(Long patientid);

    /**
     * 批量删除患者情况信息
     * 
     * @param patientids 需要删除的数据ID
     * @return 结果
     */
    public int deletePatientinfoByIds(String[] patientids);
}
