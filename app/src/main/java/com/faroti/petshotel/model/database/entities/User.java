package com.faroti.petshotel.model.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    @ColumnInfo(index = true)
    private String email;

    private String password;

    private String cellPhone;

    private Boolean  enable;

    //private List<Proveedor> proveedores;



    public User(){
    }

    public User(String name, String email, String password, String cellPhone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cellPhone = cellPhone;
        this.enable = true;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellPhone() { return cellPhone; }

    public void setCellPhone(String cellPhone) { this.cellPhone = cellPhone; }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /*
    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

     */

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", enable=" + enable +
                '}';
    }
}
