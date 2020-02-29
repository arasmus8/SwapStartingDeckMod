package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.red.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Fortification extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(Fortification.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "red/skill/entrench";

    public Fortification() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        masterDeck.addToTop(new IronWave());
        masterDeck.addToTop(new IronWave());
        masterDeck.addToTop(new IronWave());
        masterDeck.addToTop(new IronWave());
        masterDeck.addToTop(new IronWave());
        masterDeck.addToTop(new Entrench());
        masterDeck.addToTop(new Entrench());
        masterDeck.addToTop(new Entrench());
        masterDeck.addToTop(new Entrench());
        masterDeck.addToTop(new Barricade());
    }
}
