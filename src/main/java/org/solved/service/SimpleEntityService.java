package org.solved.service;

public interface SimpleEntityService<T> {
    public T create (String name);
    public T find (Long id);
}
