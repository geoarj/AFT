import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Security {
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("expirationDate")
    private String expirationDate;
    private String ownerOfTheSecurity;
    private String currency;
    private String code;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getOwnerOfTheSecurity() {
        return ownerOfTheSecurity;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getValidDateTo() { return LocalDate.parse(expirationDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")); }
}