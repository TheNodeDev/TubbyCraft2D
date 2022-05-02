package tk.tubbygames.tubbycraft;

import com.badlogic.gdx.graphics.Texture;

public class TubbyAssets {
    public static Texture LoadTexture(String FileName)
    {
        if(TubbyCraft.aManager.isLoaded(FileName))
            return TubbyCraft.aManager.get(FileName);
        else{
            TubbyCraft.aManager.load(FileName, Texture.class);
            TubbyCraft.aManager.finishLoading();
            return TubbyCraft.aManager.get(FileName);
        }
    }
}
