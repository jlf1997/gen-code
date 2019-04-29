package com.cecii.util;

import com.cecii.common.Page;
import com.github.pagehelper.PageInfo;

public class PageUtils {

	public static Page buildPage(PageInfo pageInfo) {
		Page page = null;
		if(null != pageInfo) {
			page = new Page();
			page.setList(pageInfo.getList());
			page.setPageNo(pageInfo.getPageNum());
			page.setPages(pageInfo.getPages());
			page.setPageSize(pageInfo.getPageSize());
			page.setTotal(pageInfo.getTotal());
		}
		return page;
	}
}
