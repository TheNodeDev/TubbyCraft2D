package tk.tubbygames.tubbycraft;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tk.tubbygames.tubbycraft.utils.Vector2;

public class Player {
    public static Vector2 pos = new Vector2(0,0);
    public static void DrawPlayer(SpriteBatch batch)
    {
        Vector2 Screenpos = new Vector2(
                ((Camera.pos.X)+pos.X)*(GameSettings.TileSize+1),
                ((Camera.pos.Y)+pos.Y)*(GameSettings.TileSize+1)
        );
        batch.draw(
                TubbyAssets.LoadTexture("./tex/player/face.png"),
                Screenpos.X-(0.4f*GameSettings.TileSize),
                Screenpos.Y-(0.4f*GameSettings.TileSize),
                0.8f*GameSettings.TileSize,
                0.8f*GameSettings.TileSize
        );
    }
}
