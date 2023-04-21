package q1;

/**
 * Cylinder class represents a cylinder's radius and height.
 * 
 * @author Monica
 * @version 1.0
 *
 */
public class Cylinder {
    // Cylinder variables
    /** Radius of cylinder. */
    private double radius;
        
    /** Height of cylinder. */
    private double height;

    // Variables for calculation methods    
    /** Two represents number 2. */
    private final int two = 2;


    /**
     * Constructor sets the initial values of radius and height.
     * @param radius double
     * @param height double
     */
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }


    /**
     * Returns the value of radius as a double.
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
      * Sets the value of radius to the parameter value.
      * @param radius the radius to set
      */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
      * Returns the value of height as a double.
      * @return the height
      */
    public double getHeight() {
        return height;
    }

    /**
      * Sets the value of height to the parameter value.
      * @param height the height to set
      */
    public void setHeight(double height) {
        this.height = height;
    }


    /**
      * Calculates the surface area of the cylinder.
      * @param r (radius) double
      * @param h (height) double
      * @return the surface area
      */
    public double calculateSurfaceArea(double r, double h) {
        // Formula for surface area
        double surfaceArea = two * Math.PI * r * (r + h);
            
        // Return the surface area
        return surfaceArea;
    }

    /**
      * Calculates the volume of the cylinder.
      * @param r (radius) double
      * @param h (height) double
      * @return the volume
      */
    public double calculateVolume(double r, double h) {
        // Formula for volume
        double volume = Math.PI * Math.pow(r, two) * h;
            
        // Return the volume
        return volume;
    }


    /**
      * Returns a two-line description of the cylinder's radius and height.
      * 
      * @return toString description
      */
    public String toString() {
        return "Cylinder Radius: " + radius + "\n" 
                + "Cylinder Height: " + height;
    }

}
