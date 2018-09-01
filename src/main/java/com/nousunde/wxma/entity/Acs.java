package com.nousunde.wxma.entity;

import net.sf.json.JSONObject;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Access Control System
 */
@Entity
@Table(name = "tb_acs")
public class Acs {
    @Override
    public String toString() {
        JSONObject jsonObject = JSONObject.fromObject(this);
        return jsonObject.toString();
    }

    //strategy=GenerationType.AUTO)
    private String AcsId;
    private String UserId;
    private String Keytab;
    /**
     * Authentication Method
     */
    private String Authmeth;
    private Short UserMod;
    private Short Statues;
    private Long LastActiveTime;

    @Id
    @Column(name = "acs_id", nullable = false, unique = true)
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    public String getAcsId() {
        return AcsId;
    }

    public void setAcsId(String acsId) {
        AcsId = acsId;
    }

    @Column(name = "user_id", nullable = false, unique = true)
    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    /**
     * ACS for user access permissions
     * @return 3030         Administrator
     *         4130~4199    Supper user
     *         4230~4299    Advance user
     *         4330~4399    Normal user
     *         4430>        Visitor
     */
    @Column(name = "user_mod")
    @org.hibernate.annotations.ColumnDefault("4430")
    public Short getUserMod() {
        return UserMod;
    }

    public void setUserMod(Short userMod) {
        UserMod = userMod;
    }

    @Column(name = "status")
    public Short getStatues() {
        return Statues;
    }

    public void setStatues(Short statues) {
        Statues = statues;
    }

    @Column(name = "key_tab")
    public String getKeytab() {
        return Keytab;
    }

    public void setKeytab(String keytab) {
        Keytab = keytab;
    }

    @Column(name = "auth_meth")
    public String getAuthmeth() {
        return Authmeth;
    }

    public void setAuthmeth(String authmeth) {
        Authmeth = authmeth;
    }

    @Column(name = "last_active_time")
    public Long getLastActiveTime() {
        return LastActiveTime;
    }

    public void setLastActiveTime(Long lastActiveTime) {
        LastActiveTime = lastActiveTime;
    }
}
