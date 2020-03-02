package swapstartingdeckmod.patches;

import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import javassist.CtBehavior;
import swapstartingdeckmod.relics.BloodOffering;

public class BloodOfferingPatch {
    @SpirePatch(
            clz = AbstractMonster.class,
            method = "calculateDamage"
    )
    public static class CalculateDamagePatch {
        @SpireInsertPatch(
                locator = CalcualteDamagePatchLocator.class,
                localvars = {"tmp"}
        )
        public static void Insert(AbstractMonster _instance, int dmg, @ByRef float[] tmp) {
            if (AbstractDungeon.player.hasRelic(BloodOffering.ID)) {
                // double the damage of all enemies
                tmp[0] *= 2;
            }
        }

        private static class CalcualteDamagePatchLocator extends SpireInsertLocator {
            @Override
            public int[] Locate(CtBehavior ctBehavior) throws Exception {
                Matcher finalMatcher = new Matcher.FieldAccessMatcher(Settings.class, "isEndless");
                return LineFinder.findInOrder(ctBehavior, finalMatcher);
            }
        }
    }

    @SpirePatch(
            clz = DamageInfo.class,
            method = "applyPowers"
    )
    public static class DamageInfoApplyPowersPatch {
        @SpireInsertPatch(
                locator = ApplyPowersPatchLocator.class,
                localvars = { "tmp" }
        )
        public static void Insert(DamageInfo _instance, AbstractCreature owner, AbstractCreature target, @ByRef float[] tmp) {
            if (AbstractDungeon.player.hasRelic(BloodOffering.ID)) {
                // double the damage of all enemies
                tmp[0] *= 2;
                if (_instance.base != (int)tmp[0]) {
                    _instance.isModified = true;
                }
            }
        }

        private static class ApplyPowersPatchLocator extends SpireInsertLocator {
            @Override
            public int[] Locate(CtBehavior ctBehavior) throws Exception {
                Matcher finalMatcher = new Matcher.FieldAccessMatcher(Settings.class, "isEndless");
                return LineFinder.findInOrder(ctBehavior, finalMatcher);
            }
        }
    }
}
