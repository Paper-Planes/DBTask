package Dao;

import vo.Emp;

public interface IEmpDao extends IDao<Emp,String>{
    //继承IDao接口就可以，提高了代码的复用性，也可以自己定义功能方法
    public boolean doUpdate(Emp vo) throws Exception;
    public boolean doDelete(String id) throws Exception;
}
