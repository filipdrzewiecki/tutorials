package com.drzewiecki.bank.interfaces;

import java.util.List;

public interface ServiceOrm <T, F> {

    T createNew(F form);

    T getByUid(String uid);

    T getById(long id);

    List<T> getAll();
}
