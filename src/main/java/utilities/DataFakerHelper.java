package utilities;

import net.datafaker.Faker;

import java.util.Locale;

public class DataFakerHelper {
    private Locale local = new Locale("us");
    private Faker faker = new Faker(local);

    public static DataFakerHelper getDataFakerHelper() {
        return new DataFakerHelper();
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getDay() {
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public String getMonth() {
        return "September";
    }

    public String getYear() {
        return String.valueOf(faker.number().numberBetween(1945, 2005));
    }

    public String getEmailAddress() {
        return faker.internet().emailAddress();
    }

    public String getState() {
        return "California";
    }

    public String getCityName() {
        return faker.address().city();
    }

    public String getStreetAddress() {
        return faker.address().streetAddress();
    }

    public String getPostCode() {
        return faker.address().postcode();
    }

    public String getCompanyName() {
        return faker.company().name();
    }

    public String getCountryName() {
        return "United States";
    }

    public String getPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getPassword() {
        return faker.internet().password();
    }
}
