package Dao;

import vo.InsuranceType;

public interface ITypeDao {
    public InsuranceType findById(String insNo) throws Exception;
}
