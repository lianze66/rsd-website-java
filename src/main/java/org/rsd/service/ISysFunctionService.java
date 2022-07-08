package org.rsd.service;

import org.rsd.bean.SysFunction;

import java.util.List;

public interface ISysFunctionService {
    /**
     * 查多次数据库，得到树型结构
     *
     * @return
     */
    List<SysFunction> treeList();

    /**
     * 查一次数据库，得到树型结构
     * @return
     */
    List<SysFunction> treeList2();

    /**
     * 普通的数据集合
     * @return
     */
    List<SysFunction> queryList();
}
