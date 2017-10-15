package com.fap.Every_Beginning.Core;

import com.fap.Every_Beginning.Graphics.World.Level;
import com.fap.Every_Beginning.Graphics.World.LevelWorld;

public class Keeper {

    public static Level createWordl(String path) {
        return(new LevelWorld("/Level/LevelStart.png"));
    }
}
