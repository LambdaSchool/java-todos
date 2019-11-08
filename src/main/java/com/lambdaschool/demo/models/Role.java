package com.lambdaschool.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleid;

    private String rolename;


    ///////////Foreign Key////////////////
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();


    ////////////////BOILER PLATE//////////////////////////////////
    public Role(){}

    public Role(String rolename) {
        this.rolename = rolename;
    }

    public long getRoleid() {
        return roleid;
    }

    public void setRoleid(long roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
