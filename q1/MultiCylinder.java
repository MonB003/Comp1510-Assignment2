package q1;

import java.text.DecimalFormat;

/**
 * <p>The MultiCylinder class creates two Cylinder objects from the Cylinder 
 * class. Each Cylinder object has variables to store its radius and height.
 * The program calculates the volume and surface area of each Cylinder
 * by calling methods with the objects that take in parameters for the radius 
 * and height. The methods use the values of the radius and height to fill in 
 * parts of the formula and calculate that specific cylinder's volume and 
 * surface area. The toString method stores the Cylinder object's radius and
 * height. Each method is called and the result is stored in a variable, which
 * is printed to the console.</p>
 *
 * @author Monica
 * @version 1.0
 */
public class MultiCylinder {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // Variables store values for radius and height
        final double radius1 = 2.0;
        final double height1 = 4.0;
        final double radius2 = 6.0;
        final double height2 = 3.0;
        
        // Create Cylinder objects
        Cylinder cylinder1 = new Cylinder(radius1, height1);
        Cylinder cylinder2 = new Cylinder(radius2, height2);
        
        // Decimal Format object to round results to 3 decimal places
        DecimalFormat decFormat = new DecimalFormat("#.###");

        // Print radius and height before modification
        System.out.println("Cylinder 1 (before modification): " + "\n"
                + cylinder1.toString());
        System.out.println("Cylinder 2 (before modification): " + "\n"
                + cylinder2.toString());

        // Calculate surface area
        double cylinder1SA = cylinder1.calculateSurfaceArea(radius1, height1);
        double cylinder2SA = cylinder2.calculateSurfaceArea(radius2, height2);
        
        // Print final surface area of each cylinder
        System.out.println("Cylinder 1 Surface Area: " 
                + decFormat.format(cylinder1SA));
        System.out.println("Cylinder 2 Surface Area: " 
                + decFormat.format(cylinder2SA));

        // Calculate volume
        double cylinder1Vol = cylinder1.calculateVolume(radius1, height1);
        double cylinder2Vol = cylinder2.calculateVolume(radius2, height2);
        
        // Print final volume of each cylinder
        System.out.println("Cylinder 1 Volume: " 
                + decFormat.format(cylinder1Vol));
        System.out.println("Cylinder 2 Volume: " 
                + decFormat.format(cylinder2Vol));
        
        // Print radius and height after modification
        System.out.println("Cylinder 1 (after modification): " + "\n" 
                + cylinder1.toString());
        System.out.println("Cylinder 2 (after modification): " + "\n" 
                + cylinder2.toString());
    }

}
