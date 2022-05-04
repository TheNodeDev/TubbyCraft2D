package tk.tubbygames.tubbycraft;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tk.tubbygames.tubbycraft.Items.ItemCobble;
import tk.tubbygames.tubbycraft.Items.ItemStoneBrick;

import java.util.HashMap;
import java.util.Map;

public class TileManager {
    public static Map<String, Item> itemMap;
    static {
        itemMap = new HashMap<>();
        itemMap.put("./tex/tiles/cbbl1.png", new ItemCobble());
        itemMap.put("./tex/tiles/cbbl2.png", new ItemStoneBrick());
    }
    public static Tile[][] TileMap = new Tile[128][128];
    public static int TileSize = 64;
    public static void SetTileSize(float val)
    {
        if(val > 0 && val <= 128)
            TileSize = (int)val;
    }
    public static void GenerateRandomMap()
    {
        for(int x = 0; x < TileMap.length; x++) {
            for (int y = 0; y < TileMap[0].length; y++) {
                int rnd = TubbyCraft.rnd.nextInt(2);
                TileMap[x][y] = new Tile("./tex/tiles/cbbl" + (rnd+1) + ".png");
                TileMap[x][y].isFloor = TubbyCraft.rnd.nextBoolean();
                TileMap[x][y].linkedItem = itemMap.get(TileMap[x][y].loc);
            }
        }
    }
    public static void DrawToScreen(SpriteBatch batch, boolean drawfloors)
    {
        int ScreenTileWidth = (Gdx.graphics.getWidth()/TileSize)+4;
        int ScreenTileHeight = (Gdx.graphics.getHeight()/TileSize)+2;
        for(int x = (int) (-Camera.pos.X)-1; x < Math.min(TileMap.length,-Camera.pos.X+ScreenTileWidth+1); x++)
        {
            for(int y = (int) Math.min(TileMap[0].length-1, -Camera.pos.Y+ScreenTileHeight); y > (int)(-Camera.pos.Y)-2; y--)
            {
                Vector2 Screenpos = new Vector2(
                        ((Camera.pos.X)+x)*TileSize,
                        ((Camera.pos.Y)+y)*TileSize
                );
                if(x > 0 && y > 0 && x < 127 && y < 127)
                {
                    Tile tile = TileMap[x][y];
                    if(tile == null)
                    {
                        int rnd = TubbyCraft.rnd.nextInt(2);
                        TileMap[x][y] = new Tile("./tex/tiles/cbbl" + (rnd+1) + ".png");
                        TileMap[x][y].isFloor = TubbyCraft.rnd.nextBoolean();
                        TileMap[x][y].linkedItem = itemMap.get(TileMap[x][y]);
                    }
                    tile = TileMap[x][y];
                    String destroyloc = "./tex/tiles/destroy_stage_" + (String.valueOf(tile.breakamount*10f).substring(0,1)) + ".png";
                    if(tile.isFloor) {
                        if(drawfloors){
                            batch.draw(TubbyAssets.LoadTexture(tile.loc), Screenpos.X, Screenpos.Y, TileSize, TileSize);
                            if(tile.breakamount > 0)
                                batch.draw(TubbyAssets.LoadTexture(destroyloc), Screenpos.X, Screenpos.Y, TileSize, TileSize);
                        }
                    }
                    else{

                        if(!drawfloors) {
                            batch.setColor(new Color(0.7f, 0.7f, 0.7f, 1f));
                            batch.draw(TubbyAssets.LoadTexture(tile.loc), Screenpos.X, Screenpos.Y + (TileSize * 0.6f), TileSize, TileSize);
                            if(tile.breakamount > 0)
                                batch.draw(TubbyAssets.LoadTexture(destroyloc), Screenpos.X, Screenpos.Y + (TileSize * 0.6f), TileSize, TileSize);
                            batch.setColor(new Color(0.3f, 0.3f, 0.3f, 1f));
                            batch.draw(TubbyAssets.LoadTexture(tile.loc), Screenpos.X, Screenpos.Y, TileSize, TileSize * 0.6f);
                            if(tile.breakamount > 0)
                                batch.draw(TubbyAssets.LoadTexture(destroyloc), Screenpos.X, Screenpos.Y, TileSize, TileSize * 0.6f);
                            batch.setColor(Color.WHITE);
                        }
                    }
                }
            }
        }
    }
}
