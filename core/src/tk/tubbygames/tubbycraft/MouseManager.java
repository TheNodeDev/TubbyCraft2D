package tk.tubbygames.tubbycraft;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MouseManager {
    public static void DrawCrosshair(SpriteBatch batch)
    {
        batch.draw(TubbyAssets.LoadTexture("./tex/gui/Crosshair.png"), Gdx.input.getX()-16, Gdx.graphics.getHeight()-Gdx.input.getY()-16, 32, 32);
    }
    public static void OnClick()
    {
        //Get Tile Co-ords By Mouse
        /*
            X = (Campos + x) * TileSize
            Campos+x = X/TileSize
            x=(X/TileSize)-CamPos
         */

    }
    public static void OnRightClick()
    {
    }
}
