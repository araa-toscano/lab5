import Collections.Comander;
import Collections.Message;
import java.io.IOException;
import java.util.*;

//144504

public class Main {
    /**
     * Main structure for all commands
     * @param args args
     */

    public static void main(String[] args) {

        System.out.println("\nWelcome to this game!!");
        Message firstInstruction = new Message();
        System.out.println(firstInstruction.GeneralMessage() + Message.help() + "\n");

        Scanner Command = new Scanner(System.in);
        boolean salir = false;
        String principalCommand1;
        ArrayList<String> allCommands = new ArrayList<>();

        while (!salir) {
            System.out.println("\nEnter a command: ");

            try {
                principalCommand1 = Command.next();
                allCommands.add(principalCommand1);

                switch (principalCommand1) {
                    case "help" -> Comander.help();
                    case "info" -> Comander.info();
                    case "show" -> Comander.show();
                    case "insert" -> Comander.parameterPerson();
                    case "update" -> Comander.update();
                    case "remove_key" -> Comander.removeKey();
                    case "clear" -> Comander.clear();
                    case "save" -> Comander.save();
                    case "execute_script" -> {
                        try {
                            Comander.generateScript(allCommands);
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    case "history" -> Comander.history(allCommands);
                    case "replace_if_greater" -> Comander.replaceIfGreater();
                    case "remove_greater_key" -> Comander.removeGreaterKey();
                    case "remove_all_by_nationality" -> Comander.removeAllNationality();
                    case "remove_any_by_location" -> Comander.removeAllLocation();
                    case "group_counting_by_location" -> Comander.groupCounting();
                    case "exit" -> salir = true;
                    default -> System.out.println("You press something wrong. \nPlease, try again! ");
                }

            } catch (IllegalStateException | IllegalArgumentException | IOException |InputMismatchException s) {
                System.out.println("Try again!!");
                Command.next();
            }
        }
    }
}
