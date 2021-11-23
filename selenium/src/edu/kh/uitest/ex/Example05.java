package edu.kh.uitest.ex;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example05 {
	public static void main(String[] args) {
		// 구글 홈페이지 -> "KH정보교육원" 검색
		// -> 제일 위 검색 결과를 선택 -> KH정보교육원 홈페이지 접속

		System.setProperty("webdriver.chrome.driver", 
							"C:/tools/selenium/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		
		// 구글 홈페이지 이동
		driver.get("https://www.google.com");
		
		// 검색창 요소 얻어오기
		//List<WebElement> inputList = driver.findElements(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input"));
		/*List<WebElement> inputList = driver.findElements(By.className("gLFyf"));
		System.out.println(inputList.size());
		if(inputList.size() == 1) {
			inputList.get(0).sendKeys("KH정보교육원");
		}*/
		
		
		WebElement input = driver.findElement(By.className("gLFyf")); // 첫 번째 요소만 얻어오기
		input.sendKeys("KH정보교육원"); // input 태그에 값 전달
		
		input.submit(); // 제출 이벤트 발생
		
		// 검색 결과 중 첫 번째를 찾아서 클릭
		String cssSelector = "#rso > div:nth-child(1) > div > div > div > div > div > div.yuRUbf > a > h3";
		
		WebElement first = driver.findElement(By.cssSelector(cssSelector));
		first.click();

		
		try {
			Thread.sleep(5000); // 현재 메소드(메인 메소드)가 동작 중인 스레드를 5초간 정지
			
			driver.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
