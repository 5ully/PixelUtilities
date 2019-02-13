package com.EmosewaPixel.PixelUtils.Mods;

import erogenousbeef.bigreactors.api.registry.Reactants;
import erogenousbeef.bigreactors.api.registry.ReactorConversions;

public class ExtremeReactors {
    public static String iskallium = "iskallium";
    public static String depleted_iskallium = "depleted_iskallium";

    public static void init() {
        Reactants.registerReactant(iskallium, 0, 0x71d52d);
        Reactants.registerReactant(depleted_iskallium, 1, 0xb2c8a4);

        Reactants.registerSolid("ingotIskallium", iskallium);
        Reactants.registerSolid("ingotDepletedIskallium", depleted_iskallium);

        ReactorConversions.register(iskallium, depleted_iskallium, 1.25F, 1);
    }
}
