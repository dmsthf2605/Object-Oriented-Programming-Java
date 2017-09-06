/**
 * Last Name: Lee
 * First Name: Eunsol
 * Student ID: 029557154
 * codeboard UserName: elee111
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main extends NegativeException{

    public static void main(String[] args) {
        System.out.println("------->JAC 444 Assignment 1 by Eunsol Lee <-------");

        /**
         * Read the file Shapes.txt
         * Create the shapes and store them in your data structure
         * Print all the shapes and their perimeters
         * */
        System.out.println("------->Task 1 Create the shapes and store<-------");
        // Create the shapes and store them in the ArrayList<Shape> list
        ArrayList<Shape> list = new ArrayList<>();
        list = buildShapesFromFile("Shapes.txt");
        // Print all the shapes and their perimeters
        for(Shape s : list)
            System.out.println(s);
        System.out.println("Total number of shapes: " + list.size());
        System.out.println();

        /**
         * Delete the triangle with the minimum perimeter from all triangles
         * Delete the circle with the maximum perimeter from all circles
         */
        System.out.println("------->Task 2 Delete the shapes(Triangle and Circle) <-------");
        list = deleteShapesFromFile(list);
        for(Shape s : list)
            System.out.println(s);
        System.out.println("Total number of shapes after delete: " + list.size());
        System.out.println();

        /**
         * Calculate the perimeter of all parallelograms
         * Calculate the perimeter of all triangles
         */
        System.out.println("------->Task 3 Calculate the perimeter(Parallelograms and Triangles) <-------");
        calculatePerimeters(list);
        System.out.println();

        /**
         * Print all the shapes sorted alphabetically.
         * For the same shapes print them sorted (ascending) based on the perimeter values
         */
        System.out.println("------->Task 4 Sort all the shapes <-------");
        list.sort((Shape s1, Shape s2) ->{
            int result = s1.getClass().getName().compareTo(s2.getClass().getName());
            if(result != 0)
                return result;
            else
                result = new Double(s1.getPerimeter()).compareTo(new Double(s2.getPerimeter()));
            return result;
        });
        for(Shape s : list)
            System.out.println(s);
        System.out.println();
    }

    public static void calculatePerimeters(ArrayList<Shape> t){
        ArrayList<Shape> temp = t;
        double totalP = 0.0, totalT = 0.0;

        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i) instanceof Parallelogram){
                totalP += temp.get(i).getPerimeter();
            }
            if(temp.get(i) instanceof Triangle){
                totalT += temp.get(i).getPerimeter();
            }
        }

        // Show the total perimeters of Parallelograms and Triangles
        System.out.println("Parallelogram Total Perimeter: " + totalP);
        System.out.println("Triangle Total Perimeter: " + totalT);
    }

    public static ArrayList<Shape> deleteShapesFromFile(ArrayList<Shape> t){
        ArrayList<Shape> temp = t;
        double min = Double.MAX_VALUE, max = Double.MIN_VALUE;

        for(int i = 0; i < temp.size(); i++){
            // Find the maximum perimeter from all Circles
            if(temp.get(i) instanceof Circle) {
                if (temp.get(i).getPerimeter() > max)
                    max = temp.get(i).getPerimeter();
            }
            // Find the minimum perimeter from all Triangles
            if(temp.get(i) instanceof Triangle){
                if(temp.get(i).getPerimeter() < min)
                    min = temp.get(i).getPerimeter();
            }
        }

        for(int i = 0; i < temp.size(); i++){
            // Delete the circle with the maximum perimeter from all circles
            if(temp.get(i) instanceof  Circle)
                if(temp.get(i).getPerimeter() == max)
                    temp.remove(i--);

            // Delete the triangle with the minimum perimeter from all triangles
            if(temp.get(i) instanceof Triangle)
                if(temp.get(i).getPerimeter() == min)
                    temp.remove(i--);
        }

        return temp;
    }

    public static ArrayList<Shape> buildShapesFromFile(String fileName) {

        String path = System.getProperty("user.dir");
        Shape sp = null;
        String s;
        ArrayList<Shape> list = new ArrayList<>();

        //try (BufferedReader br = new BufferedReader(new FileReader("./Root/" + fileName))) {
        try (BufferedReader br = new BufferedReader(new FileReader(path + "/src/" + fileName))) {
            // if you run locally on your environment use: new FileReader(path + "/src/" + fileName)
            while ((s = br.readLine()) != null) {
                String[] tok = s.split(",");

                // Catch Custom Exception if there is a negative value
                try {
                    //check the shape type and call the shape ctr.
                    switch (tok[0]) {
                        case "Circle":
                            if(tok.length == 2) {
                                Circle c = new Circle(Double.parseDouble(tok[1]));
                                list.add(c);
                            }
                            break;
                        case "Rectangle":
                            if(tok.length == 3) {
                                Rectangle r = new Rectangle(Double.parseDouble(tok[1]), Double.parseDouble(tok[2]));
                                list.add(r);
                            }
                            break;
                        case "Parallelogram":
                            if(tok.length == 3) {
                                Parallelogram p = new Parallelogram(Double.parseDouble(tok[1]), Double.parseDouble(tok[2]));
                                list.add(p);
                            }
                            break;
                        case "Square":
                            if(tok.length == 2) {
                                Square sq = new Square(Double.parseDouble(tok[1]));
                                list.add(sq);
                            }
                            break;
                        case "Triangle":
                            if(tok.length == 4) {
                                Triangle tr = new Triangle(Double.parseDouble(tok[1]), Double.parseDouble(tok[2]), Double.parseDouble(tok[3]));
                                list.add(tr);
                            }
                            break;
                        default:
                            break;
                    }
                } catch(NegativeException e){
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
}
