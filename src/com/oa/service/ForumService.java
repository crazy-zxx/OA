package com.oa.service;

import com.oa.base.BaseDao;
import com.oa.entity.Forum;

public interface ForumService extends BaseDao<Forum> {

	/**
	 * 上移，最上面的不能上移
	 * @param id
	 */
	void moveUp(Long id);

	/**
	 * 下移，最下面的不能下移
	 * @param id
	 */
	void moveDown(Long id);

}
