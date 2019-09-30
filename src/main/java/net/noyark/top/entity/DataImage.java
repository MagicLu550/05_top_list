package net.noyark.top.entity;

public class DataImage extends BaseEntity{

    private String path;

    private int tid;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
