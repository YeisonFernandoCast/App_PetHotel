package com.faroti.petshotel.model.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Proveedor {

    @PrimaryKey
    private Integer id;

    private String email;

    private String name;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
