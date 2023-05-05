package Collections;

public class Message {

    /**
     * Method for showing the first message
     * @return message
     */
    public String GeneralMessage() {
        return "Here you could have add objects to the collections\n" //MAYBE CORREGIR ESCRITURA
                + "\n------------INSTRUCTIONS------------" +
                "\n\nYou must write the following commands in order to continue\nList of commands: \n\n"
                ;
    }

    /**
     * Shows all the commands
     * @return available commands
     */
    public static String help() {
        return  "help : output help for available commands\n" +
                "info : output to the standard output stream information about the collection (type, initialization date, number of elements, etc.)\n" +
                "show : output to the standard output stream all elements of the collection in the string representation\n" +
                "insert null {element} : add a new element with the specified key\n" +
                "update id {element} : update the value of a collection element whose id is equal to the specified\n" +
                "remove_key null : delete an element from the collection by its key\n" +
                "clear : clear the collection\n" +
                "save : save the collection to a file\n" +
                "execute_script file_name : read and execute the script from the specified file. \nThe script contains commands in the same form in which they are entered by the user in interactive mode.\n" +
                "exit : terminate the program (without saving to a file)\n" +
                "history : output the last 9 commands (without their arguments)\n" +
                "replace_if_greater null {element} : replace the value by key if the new value is greater than the old\n" +
                "remove_greater_key null : remove from the collection all elements whose key exceeds the specified one\n" +
                "remove_all_by_nationality nationality : remove from the collection all elements whose value of the nationality field is equivalent to the specified\n" +
                "remove_any_by_location location : remove from the collection one element whose value of the location field is equivalent to the specified\n" +
                "group_counting_by_location : group the collection items by the value of the location field, output the number of items in each group";
    }

}
