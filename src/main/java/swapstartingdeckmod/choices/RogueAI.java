package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.blue.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class RogueAI extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(RogueAI.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "blue/skill/reprogram";

    public RogueAI() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        masterDeck.addToTop(new Claw());
        masterDeck.addToTop(new Claw());
        masterDeck.addToTop(new Claw());
        masterDeck.addToTop(new Claw());
        masterDeck.addToTop(new RipAndTear());
        masterDeck.addToTop(new Reprogram());
        masterDeck.addToTop(new SteamBarrier());
        masterDeck.addToTop(new SteamBarrier());
        masterDeck.addToTop(new SteamBarrier());
        masterDeck.addToTop(new SteamBarrier());
    }
}
