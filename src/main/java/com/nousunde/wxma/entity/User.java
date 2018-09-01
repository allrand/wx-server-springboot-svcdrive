package com.nousunde.wxma.entity;

import net.sf.json.JSONObject;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "tb_user")
public class User {
    @Override
    public String toString() {
        JSONObject jsonObject = JSONObject.fromObject(this);
        return jsonObject.toString();
    }

    //    @GeneratedValue(strategy=GenerationType.AUTO)
    //    @TableGenerator(name = "tb_user", initialValue = 10000)
    private String UserId;

    private String name;

    private String email;

    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String UserName;
    private String NickName;
    private String RemarkName;
    private String DisplayName;

    private Short Sex;
    private String Signature;
    private String HeadImgUrl;

    private String Province;
    private String City;
    private Short SnsFlag;
    private Integer MemberList;
    private String PyQuanpin;
    private String PyInitial;
    private String KeyWord;
    private Short MemberCount;
    private Long CreateTime;
    private Long LastEditTime;

    @Column(name = "user_name", unique = true)
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    @Column(name = "nick_name")
    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    @Column(name = "remark_name")
    public String getRemarkName() {
        return RemarkName;
    }

    public void setRemarkName(String remarkName) {
        RemarkName = remarkName;
    }

    @Column(name = "display_name")
    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    @Column(name = "sex")
    public Short getSex() {
        return Sex;
    }

    public void setSex(Short sex) {
        Sex = sex;
    }

    @Column(name = "signature")
    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    @Column(name = "head_img_url")
    public String getHeadImgUrl() {
        return HeadImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        HeadImgUrl = headImgUrl;
    }

    @Column(name = "province")
    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    @Column(name = "city")
    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Column(name = "sns_flag")
    public Short getSnsFlag() {
        return SnsFlag;
    }

    public void setSnsFlag(Short snsFlag) {
        SnsFlag = snsFlag;
    }

    @Column(name = "member_list")
    public Integer getMemberList() {
        return MemberList;
    }

    public void setMemberList(Integer memberList) {
        MemberList = memberList;
    }

    @Column(name = "py_quanpin")
    public String getPyQuanpin() {
        return PyQuanpin;
    }

    public void setPyQuanpin(String pyQuanpin) {
        PyQuanpin = pyQuanpin;
    }


    public String getPyInitial() {
        return PyInitial;
    }

    public void setPyInitial(String pyInitial) {
        PyInitial = pyInitial;
    }

    public String getKeyWord() {
        return KeyWord;
    }

    public void setKeyWord(String keyWord) {
        KeyWord = keyWord;
    }

    public Short getMemberCount() {
        return MemberCount;
    }

    public void setMemberCount(Short memberCount) {
        MemberCount = memberCount;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }

    public Long getLastEditTime() {
        return LastEditTime;
    }

    public void setLastEditTime(Long lastEditTime) {
        LastEditTime = lastEditTime;
    }
}