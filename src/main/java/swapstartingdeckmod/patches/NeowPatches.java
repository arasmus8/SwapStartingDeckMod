package swapstartingdeckmod.patches;

import basemod.ReflectionHacks;
import com.badlogic.gdx.math.MathUtils;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.RoomEventDialog;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.neow.NeowEvent;
import com.megacrit.cardcrawl.neow.NeowReward;
import javassist.CtBehavior;
import swapstartingdeckmod.SwapStartingDeckMod;
import swapstartingdeckmod.relics.*;

import java.util.ArrayList;

import static swapstartingdeckmod.patches.CustomNeowRewardDrawback.*;
import static swapstartingdeckmod.patches.CustomNeowRewardType.SWAP_STARTING_DECK;
import static swapstartingdeckmod.util.SwapOptionsHelper.getChoices;

public class NeowPatches {
    private static final CharacterStrings characterStrings = CardCrawlGame.languagePack.getCharacterString("swapstartingdeckmod:SwapStartingDeckNeow");
    private static final String[] NEOW_TEXT = characterStrings.TEXT;

    @SuppressWarnings({"unchecked"})
    @SpirePatch(
            clz = NeowEvent.class,
            method = "blessing"
    )
    public static class BlessingPatch {
        @SpireInsertPatch(
                locator = BlessingLocator.class
        )
        public static SpireReturn Insert(NeowEvent _instance) {
            AbstractPlayer.PlayerClass chosenClass = AbstractDungeon.player.chosenClass;
            ArrayList<NeowReward> rewards;
            rewards = (ArrayList<NeowReward>) ReflectionHacks.getPrivate(_instance, NeowEvent.class, "rewards");
            rewards.set(2, new SwapReward());
            return SpireReturn.Continue();
        }

        private static class BlessingLocator extends SpireInsertLocator {
            @Override
            public int[] Locate(CtBehavior ctBehavior) throws Exception {
                Matcher finalMatcher = new Matcher.MethodCallMatcher(RoomEventDialog.class, "clearRemainingOptions");
                return LineFinder.findInOrder(ctBehavior, finalMatcher);
            }
        }
    }

    @SpirePatch(
            clz = NeowReward.class,
            method = "activate"
    )
    public static class NeowRewardActivatePatch {

        public static SpireReturn Prefix(NeowReward _instance) {
            if (_instance.type != SWAP_STARTING_DECK) {
                return SpireReturn.Continue();
            }

            ReflectionHacks.setPrivate(_instance, NeowReward.class, "activated", true);

            if (_instance.drawback == LOSE_HALF_LIFE) {
                AbstractDungeon.player.damage(new DamageInfo(null, AbstractDungeon.player.currentHealth / 2, DamageInfo.DamageType.HP_LOSS));
            } else if (_instance.drawback == LOSE_QUARTER_MAX_LIFE) {
                int maxLifeLoss = (int) ((float) AbstractDungeon.player.maxHealth * 0.25F);
                AbstractDungeon.player.decreaseMaxHealth(maxLifeLoss);
            } else if (_instance.drawback == REDUCE_DRAW) {
                AbstractDungeon.getCurrRoom().spawnRelicAndObtain(Settings.WIDTH / 2f, Settings.HEIGHT / 2f, new CursedMarble());
            } else if (_instance.drawback == REDUCE_HEALING) {
                AbstractDungeon.getCurrRoom().spawnRelicAndObtain(Settings.WIDTH / 2f, Settings.HEIGHT / 2f, new DeadBlossom());
            } else if (_instance.drawback == SUDDEN_DEATH) {
                AbstractDungeon.player.decreaseMaxHealth(AbstractDungeon.player.maxHealth - 1);
            } else if (_instance.drawback == DOUBLE_DAMAGE) {
                AbstractDungeon.getCurrRoom().spawnRelicAndObtain(Settings.WIDTH / 2f, Settings.HEIGHT / 2f, new BloodOffering());
            } else if (_instance.drawback == DOUBLE_ENEMY_HP) {
                AbstractDungeon.getCurrRoom().spawnRelicAndObtain(Settings.WIDTH / 2f, Settings.HEIGHT / 2f, new GoldTooth());
            } else if (_instance.drawback == ETHEREAL_CARDS) {
                AbstractDungeon.getCurrRoom().spawnRelicAndObtain(Settings.WIDTH / 2f, Settings.HEIGHT / 2f, new Bellows());
            }

            AbstractDungeon.cardRewardScreen.chooseOneOpen(getChoices());
            return SpireReturn.Return(null);
        }
    }

    public static class SwapReward extends NeowReward {

        public SwapReward() {
            super(3);
            int drawbackIndex = MathUtils.random(3);
            if (SwapStartingDeckMod.crueltyMode) {
                switch (drawbackIndex) {
                    case 0:
                        drawback = SUDDEN_DEATH;
                        optionLabel = "" + NEOW_TEXT[4];
                        break;
                    case 1:
                        drawback = DOUBLE_DAMAGE;
                        optionLabel = "" + NEOW_TEXT[5];
                        break;
                    case 2:
                        drawback = DOUBLE_ENEMY_HP;
                        optionLabel = "" + NEOW_TEXT[6];
                        break;
                    default:
                        drawback = REDUCE_DRAW;
                        optionLabel = "" + NEOW_TEXT[7];
                }
            } else {
                switch (drawbackIndex) {
                    case 0:
                        drawback = LOSE_HALF_LIFE;
                        int damage = AbstractDungeon.player.currentHealth / 2;
                        optionLabel = "" + NEOW_TEXT[0] + damage + NEOW_TEXT[8];
                        break;
                    case 1:
                        drawback = LOSE_QUARTER_MAX_LIFE;
                        int maxLifeLoss = (int) ((float) AbstractDungeon.player.maxHealth * 0.25F);
                        optionLabel = "" + NEOW_TEXT[1] + maxLifeLoss + NEOW_TEXT[9];
                        break;
                    case 2:
                        drawback = ETHEREAL_CARDS;
                        optionLabel = "" + NEOW_TEXT[2];
                        break;
                    default:
                        drawback = REDUCE_HEALING;
                        optionLabel = "" + NEOW_TEXT[3];
                }
            }
            optionLabel = optionLabel + NEOW_TEXT[10];
            type = SWAP_STARTING_DECK;
        }
    }
}
