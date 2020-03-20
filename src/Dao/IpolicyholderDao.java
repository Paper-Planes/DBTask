package Dao;

import vo.policyholder;

public interface IpolicyholderDao extends IDao<policyholder,String> {
    //继承IDao接口就可以，提高了代码的复用性，也可以自己定义功能方法
    public boolean doUpdate(policyholder vo) throws Exception;
}
