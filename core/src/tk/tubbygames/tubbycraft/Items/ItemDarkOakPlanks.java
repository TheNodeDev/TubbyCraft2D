package tk.tubbygames.tubbycraft.Items;

import tk.tubbygames.tubbycraft.world.Tile;

public class ItemDarkOakPlanks extends Item {
    public ItemDarkOakPlanks()
    {
        super(new Tile("./tex/tiles/planks5.png", true),"./tex/tiles/planks5.png", 64);
        this.assignedTile = new Tile("./tex/tiles/planks5.png", true);
        this.ItemTexture = "./tex/tiles/planks5.png";
        this.maxStack = 64;
    }
    @Override
    public void ItemUse()
    {
        PlaceTile();
    }
}
