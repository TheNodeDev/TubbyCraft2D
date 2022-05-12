package tk.tubbygames.tubbycraft.utils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tk.tubbygames.tubbycraft.Rectangle;
import tk.tubbygames.tubbycraft.TubbyAssets;
import tk.tubbygames.tubbycraft.TubbyCraft;

public class Utils {
    public static enum Colour
    {
        CONSOLE1("./tex/colors/1.png"),
        DEBUG("./tex/colors/2.png");
        public final String loc;
        private Colour(String loc)
        {
            this.loc = loc;
        }
    }
    public static void DrawColour(SpriteBatch batch, Colour col, Rectangle pos)
    {
        batch.draw(TubbyAssets.LoadTexture(col.loc), pos.Pos1.X, pos.Pos1.Y, pos.Pos2.X, pos.Pos2.Y);
    }
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = TubbyCraft.rnd.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
