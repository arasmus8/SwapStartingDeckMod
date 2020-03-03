package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.blue.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Technologist extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(Technologist.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "blue/skill/forcefield";

    public Technologist() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        masterDeck.addToTop(new Rebound());
        masterDeck.addToTop(new Rebound());
        masterDeck.addToTop(new Rebound());
        masterDeck.addToTop(new Rebound());
        masterDeck.addToTop(new ForceField());
        masterDeck.addToTop(new ForceField());
        masterDeck.addToTop(new ForceField());
        masterDeck.addToTop(new ForceField());
        masterDeck.addToTop(new WhiteNoise());
        masterDeck.addToTop(new HelloWorld());
    }
}
