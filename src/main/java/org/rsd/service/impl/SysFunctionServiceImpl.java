package org.rsd.service.impl;

import org.rsd.bean.SysFunction;
import org.rsd.mapper.ISysFunctionMapper;
import org.rsd.service.ISysFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<SysFunction> treeList2() {
        List<SysFunction> allList = sysFunctionMapper.list();
        List<SysFunction> rootList = new ArrayList<>();
        for (SysFunction sysFunction : allList) {
            if (sysFunction.getParentId() == 0) {
                rootList.add(sysFunction);
            }
        }
        buildTree2(allList, rootList);
        return rootList;
    }

    @Override
    public List<SysFunction> queryList() {
        return sysFunctionMapper.list();
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

    private void buildTree2(List<SysFunction> allList, List<SysFunction> list) {
        if (list != null && !list.isEmpty()) {
            for (SysFunction sysFunction : list) {

                List<SysFunction> childList = new ArrayList<>();
                for (SysFunction function : allList) {
                    if (sysFunction.getId() == function.getParentId()) {
                        childList.add(function);
                    }
                }

                if (!childList.isEmpty()) {
                    sysFunction.setChildList(childList);
                    buildTree2(allList, childList);
                }
            }
        }
    }
}
