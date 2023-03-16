package pages.telecomunications;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class MobilePhoneTopUpPage extends BasePage {

    private final SelenideElement buttonWallet = $x("//div[contains(text(), 'My wallet')]");
    private final SelenideElement inputPhoneNumber = $x("//input[@data-qa-node='phone-number']");
    private final SelenideElement inputAmount = $x("//input[@data-qa-node='amount']");
    private final SelenideElement buttonTopUp = $x("//button[@data-qa-node='submit']");
    private final SelenideElement inputCardFrom = $x("//input[@data-qa-node='numberdebitSource']");
    private final SelenideElement inputCardExpDate = $x("//input[@data-qa-node='expiredebitSource']");
    private final SelenideElement inputCardCvv = $x("//input[@data-qa-node='cvvdebitSource']");
    private final SelenideElement paymentDetails = $x("//div[@data-qa-node='details']");

    /**
     * Choose a card from the wallet
     */
    public MobilePhoneTopUpPage selectCardFromWallet() {
        buttonWallet.shouldBe(Condition.visible).click();
        return this;
    }

    /**
     * Enter phone number excluding country code
     *
     * @param number phone number
     */
    public MobilePhoneTopUpPage enterPhoneNumber(String number) {
        clearAndType(inputPhoneNumber, number);
        return this;
    }

    /**
     * Enter the amount to top up the balance
     *
     * @param amount the amount to top up
     */
    public MobilePhoneTopUpPage enterAmount(String amount) {
        clearAndType(inputAmount, amount);
        return this;
    }

    /**
     * Enter the number of the card from which the balance will be replenished
     *
     * @param card is a card from which the balance is topped up
     */
    public MobilePhoneTopUpPage enterCard(String card) {
        clearAndType(inputCardFrom, card);
        return this;
    }

    /**
     * Enter an expired date of a card from which the balance is topped up
     *
     * @param date is a card expired date
     */
    public MobilePhoneTopUpPage enterCardExpDate(String date) {
        clearAndType(inputCardExpDate, date);
        return this;
    }

    public MobilePhoneTopUpPage enterCvv(String cvv) {
        clearAndType(inputCardCvv, cvv);
        return this;
    }

    public MobilePhoneTopUpPage submitToTheCard() {
        buttonTopUp.shouldBe(Condition.visible).click();
        return this;
    }

    public MobilePhoneTopUpPage checkPaymentDetailsIsPresent(String text) {
        SelenideElement details = paymentDetails.shouldBe(Condition.visible);
        Assertions.assertEquals(text, details.getText());
        return this;
    }
}
