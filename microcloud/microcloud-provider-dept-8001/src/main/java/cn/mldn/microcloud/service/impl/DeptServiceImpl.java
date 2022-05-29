package cn.mldn.microcloud.service.impl;

import cn.mldn.microcloud.dao.IDeptDAO;
import cn.mldn.microcloud.service.IDeptService;
import cn.mldn.vo.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DeptServiceImpl implements IDeptService {
    @Resource
    private IDeptDAO deptDAO ;
    @Override
    public Dept get(long id) {
        return this.deptDAO.findById(id);
    }

    @Override
    public boolean add(Dept dept) {
        return this.deptDAO.doCreate(dept);
    }

    @Override
    public List<Dept> list() {
        return this.deptDAO.findAll();
    }

}
