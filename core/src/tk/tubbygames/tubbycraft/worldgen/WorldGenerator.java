package tk.tubbygames.tubbycraft.worldgen;

import tk.tubbygames.tubbycraft.TubbyCraft;
import tk.tubbygames.tubbycraft.utils.Utils;
import tk.tubbygames.tubbycraft.world.Chunk;
import tk.tubbygames.tubbycraft.world.Tile;
import tk.tubbygames.tubbycraft.world.TileStack;

import java.awt.*;

public class WorldGenerator {
    public static Chunk[][] GenerateWorld(WorldGenConfig config)
    {
        Chunk[][] BuildMap = new Chunk[config.WorldWidth/16][config.WorldHeight/16];
        for(int x = 0; x < config.WorldWidth/16; x++)
        {
            for(int y = 0; y < config.WorldWidth/16; y++)
            {
                Chunk k = new Chunk();
                k.Tiles = new TileStack[16][16];
                for(int tx = 0; tx < 16; tx++)
                {
                    for(int ty = 0; ty < 16; ty++)
                    {
                        Tile[] stack = new Tile[1];
                        stack[0] = new Tile("./tex/tiles/cbbl1.png", false);

                        k.Tiles[tx][ty] = new TileStack(stack);
                    }
                }
                BuildMap[x][y] = k;
            }
        }
        return BuildMap;
    }

    public static Chunk[][] TileMapToChunkMap(TileStack[][] TMap)
    {
        Chunk[][] CMap = new Chunk[TMap.length/16][TMap[0].length/16];
        for( int x = 0; x < TMap.length; x++ )
        {
            for( int y = 0; y < TMap[0].length; y++ )
            {
                CMap[Math.round(x/16)][Math.round(y/16)] = new Chunk();
                CMap[Math.round(x/16)][Math.round(y/16)].Tiles[x%16][y%16] = TMap[x][y];
            }
        }
        return CMap;
    }
    public static Polygon[] GenerateForestBounds(WorldGenConfig config)
    {
        Polygon[] forestPolys = new Polygon[config.ForestSpawnAmount];
        for (int x = 0; x < config.ForestSpawnAmount; x++) {
            forestPolys[x] = new Polygon();
            int xoff = TubbyCraft.rnd.nextInt(config.WorldWidth);
            int yoff = TubbyCraft.rnd.nextInt(config.WorldHeight);
            int sides = 20;
            for (int i = 0; i < sides; i++) {
                int Xpos = (int) (xoff + sides * Math.cos(i * 2 * Math.PI / sides));
                int Ypos = (int) (yoff + sides * Math.sin(i * 2 * Math.PI / sides));
                Xpos += TubbyCraft.rnd.nextInt(50)+25;
                Ypos += TubbyCraft.rnd.nextInt(50)+25;
                forestPolys[x].addPoint(Xpos, Ypos);
            }
        }
        return forestPolys;
    }
    public static OreDeposit[] GenerateOreDeposits(WorldGenConfig config)
    {
        OreDeposit[] deposits = new OreDeposit[config.OreSpawnAmount];
        for (int x = 0; x < config.OreSpawnAmount; x++) {
            deposits[x] = new OreDeposit();
            deposits[x].polygon = new Polygon();
            deposits[x].type = Utils.randomEnum(OreType.class);
            int xoff = TubbyCraft.rnd.nextInt(config.WorldWidth);
            int yoff = TubbyCraft.rnd.nextInt(config.WorldHeight);
            for (int i = 0; i < 6; i++){
                int Xpos = (int) (xoff + 6 * Math.cos(i * 2 * Math.PI / 6));
                int Ypos = (int) (yoff + 6 * Math.sin(i * 2 * Math.PI / 6));
                Xpos += TubbyCraft.rnd.nextInt(config.OreSpawnSize/2)+config.OreSpawnSize/2;
                Ypos += TubbyCraft.rnd.nextInt(config.OreSpawnSize/2)+config.OreSpawnSize/2;
                deposits[x].polygon.addPoint(Xpos, Ypos);
            }
        }
        return deposits;
    }
    /*

        Polygon[] OreDepos = new Polygon[oreRate];
        for (int x = 0; x < oreRate; x++) {
            OreDepos[x] = new Polygon();
            int xoff = TubbyCraft.rnd.nextInt(TileMap.length);
            int yoff = TubbyCraft.rnd.nextInt(TileMap[0].length);
            for (int i = 0; i < 6; i++){
                int Xpos = (int) (xoff + 6 * Math.cos(i * 2 * Math.PI / 6));
                int Ypos = (int) (yoff + 6 * Math.sin(i * 2 * Math.PI / 6));
                Xpos+= TubbyCraft.rnd.nextInt(4)-2;
                Ypos+= TubbyCraft.rnd.nextInt(4)-2;
                OreDepos[x].addPoint(Xpos, Ypos);
            }
        }

        FastNoiseLite noise = new FastNoiseLite();
        noise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2S);
        for(int x = 0; x < TileMap.length; x++) {
            for (int y = 0; y < TileMap[0].length; y++) {
                TileMap[x][y] = new Tile("./tex/tiles/grass.png");
                TileMap[x][y].isFloor = true;
                for (int j = 0; j < oreRate; j++) {
                    if (OreDepos[j].contains(x, y)) {
                        TileMap[x][y] = new Tile("./tex/tiles/cbbl1.png");
                        TileMap[x][y].isFloor = false;
                    }
                    TileMap[x][y].linkedItem = itemMap.get(TileMap[x][y].loc);
                    if (!TileMap[x][y].isFloor)
                        TileMap[x][y].floorloc = "./tex/tiles/cbbl2.png";
                }
            }
        }
     */
}
