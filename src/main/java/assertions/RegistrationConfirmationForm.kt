package assertions

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selectors.byText

class RegistrationConfirmationForm {
    private val table = Selenide.element(".table-responsive")

    fun checkName(firstName: String, lastName: String): RegistrationConfirmationForm {
        table.find(byText("Student Name")).sibling(0).shouldHave(Condition.text("$firstName $lastName"))
        return this
    }

    fun checkEmail(userEmail: String): RegistrationConfirmationForm {
        table.find(byText("Student Email")).sibling(0).shouldHave(Condition.text(userEmail))
        return this
    }

    fun checkGender(gender: String): RegistrationConfirmationForm {
        table.find(byText("Gender")).sibling(0).shouldHave(Condition.text(gender))
        return this
    }

    fun checkMobile(userNumber: String): RegistrationConfirmationForm {
        table.find(byText("Mobile")).sibling(0).shouldHave(Condition.text(userNumber))
        return this
    }

    fun checkDateBirth(dateDay: String, dateMonth: String, dateYear: String): RegistrationConfirmationForm {
        table.find(byText("Date of Birth")).sibling(0)
            .shouldHave(Condition.text("$dateDay $dateMonth,$dateYear"))
        return this
    }

    fun checkSubjects(subjectsInput1: String, subjectsInput2: String): RegistrationConfirmationForm {
        table.find(byText("Subjects")).sibling(0)
            .shouldHave(Condition.text("$subjectsInput1, $subjectsInput2"))
        return this
    }

    fun checkHobbies(hobbies: String): RegistrationConfirmationForm {
        table.find(byText("Hobbies")).sibling(0).shouldHave(Condition.text(hobbies))
        return this
    }

    fun checkPicture(uploadPicture: String): RegistrationConfirmationForm {
        table.find(byText("Picture")).sibling(0).shouldHave(Condition.text(uploadPicture))
        return this
    }

    fun checkAddress(currentAddress: String): RegistrationConfirmationForm {
        table.find(byText("Address")).sibling(0).shouldHave(Condition.text(currentAddress))
        return this
    }

    fun checkStateCity(state: String, city: String): RegistrationConfirmationForm {
        table.find(byText("State and City")).sibling(0).shouldHave(Condition.text("$state $city"))
        return this
    }

}