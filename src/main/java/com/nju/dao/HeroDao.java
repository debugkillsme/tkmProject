package com.nju.dao;
import java.util.List;

import com.nju.entity.Hero;


public interface HeroDao {
	
		List<Hero> getAllHero();
		Hero getHeroByHid(int hid);
		int updateHeroByHid(Hero hero);
		int delHeroByHid(int hid);
		int addHero(Hero hero);
		
		List<Hero> getAllHeroByPage(int pageNo,int pageSize);
		int getHeroCount();
		//·ÖÒ³+Ä£ºý²éÑ¯
		List<Hero> getAllHeroAndFuzzyQuery(int pageNo,int pageSize,StringBuffer condition);
		
		int getHeroCountByCondition(StringBuffer condition);
		
		String getHeroImgPath(int hid);
}
