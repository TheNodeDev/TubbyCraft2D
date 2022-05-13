package tk.tubbygames.tubbycraft.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tk.tubbygames.tubbycraft.Camera;
import tk.tubbygames.tubbycraft.GameSettings;
import tk.tubbygames.tubbycraft.Player;
import tk.tubbygames.tubbycraft.utils.Vector2;
import tk.tubbygames.tubbycraft.worldgen.WorldGenConfig;
import tk.tubbygames.tubbycraft.worldgen.WorldGenerator;

import java.util.Map;

public class TileManager {
    public static Chunk[][] ChunkMap = new Chunk[8][8];
    public static void SetTileSize(float val)
    {
        if(val > 10 && val <= 128)
            GameSettings.TileSize = (int)val;
    }
    public static void GenerateRandomMap()
    {
        WorldGenConfig config = new WorldGenConfig();
        config.WorldHeight = 128;
        config.WorldWidth = 128;
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
        int ScreenChunkWidth  = (((Gdx.graphics.getWidth() /GameSettings.TileSize))/16) + 1;
        int ScreenChunkHeight = (((Gdx.graphics.getHeight()/GameSettings.TileSize))/16) + 1;
        Vector2 CameraChunkPosition = new Vector2(
                ((-Camera.pos.X)/16f),
                ((-Camera.pos.Y)/16f)
        );
        CameraChunkPosition.X = Math.max(0, CameraChunkPosition.X);
        CameraChunkPosition.Y = Math.max(0, CameraChunkPosition.Y);
        Player.DrawPlayer(batch);
        for(int x = (int) CameraChunkPosition.X; x < Math.min(ScreenChunkWidth + CameraChunkPosition.X, ChunkMap.length); x++)
        {
            for(int y = (int) CameraChunkPosition.Y; y < Math.min(ScreenChunkHeight + CameraChunkPosition.Y, ChunkMap[0].length); y++)
            {
                ChunkMap[x][y].DrawChunk(batch, x, y);
            }
        }
    }
}
