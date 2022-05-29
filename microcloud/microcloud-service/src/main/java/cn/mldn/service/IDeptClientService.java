package cn.mldn.service;

import java.util.List;

import cn.mldn.service.fallback.IDeptClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.mldn.commons.config.FeignClientConfig;
import cn.mldn.vo.Dept;
@FeignClient(value="MICROCLOUD-PROVIDER-DEPT",configuration=FeignClientConfig.class,fallbackFactory = IDeptClientServiceFallbackFactory.class)
public interface IDeptClientService {
    @RequestMapping(method=RequestMethod.GET,value="/dept/get/{id}")
    public Dept get(@PathVariable("id") long id) ;
    @RequestMapping(method=RequestMethod.GET,value="/dept/list")
    public List<Dept> list() ;
    @RequestMapping(method=RequestMethod.POST,value="/dept/add")
    public boolean add(Dept dept) ;
}
