package org.rsd.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.rsd.bean.SysUser;

import java.util.List;

public interface ISysUserMapper {

    @Select("select * from bu_sys_user order by id desc")
    List<SysUser> queryList();

    @Select("select * from bu_sys_user where id=#{id}")
    SysUser getById(Integer id);

    @Insert("insert into bu_sys_user(login_name, password) values(#{loginName}, #{password})")
    void insert(SysUser sysUser);

    @Update("update bu_sys_user set login_name=#{loginName},password=#{password} where id=#{id}")
    void update(SysUser sysUser);

    @Delete("delete from bu_sys_user where id=#{id}")
    void delete(Integer id);
}
