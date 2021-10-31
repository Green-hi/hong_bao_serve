package com.greenhi.hongBao.domian;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
/*
 * hibernate会给被管理的pojo加入一个hibernateLazyInitializer属性,
 * jsonplugin通过java的反射机制将pojo转换成json,会把hibernateLazyInitializer也拿出来操作,
 * 但是hibernateLazyInitializer无法由反射得到，所以就抛异常了
 * */
//设置将代理对象转换为json对象时，忽略的属性
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(unique = true)
    @NotEmpty
    private String phoneNum;

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;

    private Integer politicsStatus = 0;

    @ManyToOne
    private PartyBranch partyBranch;

    @ManyToOne
    private YouthLeagueBranch youthLeagueBranch;

}
