package com.jp.plan.dao;

import com.jp.plan.dao.common.BaseDao;
import com.jp.plan.po.AttachmentPo;
import com.jp.plan.po.AttachmentPoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PlanSeqFunc extends BaseDao{
    void nexVal(Map example);
    void nexValbyLen(Map example);

}