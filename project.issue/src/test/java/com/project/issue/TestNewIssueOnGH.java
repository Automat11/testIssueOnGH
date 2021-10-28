package com.project.issue;

import org.testng.annotations.Test;


import com.project.issue.pages.IssuesPage;
import com.project.issue.pages.MainPage;
import com.project.issue.pages.StartPageGitHub;

/*
 * Klasa <TestNewIssueOnGH> jest klasą testową polegającym na:
 * - zalogowaniu się na stronę GitHub.com na wcześniej założone konto 
 * - wybranie projektu (wcześniej założonego)
 * - założenie nowej sprawy wraz z opisem
 * - dopisaniem nowego komentarza
 * - usunięciem tego komentarza
 * - przypisaniu do siebie tego wątku
 * - wylogowaniu
 * Na każdej stronie znajduje się asercja sprawdzająca poprawne wczytanie strony.
 * 
 */


public class TestNewIssueOnGH extends TestBaseR {
	

	@Test	
	public void testNewIssueOnGH () throws InterruptedException {

		StartPageGitHub menu = new StartPageGitHub(this.driver);
		MainPage mpage = new MainPage(this.driver);
		IssuesPage ipage = new IssuesPage(this.driver);
		
		// ---- PARAMETRY TESTOWE ---- 
		String loginUser = "Automat11";
		String loginPass = "TestIssue1#";
		String issueTitle = "Nowy tytuł";
		String issueDescription = "Bardzo długi opis";
		String COMMENT = "Długi komentarz do zadania";
		// --- KONIEC PARAMETRÓW ---- 
		
		
		// logowanie
		menu.logIn(loginUser, loginPass);
		
		// wybranie projektu z głównego menu i przejście do zakładki Issues
		mpage.pickProjectFromRepoAndGoIssue();	
		
		// założenie nowej sprawy
		ipage.createNewIssue(issueTitle, issueDescription);
		
		ipage.addNewComment(COMMENT);
		
		ipage.deleteFirstComment();
		
		ipage.assignProjectToYourself();
		
		menu.logOut();
	}
}
