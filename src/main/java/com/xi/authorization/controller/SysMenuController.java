package com.xi.authorization.controller;


import com.xi.authorization.dto.DTMenuJson;
import com.xi.authorization.dto.ResponseResult;
import com.xi.authorization.entity.SysMenu;
import com.xi.authorization.service.impl.SysMenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Gong Qiang
 * @since 2020-11-13
 */
@RestController
@RequestMapping("/sys-menu")
public class SysMenuController {
    @Autowired
    SysMenuServiceImpl menuService;
    @RequestMapping("/menutree")
    public List<DTMenuJson> GetMenu()
    {
        return menuService.GetMenu();
    }
    @RequestMapping("/add")
    public ResponseResult<Boolean> AddMenu(String menuName,String url,int sortno,int parentId)
    {
        SysMenu m=new SysMenu();
        m.setMenuName(menuName);
        m.setCreateBy("gq");
        m.setCreateTime(new Date());
        m.setParentId(parentId);
        m.setSortno(sortno);
        boolean flag= menuService.save(m);
        return new ResponseResult<Boolean>(flag?1:0,flag,"");
    }
    @RequestMapping("/del")
    public ResponseResult<Boolean> DelMenu(int id)
    {
        boolean flag= menuService.removeById(id);
        return new ResponseResult<Boolean>(flag?1:0,flag,"");
    }
}

