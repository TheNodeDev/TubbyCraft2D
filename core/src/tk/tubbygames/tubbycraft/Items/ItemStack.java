package tk.tubbygames.tubbycraft.Items;

public class ItemStack {
    public Item ItemType;
    public int maxStack;
    public int amount = 1;
    public ItemStack(Item i)
    {
        this.ItemType = i;
        this.maxStack = i.maxStack;
    }
    public ItemStack(Item i, int amount)
    {
        this.ItemType = i;
        this.maxStack = i.maxStack;
        this.Add(amount-1);
    }
    public void Add()
    {
        this.amount++;
    }
    public void Add(int amount)
    {
        this.amount+=amount;
    }
}
