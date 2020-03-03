package swapstartingdeckmod.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.helpers.PowerTip;
import swapstartingdeckmod.SwapStartingDeckMod;

public class Bellows extends CustomRelic {
    public static final String ID = SwapStartingDeckMod.makeID(Bellows.class.getSimpleName());

    private static final Texture IMG;
    private static final Texture OUTLINE;

    public Bellows() {
        super(ID, IMG, OUTLINE, RelicTier.SPECIAL, LandingSound.FLAT);
        tips.clear();
        tips.add(new PowerTip(this.name, this.description));
        initializeTips();
    }

    @Override
    public void onPlayerEndTurn() {
        if (!AbstractDungeon.player.hand.isEmpty()) {
            addToTop(new ExhaustAction(AbstractDungeon.player.hand.size(), true, true));
        }
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    static {
        ImageMaster.loadRelicImg("Bellows", "bellows.png");
        IMG = ImageMaster.getRelicImg("Bellows");
        OUTLINE = ImageMaster.getRelicOutlineImg("Bellows");
    }
}
