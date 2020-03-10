package swapstartingdeckmod;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.daily.mods.AbstractDailyMod;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.RunModStrings;
import swapstartingdeckmod.util.TextureLoader;

public class SwapDailyMod extends AbstractDailyMod {
    public static final String ID = SwapStartingDeckMod.makeID("SwapStartingDeck");
    private static final RunModStrings strings = CardCrawlGame.languagePack.getRunModString(ID);
    private static Texture IMG;

    public SwapDailyMod() {
        super(ID, strings.NAME, strings.DESCRIPTION, null, true);
        IMG = TextureLoader.getTexture(SwapStartingDeckMod.BADGE_IMAGE);
        img = IMG;
    }
}
