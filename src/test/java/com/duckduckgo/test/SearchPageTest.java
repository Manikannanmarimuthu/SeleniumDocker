package com.duckduckgo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.duckduckgo.pages.SearchPage;
import com.qa.test.BaseTest;

public class SearchPageTest extends BaseTest {

	private String keyword;

	@BeforeMethod
	@Parameters({ "keyword" })
	public void setupParameters(String keyword) {
		this.keyword = keyword;
	}

	@Test

	public void search() {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.goTo();
		searchPage.doSearch(keyword);
		searchPage.goToVideos();
		int size = searchPage.getResult();
		Assert.assertTrue(size > 0);
	}

}