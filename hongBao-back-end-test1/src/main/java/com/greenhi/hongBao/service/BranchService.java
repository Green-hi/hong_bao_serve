package com.greenhi.hongBao.service;

import com.greenhi.hongBao.domian.PartyBranch;
import com.greenhi.hongBao.domian.YouthLeagueBranch;
import com.greenhi.hongBao.repository.PartyBranchRepository;
import com.greenhi.hongBao.repository.YouthLeagueBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    private PartyBranchRepository pRepo;
    @Autowired
    private YouthLeagueBranchRepository yRepo;

    public List<PartyBranch> findAllPBranches() {
        return pRepo.findAll();
    }

    public List<YouthLeagueBranch> findAllYBranches() {
        return yRepo.findAll();
    }

    public PartyBranch save(PartyBranch obj) {
        return pRepo.save(obj);
    }

    public YouthLeagueBranch save(YouthLeagueBranch obj) {
        return yRepo.save(obj);
    }
}
