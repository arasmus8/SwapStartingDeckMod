package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.red.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Berserker extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(Berserker.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "red/skill/limit_break";

    public Berserker() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        masterDeck.addToTop(new Anger());
        masterDeck.addToTop(new Anger());
        masterDeck.addToTop(new TwinStrike());
        masterDeck.addToTop(new TwinStrike());
        masterDeck.addToTop(new Pummel());
        masterDeck.addToTop(new Rage());
        masterDeck.addToTop(new Rage());
        masterDeck.addToTop(new Flex());
        masterDeck.addToTop(new Flex());
    }
}
