package com.gdou;

import java.io.Serializable;

/*
   用户传输对象
 */
public class UserDTO implements Serializable {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
