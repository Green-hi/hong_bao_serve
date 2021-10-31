package com.greenhi.hongBao.domian;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class PartyBranch {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Integer id;

    @NotEmpty
    @Column(unique = true)
    private String branchName;

}
