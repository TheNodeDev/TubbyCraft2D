package tk.tubbygames.tubbycraft.data;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import tk.tubbygames.tubbycraft.TubbyAssets;

import java.util.HashMap;
import java.util.Map;

public class TransparentTextures {
    public static Map<String, Boolean> db = new HashMap<String, Boolean>();
    public static boolean IsTransparent(String loc)
    {
        if(db.containsKey(loc))
            return db.get(loc);

        Texture tex = TubbyAssets.LoadTexture(loc);
        tex.getTextureData().prepare();
        Pixmap map = tex.getTextureData().consumePixmap();
        for(int x = 0; x < map.getWidth(); x++)
        {
            for(int y = 0; y < map.getHeight(); y++)
            {
                if(new Color(map.getPixel(x, y)).a < 1){
                    db.put(loc, true);
                    return true;
                }
            }
        }
        db.put(loc, false);
        return false;
    }
}
