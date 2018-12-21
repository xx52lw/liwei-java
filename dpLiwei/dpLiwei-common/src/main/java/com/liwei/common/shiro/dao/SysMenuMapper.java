package com.liwei.common.shiro.dao;

import com.liwei.common.cm.dao.BaseMapper;
import com.liwei.common.shiro.entity.SysMenuEntity;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * 系统菜单dao
 *
 * @author liwei
 * @file com.liwei.common.shiro.dao
 * @Date：下午5:33 下午5:33
 */
@MapperScan
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {

    List<SysMenuEntity> listParentId(Long parentId);

    List<SysMenuEntity> listNotButton();

    List<String> listUserPerms(Long userId);

    int countMenuChildren(Long parentId);

}
