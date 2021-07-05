import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selectors.byText
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.sleep
import org.junit.jupiter.api.Test
import org.openqa.selenium.By

class TextBoxTests : TestBase() {
    var firstName = "firstName"
    var lastName = "lastName"
    var gender = "Other"
    var userEmail = "userEmail@m.ru"
    var userNumber = "7056314566"
    var subjectsInput1 = "Biology"
    var subjectsInput2 = "Physics"
    var currentAddress = "Delhi 215"
    var uploadPicture = "kater.jpg"
    var state = "NCR"
    var city = "Delhi"
    var dateMonth = "August"
    var dateYear = "1970"
    var dateDay = "19"
    @Test
    fun selenideSearchTest() {
        Selenide.open("https://demoqa.com/automation-practice-form")
        element(".practice-form-wrapper").shouldHave(text("Student Registration Form"))
        element("#firstName").value = firstName
        element("#lastName").value = lastName
        element("#userEmail").value = userEmail
        element("#genterWrapper").find(byText(gender)).click()
        element("#userNumber").value = userNumber
        element("#subjectsInput").setValue(subjectsInput1).pressEnter()
        element("#subjectsInput").setValue(subjectsInput2).pressEnter()
        element("[for=hobbies-checkbox-2]").click() //Reading
        element("[for=hobbies-checkbox-3]").click() //Music
        element("#currentAddress").value = currentAddress
        element("#uploadPicture").uploadFromClasspath(uploadPicture)
        element("#dateOfBirthInput").click()
        element(".react-datepicker__month-select").selectOption(dateMonth)
        element(".react-datepicker__year-select").selectOption(dateYear)
        element(".react-datepicker__month").find(byText(dateDay)).click()
        // CSS [attribute*=value]
        element("#state").scrollTo()
        element("#state").click()
        element(Selectors.byText(state)).click()
        element("#city").click()
        element(Selectors.byText(city)).click()
        sleep(2000)
        element("[id=submit]").click()
        element(
            By.xpath("//td[text()='Student Name']")).parent().shouldHave(text("$firstName $lastName"))

        element(".table-responsive").find(byText("Student Email")).sibling(0)
            .shouldHave(text(userEmail))

        element(".table-responsive").find(byText("Gender")).sibling(0).shouldHave(text(gender))
        element(".table-responsive").find(byText("Mobile")).sibling(0)
            .shouldHave(text(userNumber))
        element(".table-responsive").find(byText("Date of Birth")).sibling(0).shouldHave(
            text(
                "$dateDay $dateMonth,$dateYear"
            )
        )
        element(".table-responsive").find(byText("Subjects")).sibling(0).shouldHave(
            text(
                "$subjectsInput1, $subjectsInput2"
            )
        )
        element(".table-responsive").find(byText("Hobbies")).sibling(0)
            .shouldHave(text("Reading, Music"))
        element(".table-responsive").find(byText("Picture")).sibling(0)
            .shouldHave(text(uploadPicture))
        element(".table-responsive").find(byText("Address")).sibling(0)
            .shouldHave(text(currentAddress))
        element(".table-responsive").find(byText("State and City")).sibling(0).shouldHave(
            text(
                "$state $city"
            )
        )
        sleep(2000)

    }
}