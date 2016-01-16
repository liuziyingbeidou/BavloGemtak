package com.bavlo.counter.commonbeans;

import java.util.ArrayList;
import java.util.List;

import com.bavlo.counter.config.Constant;

/**
 * @Title: ����Counter
 * @ClassName: Page 
 * @Description: ��ҳ
 * @author liuzy
 * @date 2015-9-19 ����11:55:33
 */
public class Page {

	public Page(int start,int limit,int total, List<?> items){
		this.start = start;
		this.total = total;
		this.items = items;
		this.limit = limit;
	}
	
	public Page() {
		limit = Constant.PAGE_SIZE;
		start = 0;
		total = 0;
		items = new ArrayList();
	}

	private int limit;
	private int start;
	private int total;
	
	private List items;
	
	
	public List getItems() {
		return items;
	}
	public void setItems(List items) {
		this.items = items;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * ������ҳ��.
	 */
	public int getTotalPages() {
		if (total == -1)
			return -1;

		int count = total / limit;
		if (total % limit > 0) {
			count++;
		}
		return count;
	}

	/**
	 * �Ƿ�����һҳ.
	 */
	public boolean hasNextPage() {
		return getTotalPages() > start / limit + 1;
	}
	public int getPageNumer() {
		
		if (hasNextPage())
			return start / limit + 1;
		else{
			return start / limit + 1;
		}
			
		
	}
	/**
	 * ��ȡҳ��,��1��ʼ����
	 * @return
	 */
	public int getNextPage() {
		if (hasNextPage())
			return start / limit + 2;
		else
			return start / limit + 1;
	}

	/**
	 * �Ƿ�����һҳ. 
	 */
	public boolean hasPrePage() {
		return start > 0;
	}

	/**
	 * ������ҳ��ҳ��,��Ŵ�1��ʼ.
	 */
	public int getPrePage() {
		if (hasPrePage())
			return start / limit;
		else
			return 1;
	}


	public int getFirstPage() {
		return 1;
	}

	public int getLastPage() {
		return getTotalPages();
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
}
