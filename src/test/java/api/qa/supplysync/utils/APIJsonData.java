package api.qa.supplysync.utils;

public class APIJsonData {


    // I AM USING APIJsonData TO MAKE MY AUTOMATION PROFESSIONAL AND EASY TO MAINTAIN AND REUSABLE!
    public static String createCompany(String name, String email, String address, String phoneNumber){

        return "{\n" +
                "  \"logo\": \"/Users/akmalaralov/Desktop/Google.png\",\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"address\": \""+address+"\",\n" +
                "  \"phoneNumber\": \""+phoneNumber+"\"\n" +
                "}";

    }


    public static String createBranch(String name, String email, String address, String phone, String regionId, String companyId){

        return "{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"address\": \""+address+"\",\n" +
                "  \"phoneNumber\": \""+phone+"\",\n" +
                "  \"regionId\": "+regionId+",\n" +
                "  \"companyId\": "+companyId+"\n" +
                "}";

    }
}
