package swapstartingdeckmod.patches;

import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import javassist.CtBehavior;
import swapstartingdeckmod.relics.BloodOffering;
import swapstartingdeckmod.relics.GoldTooth;

public class GoldToothPatches {
    @SpirePatch(
            clz = AbstractMonster.class,
            method = SpirePatch.CONSTRUCTOR,
            paramtypez = { String.class, String.class, int.class, float.class, float.class, float.class, float.class, String.class, float.class, float.class, boolean.class }
    )
    public static class ConstructorPatch {
        @SpireInsertPatch(
                locator = GoldToothConstructorPatchLocator.class
        )
        public static void Insert(AbstractMonster _instance, String name, String id, @ByRef int[] maxHealth, float hb_x, float hb_y, float hb_w, float hb_h, String imfUrl, float offsetX, float offsetY, boolean ignoreBlights) {
            if (AbstractDungeon.player.hasRelic(GoldTooth.ID)) {
                // double the health of all enemies
                maxHealth[0] *= 2;
                _instance.maxHealth = maxHealth[0];
            }
        }

        private static class GoldToothConstructorPatchLocator extends SpireInsertLocator {
            @Override
            public int[] Locate(CtBehavior ctBehavior) throws Exception {
                Matcher finalMatcher = new Matcher.FieldAccessMatcher(Settings.class, "isEndless");
                return LineFinder.findInOrder(ctBehavior, finalMatcher);
            }
        }
    }

    @SpirePatch(
            clz = AbstractMonster.class,
            method = "setHp",
            paramtypez = { int.class, int.class }
    )
    public static class SetHpPatch {
        public static void Postfix(AbstractMonster _instance, int minHp, int maxHp) {
            if (AbstractDungeon.player.hasRelic(GoldTooth.ID)) {
                _instance.currentHealth *= 2;
                _instance.maxHealth = _instance.currentHealth;
            }
        }
    }
}
