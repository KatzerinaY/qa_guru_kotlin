import com.codeborne.selenide.Configuration
import org.junit.jupiter.api.BeforeAll

open class TestBase {
    companion object {
        @BeforeAll
        fun setUp() {
            Configuration.browser = "chrome"
            Configuration.startMaximized = true
        }
    }
}