package edu.kh.uitest.ex;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example03 {
	public static void main(String[] args) {
		
		// 네이버 로그인
		
		
		// 웹 드라이버 위치 지정
		System.setProperty("webdriver.chrome.driver", 
							"C:/tools/selenium/chromedriver.exe");
		
		
		// 웹 드라이버 제어 객체 생성
		WebDriver driver = new ChromeDriver();
		
		
		// 네이버로 이동
		driver.get("https://www.naver.com");
		
		
		// 1. 클래스를 이용한 로그인 버튼 찾기
		// findElement(By.className("클래스명"))  : 
		//  일치하는 클래스를 가지는 요소 중 첫 번째 요소만 얻어와 WebElement로 반환
		
		// findElements(By.className("클래스명")) : 
		//	일치하는 클래스를 가지는 모든 요소를 얻어와 List<WebElement> 로 반환
		
		//List<WebElement> btns = driver.findElements(By.className("link_login")); 
		
		
		// 2. CSS 선택자를 이용하여 로그인 버튼 찾기
		// -> By.cssSelector("CSS 선택자")
		//List<WebElement> btns = driver.findElements(By.cssSelector("#account > a"));

		
		// 3. xpath를 이용하여 로그인 버튼 찾기
		
	    // xpath :  W3C의 표준으로 XML(Extensible Markup Language)
 		// 			문서의 구조를 통해 경로(Path)위에 지정한 구문을 사용하여 항목을 배치하고 
 		//			처리하는 방법을 기술하는 언어
		
		// -> By.xpath("xpath");
		
		List<WebElement> btns = driver.findElements( By.xpath("//*[@id=\"account\"]/a") );
		// full xpath :  /html/body/div[2]/div[3]/div[3]/div/div[2]/a
		
		
		// 향상된 for문을 이용하여 얻어온 모든 요소에 작성된 내용 얻어오기
		for(WebElement btn : btns) {
			System.out.println( btn.getText() );
		}
		
		System.out.println("link_login 클래스를 가진 요소의 수 : " + btns.size());
		// -> 1개
		
		
		// 만약 얻어온 요소의 개수가 1개인 경우 
		// 0번 인덱스 요소를 선택해서 click() 하기
		if(btns.size() == 1) {
			btns.get(0).click();
		}
		
		
		//driver.close();
		
		
		
	}
}
