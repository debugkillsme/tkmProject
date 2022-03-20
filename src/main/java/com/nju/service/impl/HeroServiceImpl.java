package com.nju.service.impl;

import java.util.List;

import com.nju.dao.HeroDao;
import com.nju.dao.impl.HeroDaoImpl;
import com.nju.entity.Hero;
import com.nju.service.HeroService;

public class HeroServiceImpl implements HeroService {
	HeroDao heroDao=new HeroDaoImpl();
	
	@Override
	public List<Hero> getAllHero() {
		
		return heroDao.getAllHero();
	}

	@Override
	public Hero getHeroByHid(int hid) {
		return heroDao.getHeroByHid(hid);
	}

	@Override
	public int updateHeroByHid(Hero hero) {
		return heroDao.updateHeroByHid(hero);
	}

	@Override
	public int delHeroByHid(int hid) {
		return heroDao.delHeroByHid(hid);
	}

	@Override
	public int addHero(Hero hero) {
		return heroDao.addHero(hero);
	}

	@Override
	public List<Hero> getAllHeroByPage(int pageNo, int pageSize) {
		return heroDao.getAllHeroByPage(pageNo, pageSize);
	}

	@Override
	public int getHeroCount() {
		return heroDao.getHeroCount();
	}

	@Override
	public List<Hero> getAllHeroAndFuzzyQuery(int pageNo, int pageSize, StringBuffer condition) {
		return heroDao.getAllHeroAndFuzzyQuery(pageNo, pageSize, condition);
	}

	@Override
	public int getHeroCountByCondition(StringBuffer condition) {
		return heroDao.getHeroCountByCondition(condition);
	}

	@Override
	public String getHeroImgPath(int hid) {
		return heroDao.getHeroImgPath(hid);
	}

}
