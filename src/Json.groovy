import com.google.gson.*
import com.google.gson.reflect.TypeToken
import org.apache.jmeter.assertions.AssertionResult
import org.apache.jmeter.threads.JMeterContextService

class Json {


    private String response = JMeterContextService.getContext().getPreviousResult().getResponseDataAsString();

    private Map<String,JsonElement> map = new Gson().fromJson(response,new TypeToken<HashMap<String,JsonElement>>(){}
            .getType());

    private List<String> errors;
    private String valueFromMap;

    public List<String> getErrors() {

        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        return this.errors
    }

    public String getValueFromMap() {
        return this.valueFromMap
    }

    public getErrorsForPrint() {
        this.errors.each {entry -> println entry};
    }

    public void getAssertionResult() {
        AssertionResult assertionResult = new AssertionResult();
        assertionResult.setFailureMessage("Actual parameter values are not as expected. " +
                "View Jmeter command line messages")
        assertionResult.setFailure(true);
    }

    public String convertValueToString(String parameterName) {

        String value = "";

        if (map.get(parameterName).isJsonPrimitive()) {

            value = map.get(parameterName).getAsString();

        } else if (map.get(parameterName).isJsonNull()) {

            value = "null";

        } else {

            throw new RuntimeException("Parameter value is not suitable for converting");
        }

        return this.valueFromMap = value;
    }

    public String convertValueToString(String parameterNameForObject, String parameterNameInObject) {

        String value = "";

        if (map.get(parameterNameForObject) != null) {

            if (map.get(parameterNameForObject).isJsonObject()) {

                JsonObject obj = map.get(parameterNameForObject).getAsJsonObject();

                if (obj.get(parameterNameInObject) != null && obj.get(parameterNameInObject).isJsonPrimitive()) {

                    value = obj.get(parameterNameInObject).getAsString();

                } else if (obj.get(parameterNameInObject).isJsonNull()){

                    value = "null";

                } else if (obj.get(parameterNameInObject) == null){

                    throw new RuntimeException("!!!!!!!!!! " + parameterNameInObject
                            + " parameter is not present in the response !!!!!!!!!!");
                } else {

                    throw new RuntimeException("!!!!!!!!!! Value for " + parameterNameInObject
                            + " parameter is not suitable for converting !!!!!!!!!!");
                }

            } else if (map.get(parameterNameForObject).isJsonNull()) {

                value = "null";

            } else {
                throw new RuntimeException("!!!!!!!!!! Value for " + parameterNameForObject
                        + " parameter is not suitable for converting !!!!!!!!!!");
            }

        } else {

            throw new RuntimeException("!!!!!!!!!! " + parameterNameForObject
                    + " parameter is not present in the response !!!!!!!!!!");
        }

        return this.valueFromMap = value;

    }

    public int getNumberParametersInResponse () {

        int summ = 0;
        map.each {key, value ->

            if (value.isJsonObject()) {
                summ = value.getAsJsonObject().size();
            }
        }
        return summ + map.size();
    }
}
