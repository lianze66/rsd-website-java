package org.rsd.service.impl;

import org.rsd.bean.SysFunction;
import org.rsd.mapper.ISysFunctionMapper;
import org.rsd.service.ISysFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysFunctionServiceImpl implements ISysFunctionService {

    @Autowired
    private ISysFunctionMapper sysFunctionMapper;

    @Override
    public List<SysFunction> treeList() {
        List<SysFunction> list = sysFunctionMapper.getListByParentId(0);
        buildTree(list);
        return list;
    }

    private void buildTree(List<SysFunction> list) {
        if (list != null && !list.isEmpty()) {
            for (SysFunction sysFunction : list) {
                List<SysFunction> childList = sysFunctionMapper.getListByParentId(sysFunction.getId());
                if (childList != null && !childList.isEmpty()) {
                    sysFunction.setChildList(childList);
                    buildTree(childList);
                }
            }
        }
    }
}
