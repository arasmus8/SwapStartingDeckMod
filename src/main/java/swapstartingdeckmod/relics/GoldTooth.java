package swapstartingdeckmod.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.helpers.PowerTip;
import swapstartingdeckmod.SwapStartingDeckMod;

public class GoldTooth extends CustomRelic {
    public static final String ID = SwapStartingDeckMod.makeID(GoldTooth.class.getSimpleName());

    private static final Texture IMG;
    private static final Texture OUTLINE;

    public GoldTooth() {
        super(ID, IMG, OUTLINE, RelicTier.SPECIAL, LandingSound.MAGICAL);
        tips.clear();
        tips.add(new PowerTip(this.name, this.description));
        initializeTips();
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    static {
        ImageMaster.loadRelicImg("Gold Tooth", "goldTooth.png");
        IMG = ImageMaster.getRelicImg("Gold Tooth");
        OUTLINE = ImageMaster.getRelicOutlineImg("Gold Tooth");
    }
}
