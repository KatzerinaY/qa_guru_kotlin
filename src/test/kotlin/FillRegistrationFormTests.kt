import pages.RegistrationPage
import assertions.RegistrationConfirmationForm
import java.text.SimpleDateFormat
import com.github.javafaker.Faker
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.Test
import java.util.*
import io.qameta.allure.Allure.step
import io.qameta.allure.Allure.StepContext

import io.qameta.allure.selenide.AllureSelenide
import com.codeborne.selenide.logevents.SelenideLogger

class FillRegistrationFormTests : TestBase() {

    private var regPage = RegistrationPage()
    private var regModForm = RegistrationConfirmationForm()
    private var formatterMonth = SimpleDateFormat("MMMM", Locale.ENGLISH)
    private var formatterDay = SimpleDateFormat("dd", Locale.ENGLISH)
    private var formatterYear = SimpleDateFormat("yyyy", Locale.ENGLISH)

    var faker = Faker()
    var birthday: Date = faker.date().birthday(16, 20)

    var firstName: String = faker.name().firstName()
    var lastName : String = faker.name().lastName()
    var gender = "Other"
    var userEmail: String = faker.internet().emailAddress()
    var userNumber: String = faker.number().digits(10)
    var dateMonth: String = formatterMonth.format(birthday)
    var dateYear: String = formatterYear.format(birthday)
    var dateDay: String = formatterDay.format(birthday)

    var subjectsInput1 = "Biology"
    var subjectsInput2 = "Physics"
    var currentAddress: String = faker.address().fullAddress()
    var uploadPicture = "kater.jpg"
    var state = "NCR"
    var city = "Delhi"

    @Test
    fun selenideSearchTest() {

        SelenideLogger.addListener("allure", AllureSelenide())

        step("Open page with registration form") {_: StepContext ->
            regPage.openPage()
        }


        step("Fill students registration form"){_: StepContext ->
        regPage.fillFirstName(firstName)
            .fillLastName(lastName)
            .fillUserEmail(userEmail)
            .fillGender(gender)
            .fillUserNumber(userNumber)
            .fillSubjects(subjectsInput1, subjectsInput2)
            .fillHobbies()
            .fillAddress(currentAddress)
            .uploadPicture(uploadPicture)
            .fillBirthday(dateDay, dateMonth, dateYear)
            .fillStateAndCity(state, city)
        }

        Selenide.sleep(3000)

        step("button: Submit registration form") {_: StepContext ->
            regPage.submit()
        }

        step("Check students registration form") {_: StepContext ->
        regModForm.checkName(firstName, lastName)
            .checkGender(gender)
            .checkEmail(userEmail)
            .checkMobile(userNumber)
            .checkDateBirth(dateDay, dateMonth, dateYear)
            .checkSubjects(subjectsInput1, subjectsInput2)
            .checkHobbies("Reading, Music")
            .checkPicture(uploadPicture)
            .checkAddress(currentAddress)
            .checkStateCity(state, city)
        }

        Selenide.sleep(3000)
    }
}