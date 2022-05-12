package tk.tubbygames.tubbycraft.Items;

import tk.tubbygames.tubbycraft.world.Tile;

public class ItemBirchPlanks extends Item {
    public ItemBirchPlanks()
    {
        super(new Tile("./tex/tiles/planks3.png", true),"./tex/tiles/planks3.png", 64);
        this.assignedTile = new Tile("./tex/tiles/planks3.png", true);
        this.ItemTexture = "./tex/tiles/planks3.png";
        this.maxStack = 64;
    }
    @Override
    public void ItemUse()
    {
        PlaceTile();
    }
}
