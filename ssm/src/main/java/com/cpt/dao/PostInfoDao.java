package com.cpt.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cpt.model.PostInfo;
@Repository
public interface PostInfoDao {

	public List<PostInfo> getLst();
	
}
