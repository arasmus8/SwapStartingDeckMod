package swapstartingdeckmod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.daily.mods.AbstractDailyMod;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ModHelper;
import com.megacrit.cardcrawl.neow.NeowEvent;
import com.megacrit.cardcrawl.screens.custom.CustomModeScreen;
import swapstartingdeckmod.SwapDailyMod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static swapstartingdeckmod.util.SwapOptionsHelper.getChoices;

public class CustomModePatches {
    @SpirePatch(
            clz = CustomModeScreen.class,
            method = "initializeMods"
    )
    public static class CustomModeScreenPatch {
        @SpireInsertPatch(
                rloc = 2
        )
        public static void Insert(CustomModeScreen _instance) {
            try {
                Method addModMethod = CustomModeScreen.class.getDeclaredMethod("addDailyMod", String.class, String.class);
                addModMethod.setAccessible(true);
                addModMethod.invoke(_instance, SwapDailyMod.ID, "b");
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @SpirePatch(
            clz = NeowEvent.class,
            method = "dailyBlessing"
    )
    public static class NeowEventPatch {
        public static void Postfix(NeowEvent _instance) {
            if (ModHelper.isModEnabled(SwapDailyMod.ID)) {
                AbstractDungeon.cardRewardScreen.chooseOneOpen(getChoices());
            }
        }
    }

    @SpirePatch(
            clz = ModHelper.class,
            method = "getMod"
    )
    public static class ModHelperGetModPatch {
        public static SpireReturn<AbstractDailyMod> Prefix(String key) {
            if (key.equals(SwapDailyMod.ID)) {
                return SpireReturn.Return(new SwapDailyMod());
            }
            return SpireReturn.Continue();
        }
    }
}
