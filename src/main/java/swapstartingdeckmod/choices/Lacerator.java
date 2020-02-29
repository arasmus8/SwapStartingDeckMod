package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.green.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Lacerator extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(Lacerator.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "green/skill/blade_dance";

    public Lacerator() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        masterDeck.addToTop(new Slice());
        masterDeck.addToTop(new Slice());
        masterDeck.addToTop(new Choke());
        masterDeck.addToTop(new Finisher());
        masterDeck.addToTop(new CloakAndDagger());
        masterDeck.addToTop(new CloakAndDagger());
        masterDeck.addToTop(new BladeDance());
        masterDeck.addToTop(new BladeDance());
        masterDeck.addToTop(new AThousandCuts());
    }
}
