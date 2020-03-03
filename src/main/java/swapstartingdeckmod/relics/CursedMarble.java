package swapstartingdeckmod.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.helpers.PowerTip;
import swapstartingdeckmod.SwapStartingDeckMod;

public class CursedMarble extends CustomRelic {
    public static final String ID = SwapStartingDeckMod.makeID(CursedMarble.class.getSimpleName());

    private static final Texture IMG;
    private static final Texture OUTLINE;

    public CursedMarble() {
        super(ID, IMG, OUTLINE, RelicTier.SPECIAL, LandingSound.CLINK);
        tips.clear();
        tips.add(new PowerTip(this.name, this.description));
        initializeTips();
    }

    @Override
    public void onEquip() {
        AbstractDungeon.player.masterHandSize -= 1;
    }

    @Override
    public void onUnequip() {
        AbstractDungeon.player.masterHandSize += 1;
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    static {
        ImageMaster.loadRelicImg("Runic Sphere", "runicSphere.png");
        IMG = ImageMaster.getRelicImg("Runic Sphere");
        OUTLINE = ImageMaster.getRelicOutlineImg("Runic Sphere");
    }
}
