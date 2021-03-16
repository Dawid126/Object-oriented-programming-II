public class SquarePegAdapter extends RoundPeg
{
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg)
    {
        super(peg.getWidth());
        System.out.println("Creating an adapter for square with width of " + peg.getWidth());
        this.peg = peg;
    }

    public int getRadius()
    {
        return (int) (peg.getWidth()*Math.sqrt(2)/2);
    }
}
