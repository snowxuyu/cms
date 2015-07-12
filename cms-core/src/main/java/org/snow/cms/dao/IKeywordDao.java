package org.snow.cms.dao;

import java.util.List;
import org.snow.cms.model.KeyWord;
import org.snow.cms.util.Pager;

public abstract interface IKeywordDao extends IBaseDao<KeyWord>
{
  public abstract void addOrUpdate(String paramString);

  public abstract Pager<KeyWord> findNoUseKeyword();

  public abstract void clearNoUsekeyword();

  public abstract List<KeyWord> listUseKeyword();

  public abstract List<KeyWord> listKeywordByCon(String paramString);

  public abstract List<String> listKeywordStringByCon(String paramString);
}
