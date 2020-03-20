package test;

import factory.DaoFactory;
import util.MD5;
import vo.policyholder;

public class addPh {
    public static void main(String args[])throws Exception{
        policyholder ph=new policyholder();
        ph.setPhNumber("0001");
        MD5 getMD5 = new MD5();
        ph.setPhPwd(getMD5.GetMD5Code("0001"));
        ph.setPhName("单一");
        ph.setPhID("000000000000000001");
        ph.setPhPhone("13000000001");
        ph.setPhAddr("商丘");
        DaoFactory.getIpolicyholderDaoInstance().doCreate(ph);
    }
}
