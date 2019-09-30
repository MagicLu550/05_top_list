package net.noyark.top.entity;

public abstract class BaseEntity {

    private int id;

    private String name;

    private String description;

    private int deleted;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
    public void setDeleted(){
        setDeleted(1);
    }

}
