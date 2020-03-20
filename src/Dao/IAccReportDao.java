package Dao;

import vo.AccReport;

import java.util.List;

public interface IAccReportDao {
    public boolean doCreate(AccReport vo) throws Exception;//增
    public AccReport findById(int SurveyNumber) throws Exception;//查
    public List<AccReport> findByEmp(String phNumber) throws Exception;//查
}
