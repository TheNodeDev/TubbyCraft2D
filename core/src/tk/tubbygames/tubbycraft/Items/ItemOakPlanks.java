package tk.tubbygames.tubbycraft.Items;

import tk.tubbygames.tubbycraft.world.Tile;

public class ItemOakPlanks extends Item {
    public ItemOakPlanks()
    {
        super(new Tile("./tex/tiles/planks1.png", true),"./tex/tiles/planks1.png", 64);
        this.assignedTile = new Tile("./tex/tiles/planks1.png", true);
        this.ItemTexture = "./tex/tiles/planks1.png";
        this.maxStack = 64;
    }
    @Override
    public void ItemUse()
    {
        PlaceTile();
    }
}
