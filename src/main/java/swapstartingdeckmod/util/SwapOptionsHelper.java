package swapstartingdeckmod.util;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import swapstartingdeckmod.SwapStartingDeckMod;
import swapstartingdeckmod.choices.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class SwapOptionsHelper {
    public static ArrayList<AbstractCard> getChoices() {
        ArrayList<AbstractCard> choices = new ArrayList<>();
        switch (AbstractDungeon.player.getCardColor()) {
            case RED:
                choices.add(new Berserker());
                choices.add(new Uproar());
                choices.add(new Fortification());
                choices.add(new Impermanence());
                choices.add(new Pyromancer());
                break;
            case GREEN:
                choices.add(new Acrobat());
                choices.add(new Lacerator());
                choices.add(new Alchemist());
                choices.add(new Strategist());
                choices.add(new Ninja());
                break;
            case BLUE:
                choices.add(new Battery());
                choices.add(new IceAge());
                choices.add(new Thunderstruck());
                choices.add(new RogueAI());
                choices.add(new Technologist());
                break;
            case PURPLE:
                choices.add(new Dancer());
                choices.add(new Visionary());
                choices.add(new NorthStar());
                choices.add(new Enlightenment());
                choices.add(new Creation());
                break;
        }
        Collections.shuffle(choices);
        ArrayList<AbstractCard> finalChoices = choices.stream().limit(2).collect(Collectors.toCollection(ArrayList::new));
        if (SwapStartingDeckMod.insanityMode) {
            finalChoices.add(new Insanity());
        } else {
            finalChoices.add(new Chaos());
        }
        return finalChoices;
    }
}
