package com.hjl.mapper;

import com.hjl.pojo.Usertable;
import com.hjl.pojo.UsertableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsertableMapper {
    int countByExample(UsertableExample example);

    int deleteByExample(UsertableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usertable record);

    int insertSelective(Usertable record);

    List<Usertable> selectByExample(UsertableExample example);

    Usertable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Usertable record, @Param("example") UsertableExample example);

    int updateByExample(@Param("record") Usertable record, @Param("example") UsertableExample example);

    int updateByPrimaryKeySelective(Usertable record);

    int updateByPrimaryKey(Usertable record);
}