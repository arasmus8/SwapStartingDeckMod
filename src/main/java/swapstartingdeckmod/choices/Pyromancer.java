package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.red.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Pyromancer extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(Pyromancer.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "red/power/fire_breathing";

    public Pyromancer() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        masterDeck.addToTop(new RecklessCharge());
        masterDeck.addToTop(new RecklessCharge());
        masterDeck.addToTop(new WildStrike());
        masterDeck.addToTop(new WildStrike());
        masterDeck.addToTop(new PowerThrough());
        masterDeck.addToTop(new PowerThrough());
        masterDeck.addToTop(new SecondWind());
        masterDeck.addToTop(new SecondWind());
        masterDeck.addToTop(new FireBreathing());
    }
}
