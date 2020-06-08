package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PatientreportMapper;
import com.ruoyi.system.domain.Patientreport;
import com.ruoyi.system.service.IPatientreportService;
import com.ruoyi.common.core.text.Convert;

/**
 * 患者报告单Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-10-21
 */
@Service
public class PatientreportServiceImpl implements IPatientreportService 
{
    @Autowired
    private PatientreportMapper patientreportMapper;

    /**
     * 查询患者报告单
     * 
     * @param reportid 患者报告单ID
     * @return 患者报告单
     */
    @Override
    public Patientreport selectPatientreportById(Long reportid)
    {
        return patientreportMapper.selectPatientreportById(reportid);
    }

    /**
     * 查询患者报告单列表
     * 
     * @param patientreport 患者报告单
     * @return 患者报告单
     */
    @Override
    public List<Patientreport> selectPatientreportList(Patientreport patientreport)
    {
        return patientreportMapper.selectPatientreportList(patientreport);
    }

    /**
     * 新增患者报告单
     * 
     * @param patientreport 患者报告单
     * @return 结果
     */
    @Override
    public int insertPatientreport(Patientreport patientreport)
    {
        return patientreportMapper.insertPatientreport(patientreport);
    }

    /**
     * 修改患者报告单
     * 
     * @param patientreport 患者报告单
     * @return 结果
     */
    @Override
    public int updatePatientreport(Patientreport patientreport)
    {
        return patientreportMapper.updatePatientreport(patientreport);
    }

    /**
     * 删除患者报告单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePatientreportByIds(String ids)
    {
        return patientreportMapper.deletePatientreportByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除患者报告单信息
     * 
     * @param reportid 患者报告单ID
     * @return 结果
     */
    @Override
    public int deletePatientreportById(Long reportid)
    {
        return patientreportMapper.deletePatientreportById(reportid);
    }
}
