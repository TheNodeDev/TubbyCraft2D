package tk.tubbygames.tubbycraft.Items;

import tk.tubbygames.tubbycraft.Item;
import tk.tubbygames.tubbycraft.Tile;

public class ItemOakPlanks extends Item {
    public ItemOakPlanks()
    {
        super(new Tile("./tex/tiles/planks1.png"),"./tex/tiles/planks1.png", 64);
        this.assignedTile = new Tile("./tex/tiles/planks1.png");
        this.ItemTexture = "./tex/tiles/planks1.png";
        this.maxStack = 64;
    }
    @Override
    public void ItemUse()
    {
        PlaceTile();
    }
}
