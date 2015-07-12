package org.snow.cms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.snow.cms.dao.IRoleDao;
import org.snow.cms.model.Role;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements IRoleDao {

	@Inject
	private SqlSession sqlSession;

	public List<Role> listUserRoles(int userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", Integer.valueOf(userId));
		return list(Role.class.getName() + ".list_user_roles", map);
	}

	public List<Integer> listUserRoleIds(int userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", Integer.valueOf(userId));
		List<Integer> list = this.sqlSession.selectList(Role.class.getName()+".list_user_roleIds", map);
		return list;
	}

	public List<Role> listRole() {
		List<Role> list = list(Role.class, null);
		return list;
	}

	public void deleteRoleUsers(int roleId) {
		this.sqlSession.delete(Role.class.getName() + ".delete_role_users", Integer.valueOf(roleId));
	}
}
