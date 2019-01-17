public enum Api {


    Сервіси_вхідних_пакетів_даних_Збереження_вхідного_пакету_даних("http://10.100.174.36:8091/incoming-packets",
            "POST","Сервіси_вхідних_пакетів_даних","Збереження_пакету"),


    Тест("https://hooks.zapier.com/hooks/catch/3320164/azrwrw/","POST","Тест","Тест");



    public final String STORAGE = "C:\\Users\\Admin\\Desktop\\МинФин";
    public final String url;
    public final String method;
    public final String dataFile;
    public final String dataSheet;

    Api(String url, String method, String dataFile, String dataSheet) {
        this.url = url;
        this.method = method;
        this.dataFile = dataFile;
        this.dataSheet = dataSheet;
    }
}
