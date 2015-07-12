package org.snow.cms.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.snow.cms.dao.IKeywordDao;
import org.snow.cms.model.KeyWord;
import org.snow.cms.util.Pager;
import org.snow.cms.util.PinyinUtil;
import org.springframework.stereotype.Repository;

@Repository("keywordDao")
public class KeywordDaoImpl extends BaseDaoImpl<KeyWord> implements IKeywordDao {

	@Inject
	private SqlSession sqlSession;

	private Map<String, Integer> getExitKeyword2Map() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> allKeys = this.sqlSession.selectList(KeyWord.class
				.getName() + ".search_keyword_from_topic");
		for (String ak : allKeys) {
			String[] ks = ak.split("\\|");
			for (String k : ks) {
				if (!"".equals(k.trim())) {
					if (map.containsKey(k))
						map.put(k, Integer.valueOf(((Integer) map.get(k))
								.intValue() + 1));
					else
						map.put(k, Integer.valueOf(1));
				}
			}
		}
		return map;
	}

	public void addOrUpdate(String name) {
		KeyWord k = (KeyWord) this.sqlSession.selectOne(KeyWord.class.getName()
				+ ".search_keyword_by_name", name);
		if (null == k) {
			k = new KeyWord();
			k.setName(name);
			k.setNameFullPy(PinyinUtil.str2Pinyin(name, null));
			k.setNameShortPy(PinyinUtil.strFirst2Pinyin(name));
			k.setTimes(1);
			add(k);
		} else {
			k.setTimes(k.getTimes() + 1);
			update(k);
		}
	}

	public Pager<KeyWord> findNoUseKeyword() {
		return find(KeyWord.class.getName() + ".find_no_use_keyword", null);
	}

	public void clearNoUsekeyword() {
		this.sqlSession.delete(KeyWord.class.getName()
				+ ".clear_no_use_keyword");
	}

	public List<KeyWord> listUseKeyword() {
		Map<String, Integer> allKeys = getExitKeyword2Map();
		Set<String> keys = allKeys.keySet();
		List<KeyWord> list = new ArrayList<KeyWord>();
		for (String k : keys) {
			list.add(new KeyWord(k, ((Integer) allKeys.get(k)).intValue()));
		}
		Collections.sort(list);
		return list;
	}

	public List<KeyWord> listKeywordByCon(String con) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("con", con);
		return this.sqlSession.selectList(KeyWord.class.getName()
				+ ".list_keyword_by_con", map);
	}

	public List<String> listKeywordStringByCon(String con) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("con", con);
		return this.sqlSession.selectList(KeyWord.class.getName()
				+ ".list_keyword_string_by_con", map);
	}
}
