package tk.tubbygames.tubbycraft;

import static java.lang.Math.*;

public class Vector2 {
    public float X;
    public float Y;

    public Vector2()
    {
        this.X = 0;
        this.Y = 0;
    }

    public Vector2(float x, float y)
    {
        this.X = x;
        this.Y = y;
    }
    public float GetDistance(Vector2 pos)
    {
        float dx = abs(this.X - pos.X);
        float dy = abs(this.Y - pos.Y);
        float distance = (float)sqrt(pow(dx, 2) + pow(dy, 2));
        return distance;
    }
    public void Add(Vector2 var)
    {
        this.Y += var.Y;
        this.X += var.X;
    }
    public void Add(Vector2 var, float mag)
    {
        this.Y += var.Y * mag;
        this.X += var.X * mag;
    }
}
