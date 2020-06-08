package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PatientinfoMapper;
import com.ruoyi.system.domain.Patientinfo;
import com.ruoyi.system.service.IPatientinfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 患者情况信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-10-10
 */
@Service
public class PatientinfoServiceImpl implements IPatientinfoService 
{
    @Autowired
    private PatientinfoMapper patientinfoMapper;

    /**
     * 查询患者情况信息
     * 
     * @param patientid 患者情况信息ID
     * @return 患者情况信息
     */
    @Override
    public Patientinfo selectPatientinfoById(Long patientid)
    {
        return patientinfoMapper.selectPatientinfoById(patientid);
    }

    /**
     * 查询患者情况信息列表
     * 
     * @param patientinfo 患者情况信息
     * @return 患者情况信息
     */
    @Override
    public List<Patientinfo> selectPatientinfoList(Patientinfo patientinfo)
    {
        return patientinfoMapper.selectPatientinfoList(patientinfo);
    }

    /**
     * 新增患者情况信息
     * 
     * @param patientinfo 患者情况信息
     * @return 结果
     */
    @Override
    public int insertPatientinfo(Patientinfo patientinfo)
    {
        return patientinfoMapper.insertPatientinfo(patientinfo);
    }

    /**
     * 修改患者情况信息
     * 
     * @param patientinfo 患者情况信息
     * @return 结果
     */
    @Override
    public int updatePatientinfo(Patientinfo patientinfo)
    {
        return patientinfoMapper.updatePatientinfo(patientinfo);
    }

    /**
     * 删除患者情况信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePatientinfoByIds(String ids)
    {
        return patientinfoMapper.deletePatientinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除患者情况信息信息
     * 
     * @param patientid 患者情况信息ID
     * @return 结果
     */
    @Override
    public int deletePatientinfoById(Long patientid)
    {
        return patientinfoMapper.deletePatientinfoById(patientid);
    }
}
