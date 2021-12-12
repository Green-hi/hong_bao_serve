package com.greenhi.hongBao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.hongBao.entity.PartyDuesRecord;
import com.greenhi.hongBao.mapper.PartyDuesRecordMapper;
import com.greenhi.hongBao.service.PartyDuesRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greenhi.hongBao.unit.Result;
import com.greenhi.hongBao.unit.ResultEnum;
import com.greenhi.hongBao.unit.ResultUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author greenhi
 * @since 2021-11-15
 */
@Service

public class PartyDuesRecordServiceImpl extends ServiceImpl<PartyDuesRecordMapper, PartyDuesRecord> implements PartyDuesRecordService {

    /**
     * 向party_dues_record数据表中添加一条记录
     * @param partyDuesRecord
     * @return Result
     */
    @Override
    public Result add(PartyDuesRecord partyDuesRecord) {
        if (getOne(new QueryWrapper<PartyDuesRecord>()
                .eq("mid", partyDuesRecord.getMid())
                .eq("month",partyDuesRecord.getMonth())
        ) == null) {
            save(partyDuesRecord);
            return ResultUtil.success("党费缴费记录数据添加成功");
        } else {
            return ResultUtil.error(ResultEnum.DUE_IS_PAYED.getCode(), ResultEnum.DUE_IS_PAYED.getMsg());
        }
    }

    /**
     * 删除party_dues_record数据表中的某条记录
     * @param id
     * @return Result
     */
    @Override
    public Result delete(Long id) {
        if (getOne(new QueryWrapper<PartyDuesRecord>()
                .eq("id", id)
        ) != null) {
            baseMapper.delete(new QueryWrapper<PartyDuesRecord>().eq("id",id));
            return ResultUtil.success("党费缴费记录数据已经删除");
        } else {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
    }

    /**
     * 对party_dues_record数据表的分页查询
     * @param pageNo
     * @param pageSize
     * @return Result data: IPage<PartyDuesRecord>
     */
    @Override
    public Result getAllPaging(Integer pageNo, Integer pageSize) {
        IPage<PartyDuesRecord> mPage = new Page<>(pageNo, pageSize);
        QueryWrapper<PartyDuesRecord> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        IPage<PartyDuesRecord> partyDuesRecordIPage = page(mPage, wrapper);
        if(partyDuesRecordIPage != null){
            return ResultUtil.success(partyDuesRecordIPage);
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    /**
     * 从party_dues_record数据表中查询某条缴费记录
     * @param id
     * @return Result data: PartyDuesRecord
     */
    @Override
    public Result selectDuesRecordOneByID(Long id) {
        PartyDuesRecord partyDuesRecord = getOne(new QueryWrapper<PartyDuesRecord>()
                .eq("id", id));
        if (partyDuesRecord == null) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(partyDuesRecord);
        }
    }

    /**
     * 从party_dues_record数据表中查询某个党员的所有缴费记录
     * @param mid
     * @return Result data: List<PartyDuesRecord>
     */
    @Override
    public Result selectDuesRecordByMemberID(String mid) {
        List<PartyDuesRecord> partyDuesRecords = list(new QueryWrapper<PartyDuesRecord>()
                .eq("mid", mid));
        if (partyDuesRecords.size()==0) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(partyDuesRecords);
        }
    }

    /**
     * 从party_dues_record数据表中查询某个党支部的所有缴费记录
     * @param branchName
     * @return Result data: List<PartyDuesRecord>
     */
    @Override
    public Result selectDuesRecordByBranchName(String branchName) {
        List<PartyDuesRecord> partyDuesRecords = baseMapper.getListByBranchName(branchName);
        if (partyDuesRecords.size()==0) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(partyDuesRecords);
        }
    }

    /**
     * 从party_dues_record数据表中查询某个党支部某个月的所有缴费记录
     * @param branchName
     * @param month
     * @return Result data: List<PartyDuesRecord>
     */
    @Override
    public Result selectDuesRecordByBranchNameAndMonth(String branchName, String month) {
        List<PartyDuesRecord> partyDuesRecords = baseMapper.getListByBranchNameAndMonth(branchName,month);
        if (partyDuesRecords.size()==0) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(partyDuesRecords);
        }
    }
}
