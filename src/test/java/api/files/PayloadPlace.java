package api.files;

public class PayloadPlace {
    public static String addPlace() {
        return "{\n" +
                "    \"location\": {\n" +
                "        \"lat\": -38.383494,\n" +
                "        \"lng\": 33.427362\n" +
                "    },\n" +
                "    \"accuracy\": 50,\n" +
                "    \"name\": \"Frontline house\",\n" +
                "    \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "    \"address\": \"29, side layout, cohen 09\",\n" +
                "    \"types\": [\n" +
                "        \"shoe park\",\n" +
                "        \"shop\"\n" +
                "    ],\n" +
                "    \"website\": \"http://google.com\",\n" +
                "    \"language\": \"French-IN\"\n" +
                "}";
    }

    public static String updatePlace(String placeId) {
        return String.format("{\n" +
                "    \"place_id\": \"%s\",\n" +
                "    \"address\": \"70 Summer walk, USA\",\n" +
                "    \"key\": \"qaclick123\"\n" +
                "}",placeId);
    }
    public static String updatePlace(String placeId,String address) {
        return String.format("{\n" +
                "    \"place_id\": \"%s\",\n" +
                "    \"address\": \"%s\",\n" +
                "    \"key\": \"qaclick123\"\n" +
                "}",placeId,address);
    }
    public static String deletePlace(String placeId){
        return String.format("{\n" +
                "    \"place_id\": \"%s\"\n" +
                "}",placeId);
    }

}
