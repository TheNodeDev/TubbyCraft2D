package tk.tubbygames.tubbycraft.worldgen;

public enum OreType {
    COAL("./tex/tiles/planks1.png"),
    IRON("./tex/tiles/planks2.png"),
    GOLD("./tex/tiles/planks3.png"),
    DIAMOND("./tex/tiles/planks4.png");
    public String loc;
    OreType(String loc)
    {
        this.loc = loc;
    }
}
