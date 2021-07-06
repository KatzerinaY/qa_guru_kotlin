package components

import com.codeborne.selenide.Selenide.element

class CalendarComponent {

    fun dateChange(dateDay: String, dateMonth: String, dateYear: String, dataLocator: String) {
        //$("#dateOfBirthInput").click();
        element(dataLocator).click()
        element(".react-datepicker__month-select").selectOption(dateMonth)
        element(".react-datepicker__year-select").selectOption(dateYear)
        element(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", dateDay)).click()
    }
}