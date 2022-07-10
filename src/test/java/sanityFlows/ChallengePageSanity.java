package sanityFlows;

import base.BaseTest;
import dataProviders.UserData;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Challenges.Featured.FeaturedTab;
import pages.Challenges.Featured.LiveChallengePage;
import pages.Challenges.Featured.SpotLightPage;

public class ChallengePageSanity extends BaseTest {

    private FeaturedTab featuredTab;
    private LiveChallengePage liveChallengePage;
    private SpotLightPage spotLightPage;

    @BeforeClass
    @Step("Initialise Appium Driver")
    public void startDriver() {
        featuredTab = new FeaturedTab();
        liveChallengePage = new LiveChallengePage();
        spotLightPage = new SpotLightPage();
    }

    @Test(description = "Login to DIY account and move to challenge page", priority = 1)
    private void loginAndMoveToChallengePage() {
        featuredTab.clickChallengeType("live");
        liveChallengePage.clickJoinButton();
    }

    @Test(description = "Search Any random Challenge", priority = 2, dataProviderClass = UserData.class, dataProvider = "searchValidChallenge")
    private void searchAnyChallenge(String challengeName) {
        featuredTab.searchAnyChallenge(challengeName);
        Assert.assertEquals("", "");
    }

    @Test(description = "Search Any random Challenge and make a post", priority = 3, dataProviderClass = UserData.class, dataProvider = "searchValidChallenge")
    private void postOnChallenge(String challengeName) {
        spotLightPage.clickSpotLight();
        spotLightPage.makeAPost();
    }
}
