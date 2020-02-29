package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.green.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Acrobat extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(Acrobat.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "green/skill/acrobatics";

    public Acrobat() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        masterDeck.addToTop(new SneakyStrike());
        masterDeck.addToTop(new SneakyStrike());
        masterDeck.addToTop(new Eviscerate());
        masterDeck.addToTop(new Eviscerate());
        masterDeck.addToTop(new GrandFinale());
        masterDeck.addToTop(new Acrobatics());
        masterDeck.addToTop(new Acrobatics());
        masterDeck.addToTop(new Backflip());
        masterDeck.addToTop(new Backflip());
        masterDeck.addToTop(new Prepared());
        masterDeck.addToTop(new Prepared());
    }
}
