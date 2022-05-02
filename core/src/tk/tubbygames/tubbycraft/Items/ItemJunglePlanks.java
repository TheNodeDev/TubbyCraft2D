package tk.tubbygames.tubbycraft.Items;

import tk.tubbygames.tubbycraft.Item;
import tk.tubbygames.tubbycraft.Tile;

public class ItemJunglePlanks extends Item {
    public ItemJunglePlanks()
    {
        super(new Tile("./tex/tiles/planks6.png"),"./tex/tiles/planks6.png", 64);
        this.assignedTile = new Tile("./tex/tiles/planks6.png");
        this.ItemTexture = "./tex/tiles/planks6.png";
        this.maxStack = 64;
    }
    @Override
    public void ItemUse()
    {
        PlaceTile();
    }
}
