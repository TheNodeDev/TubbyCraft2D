package tk.tubbygames.tubbycraft.world;

import tk.tubbygames.tubbycraft.Items.Item;
import tk.tubbygames.tubbycraft.data.ItemTileConversion;

public class Tile {
    public boolean isFullBlock = false;
    public String Texture;
    public String WallTexture;
    public Item linkedItem;
    public float breakAmount = 0f;
    public Tile(String loc, boolean full)
    {
        this.Texture = loc;
        this.WallTexture = loc;
        this.isFullBlock = full;
        this.linkedItem = ItemTileConversion.itemMap.get(loc);
    }
    public Tile(Tile cp)
    {
        this.Texture     = cp.Texture;
        this.isFullBlock = cp.isFullBlock;
        this.breakAmount = cp.breakAmount;
        this.linkedItem  = cp.linkedItem;
    }
}