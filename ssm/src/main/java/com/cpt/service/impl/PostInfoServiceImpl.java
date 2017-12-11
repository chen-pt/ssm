package com.cpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cpt.dao.PostInfoDao;
import com.cpt.model.PostInfo;
import com.cpt.service.IPostInfoService;
@Service
public class PostInfoServiceImpl implements IPostInfoService {

	@Resource private PostInfoDao postInfoDao;
	
	@Override
	public List<PostInfo> getLst() {

		return postInfoDao.getLst();
	}

}
