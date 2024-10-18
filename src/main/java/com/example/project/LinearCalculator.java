package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below
        //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String cd1, String cd2){ // <--add 2 string parameters to this constructor
        x1 = Integer.parseInt(cd1.substring(1, cd1.indexOf(",")));
        y1 = Integer.parseInt(cd1.substring(cd1.indexOf(",") + 1, cd1.length()-1));   //god forbid i actually learn to code and not engage in shenanigans with substrings
        x2 = Integer.parseInt(cd2.substring(1, cd2.indexOf(",")));
        y2 = Integer.parseInt(cd2.substring(cd2.indexOf(",") + 1, cd2.length()-1));
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){
        return x1;
    }
    public int getY1(){
        return y1;
    }
    public int getX2(){
        return x2;
    }
    public int getY2(){
        return y2;
    }
    public void setX1(int newX1){
        x1 = newX1;
    }
    public void setY1(int newY1){
        y1 = newY1;
    }
    public void setX2(int newX2){
        x2 = newX2;
    }
    public void setY2(int newY2){
        y2 = newY2;
    }


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double y = y2 - y1;             //distance between y values
        double x = x2 - x1;             //distance between x values
        double c = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));              //sqrt(a^2 + b^2) = c, which is the hypotenuse
        return Math.round(c * 100) / 100.0;
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if (x1 == x2) {
            return -999.99;             //if both x values are the same then slope is undefined
        }
        else if (x2 == 0) { 
            return y2;                  //y-value that's paired with a x-value of 0 is the y-intercept
        }
        else if (x1 == 0) {
            return y1;
        }
        else {
            double y = slope() * x1;
            double b = y1 - y;                          //takes the y value of one of the x positions and finds the difference between that and y1, which is b
            return Math.round(b * 100) / 100.0;
        }
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        double y = y2 - y1;
        double x = x2 - x1;
        double m;
        if (x == 0) {m = -999.99;}
        else {m = y / x;}           //(y2 - y1) / (x2 - x1) = m
        return Math.round(m * 100) / 100.0;
    }
    
    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        double m = slope();
        double b = yInt();
        if (m == -999.99) {
            return "undefined";
        }
        else if (m == 0) {                     //slope = 0
            return "y=" + b;
        }
        else if (b > 0) {                      //y-intercept is positive
            return "y=" + m + "x" + "+" + b;
        }
        else if (b == 0) {                     //y-intercept = 0
            return "y=" + m + "x";
        }
        else {                                 //y-intercept is negative
            return "y=" + m + "x" + b;
        }
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        double x2 = Math.round(x * 100) / 100.0;            // * 100 so hundreths are now ones which get rounded and then / 100 to bring them back to hundreths
        return x2;
    }


    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo() {
        String str = "The two points are: (" + x1 + "," + y1 + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\nThe midpoint of the line is: " + Midpoint();
        return str;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry() {
        if (y1 == y2 * -1) {
            if (x1 == x2 * -1) {
                return "Symmetric about the origin";        //checks for y-axis symmetry after x-axis
            }
            else {
                return "Symmetric about the x-axis";
            }
        }
        else if (x1 == x2 * -1) {
            return "Symmetric about the y-axis";            //checks for y-axis symmetry if x-axis symmetry is not met
        }
        else {
            return "No symmetry";
        }
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint() {
        double midX = (x1 + x2) / 2;                //midpoint = average of both x or y values
        double midY = (y1 + y2) / 2;
        return "The midpoint of this line is: (" + midX + "," + midY + ")";
    }
}



