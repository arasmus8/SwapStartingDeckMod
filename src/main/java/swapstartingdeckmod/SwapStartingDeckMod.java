package swapstartingdeckmod;

import basemod.BaseMod;
import basemod.ModLabeledToggleButton;
import basemod.ModPanel;
import basemod.helpers.RelicType;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireConfig;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import swapstartingdeckmod.relics.*;
import swapstartingdeckmod.util.IDCheckDontTouchPls;
import swapstartingdeckmod.util.TextureLoader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

@SpireInitializer
public class SwapStartingDeckMod implements
        PostInitializeSubscriber,
        EditRelicsSubscriber,
        EditStringsSubscriber {
    private static String modID;

    public static SpireConfig config;
    public static boolean crueltyMode = false;

    private static final Logger logger = Logger.getLogger(SwapStartingDeckMod.class.getName());
    private static final String MODNAME = "Swap Starting Deck Mod";
    private static final String AUTHOR = "NotInTheFace";
    private static final String DESCRIPTION = "Replaces Neow's 3rd option with an option to replace your starting deck with a predefined package.";

    public static final String BADGE_IMAGE = "swapstartingdeckmodResources/images/Badge.png";

    public static String makeRelicPath(String resourcePath) {
        return getModID() + "Resources/images/relics/" + resourcePath;
    }

    public static String makeRelicOutlinePath(String resourcePath) {
        return getModID() + "Resources/images/relics/outline/" + resourcePath;
    }

    public SwapStartingDeckMod() {
        logger.info("Subscribe to BaseMod hooks");
        BaseMod.subscribe(this);
        setModID("swapstartingdeckmod");
        logger.info("Done subscribing");
    }

    public static void setModID(String ID) {
        Gson coolG = new Gson();

        InputStream in = SwapStartingDeckMod.class.getResourceAsStream("/IDCheckStringsDONT-EDIT-AT-ALL.json");
        IDCheckDontTouchPls EXCEPTION_STRINGS = coolG.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), IDCheckDontTouchPls.class);
        logger.info("You are attempting to set your mod ID as: " + ID);
        if (ID.equals(EXCEPTION_STRINGS.DEFAULTID)) {
            throw new RuntimeException(EXCEPTION_STRINGS.EXCEPTION);
        } else if (ID.equals(EXCEPTION_STRINGS.DEVID)) {
            modID = EXCEPTION_STRINGS.DEFAULTID;
        } else {
            modID = ID;
        }
        logger.info("Success! ID is " + modID);
    }

    public static String getModID() {
        return modID;
    }

    private static void pathCheck() {
        Gson coolG = new Gson();

        InputStream in = SwapStartingDeckMod.class.getResourceAsStream("/IDCheckStringsDONT-EDIT-AT-ALL.json");
        IDCheckDontTouchPls EXCEPTION_STRINGS = coolG.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), IDCheckDontTouchPls.class);
        String packageName = SwapStartingDeckMod.class.getPackage().getName();
        FileHandle resourcePathExists = Gdx.files.internal(getModID() + "Resources");
        if (!modID.equals(EXCEPTION_STRINGS.DEVID)) {
            if (!packageName.equals(getModID())) {
                throw new RuntimeException(EXCEPTION_STRINGS.PACKAGE_EXCEPTION + getModID());
            }
            if (!resourcePathExists.exists()) {
                throw new RuntimeException(EXCEPTION_STRINGS.RESOURCE_FOLDER_EXCEPTION + getModID() + "Resources");
            }
        }
    }

    @SuppressWarnings("unused")
    public static void initialize() {
        logger.info("========================= Initializing Swap Starting Deck Mod. Hi. =========================");
        SwapStartingDeckMod swapStartingDeckMod = new SwapStartingDeckMod();
        logger.info("========================= /Swap Starting Deck Mod Initialized. Hello World./ =========================");
    }

    @Override
    public void receivePostInitialize() {
        logger.info("Loading badge image and mod options");
        Texture badgeTexture = TextureLoader.getTexture(BADGE_IMAGE);

        logger.info("Adding mod settings");
        try {
            config = new SpireConfig("SwapStartingDeckMod", "swapStartingDeckModConfig");
            config.load();
            crueltyMode = config.getBool("crueltyMode");
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("Done adding mod settings");


        ModPanel panel = new ModPanel();
        // Create the on/off button:
        ModLabeledToggleButton toggleCrueltyModeButton = new ModLabeledToggleButton("Enable Cruelty Mode - Drawbacks are extra severe!",
                350.0f, 700.0f, Settings.CREAM_COLOR, FontHelper.charDescFont,
                crueltyMode,
                panel,
                (label) -> {
                },
                (button) -> {
                    crueltyMode = button.enabled;
                    try {
                        // And based on that boolean, set the settings and save them
                        SpireConfig config = new SpireConfig("SwapStartingDeckMod", "swapStartingDeckModConfig");
                        config.setBool("crueltyMode", crueltyMode);
                        config.save();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        panel.addUIElement(toggleCrueltyModeButton);
        BaseMod.registerModBadge(badgeTexture, MODNAME, AUTHOR, DESCRIPTION, panel);

        logger.info("Done loading badge Image and mod options");
    }

    @Override
    public void receiveEditStrings() {
        logger.info("Beginning to edit strings for mod with ID: " + getModID());
        BaseMod.loadCustomStringsFile(CharacterStrings.class, getModID() + "Resources/localization/eng/SwapStartingDeckMod-Character-Strings.json");
        BaseMod.loadCustomStringsFile(RelicStrings.class, getModID() + "Resources/localization/eng/SwapStartingDeckMod-Relic-Strings.json");
        BaseMod.loadCustomStringsFile(CardStrings.class, getModID() + "Resources/localization/eng/SwapStartingDeckMod-Card-Strings.json");
        logger.info("Done editing strings");
    }

    @Override
    public void receiveEditRelics() {
        logger.info("Adding relics");

        // This adds a relic to the Shared pool. Every character can find this relic.
        BaseMod.addRelic(new Bellows(), RelicType.SHARED);
        BaseMod.addRelic(new BloodOffering(), RelicType.SHARED);
        BaseMod.addRelic(new CursedMarble(), RelicType.SHARED);
        BaseMod.addRelic(new DeadBlossom(), RelicType.SHARED);
        BaseMod.addRelic(new GoldTooth(), RelicType.SHARED);

        // Mark relics as seen (the others are all starters so they're marked as seen in the character file
        UnlockTracker.markRelicAsSeen(Bellows.ID);
        UnlockTracker.markRelicAsSeen(BloodOffering.ID);
        UnlockTracker.markRelicAsSeen(CursedMarble.ID);
        UnlockTracker.markRelicAsSeen(DeadBlossom.ID);
        UnlockTracker.markRelicAsSeen(GoldTooth.ID);
        logger.info("Done adding relics!");
    }

    public static String makeID(String idText) {
        return getModID() + ":" + idText;
    }
}