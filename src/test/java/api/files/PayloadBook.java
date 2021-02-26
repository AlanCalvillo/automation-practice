package api.files;

public class PayloadBook {
    public static final String addBook(){
        return "{\n" +
                "  \"name\": \"Learn Appium Automation with Java\",\n" +
                "  \"isbn\": \"bcd\",\n" +
                "  \"aisle\": \"227\",\n" +
                "  \"author\": \"John foe\"\n" +
                "}";
    }
    public static final String deleteBook(String bookId){
        return String.format("{\n" +
                "  \"ID\": \"%s\"\n" +
                "}",bookId);
    }
}
