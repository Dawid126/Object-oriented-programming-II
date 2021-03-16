public class RoundHole
{
    private int radius;

    public RoundHole(int radius)
    {
        this.radius = radius;
    }

    int getRadius()
    {
        return radius;
    }

    boolean fits(RoundPeg peg)
    {
        System.out.println("Trying to fit peg into the hole");
        return peg.getRadius() <= radius;
    }
}
