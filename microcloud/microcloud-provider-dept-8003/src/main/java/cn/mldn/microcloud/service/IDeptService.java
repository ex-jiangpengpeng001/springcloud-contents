package cn.mldn.microcloud.service;

import cn.mldn.vo.Dept;

import java.util.List;

public interface IDeptService {
    public Dept get(long id);
    public boolean add(Dept dept);
    public List<Dept> list();
}
