package tk.tubbygames.tubbycraft.world;

import java.io.IOException;

public class MapParser {
    private static String[] TexIndex = {
            null,
            "cbbl1",
            "cbbl2",
            "planks1",
            "planks2",
            "planks3",
            "planks4",
            "planks5",
            "planks6",
            "planks7",
            "planks8",
            "grass"
    };
    public static Tile[][] ReadMapFile(String loc) throws IOException {
        /*
        File file = new File(loc);
        byte[] FileARR = Files.readAllBytes(file.toPath());
        int width = (int)FileARR[0];
        int height = (int)FileARR[1];
        Tile[][] TileMap = new Tile[width][height];
        int i = 0;
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                int index = (x*width)+y;
                TileMap[x][y] = parseKey(FileARR[index + 2]);
            }
        }
        return TileMap;

         */
        return null;
    }
    public static void SaveCurrentMap(String loc) throws IOException {
        /*
        File file = new File(loc);
        int width = TileManager.TileMap.length;
        int height = TileManager.TileMap[0].length;

        byte[] FileARR = new byte[(width*height)+ 2];
        FileARR[0] = (byte) width;
        FileARR[1] = (byte) height;
        for(int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Tile tile = TileManager.TileMap[x][y];
                if(tile == null)
                    tile = new Tile("./tex/tiles/cbbl2.png");
                int index = (x * width) + y;
                String texKey =tile.loc.substring(12, tile.loc.length()-4);
                int tileTexIndex = 0;
                for(int i = 0; i < TexIndex.length; i++)
                {
                    String key = TexIndex[i];
                    if(key.equals(texKey))
                        tileTexIndex = i;
                }
                byte tileByte = (byte)tileTexIndex;
                if(!tile.isFloor)
                    tileByte |= (byte) (1 << 7);
                FileARR[index+2] = tileByte;
            }
        }
        Files.write(file.toPath(), FileARR);

         */
    }
    public static Tile parseKey(int key)
    {
        /*
        byte keyByte = (byte)key;
        Tile res = new Tile();
        byte keyunsin = keyByte;
        keyunsin &= (byte) ~(1 << 7);
        if(keyByte == keyunsin)
            res.isFloor = true;
        else
            res.isFloor = false;
        res.loc = "./tex/tiles/" + TexIndex[(int)keyunsin] + ".png";
        return res;

         */
        return null;
    }
}
