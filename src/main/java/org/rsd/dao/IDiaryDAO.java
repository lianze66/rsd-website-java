package org.rsd.dao;

import org.rsd.bean.Diary;

import java.util.List;

public interface IDiaryDAO {

    List<Diary> queryList();

    Diary getById(Integer id);

    void insert(Diary diary);

}
