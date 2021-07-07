package components

import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Allure.step
import io.qameta.allure.Allure.StepContext
import io.qameta.allure.selenide.AllureSelenide
import com.codeborne.selenide.logevents.SelenideLogger

class CalendarComponent {

    fun dateChange(dateDay: String, dateMonth: String, dateYear: String, dataLocator: String) {
        SelenideLogger.addListener("allure", AllureSelenide())

        step("Fill students registration form"){s: StepContext ->
            element(dataLocator).click()
            element(".react-datepicker__month-select").selectOption(dateMonth)
            element(".react-datepicker__year-select").selectOption(dateYear)
            element(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)",dateDay)).click()
        }
    }
}