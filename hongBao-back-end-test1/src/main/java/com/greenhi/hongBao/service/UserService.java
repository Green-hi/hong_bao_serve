package com.greenhi.hongBao.service;

import com.greenhi.hongBao.domian.User;
import com.greenhi.hongBao.dto.UserDTO;
import com.greenhi.hongBao.repository.PartyBranchRepository;
import com.greenhi.hongBao.repository.UserRepository;
import com.greenhi.hongBao.repository.YouthLeagueBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    @Autowired
    private PartyBranchRepository pRepo;
    @Autowired
    private YouthLeagueBranchRepository yRepo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findOne(Long id) {
        return repo.getOne(id);
    }

    public User insert(User obj) {
        return repo.save(obj);
    }

    public void delete(Long id) {
        User user = findOne(id);//如果没有该用户则抛出异常
        repo.deleteById(id);
        System.out.println("success delete--> " + user);
    }

    public User update(@org.jetbrains.annotations.NotNull User obj) {
        findOne(obj.getUserId());
        return repo.save(obj);
    }

    public User fromDTO(@NotNull UserDTO obj) {
        User user = new User();
        user.setPhoneNum(obj.getPhoneNum());
        user.setUserName(obj.getUserName());
        user.setPassword(obj.getPassword());
        Integer status = obj.getPoliticsStatus();
        if (status != null) {
            user.setPoliticsStatus(status);
            switch (status) {
                case 0:
                    break;
                case 1:
                    user.setPartyBranch(pRepo.findById(obj.getPartyBranchId()).get());
                    break;
                case 2:
                    user.setYouthLeagueBranch(yRepo.findById(obj.getLeagueBranchId()).get());
                    break;
            }
        }
        return user;
    }

}
