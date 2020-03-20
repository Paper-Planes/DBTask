package Dao;

import vo.Car;

import java.util.List;

public interface IDao<T,K> {
    public boolean doCreate(T vo) throws Exception;//增
    public T findById(K id) throws Exception;//按ID查
}
