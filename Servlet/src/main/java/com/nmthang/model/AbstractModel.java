package com.nmthang.model;

import java.util.List;

public class AbstractModel <T>{
	private int id;
	private int ids[];
	private int curentPage;
	private String action;
	private String sortBy;
	private int totalItem;
	private List<T> listResult;
	private int visiblePage;
	private String sortName;
	private int totalPage;
	private T resultById;


	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurentPage() {
		return curentPage;
	}

	public void setCurentPage(int curentPage) {
		this.curentPage = curentPage;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public List<T> getListResult() {
		return listResult;
	}

	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}

	public int getVisiblePage() {
		return visiblePage;
	}

	public void setVisiblePage(int visiblePage) {
		this.visiblePage = visiblePage;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public T getResultById() {
		return resultById;
	}

	public void setResultById(T resultById) {
		this.resultById = resultById;
	}

	
}
