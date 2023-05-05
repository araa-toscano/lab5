package Collections;

import Characteristics.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import static Characteristics.Color.*;
import static Characteristics.Country.*;

/**
 *Class for handling all commands
 */
public class Comander {

    static TreeMap<Integer, Person> personas = new TreeMap<>();
    static Scanner Command = new Scanner(System.in);
    static Integer key;
    static int id;
    static String name;
    static Coordinates coordinates;
    static float height;
    static java.time.LocalDate date;
    static String passport;
    static Color hairColor;
    static Country nationality;
    static Location location;

    /**
     * Shows the commands to the user
     */
    public static void help() {
        System.out.println(Message.help());
    }

    /**
     * Gives all the information about your collection
     */
    public static void info() {
        System.out.println("Sizes in your collection: " + personas.size());
        System.out.println("Names of your collection: " + personas.keySet());
    }

    /**
     * Shows all the values for the collection to the user
     */
    public static void show() {
        for (Map.Entry<Integer, Person> myCollectionPerson : personas.entrySet()) {
            System.out.println(myCollectionPerson);
        }
    }

    /**
     * Values for the collection
     */
    public static void parameterPerson() {
        try {
            System.out.println("Enter a key");
            key = Integer.valueOf(Command.next());

            int numberDigits = 6;
            Random numRandom = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numberDigits; i++) {
                sb.append(numRandom.nextInt(10));
            }
            String theId = sb.toString();
            id = Integer.parseInt(theId);

            System.out.println("Enter a name: ");
            name = Command.next();

            System.out.println("Enter a coordinates");
            coordinates = Coordinates.createCoordinates(Command);

            LocalDateTime ldt = LocalDateTime.now();
            date = LocalDate.from(ldt);

            System.out.println("Enter a height");
            height = Command.nextFloat();

            System.out.println("Enter a passportID: ");
            passport = Command.next();

            System.out.println("\nSelect the Color Hair");
            System.out.println("Option BLACK");
            System.out.println("Option BLUE");
            System.out.println("Option YELLOW");
            System.out.println("Option ORANGE");
            System.out.println("Option BROWN");
            System.out.println("Write one of this options: ");

            hairColor = Color.valueOf(Command.next());
            switch (hairColor) {
                case BLACK -> hairColor.equals(BLACK);
                case BLUE -> hairColor.equals(BLUE);
                case YELLOW -> hairColor.equals(YELLOW);
                case ORANGE -> hairColor.equals(ORANGE);
                case BROWN -> hairColor.equals(BROWN);
                default -> hairColor.equals(null);
            }

            System.out.println("\nSelect the Country");
            System.out.println("Option THAILAND");
            System.out.println("Option CHINA");
            System.out.println("Option ECUADOR");
            System.out.println("Option GERMANY");
            System.out.println("Option RUSSIA");
            System.out.println("Option VATICAN");
            System.out.println("Write one of this options:");

            nationality = Country.valueOf(Command.next());
            switch (nationality) {
                case THAILAND -> nationality.equals(THAILAND);
                case CHINA -> nationality.equals(CHINA);
                case ECUADOR -> nationality.equals(ECUADOR);
                case GERMANY -> nationality.equals(GERMANY);
                case RUSSIA -> nationality.equals(RUSSIA);
                case VATICAN -> nationality.equals(Country.VATICAN);
                default -> nationality.equals(null);
            }

            location = Location.createLocation(Command);
            System.out.println("Your collection has been completed!!\n");
            personas.put(key, new Person(id, name, coordinates, date, height, passport, hairColor, nationality, location));

        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Something is wrong. Please try again!");
        }

    }

    /**
     * Remove from the collection all elements whose nationality is the same to the specified
     */
    public static void removeAllNationality() {
        Scanner borrarNacionalidad = new Scanner(System.in);
        Country rmvNationality = Country.valueOf(borrarNacionalidad.next());
        personas.entrySet().removeIf(entry -> entry.getValue().getNationality().equals(rmvNationality));
    }

    /**
     * Clear all collection
     */
    public static void clear() {
        personas.clear();
    }

    /**
     * Remove the key whose is the same to the specified
     */
    public static void removeKey() {
        Scanner rmvKey = new Scanner(System.in);
        Integer rmvKEY = rmvKey.nextInt();
        personas.entrySet().removeIf(entry -> entry.getKey().equals(rmvKEY));
    }

    /**
     * Remove the location whose is the same to the specified
     */
    public static void removeAllLocation() {
        Scanner rmLol = new Scanner(System.in);
        System.out.println("Enter location city:");
        String ubicacion = rmLol.next();
        boolean correctLocation = personas.entrySet().removeIf(entry -> entry.getValue().getLocation().getName().equals(ubicacion));
       if (correctLocation){
           System.out.println("Success");
       }else {
           System.out.println("Incorrect location city. Try again!!");
       }
    }

    /**
     * Groups the collection depending on its values of the location
     */
    public static void groupCounting() {

        try {
            if (personas.isEmpty()) {
                throw new Exception("The collection is empty.");
            } else {
                int first = 0;
                int second = 0;
                int third = 0;
                int fourth = 0;
                for (Person pr :personas.values()) {
                    if (pr.getLocation().getX() >= 0) {
                        if (pr.getLocation().getY() >= 0) {
                            first += 1;
                        }
                    } else {
                        fourth += 1;
                    }
                    if (pr.getLocation().getY() >= 0) {
                        second += 1;
                    } else {
                        third += 1;
                    }
                   } System.out.println("There are " + first + " elements in the first group, " +
                        "" + second + " in the second one, " + third + " in the third one, " + fourth + " in the fourth one.");
            }
        } catch(Exception e){
        System.out.println("Error "+e.getMessage());
    }


    }

    /**
     * Replace the value by key if the new value is greater than the old
     */
    public static void replaceIfGreater() {
        try {
            Scanner rplGerater = new Scanner(System.in);
            Integer replaceGreater = rplGerater.nextInt();

            for (Map.Entry<Integer, Person> entry : personas.entrySet()) {
                if (entry.getKey() > replaceGreater) {
                    System.out.println("\nEnter a name");
                    String remplaceName = rplGerater.next();
                    personas.get(key).setName(remplaceName);
                    System.out.println("Your collection has been replaced");
                } else {
                    System.out.println("You can't replace your collection because your key is older than your collection ");
                }
            }
        } catch (InputMismatchException i) {
            System.out.println("You must enter a key");
        }
    }

    /**
     * Update the id if is the same to the specified
     */
    public static void update() {
        int newID = Command.nextInt();
        for (Map.Entry<Integer, Person> entry : personas.entrySet()) {
            if (entry.getValue().getId() == newID) {
                int numberDigits = 6;
                Random numRandom = new Random();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < numberDigits; i++) {
                    sb.append(numRandom.nextInt(10));
                }
                String theId = sb.toString();
                int myNewId = Integer.parseInt(theId);
                personas.put(key, new Person(myNewId, name, coordinates, date, height, passport, hairColor, nationality, location));
                System.out.println("Success");
            }
        }
    }

    /**
     * Shows the last 9 commands, which has been typed by user
     * @param allCommands list of commands
     */
    public static void history(ArrayList<String> allCommands){
        System.out.println("\nLast 9 commands:");
        for (int i = Math.max(allCommands.size() - 9, 0); i < allCommands.size(); i++) {
            System.out.println(allCommands.get(i));
        }
        if (allCommands.size() > 9) {
            allCommands.remove(0);
        }

    }

    /**
     * Remove from the collection all elements whose key exceeds the specified
     */
    public static void removeGreaterKey() {
        Integer rmvGKey = Command.nextInt();
        boolean removeGreat = personas.entrySet().removeIf(entry -> entry.getKey() > rmvGKey);
        if(removeGreat){
            System.out.println("Success");
        }else {
            System.out.println("Something is wrong, try again!");
        }
    }

    /**
     * Generate a script with all commands, which has been typed by user
     * @param allCommands list of commands
     */
    public static void generateScript(ArrayList<String> allCommands){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            System.out.println("Enter File Name: ");
            String fileName;
            fileName = Command.next();
            org.w3c.dom.Element rootElement =  (document).createElement(fileName);(document).appendChild(rootElement);
            for (String allCommand : allCommands) {
                Element elementCommand = (document).createElement(allCommand);
                elementCommand.appendChild(document.createTextNode("\n"));
                (rootElement).appendChild(elementCommand);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(fileName)+".xml");
            transformer.transform(source, result);
        }catch (ParserConfigurationException | TransformerException e) {
            System.out.println("Exception: " + e);
        }
    }

    /**
     * Save the collection in a file .csv
     * @throws IOException for the file
     */
    public static void save() throws IOException {
        String fileName = "data.csv";
        try (PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            pw.println("Id,Name, Coordinates, Date, Height, PassportID, Hair Color,Nationality, Location\n");
            for (Map.Entry<Integer, Person> entry: personas.entrySet()) {
                pw.println(entry.getValue().getId()+","+entry.getValue().getName()+","+entry.getValue().getCoordinates()+","+entry.getValue().getCreationDate()+","+entry.getValue().getHeight()+","+entry.getValue().getPassportID()+","+entry.getValue().getHairColor()+","+entry.getValue().getNationality()+","+entry.getValue().getLocation()+"\n");
            }
            System.out.println("All collection written to the file CSV.");
        } catch (IOException e) {
            System.out.println("Error while writing to the file CSV: " + e.getMessage());
        }
    }
}
