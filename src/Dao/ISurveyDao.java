package Dao;

import vo.Survey;

import java.util.List;

public interface ISurveyDao {
    public boolean doCreate(Survey vo) throws Exception;//增
    public Survey findById(int AccNo) throws Exception;//查
    public List<Survey> findByEmp(String phNumber) throws Exception;//查
}
