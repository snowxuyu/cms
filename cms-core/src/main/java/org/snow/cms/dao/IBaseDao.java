package org.snow.cms.dao;

public abstract interface IBaseDao<T>
{
  public abstract void add(T paramT);

  public abstract void update(T paramT);

  public abstract void delete(Class<T> paramClass, Object paramObject);

  public abstract T load(Class<T> paramClass, Object paramObject);
}
