package com.liwei.common.shiro.entity;


import java.io.Serializable;

/**
 *
 * 角色与菜单对应关系
 *
 *@file com.liwei.common.shiro.entity
 *@author liwei
 *@Date：下午5:18 下午5:18
*/
public class SysRoleMenuEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 记录id
	 */
	private Long id;

	/**
	 * 角色ID
	 */
	private Long roleId;

	/**
	 * 菜单ID
	 */
	private Long menuId;

	public SysRoleMenuEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

}
