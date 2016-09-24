package com.ricky.base.mapper;

import com.ricky.base.model.entity.Sysuser;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by zhl on 16/9/19.
 */
public interface SysuserMapper extends Mapper<Sysuser> {

    Sysuser selectSysuserByLoginName(String loginName);

    int updateSysuserLoginInfo(Sysuser user);
}
