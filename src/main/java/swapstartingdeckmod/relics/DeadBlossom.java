package swapstartingdeckmod.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.helpers.PowerTip;
import swapstartingdeckmod.SwapStartingDeckMod;
import swapstartingdeckmod.util.TextureLoader;

import static swapstartingdeckmod.SwapStartingDeckMod.makeRelicOutlinePath;
import static swapstartingdeckmod.SwapStartingDeckMod.makeRelicPath;

public class DeadBlossom extends CustomRelic {
    public static final String ID = SwapStartingDeckMod.makeID(DeadBlossom.class.getSimpleName());

    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("DeadFlower.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("DeadFlower.png"));

    public DeadBlossom () {
        super(ID, IMG, OUTLINE, RelicTier.SPECIAL, LandingSound.MAGICAL);
        tips.clear();
        tips.add(new PowerTip(this.name, this.description));
        initializeTips();
    }

    @Override
    public int onPlayerHeal(int healAmount) {
        return MathUtils.round((float)healAmount / 2f);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
