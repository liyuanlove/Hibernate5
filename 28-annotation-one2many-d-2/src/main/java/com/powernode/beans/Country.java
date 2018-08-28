package com.powernode.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Country {

    @Id
    @GeneratedValue(generator = "xxx")
    @GenericGenerator(name = "xxx", strategy = "native")
    private Integer cid;
    private String cname;
    //关联属性
    //mappedBy的设置表示当前的one方放弃了关联关系的维护权，将维护权交给了many方的关联属性
    //一旦one方放弃了维护权，则不能再设置@JoinColumn注解
    @OneToMany(targetEntity = Minister.class, cascade = CascadeType.ALL, mappedBy = "country")
    //@JoinColumn(name="countryId")
    private Set<Minister> ministers;

    public Country() {
        ministers = new HashSet<Minister>();
    }

    public Country(String cname) {
        this();
        this.cname = cname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<Minister> getMinisters() {
        return ministers;
    }

    public void setMinisters(Set<Minister> ministers) {
        this.ministers = ministers;
    }

    @Override
    public String toString() {
        return "Country [cid=" + cid + ", cname=" + cname + ", ministers=" + ministers + "]";
    }

}