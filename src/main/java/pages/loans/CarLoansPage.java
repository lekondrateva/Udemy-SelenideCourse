package pages.loans;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CarLoansPage {

    private final SelenideElement agreements = $x("//div[contains(text(), 'Agreements')]");

    public CarLoansPage selectAgreementsTab() {
        agreements.shouldBe(Condition.visible).click();
        return this;
    }
}
