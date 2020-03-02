package swapstartingdeckmod.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.helpers.PowerTip;
import swapstartingdeckmod.SwapStartingDeckMod;

public class BloodOffering extends CustomRelic {
    public static final String ID = SwapStartingDeckMod.makeID(BloodOffering.class.getSimpleName());

    private static final Texture IMG;
    private static final Texture OUTLINE;

    public BloodOffering() {
        super(ID, IMG, OUTLINE, RelicTier.SPECIAL, LandingSound.MAGICAL);
        tips.clear();
        tips.add(new PowerTip(this.name, this.description));
        initializeTips();
    }

    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        return super.onAttacked(info, damageAmount);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    static {
        ImageMaster.loadRelicImg("Blood of Gifted", "bloodOfGifted.png");
        IMG = ImageMaster.getRelicImg("Blood of Gifted");
        OUTLINE = ImageMaster.getRelicOutlineImg("Blood of Gifted");
    }
}
