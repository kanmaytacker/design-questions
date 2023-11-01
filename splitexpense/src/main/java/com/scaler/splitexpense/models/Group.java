package com.scaler.splitexpense.models;

import java.util.ArrayList;
import java.util.List;


public class Group extends BaseModel {
    private String name;
    private User createdBy;

    private List<User> members = new ArrayList<>();

    private List<User> admins = new ArrayList<>();
}