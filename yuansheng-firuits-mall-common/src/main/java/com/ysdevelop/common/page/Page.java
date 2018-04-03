package com.ysdevelop.common.page;

import java.util.List;

/**
 * 
 * @author HuangHang
 * 
 * 
 * @date 2017/4/7
 * 
 *       分页接口
 * 
 * 
 * @param <E>
 * 
 *            分页接口
 * 
 */

public interface Page<E> extends Iterable<E> {

	/**
	 * 起始分页
	 * 
	 * @return
	 * 
	 * 
	 */

	int getFirstPageNum();

	/**
	 * 终止分页
	 * 
	 * @return
	 * 
	 * 
	 */

	int getLastPageNum();

	/**
	 * 当前页号
	 * 
	 * @return
	 * 
	 * 
	 */

	int getPageNum();

	/**
	 * 页面尺寸
	 * 
	 * @return
	 * 
	 * 
	 */
	int getPageSize();

	/**
	 * 页面上的内容
	 * 
	 * @return
	 * 
	 * 
	 */

	List<E> getItems();

	/**
	 * 是第一页
	 * 
	 * @return
	 * 
	 */
	boolean isFirstPage();

	/**
	 * 到最后一页
	 * 
	 * @return
	 * 
	 */

	boolean isLastPage();

	/**
	 * 是否为空
	 * 
	 * @return
	 */

	boolean isEmpty();

}
