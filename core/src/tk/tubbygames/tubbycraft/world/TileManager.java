package tk.tubbygames.tubbycraft.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tk.tubbygames.tubbycraft.GameSettings;
import tk.tubbygames.tubbycraft.Player;
import tk.tubbygames.tubbycraft.worldgen.WorldGenConfig;
import tk.tubbygames.tubbycraft.worldgen.WorldGenerator;

public class TileManager {
    public static Chunk[][] ChunkMap = new Chunk[5][5];
    public static void SetTileSize(float val)
    {
        if(val > 10 && val <= 128)
            GameSettings.TileSize = (int)val;
    }
    public static void GenerateRandomMap()
    {
        WorldGenConfig config = new WorldGenConfig();
        config.WorldHeight = 80;
        config.WorldWidth = 80;
        config.BiomeSize = 100;
        config.OreSpawnAmount = 100;
        config.OreSpawnSize = 10;
        config.ForestDensity = 0.5f;
        config.ForestSize = 100;
        config.ForestSpawnAmount = 100;
        ChunkMap = WorldGenerator.GenerateWorld(config);
    }
    public static void DrawToScreen(SpriteBatch batch)
    {
        int ScreenTileWidth = (Gdx.graphics.getWidth()/GameSettings.TileSize)+4;
        int ScreenTileHeight = (Gdx.graphics.getHeight()/GameSettings.TileSize)+2;

        Player.DrawPlayer(batch);
        for(int x = 0; x < ChunkMap.length; x++)
        {
            for(int y = 0; y < ChunkMap[0].length; y++)
            {
                ChunkMap[x][y].DrawChunk(batch, x, y);
            }
        }
    }
}
