package Dao;

import vo.Insurance;
import java.util.List;

public interface IInsuranceDao {
    //继承IDao接口就可以，提高了代码的复用性，也可以自己定义功能方法
    public boolean doCreate(Insurance vo) throws Exception;//增
    public Insurance findById(int iNo) throws Exception;//查
    public List<Insurance> findByEmp(String phNumber) throws Exception;//查
    public boolean doUpdate(Insurance vo) throws Exception;//改
}
