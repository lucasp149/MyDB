package org.solved.domain;

public abstract class GeneralEntity {
    Long id;
    String name;

    public Long getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
