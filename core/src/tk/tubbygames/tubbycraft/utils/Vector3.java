package tk.tubbygames.tubbycraft.utils;

import static java.lang.Math.*;

public class Vector3 {
    public float X;
    public float Y;
    public float Z;

    public Vector3()
    {
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
    }

    public Vector3(float x, float y, float z)
    {
        this.X = x;
        this.Y = y;
        this.Z = z;
    }
    public float GetDistance(Vector3 pos)
    {
        float dx = abs(this.X - pos.X);
        float dy = abs(this.Y - pos.Y);
        float dz = abs(this.Z - pos.Z);
        return (float)sqrt(pow(dx, 2) + pow(dy, 2) + pow(dz, 2));
    }
    public void Add(Vector3 var)
    {
        this.Y += var.Y;
        this.X += var.X;
        this.Z += var.Z;
    }
    public void Add(Vector3 var, float mag)
    {
        this.Y += var.Y * mag;
        this.X += var.X * mag;
        this.Z += var.Z * mag;
    }
}
