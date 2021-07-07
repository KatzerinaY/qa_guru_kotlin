package pages

import com.codeborne.selenide.Condition
import components.CalendarComponent
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.open
import io.qameta.allure.Allure.step
import io.qameta.allure.Allure.StepContext

class RegistrationPage {

    private var calendar = CalendarComponent()

    fun openPage() : RegistrationPage {
        open("https://demoqa.com/automation-practice-form")
        element(".practice-form-wrapper").shouldHave(Condition.text("Student Registration Form"))
        return this
    }

    fun fillFirstName (firstName: String): RegistrationPage {
        element("#firstName").value = firstName
        return this
    }

    fun fillLastName  (lastName: String): RegistrationPage {
        element("#lastName").value = lastName
        return this
    }

    fun fillUserEmail (userEmail: String): RegistrationPage  {
        element("#userEmail").value = userEmail
        return this
    }

    fun fillGender (gender: String): RegistrationPage  {
        element("#genterWrapper").find(Selectors.byText(gender)).click()
        return this
    }

    fun fillUserNumber(userNumber: String) : RegistrationPage{
        element("#userNumber").value = userNumber
        return this
    }

    fun fillSubjects(subjectsInput1: String, subjectsInput2: String) : RegistrationPage{
        element("#subjectsInput").setValue(subjectsInput1).pressEnter()
        element("#subjectsInput").setValue(subjectsInput2).pressEnter()
        return this
    }

    fun fillHobbies() : RegistrationPage{
        element("[for=hobbies-checkbox-2]").click() //Reading
        element("[for=hobbies-checkbox-3]").click() //Music
        return this
    }

    fun fillAddress(currentAddress: String): RegistrationPage {
        element("#currentAddress").value = currentAddress
        return this
    }

    fun uploadPicture(uploadPicture: String) : RegistrationPage{
        element("#uploadPicture").uploadFromClasspath(uploadPicture)
        return this
    }

    fun fillBirthday(dateDay: String, dateMonth: String, dateYear: String): RegistrationPage {
        calendar.dateChange(dateDay, dateMonth, dateYear, "#dateOfBirthInput")
        return this
    }

    fun fillStateAndCity(state: String, city: String): RegistrationPage {
        step("Fill state and city") { _: StepContext ->
            element("#state").scrollTo()
            element("#state").click()
            element(Selectors.byText(state)).click()
            element("#city").click()
            element(Selectors.byText(city)).click()
        }
            return this
    }

    fun submit() : RegistrationPage{
        element("[id=submit]").click()
        return this
    }
}