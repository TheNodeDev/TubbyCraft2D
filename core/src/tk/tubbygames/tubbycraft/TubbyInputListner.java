package tk.tubbygames.tubbycraft;

import com.badlogic.gdx.InputProcessor;

public class TubbyInputListner implements InputProcessor {
    @Override
    public boolean keyDown(int keycode) {
        if(TubbyCraft.screen != null)
            TubbyCraft.screen.keyDown(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(TubbyCraft.screen != null)
            TubbyCraft.screen.keyUp(keycode);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        if(TubbyCraft.screen != null)
            TubbyCraft.screen.keyTyped(character);
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(TubbyCraft.screen != null)
            TubbyCraft.screen.touchDown( screenX,  screenY,  pointer,  button);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(TubbyCraft.screen != null)
            TubbyCraft.screen.touchUp( screenX,  screenY,  pointer,  button);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if(TubbyCraft.screen != null)
            TubbyCraft.screen.touchDragged(screenX, screenY, pointer);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        if(TubbyCraft.screen != null)
            TubbyCraft.screen.mouseMoved(screenX, screenY);
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        if(TubbyCraft.screen != null)
            TubbyCraft.screen.scrolled(amountX, amountY);
        return false;
    }
}
