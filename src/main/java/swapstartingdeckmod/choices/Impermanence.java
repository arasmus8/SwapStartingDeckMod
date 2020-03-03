package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.red.Carnage;
import com.megacrit.cardcrawl.cards.red.FeelNoPain;
import com.megacrit.cardcrawl.cards.red.GhostlyArmor;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Impermanence extends AbstractDeckSwapChoice {

// TEXT DECLARATION

    public static final String ID = SwapStartingDeckMod.makeID(Impermanence.class.getSimpleName());
    private static final CardStrings CARD_STRINGS = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = "red/skill/ghostly_armor";

    public Impermanence() {
        super(ID, IMG, CARD_STRINGS.NAME, CARD_STRINGS.DESCRIPTION);
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();
        CardGroup masterDeck = AbstractDungeon.player.masterDeck;
        masterDeck.addToTop(new Carnage());
        masterDeck.addToTop(new Carnage());
        masterDeck.addToTop(new Carnage());
        masterDeck.addToTop(new Carnage());
        masterDeck.addToTop(new GhostlyArmor());
        masterDeck.addToTop(new GhostlyArmor());
        masterDeck.addToTop(new GhostlyArmor());
        masterDeck.addToTop(new GhostlyArmor());
        masterDeck.addToTop(new GhostlyArmor());
        masterDeck.addToTop(new FeelNoPain());
    }
}
