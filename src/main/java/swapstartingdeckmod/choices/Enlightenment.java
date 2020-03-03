package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.purple.Brilliance;
import com.megacrit.cardcrawl.cards.purple.Pray;
import com.megacrit.cardcrawl.cards.purple.Prostrate;
import com.megacrit.cardcrawl.cards.purple.ReachHeaven;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Enlightenment extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(Enlightenment.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "purple/skill/worship";

    public Enlightenment() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        masterDeck.addToTop(new ReachHeaven());
        masterDeck.addToTop(new ReachHeaven());
        masterDeck.addToTop(new ReachHeaven());
        masterDeck.addToTop(new ReachHeaven());
        masterDeck.addToTop(new Prostrate());
        masterDeck.addToTop(new Prostrate());
        masterDeck.addToTop(new Prostrate());
        masterDeck.addToTop(new Prostrate());
        masterDeck.addToTop(new Prostrate());
        masterDeck.addToTop(new Pray());
    }
}
