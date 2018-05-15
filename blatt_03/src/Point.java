import Geometry.Geometry;

public class Point extends Geometry {
    private double[] coordinates;
    
    public Point( double[] coordinates ) {
        super( coordinates.length );
        this.coordinates = coordinates;
    }

    public Point( int dimensions ) {
        super( dimensions );
        double[] iniCoord = new double[dimensions];
        for( int i = 0; i < iniCoord.length; i++ ) {
            iniCoord[i] = 0;
        }
        this.coordinates = iniCoord;
    }

    public double volume() {
        return 0;
    }
}