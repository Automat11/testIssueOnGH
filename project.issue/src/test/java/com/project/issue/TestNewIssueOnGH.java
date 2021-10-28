package com.project.issue;

import org.testng.annotations.Test;

import com.project.issue.pages.IssuesPage;
import com.project.issue.pages.MainPage;
import com.project.issue.pages.StartPageGitHub;

public class TestNewIssueOnGH extends TestBaseR {
	

	@Test	
	public void getTitleTest() throws InterruptedException {

		StartPageGitHub menu = new StartPageGitHub(this.driver);
		MainPage mpage = new MainPage(this.driver);
		IssuesPage ipage = new IssuesPage(this.driver);
		
		// ---- PARAMETRY TESTOWE ---- 
		String LOGIN_USER = "Automat11";
		String LOGIN_PASS = "TestIssue1#";
		String ISSUE_TITLE = "Nowy tytuł";
		String ISSUE_DESCRIPTION = "Bardzo długi opis";
		String COMMENT = "Długi komentarz do zadania";
		
		// logowanie
		menu.logIn(LOGIN_USER, LOGIN_PASS);
		
		// wybranie projektu z głównego menu i przejście do zakładki Issues
		mpage.pickProjectFromRepoAndGoIssue();	
		
		// założenie nowej sprawy
		ipage.createNewIssue(ISSUE_TITLE, ISSUE_DESCRIPTION);
		
		ipage.addNewComment(COMMENT);
		
		
		ipage.deleteFirstComment();
		
		ipage.assignProjectToYourself();
		
		menu.logOut();
		
		
		
		Thread.sleep(10000);
		
	}
}
