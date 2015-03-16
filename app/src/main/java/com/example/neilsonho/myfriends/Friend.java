package com.example.neilsonho.myfriends;

/**
 * Created by neilsonho on 15-02-23.
 */
public class Friend {
    private int _id;
    private String _name;
    private String _email;
    private String _phone;

    public Friend() {
    }

    public Friend (String name, String email, String phone){
        this._name = name;
        this._email = email;
        this._phone = phone;
    }

    public Friend(int id, String name, String email, String phone){
        this._id = id;
        this._name = name;
        this._email = email;
        this._phone = phone;
    }

    public void setID(int id) {
        this._id = id;
    }

    public int getID() {
        return this._id;
    }

    public void setName(String name){
        this._name = name;
    }

    public String getName(){
        return this._name;
    }

    public void setEmail(String email){
        this._email = email;
    }

    public String getEmail(){
        return this._email;
    }

    public void setPhone(String phone){
        this._phone=phone;
    }

    public String getPhone(){
        return this._phone;
    }

    @Override
    public String toString() {
        return this._name;
    }

}
