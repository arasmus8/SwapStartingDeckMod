package swapstartingdeckmod.choices;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class AbstractDeckSwapChoice extends AbstractCard {

    public AbstractDeckSwapChoice(String id, String img, String name, String description) {
        super(id, name, img, -2, description, AbstractCard.CardType.STATUS, AbstractCard.CardColor.COLORLESS, AbstractCard.CardRarity.SPECIAL, AbstractCard.CardTarget.NONE);
    }

    @Override
    public AbstractCard makeCopy() {
        try {
            return (AbstractCard)this.getClass().newInstance();// 52
        } catch (IllegalAccessException | InstantiationException var2) {// 53
            throw new RuntimeException("BaseMod failed to auto-generate makeCopy for card: " + this.cardID);// 54
        }
    }

    @Override
    public void onChoseThisOption() {
        ArrayList<AbstractCard> basicCards = AbstractDungeon.player.masterDeck.group.stream()
                .filter(card -> card.rarity == CardRarity.BASIC)
                .collect(Collectors.toCollection(ArrayList::new));
        basicCards.forEach(card -> AbstractDungeon.player.masterDeck.removeCard(card));
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) { }

    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        return false;
    }

    @Override
    public boolean canUpgrade() {
        return false;
    }

    @Override
    public void upgrade() { }
}
