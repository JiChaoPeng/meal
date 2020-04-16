package com.example.demo.xxxx.bean;

import java.util.List;

public class UserListBean {
private List<UserMeal> list;

    public UserListBean(List<UserMeal> list) {
        this.list = list;
    }

    public List<UserMeal> getList() {
        return list;
    }

    public void setList(List<UserMeal> list) {
        this.list = list;
    }
}
