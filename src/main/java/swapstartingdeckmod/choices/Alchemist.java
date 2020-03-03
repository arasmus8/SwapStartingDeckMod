package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.green.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Alchemist extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(Alchemist.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "green/skill/crippling_poison";

    public Alchemist() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        masterDeck.addToTop(new PoisonedStab());
        masterDeck.addToTop(new PoisonedStab());
        masterDeck.addToTop(new PoisonedStab());
        masterDeck.addToTop(new PoisonedStab());
        masterDeck.addToTop(new Deflect());
        masterDeck.addToTop(new Deflect());
        masterDeck.addToTop(new Deflect());
        masterDeck.addToTop(new Deflect());
        masterDeck.addToTop(new DeadlyPoison());
        masterDeck.addToTop(new Alchemize());
    }
}
