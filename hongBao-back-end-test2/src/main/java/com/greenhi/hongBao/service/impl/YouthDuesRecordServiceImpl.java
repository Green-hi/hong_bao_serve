package com.greenhi.hongBao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.hongBao.entity.YouthDuesRecord;
import com.greenhi.hongBao.mapper.YouthDuesRecordMapper;
import com.greenhi.hongBao.service.YouthDuesRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greenhi.hongBao.unit.Result;
import com.greenhi.hongBao.unit.ResultEnum;
import com.greenhi.hongBao.unit.ResultUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author greenhi
 * @since 2021-11-15
 */
@Service
public class YouthDuesRecordServiceImpl extends ServiceImpl<YouthDuesRecordMapper, YouthDuesRecord> implements YouthDuesRecordService {
    /**
     * 向youth_dues_record数据表中添加一条记录
     *
     * @param youthDuesRecord
     * @return Result
     */
    @Override
    public Result add(YouthDuesRecord youthDuesRecord) {
        if (getOne(new QueryWrapper<YouthDuesRecord>()
                .eq("mid", youthDuesRecord.getMid())
                .eq("month", youthDuesRecord.getMonth())
        ) == null) {
            save(youthDuesRecord);
            return ResultUtil.success("团费缴费记录数据添加成功");
        } else {
            return ResultUtil.error(ResultEnum.DUE_IS_PAYED.getCode(), ResultEnum.DUE_IS_PAYED.getMsg());
        }
    }

    /**
     * 删除youth_dues_record数据表中的某条记录
     *
     * @param id
     * @return Result
     */
    @Override
    public Result delete(Long id) {
        if (getOne(new QueryWrapper<YouthDuesRecord>()
                .eq("id", id)
        ) != null) {
            baseMapper.delete(new QueryWrapper<YouthDuesRecord>().eq("id", id));
            return ResultUtil.success("团费缴费记录数据已经删除");
        } else {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
    }

    /**
     * 对youth_dues_record数据表的分页查询
     *
     * @param pageNo
     * @param pageSize
     * @return Result data: IPage<YouthDuesRecord>
     */
    @Override
    public Result getAllPaging(Integer pageNo, Integer pageSize) {
        IPage<YouthDuesRecord> mPage = new Page<>(pageNo, pageSize);
        QueryWrapper<YouthDuesRecord> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        IPage<YouthDuesRecord> youthDuesRecordIPage = page(mPage, wrapper);
        if (youthDuesRecordIPage != null) {
            return ResultUtil.success(youthDuesRecordIPage);
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    /**
     * 从youth_dues_record数据表中查询某条缴费记录
     *
     * @param id
     * @return Result data: YouthDuesRecord
     */
    @Override
    public Result selectDuesRecordOneByID(Long id) {
        YouthDuesRecord YouthDuesRecord = getOne(new QueryWrapper<YouthDuesRecord>()
                .eq("id", id));
        if (YouthDuesRecord == null) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(YouthDuesRecord);
        }
    }

    /**
     * 从youth_dues_record数据表中查询某个团员的所有缴费记录
     *
     * @param mid
     * @return Result data: List<YouthDuesRecord>
     */
    @Override
    public Result selectDuesRecordByMemberID(String mid) {
        List<YouthDuesRecord> youthDuesRecords = list(new QueryWrapper<YouthDuesRecord>()
                .eq("mid", mid));
        if (youthDuesRecords.size() == 0) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(youthDuesRecords);
        }
    }

    /**
     * 从youth_dues_record数据表中查询某个团支部的所有缴费记录
     * @param branchName
     * @return Result data: List<YouthDuesRecord>
     */
    @Override
    public Result selectDuesRecordByBranchName(String branchName) {
        List<YouthDuesRecord> youthDuesRecords = baseMapper.getListByBranchName(branchName);
        if (youthDuesRecords.size()==0) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(youthDuesRecords);
        }
    }

    /**
     * 从youth_dues_record数据表中查询某个团支部某个月的所有缴费记录
     * @param branchName
     * @param month
     * @return Result data: List<YouthDuesRecord>
     */
    @Override
    public Result selectDuesRecordByBranchNameAndMonth(String branchName, String month) {
        List<YouthDuesRecord> youthDuesRecords = baseMapper.getListByBranchNameAndMonth(branchName,month);
        if (youthDuesRecords.size()==0) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(youthDuesRecords);
        }
    }
}
