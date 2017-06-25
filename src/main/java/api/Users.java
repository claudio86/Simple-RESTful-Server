package api;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private String user;
    private List users;
    public String getUser (){
        return this.user;
    }
    public void setUser(String user){
        this.user = user;
    }
    public List getUsers (){
        return this.users;
    }
    public void setUsers(ArrayList <List> users){
        this.users = users;
    }

}
