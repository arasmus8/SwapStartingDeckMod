package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.blue.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Thunderstruck extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(Thunderstruck.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "blue/skill/zap";

    public Thunderstruck() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        masterDeck.addToTop(new BallLightning());
        masterDeck.addToTop(new BallLightning());
        masterDeck.addToTop(new BallLightning());
        masterDeck.addToTop(new BallLightning());
        masterDeck.addToTop(new ThunderStrike());
        masterDeck.addToTop(new Stack());
        masterDeck.addToTop(new Stack());
        masterDeck.addToTop(new Stack());
        masterDeck.addToTop(new Stack());
        masterDeck.addToTop(new Zap());
    }
}
