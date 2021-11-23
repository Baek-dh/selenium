package edu.kh.uitest.ex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example06 {
	public static void main(String[] args) {

		// 웹 드라이버 위치 지정
		System.setProperty("webdriver.chrome.driver", 
							"C:/tools/selenium/chromedriver.exe");

		
		// 웹 드라이버 제어 객체 생성
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("http://kh-aclass.xyz:8081/Selenium/exam1/iframeTest.html");
		
		
		// 문제 해결 방법 적용
		driver.switchTo().frame("subIframe");
		
		
		// iframe 내부에 작성된 id input 요소를 얻어와 "test" 값 전달
		WebElement id = driver.findElement(By.id("id"));
		id.sendKeys("test");
		
		WebElement pw = driver.findElement(By.id("password"));
		pw.sendKeys("test");
		
		
		// NoSuchElementException : 요소를 찾지 못해 예외 발생
		
		// 왜????  iframe은 또 다른 HTML 문서를 나타내는 요소로써
		//         완전히 다른 화면에 존재하고 있는 상태이기 때문에 단순 접근 불가능
		
		// 해결 방법 : driver.switchTo().frame("iframe이름");
		//			-> 요소를 검색하기 위한 포커스를 iframe으로 변경
		
		
		// 로그인 버튼을 얻어와 클릭
		// -> id, class 없음 --> 유일한 button --> 태그로 찾기
		
		// By.tagName("button")
		driver.findElement(By.tagName("button")).click();
		
		
		
		
		
		

	}
}
