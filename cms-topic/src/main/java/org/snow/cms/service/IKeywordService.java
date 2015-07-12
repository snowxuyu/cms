package org.snow.cms.service;

import java.util.List;
import org.snow.cms.model.KeyWord;
import org.snow.cms.util.Pager;

public abstract interface IKeywordService
{
  public abstract void addOrUpdate(String paramString);

  public abstract List<KeyWord> getKeywordByTimes(int paramInt);

  public abstract List<KeyWord> getMaxTimesKeyword(int paramInt);

  public abstract Pager<KeyWord> findNoUseKeyword();

  public abstract void clearNoUseKeyword();

  public abstract List<KeyWord> listUseKeyword();

  public abstract List<KeyWord> listKeywordByCon(String paramString);

  public abstract List<String> listKeywordStringByCon(String paramString);
}

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-topic\0.0.1-SNAPSHOT\cms-topic-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.service.IKeywordService
 * JD-Core Version:    0.6.2
 */