package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.green.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Ninja extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(Ninja.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "green/skill/blur";

    public Ninja() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        masterDeck.addToTop(new QuickSlash());
        masterDeck.addToTop(new QuickSlash());
        masterDeck.addToTop(new QuickSlash());
        masterDeck.addToTop(new QuickSlash());
        masterDeck.addToTop(new QuickSlash());
        masterDeck.addToTop(new Blur());
        masterDeck.addToTop(new DodgeAndRoll());
        masterDeck.addToTop(new DodgeAndRoll());
        masterDeck.addToTop(new DodgeAndRoll());
        masterDeck.addToTop(new DodgeAndRoll());
    }
}
