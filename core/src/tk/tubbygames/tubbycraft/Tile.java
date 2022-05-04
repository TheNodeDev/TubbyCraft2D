package tk.tubbygames.tubbycraft;

public class Tile {
    public boolean isFloor = true;
    public String loc = "./tex/tiles/cbbl1.png";
    public float breakamount = 0f;
    public Item linkedItem = null;
    public Tile(String loc)
    {
        this.loc = loc;
    }
    public Tile(Tile t)
    {
        this.isFloor = t.isFloor;
        this.loc = t.loc;
    }
    public Tile(){}
}
