package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.purple.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Visionary extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(Visionary.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "purple/skill/third_eye";

    public Visionary() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        masterDeck.addToTop(new CutThroughFate());
        masterDeck.addToTop(new CutThroughFate());
        masterDeck.addToTop(new CutThroughFate());
        masterDeck.addToTop(new CutThroughFate());
        masterDeck.addToTop(new ThirdEye());
        masterDeck.addToTop(new ThirdEye());
        masterDeck.addToTop(new ThirdEye());
        masterDeck.addToTop(new ThirdEye());
        masterDeck.addToTop(new Omniscience());
        masterDeck.addToTop(new Nirvana());
    }
}
