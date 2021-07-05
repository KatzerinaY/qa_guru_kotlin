import com.codeborne.selenide.Condition
import com.codeborne.selenide.Configuration
import org.junit.jupiter.api.BeforeEach
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selectors
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class SearchTests {
    @BeforeEach
    fun openGooglePage() {
        log.info(" @BeforeEach")
        Selenide.open("https://www.google.com/")
    }

    @Test
    fun selenideSearchTest() {
        Selenide.`$`(Selectors.byName("q")).setValue("Selenide").pressEnter()
        Selenide.`$`("#search").shouldHave(Condition.text("selenide.org"))
    }

    @Test
    fun allureSearchTest() {
        Selenide.`$`(Selectors.byName("q")).setValue("Allure testops").pressEnter()
        Selenide.`$`("#search").shouldHave(Condition.text("qameta.io"))
    }

    @AfterEach
    fun closeBrowser() {
        log.info("@AfterEach")
        Selenide.closeWebDriver()
    }

    companion object {
        var log = LoggerFactory.getLogger(SearchTests::class.java)
        @BeforeAll
        fun setUpConfig() {
            log.info("@BeforeAll")
            Configuration.browser = "chrome"
            Configuration.startMaximized = true
        }
    }
}