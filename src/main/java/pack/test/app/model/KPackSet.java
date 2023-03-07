package pack.test.app.model;

import java.util.ArrayList;
import java.util.List;

public class KPackSet {

    private int id;
    private String title;

    private List<KPack> kPacks = new ArrayList<>();

    public KPackSet() {
    }

    public KPackSet(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<KPack> getkPacks() {
        return kPacks;
    }

    public void setkPacks(List<KPack> kPacks) {
        this.kPacks = kPacks;
    }

    public void addKPack(KPack kPack) {
        this.kPacks.add(kPack);
    }
}
