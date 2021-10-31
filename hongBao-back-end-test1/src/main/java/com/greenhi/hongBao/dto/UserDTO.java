package com.greenhi.hongBao.dto;

import com.greenhi.hongBao.domian.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    private String phoneNum;
    private String userName;
    private String password;
    private Integer politicsStatus;
    private Integer partyBranchId;
    private Integer leagueBranchId;

    public UserDTO(@NotNull User obj) {
        phoneNum = obj.getPhoneNum();
        userName = obj.getUserName();
        password = obj.getPassword();
        politicsStatus = obj.getPoliticsStatus();
        switch (politicsStatus) {
            case 0:
                break;
            case 1:
                partyBranchId = obj.getPartyBranch().getId();
                break;
            case 2:
                leagueBranchId = obj.getYouthLeagueBranch().getId();
                break;
        }
    }
}
