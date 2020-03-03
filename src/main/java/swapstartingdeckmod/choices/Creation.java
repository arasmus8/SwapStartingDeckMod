package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.purple.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Creation extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(Creation.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "purple/skill/deceive_reality";

    public Creation() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        masterDeck.addToTop(new CarveReality());
        masterDeck.addToTop(new CarveReality());
        masterDeck.addToTop(new CarveReality());
        masterDeck.addToTop(new CarveReality());
        masterDeck.addToTop(new CarveReality());
        masterDeck.addToTop(new DeceiveReality());
        masterDeck.addToTop(new DeceiveReality());
        masterDeck.addToTop(new DeceiveReality());
        masterDeck.addToTop(new DeceiveReality());
        masterDeck.addToTop(new DeceiveReality());
    }
}
