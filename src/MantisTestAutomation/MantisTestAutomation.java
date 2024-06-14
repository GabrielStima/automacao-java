package MantisTestAutomation;

import java.time.Duration;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MantisTestAutomation {
	@Test
    public void criarTarefa() {
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.get("https://mantis-prova.base2.com.br/");

        driver.findElement(By.name("username")).sendKeys("grupoVermelho");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Report Issue")));
        
        driver.findElement(By.linkText("Report Issue")).click();

        Select categoria = new Select(driver.findElement(By.name("category_id")));
        categoria.selectByVisibleText("[All Projects] categoria teste");

        Select frequencia = new Select(driver.findElement(By.name("reproducibility")));
        frequencia.selectByVisibleText("sometimes");

        Select prioridade = new Select(driver.findElement(By.name("priority")));
        prioridade.selectByVisibleText("low");

        driver.findElement(By.name("summary")).sendKeys("Resumo da tarefa - Final3");
        driver.findElement(By.name("description")).sendKeys("Descrição detalhada da tarefa - Final3");
        driver.findElement(By.name("steps_to_reproduce")).sendKeys("Passos para reproduzir o problema - Final3");
        driver.findElement(By.name("additional_info")).sendKeys("Informações adicionais relevantes - Final3");


        driver.findElement(By.xpath("//input[@value='Submit Issue']")).click();

        WebDriverWait waitS = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitS.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-success")));
        
        WebElement mensagemSucesso = driver.findElement(By.className("alert-success"));
        
        if (mensagemSucesso.isDisplayed()) {
            System.out.println("Tarefa criada com sucesso!");
        } else {
            System.out.println("Erro ao criar tarefa.");
        }

        driver.quit();
    }
}
