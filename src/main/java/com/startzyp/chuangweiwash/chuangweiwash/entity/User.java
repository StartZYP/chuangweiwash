package com.startzyp.chuangweiwash.chuangweiwash.entity;

import java.sql.Timestamp;

/**
 * @Author: Startzyp
 * @Date: 2019/9/15 20:45
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private int roleid;
    private Timestamp createtime;
    private Timestamp updatetime;
    private boolean deletestatus;

    public User(int id, String username, String password, String nickname, int roleid, Timestamp createtime, Timestamp updatetime, boolean deletestatus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.roleid = roleid;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.deletestatus = deletestatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", roleid=" + roleid +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", deletestatus=" + deletestatus +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public boolean isDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(boolean deletestatus) {
        this.deletestatus = deletestatus;
    }
}
