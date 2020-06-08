package com.ruoyi.system.service;

import com.ruoyi.system.domain.Patientreport;
import java.util.List;

/**
 * 患者报告单Service接口
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
public interface IPatientreportService 
{
    /**
     * 查询患者报告单
     * 
     * @param reportid 患者报告单ID
     * @return 患者报告单
     */
    public Patientreport selectPatientreportById(Long reportid);

    /**
     * 查询患者报告单列表
     * 
     * @param patientreport 患者报告单
     * @return 患者报告单集合
     */
    public List<Patientreport> selectPatientreportList(Patientreport patientreport);

    /**
     * 新增患者报告单
     * 
     * @param patientreport 患者报告单
     * @return 结果
     */
    public int insertPatientreport(Patientreport patientreport);

    /**
     * 修改患者报告单
     * 
     * @param patientreport 患者报告单
     * @return 结果
     */
    public int updatePatientreport(Patientreport patientreport);

    /**
     * 批量删除患者报告单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePatientreportByIds(String ids);

    /**
     * 删除患者报告单信息
     * 
     * @param reportid 患者报告单ID
     * @return 结果
     */
    public int deletePatientreportById(Long reportid);
}
