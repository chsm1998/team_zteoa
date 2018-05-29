package com.three.zteoa.mapper;

import com.three.zteoa.bean.Emp;
import com.three.zteoa.bean.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface EmpMapper {
    long countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExampleWithRowbounds(EmpExample example, RowBounds rowBounds);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}