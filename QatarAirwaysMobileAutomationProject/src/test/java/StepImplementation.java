
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class StepImplementation extends BaseTest {

    Logger logger = LogManager.getLogger(StepImplementation.class);
    @Step("Uygulamanın Açıldığının Kontrolü Yapılır")
    public void checkIsTheAppOpen() {
        MobileElement element = appiumDriver.findElement(By.id("com.m.qr:id/push_consent_msg_header"));

        if (element.isDisplayed()) {
            Assert.assertTrue("Uygulama Açılmadı!", element.getText().equals("Get notified, never miss an offer!"));
            logger.info("Uygulama Başarılı Şekilde Açıldı");
        } else {
            System.out.println("Element Görünür Değil!");
        }
    }

    @Step("<i> saniye bekle")
    public void waitBySecond(int i) throws InterruptedException {
        Thread.sleep(i * 1000);
    }

    @Step("Location Bildirimi Skip Butonuna Basılarak Geçilir")
    public void AcceptNotifications() {
        appiumDriver.findElement(By.id("com.m.qr:id/skip_button")).click();
    }

    @Step("Karşılama Ekranı Skip Butonuna Basılarak Geçilir")
    public void skipTheEnterance() {
        appiumDriver.findElement(By.id("com.m.qr:id/onboarding_skip_button")).click();
    }

    @Step("Bildirimleri Kabul Etmek için 'Allow' Butonuna Basılır")
    public void allowTheNotifications() {
        appiumDriver.findElement(By.id("com.m.qr:id/push_consent_allow")).click();
    }

    @Step("Ana Menüden 'Book' Tabına Basılır")
    public void selectBookTab() {
        appiumDriver.findElement(By.id("com.m.qr:id/nav_menu_book")).click();
    }

    @Step("Seyahat Tipi 'One Way' Seçilir")
    public void selectTheType() {
        appiumDriver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='One-way']/android.widget.TextView")).click();
    }

    @Step("Kalkış Havaalanı 'Berlin' Seçilir")
    public void pickTheBerlin() {
        appiumDriver.findElement(By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_origin_holder")).click();
        appiumDriver.findElement(By.id("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext")).sendKeys("Berlin");
        appiumDriver.findElement(By.xpath("(//*[@resource-id='com.m.qr:id/rvmp_item_ond_selection_list_iata_code_and_airport_name'])[1]")).click();
    }

    @Step("Varış Havaalanı 'Istanbul' Seçilir")
    public void pickTheIstanbul() {
        appiumDriver.findElement(By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_destination_holder")).click();
        appiumDriver.findElement(By.id("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext")).sendKeys("Istanbul");
        appiumDriver.findElement(By.xpath("(//*[@resource-id='com.m.qr:id/rvmp_item_ond_selection_list_iata_code_and_airport_name'])[1]")).click();
    }

    @Step("Tarih Alanı Seçilir")
    public void pickTheDateArea() {
        appiumDriver.findElement(By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_date_holder_date_text_view")).click();

        new Actions(appiumDriver).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build();

        appiumDriver.findElement(By.id("com.m.qr:id/fragment_calendar_confirm_button")).click();
    }

    @Step("Uçuş Ara")
    public void searchFlight(){
        appiumDriver.findElement(By.id("com.m.qr:id/rvmp_booking_search_flights_button")).click();
    }

    @Step("Uçuş Seçim Ekranı Kontrolü Yapılır")
    public void cheachFlightPage(){
        Assert.assertTrue("Uçuş Ekranı Geldi", appiumDriver.findElement(By.id("com.m.qr:id/snackbar_main_text")).getText().equals("No flights found. Try a different itinerary or search again later."));
        logger.info("Uçuş Ekranı Gelmedi!");
    }

    @Step("Rastegele Uçuş Seçilir")
    public void selectRandomFlight(){
        logger.info("Rastgele Uçuş Seçilemedi!");
    }


}
