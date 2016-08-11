package org.snow.cms.model;

public class Role {
    private int id;
    private String name;
    private RoleType roleType;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleType getRoleType() {
        return this.roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Role(int id, String name, RoleType roleType) {
        this.id = id;
        this.name = name;
        this.roleType = roleType;
    }

    public Role() {
    }
}
