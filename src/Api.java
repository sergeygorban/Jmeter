public enum Api {


    ������_�������_������_�����_����������_��������_������_�����("http://10.100.174.36:8091/incoming-packets",
            "POST","������_�������_������_�����","����������_������"),


    ����("https://hooks.zapier.com/hooks/catch/3320164/azrwrw/","POST","����","����");



    public final String STORAGE = "C:\\Users\\Admin\\Desktop\\������";
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
