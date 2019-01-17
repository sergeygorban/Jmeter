import java.util.regex.MatchResult
import java.util.regex.Matcher
import java.util.regex.Pattern
import java.util.stream.Collectors
import java.util.stream.Stream

class RegEx {


    public static void main(String[] args) {

        String response = '{"category_id": "1", \n' +
                ' "category_name": "Computers and accessories",\n' +
                ' "category_id": "2",\n' +
                ' "category_goods": [\n' +
                '\t{"id": "100", "name": "monitor","price": "125"},\n' +
                '\t{"id": "101", "name": "usb wire ","price": "10"}\n' +
                '  ]\n' +
                '}';

        //String REGEX = '"category_id": "(.+)"';
        //String REGEX = '"id": "(.+)", "name"';

        List<String> listREGEX = new ArrayList<>();
        listREGEX.add("category_name");
        listREGEX.add("category_id");
        listREGEX.add("category_goods");

        List<String> listParametersFromAPI = new ArrayList<>();

        listREGEX.stream().forEach{elementFromListREGEX ->
            Stream<MatchResult> result = Pattern.compile(elementFromListREGEX).matcher(response).results();
            result.forEach{element -> listParametersFromAPI.add(element.group(0))}
        };
        println(listParametersFromAPI)

        if (listParametersFromAPI.size() == listREGEX.size()) {
            println("All parameters are present in the API response");
        } else {
            println("There are no parameters in the API response or some parameters are missing");
        }





/*        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(response);

        long count = matcher.results().count();
        println(count);*/


        //matcher.results().forEach { a -> println(a.group(1) + "!!!!!")}


/*        println matcher.groupCount();
        println matcher.find();
        println matcher.group(0);
        println matcher.find();
        println matcher.group(0);*/

/*        if (matcher.find() && matcher.group(1).equals("1")) {
            println "The value of the \"category ID\" parameter is \"1\"";
        } else {
            println "The value of the \"Category ID\" parameter was not found or is not equal to \"1\"";
        }*/



    }
}
