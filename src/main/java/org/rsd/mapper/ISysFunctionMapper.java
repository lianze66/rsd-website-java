package org.rsd.mapper;

import org.apache.ibatis.annotations.Select;
import org.rsd.bean.SysFunction;

import java.util.List;

public interface ISysFunctionMapper {

    @Select("select * from bu_sys_function where parent_id=#{parentId}")
    List<SysFunction> getListByParentId(Integer parentId);

    @Select("select * from bu_sys_function")
    List<SysFunction> list();
}
