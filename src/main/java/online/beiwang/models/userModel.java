package online.beiwang.models;

/**
 * Created by yuying on 2016/12/19.
 */
public class userModel {

    /**
     * id :
     * name :
     * mail :
     * password :
     * tel :
     */

    private int id;
    private String name;
    private String mail;
    private String password;
    private String tel;

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
