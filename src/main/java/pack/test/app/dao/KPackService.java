package pack.test.app.dao;

import pack.test.app.model.KPack;

import java.util.List;

public interface KPackService {

    int save(KPack kPack);

    int delete(int id);

    KPack get(int id);

    List<KPack> getAll();
}
