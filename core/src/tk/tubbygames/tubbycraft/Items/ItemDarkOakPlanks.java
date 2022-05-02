package tk.tubbygames.tubbycraft.Items;

import tk.tubbygames.tubbycraft.Item;
import tk.tubbygames.tubbycraft.Tile;

public class ItemDarkOakPlanks extends Item {
    public ItemDarkOakPlanks()
    {
        super(new Tile("./tex/tiles/planks5.png"),"./tex/tiles/planks5.png", 64);
        this.assignedTile = new Tile("./tex/tiles/planks5.png");
        this.ItemTexture = "./tex/tiles/planks5.png";
        this.maxStack = 64;
    }
    @Override
    public void ItemUse()
    {
        PlaceTile();
    }
}
