import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Company {
    private long id;
    @SerializedName("name")
    private String name;
    private String address;
    private String phoneNumber;
    private String inn;
    private String ogrn;
    @SerializedName("foundationDate")
    private String foundationDate;

    private ArrayList<Security> securities;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getInn() {
        return inn;
    }

    public String getOgrn() {
        return ogrn;
    }

    public String getFoundationDate() {
        return foundationDate;
    }

    public ArrayList<Security> getSecurities() {
        return securities;
    }

    public LocalDate getValidDate() { return LocalDate.parse(foundationDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")); }
}
