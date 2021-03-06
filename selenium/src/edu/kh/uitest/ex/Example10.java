package edu.kh.uitest.ex;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example10 {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
						   "C:/tools/selenium/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		// 화면 이동
		driver.get("http://kh-aclass.xyz:8081/Selenium/exam2/formTest.html");
		
		// 각 input 태그 요소를 얻어와 저장
		WebElement userId 		= driver.findElement(By.id("userid"));
		WebElement passwd1 		= driver.findElement(By.id("passwd1"));
		WebElement passwd2 		= driver.findElement(By.id("passwd2"));
		WebElement name 		= driver.findElement(By.id("name"));
		WebElement email 		= driver.findElement(By.id("email"));
		WebElement tel 		 	= driver.findElement(By.id("tel"));
		WebElement birthYear 	= driver.findElement(By.id("birthYear"));
		
		// radio , checkbox는 요소가 여러 개 존재
		// -> name을 이용해서 요소를 찾아 List로 반환 받기
		List<WebElement> schoolList = driver.findElements(By.name("school"));
		List<WebElement> interestList = driver.findElements(By.name("interest"));
		
		
		// 얻어온 요소에 알맞은 값 전달 또는 선택
		userId.sendKeys("User01");
		passwd1.sendKeys("qwer1234!@#");
		passwd2.sendKeys("qwer1234!@#");
		name.sendKeys("유저일");
		email.sendKeys("user01@naver.com");
		tel.sendKeys("01012341234");
		birthYear.sendKeys("1999");
		
		schoolList.get(2).click(); // 학력 선택
		
		interestList.get(0).click(); // 관심분야 선택
		interestList.get(1).click();
		
		
		// driver를 자바스크립트를 사용할 수 있는 형태로 형변환
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("goSubmit()");
		
		// 회원가입 완료 alert로 포커스를 이동해서 확인버튼 누르기
		driver.switchTo().alert().accept();
		
		
		// 회원 가입 시 입력했던 값들 모두 치우기(제거)
		userId.clear();
		passwd1.clear();
		passwd2.clear();
		name.clear();
		email.clear();
		tel.clear();
		birthYear.clear();
		
		// radio, checkbox 는 clear() 불가
		/*for(WebElement school : schoolList) {
			school.clear();
		}
		
		for(WebElement interest : interestList) {
			interest.clear();
		}*/
		
		// reset 버튼 클릭
		String selector = "body > form > fieldset > ul > li:nth-child(10) > button:nth-child(2)";
		driver.findElement(By.cssSelector(selector)).click();
		
		
		
		
	}
}
