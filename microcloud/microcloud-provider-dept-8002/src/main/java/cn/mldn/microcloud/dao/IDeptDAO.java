package cn.mldn.microcloud.dao;

import cn.mldn.vo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IDeptDAO {
    public boolean doCreate(Dept vo);
    public Dept findById(Long id);
    public List<Dept> findAll();
}
