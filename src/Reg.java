import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Reg {

    public static void main(String[] args) {

        String response = "{\"category_id\": \"1\", \n" +
                " \"category_name\": \"Computers and accessories\",\n" +
                " \"category_id\": \"2\",\n" +
                " \"category_goods\": [\n" +
                "\t{\"id\": \"100\", \"name\": \"monitor\",\"price\": \"125\"},\n" +
                "\t{\"id\": \"101\", \"name\": \"usb wire \",\"price\": \"10\"}\n" +
                "  ]\n" +
                '}';

        List<String> listREGEX = new ArrayList<>();
        listREGEX.add("category_name");
        listREGEX.add("category_id");
        listREGEX.add("category_goods");

        Pattern pattern = Pattern.compile(listREGEX.get(0));
        Matcher matcher = pattern.matcher(response);

        /*System.out.println(matcher.find());
        System.out.println(matcher.group(0));*/


        List<String> listParametersFromAPI = new ArrayList<>();

        listREGEX.stream()
                .map(elementFromListREGEX -> Pattern.compile(elementFromListREGEX).matcher(response).results())
                .forEach(results -> {
                    results.forEach(parameter -> listParametersFromAPI.add(parameter.group(0)));
                });

        System.out.println(listParametersFromAPI);




/*        String REGEX = "\"category_id\": \"(.+)\"";

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(response);



        System.out.println( matcher.results().count());
        matcher.results().forEach(a -> System.out.println(a.group(1)));


        System.out.println(matcher.groupCount());
        System.out.println(matcher.find());
        System.out.println(matcher.group(0));
        System.out.println(matcher.find());
        System.out.println(matcher.group(0));

        if (matcher.find() && matcher.group(1).equals("1")) {
            System.out.println("The value of the \"category ID\" parameter is \"1\"");
        } else {
            System.out.println("The value of the \"Category ID\" parameter was not found or is not equal to \"1\"");
        }*/



    }
}
