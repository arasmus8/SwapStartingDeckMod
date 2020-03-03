package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.blue.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Chaos extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(Chaos.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "blue/skill/chaos";

    public Chaos() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        for (int i=0; i<10; ++i) {
            masterDeck.addToTop(AbstractDungeon.getCard(CardRarity.COMMON).makeCopy());
        }
    }
}
