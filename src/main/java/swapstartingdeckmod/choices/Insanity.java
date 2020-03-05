package swapstartingdeckmod.choices;

import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Insanity extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(Insanity.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "colorless/skill/madness";

    public Insanity() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        for (int i=0; i<50; ++i) {
            CardRarity randomRarity = CardRarity.COMMON;
            if (MathUtils.randomBoolean(0.1f)) {
                randomRarity = CardRarity.RARE;
            } else if (MathUtils.randomBoolean(0.25f)) {
                randomRarity = CardRarity.UNCOMMON;
            }
            masterDeck.addToTop(AbstractDungeon.getCard(randomRarity).makeCopy());
        }
    }
}
