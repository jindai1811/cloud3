package com.serket.cloud.util;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class Page {
	private Object where;


	private int offset;
	private int limit;
	// 当前页
	private int page = 1;
	// 每页显示的记录数量
	private int rows = 20;
	// 从数据库中查询
	// 总记录数
	private int total;
	// 本页的数据列表
	private List list;

	public void setTotal(int total) {
		int totalPage = (total + rows - 1) / rows;
		// 分页数据合理化
		if (page < 1) {
			page = 1;
		} else if (page > totalPage && totalPage > 0) {
			page = totalPage;
		}
		this.total = total;
	}

	@Override
	public String toString() {
		return "PageView [page=" + page + ", pageSize=" + rows + ", total="
				+ total + ", list=" + list + "]";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@JsonIgnore
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	@JsonProperty("rows")
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	@JsonIgnore
	public Object getWhere() {
		return where;
	}

	public void setWhere(Object where) {
		this.where = where;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.rows=limit;
		this.limit = limit;
	}

	public int getOffset() {

		return offset;
	}

	public void setOffset(int offset) {	this.page=(offset+limit-1)/limit;
		this.offset = offset;
	}
}
