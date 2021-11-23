package edu.kh.uitest.ex;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example04 {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
						   "C:/tools/selenium/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		// 네이버 홈페이지 -> 로그인 페이지 -> 로그인
		// 네이버는 자동 로그인 방지 상태이기 때문에 로그인이 되지 않음
		// 테스트 시 아이디랑 비밀번호는 아무거나 입력
		
		driver.get("https://www.naver.com");
		
		List<WebElement> btns = driver.findElements(By.className("link_login"));
		
		if(btns.size() == 1) {
			btns.get(0).click(); // 로그인 페이지 이동
		}
		
		// id, pw input 요소를 얻어와 저장
		WebElement id = driver.findElement(By.id("id"));
		WebElement pw = driver.findElement(By.id("pw"));
		
		// id, pw에 값 전달
		id.sendKeys("test1234");
		pw.sendKeys("xptmxm!123");
		
		// pw 입력 완료 후 제출(submit) 이벤트 발생
		//pw.submit();
		
		// 로그인 버튼 요소를 얻어와 클릭
		driver.findElement(By.id("log.login")).click();
		
	}
}



