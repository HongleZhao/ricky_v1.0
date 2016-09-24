package com.ricky.base.mapper;

import com.ricky.base.model.entity.Authority;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by zhl on 16/9/24.
 */
public interface AuthorityMapper extends Mapper<Authority> {

    List<Authority> selectAuthorityByRoleId(Long roleId);

}
