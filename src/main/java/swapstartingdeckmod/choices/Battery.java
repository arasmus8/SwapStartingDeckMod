package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.blue.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Battery extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(Battery.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "blue/skill/double_energy";

    public Battery() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        masterDeck.addToTop(new MeteorStrike());
        masterDeck.addToTop(new MeteorStrike());
        masterDeck.addToTop(new Streamline());
        masterDeck.addToTop(new Streamline());
        masterDeck.addToTop(new Recycle());
        masterDeck.addToTop(new DoubleEnergy());
        masterDeck.addToTop(new DoubleEnergy());
        masterDeck.addToTop(new DoubleEnergy());
        masterDeck.addToTop(new Tempest());
        masterDeck.addToTop(new ReinforcedBody());
    }
}
