package tk.tubbygames.tubbycraft.Items;

import tk.tubbygames.tubbycraft.Item;
import tk.tubbygames.tubbycraft.Tile;

public class ItemCobble extends Item {
    public ItemCobble()
    {
        super(new Tile("./tex/tiles/cbbl1.png"),"./tex/tiles/cbbl1.png", 64);
        this.assignedTile = new Tile("./tex/tiles/cbbl1.png");
        this.ItemTexture = "./tex/tiles/cbbl1.png";
        this.maxStack = 64;
    }
    @Override
    public void ItemUse()
    {
        PlaceTile();
    }
}
