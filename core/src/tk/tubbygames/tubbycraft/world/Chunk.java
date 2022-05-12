package tk.tubbygames.tubbycraft.world;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tk.tubbygames.tubbycraft.Camera;
import tk.tubbygames.tubbycraft.GameSettings;
import tk.tubbygames.tubbycraft.TubbyAssets;
import tk.tubbygames.tubbycraft.utils.Vector2;

public class Chunk {
    public TileStack[][] Tiles;
    public Chunk(TileStack[][] tiles)
    {
        this.Tiles = tiles;
    }
    public Chunk()
    {
        this.Tiles = new TileStack[16][16];
    }
    public void DrawChunk(SpriteBatch batch, int cx, int cy)
    {
        for(int x = 0; x < 16; x++)
        {
            for(int y = 0; y < 16; y++)
            {
                boolean isFirst = true;
                String destroyloc = "./tex/tiles/destroy_stage_" + (String.valueOf(Tiles[x][y].GetTopTile().breakAmount*10f).charAt(0)) + ".png";
                Vector2 ScreenPos = new Vector2(
                        ((x * GameSettings.TileSize) + (Camera.pos.X * GameSettings.TileSize) + (cx*(16*GameSettings.TileSize))),
                        ((y * GameSettings.TileSize) + (Camera.pos.Y * GameSettings.TileSize) + (cy*(16*GameSettings.TileSize)))
                );
                String[] Textures = Tiles[x][y].GetTextures();
                for(int i = 0; i < Textures.length; i++)
                {
                    String tex = Textures[i];
                    batch.draw(
                            TubbyAssets.LoadTexture(tex),
                            ScreenPos.X,
                            ScreenPos.Y,
                            GameSettings.TileSize,
                            GameSettings.TileSize
                    );
                    if(isFirst)
                    {

                    }
                    isFirst = false;
                }
            }
        }
    }
}
