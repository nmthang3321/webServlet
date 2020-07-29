package com.nmthang.page;

import com.nmthang.sorter.Sorter;

public class PageRequest implements IPageRequest{
	
	private int visiblePage;
	private int curentPage;
	private Sorter soter;
	
	public PageRequest(int visiblePage, int curentPage, Sorter sorter) {
		this.visiblePage = visiblePage;
		this.curentPage = curentPage;
		this.soter = sorter;
	}

	@Override
	public int maxLimit() {
		return visiblePage;
	}

	@Override
	public int minLimit() {
		return (this.curentPage - 1) * this.visiblePage;
	}

	public Sorter getSoter() {
		return soter;
	}

	public void setSoter(Sorter soter) {
		this.soter = soter;
	}

	public int getCurentPage() {
		return curentPage;
	}

	public void setCurentPage(int curentPage) {
		this.curentPage = curentPage;
	}

	public int getVisiblePage() {
		return visiblePage;
	}

	public void setVisiblePage(int visiblePage) {
		this.visiblePage = visiblePage;
	}


}
