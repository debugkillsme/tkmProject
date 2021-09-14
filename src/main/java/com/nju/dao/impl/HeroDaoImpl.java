package com.nju.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nju.dao.HeroDao;
import com.nju.entity.Hero;
import com.nju.util.BaseDao;

public class HeroDaoImpl extends BaseDao implements HeroDao {

	@Override
	public List<Hero> getAllHero() {
		String sql="select hid,hname,hborndate from hero";
		ResultSet rs=this.getDataByAny(sql);
		List<Hero> list=new ArrayList<Hero>();
		try {
			while(rs.next()) {
				Hero hero =new Hero();
				hero.setHid(rs.getInt(1));
				hero.setHname(rs.getString("hname"));
				hero.setHborndate(rs.getDate("hborndate"));
				list.add(hero);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Hero getHeroByHid(int hid) {
		String sql="select * from hero where hid=?";
		ResultSet rs=this.getDataByAny(sql, hid);
		Hero hero=null;
				
		try {
			while(rs.next()) {
				hero =new Hero();
				hero.setHid(rs.getInt(1));
				hero.setHname(rs.getString("hname"));
				hero.setHborndate(rs.getDate("hborndate"));
				hero.setImgpath("imgpath");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return hero;
	}

	@Override
	public int updateHeroByHid(Hero hero) {
		String sql="update hero set hname=?,hborndate=?,imgpath=? where hid=?";
		return this.modifyData(sql, hero.getHname(),hero.getHborndate(),hero.getImgpath(),hero.getHid());
		
	}

	@Override
	public int delHeroByHid(int hid) {
		String sql="delete from hero where hid=?";
		return this.modifyData(sql,hid);
	}

	@Override
	public int addHero(Hero hero) {
		String sql="insert into hero(hname,hborndate,imgpath) values(?,?,?)";
		return this.modifyData(sql,hero.getHname(),hero.getHborndate(),hero.getImgpath());
		
	}

	@Override
	public List<Hero> getAllHeroByPage(int pageNo, int pageSize) {
		String sql="select hid,hname,hborndate from hero limit ?,?";
		ResultSet rs=this.getDataByAny(sql,(pageNo-1)*pageSize,pageSize);
		List<Hero> list=new ArrayList<Hero>();
		try {
			while(rs.next()) {
				Hero hero =new Hero();
				hero.setHid(rs.getInt(1));
				hero.setHname(rs.getString("hname"));
				hero.setHborndate(rs.getDate("hborndate"));
				list.add(hero);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getHeroCount() {
		String sql="select count(1) from hero";
		ResultSet rs=this.getDataByAny(sql);
		int count=0;
		try {
			while(rs.next()) {
				count=rs.getInt(1);
				//或者使用count++
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeResource();
		}
		return count;
	}

	@Override
	public List<Hero> getAllHeroAndFuzzyQuery(int pageNo, int pageSize, StringBuffer condition) {
		String sql="select hid,hname,hborndate,imgpath from hero where 1=1"+condition+" limit ?,?";
		ResultSet rs=this.getDataByAny(sql,(pageNo-1)*pageSize,pageSize);
		List<Hero> list=new ArrayList<Hero>();
		try {
			while(rs.next()) {
				Hero hero =new Hero();
				hero.setHid(rs.getInt(1));
				hero.setHname(rs.getString("hname"));
				hero.setHborndate(rs.getDate("hborndate"));
				hero.setImgpath(rs.getString("imgpath"));
				list.add(hero);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeResource();
		}
		return list;
	}

	@Override
	public int getHeroCountByCondition(StringBuffer condition) {
		String sql="select count(1) from hero where 1=1 "+condition;
		ResultSet rs=this.getDataByAny(sql);
		int count=0;
		try {
			while(rs.next()) {
				count=rs.getInt(1);
				//或者使用count++
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeResource();
		}
		return count;
	}

	@Override
	public String getHeroImgPath(int hid) {
		String sql="select imgpath from hero where hid=?";
		ResultSet rs=this.getDataByAny(sql, hid);
		try {
			while(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeResource();
		}
		return null;
	}

}
