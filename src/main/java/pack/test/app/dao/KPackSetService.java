package pack.test.app.dao;

import pack.test.app.model.KPackSet;

import java.util.List;

public interface KPackSetService {

    int save(KPackSet kPackSet);

    int delete(int id);

    KPackSet get(int id);

    List<KPackSet> getAll();
}
