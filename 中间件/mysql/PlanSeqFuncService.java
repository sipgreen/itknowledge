package com.jp.plan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jp.plan.dao.PlanSeqFunc;

@Service
public class PlanSeqFuncService {
	@Resource
	PlanSeqFunc seqFunc;
	
	public Long nexVal(String tablename)
	{
		Map map = new HashMap();
		map.put("p1", tablename);
		try {
			seqFunc.nexVal(map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return (Long) map.get("p3");
	}
	public List<Long> nexValbyLen(Integer len,String tablename)
    {
	    List<Long> retlist = new ArrayList<Long>(len);
        Map map = new HashMap();
        map.put("p1", len);
        map.put("p2", tablename);
        try {
            seqFunc.nexValbyLen(map);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        Long funcret= (Long) map.get("p3");
        for(int i=0;i<len;i++)
        {
            retlist.add(funcret + i);
        }        
        return retlist;
    }
}
