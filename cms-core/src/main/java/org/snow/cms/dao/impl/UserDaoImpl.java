package org.snow.cms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.snow.cms.dao.IUserDao;
import org.snow.cms.model.Group;
import org.snow.cms.model.Role;
import org.snow.cms.model.RoleType;
import org.snow.cms.model.User;
import org.snow.cms.model.UserGroup;
import org.snow.cms.model.UserRole;
import org.snow.cms.util.Pager;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

	@Inject
	private SqlSession sqlSession;

	public UserRole loadUserRole(int userId, int roleId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", Integer.valueOf(userId));
		map.put("roleId", Integer.valueOf(roleId));
		UserRole ur = (UserRole) this.sqlSession.selectOne(
				"org.snow.cms.model.User.load_user_role", map);
		return ur;
	}

	public UserGroup loadUserGroup(int userId, int groupId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", Integer.valueOf(userId));
		map.put("groupId", Integer.valueOf(groupId));
		UserGroup ug = (UserGroup) this.sqlSession.selectOne(
				"org.snow.cms.model.User.load_user_group", map);
		return ug;
	}

	public User loadByUsername(String username) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		return (User) loadBySqlId(User.class.getName() + ".load_by_username",
				map);
	}

	public List<User> listRoleUsers(int roleId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleId", Integer.valueOf(roleId));
		return list(User.class.getName() + ".list_role_users_by_roleId", map);
	}

	public List<User> listRoleUsers(RoleType roleType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleType", roleType);
		return list(User.class.getName() + ".list_role_users_by_roleType", map);
	}

	public List<User> listGroupUsers(int groupId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("groupId", Integer.valueOf(groupId));
		return list(User.class.getName() + ".list_group_users_by_groupId", map);
	}

	public void addUserRole(User user, Role role) {
		UserRole ur = loadUserRole(user.getId(), role.getId());
		if (null != ur)
			return;
		ur = new UserRole();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", Integer.valueOf(user.getId()));
		map.put("roleId", Integer.valueOf(role.getId()));
		this.sqlSession.insert(User.class.getName() + ".add_user_role", map);
	}

	public void addUserGroup(User user, Group group) {
		UserGroup ug = loadUserGroup(user.getId(), group.getId());
		if (null != ug)
			return;
		ug = new UserGroup();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", Integer.valueOf(user.getId()));
		map.put("groupId", Integer.valueOf(group.getId()));
		this.sqlSession.insert(User.class.getName() + ".add_user_group", map);
	}

	public void deleteUserRoles(int userId) {
		this.sqlSession.delete(User.class.getName() + ".delete_user_roles",
				Integer.valueOf(userId));
	}

	public void deleteUserGroups(int userId) {
		this.sqlSession.delete(User.class.getName() + ".delete_user_groups",
				Integer.valueOf(userId));
	}

	public Pager<User> findUser(Map<String, Object> map) {
		return find(User.class, map);
	}

	public void deleteUserRole(int userId, int roleId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", Integer.valueOf(userId));
		map.put("roleId", Integer.valueOf(roleId));
		this.sqlSession.delete(User.class.getName() + ".delete_user_role", map);
	}

	public void deleteUserGroup(int userId, int groupId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", Integer.valueOf(userId));
		map.put("groupId", Integer.valueOf(groupId));
		this.sqlSession
				.delete(User.class.getName() + ".delete_user_group", map);
	}
}
