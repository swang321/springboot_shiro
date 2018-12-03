package com.whh.dao;

import com.whh.bean.pojo.CollectGameLoginUnique;

public interface CollectGameLoginUniqueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CollectGameLoginUnique record);

    int insertSelective(CollectGameLoginUnique record);

    CollectGameLoginUnique selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CollectGameLoginUnique record);

    int updateByPrimaryKey(CollectGameLoginUnique record);
}