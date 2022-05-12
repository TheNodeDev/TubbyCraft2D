package tk.tubbygames.tubbycraft.world;

import tk.tubbygames.tubbycraft.data.TransparentTextures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TileStack {
    public Tile[] Stack;
    public TileStack(Tile[] Stack)
    {
        this.Stack = Stack;
    }
    public String[] GetTextures(boolean floorLayer)
    {
        String[] ret;
        if(floorLayer)
        {
            ret = new String[1];
            ret[0] = Stack[0].Texture;
        }else{
            List<String> TexList = new ArrayList<String>();
            int i = Stack.length-1;
            String tex = Stack[i].Texture;
            while (TransparentTextures.IsTransparent(tex))
            {
                TexList.add(tex);
                i--;
                tex = Stack[i].Texture;
            }
            ret = TexList.toArray(new String[0]);
        }
        return ret;
    }
    public String[] GetTextures()
    {
        String[] ret;
        LinkedList<String> TexList = new LinkedList<>();
        TexList.add(Stack[0].Texture);
        int i = Stack.length-1;
        String tex = Stack[i].Texture;
        while (TransparentTextures.IsTransparent(tex))
        {
            TexList.add(tex);
            i--;
            tex = Stack[i].Texture;
        }
        ret = TexList.toArray(new String[0]);
        return ret;
    }
    public Tile GetTopTile()
    {
        return Stack[Stack.length-1];
    }
    public Boolean isAir()
    {
        if(this.Stack.length > 0)
            return false;
        return true;
    }
}
