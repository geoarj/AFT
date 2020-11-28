import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String filePath = null;
        Gson gson = new Gson();
        ArrayList<Company> companies = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the path to the file, please.");
            filePath = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            companies = gson.fromJson(new FileReader(new File(filePath)), new TypeToken<List<Company>>(){}.getType());
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }


        printShortInfo(companies);
        System.out.println();

        printExpiredSecurities(companies);
        System.out.println();

        printCompaniesAfterDate(companies);

        printTargetedSecurities(companies);

    }

    public static void printShortInfo(ArrayList<Company> companies) {
        if (!companies.isEmpty()) {
            System.out.println("Information about companies:");
            long counter = 1;
            for (Company element : companies) {
                System.out.println("«" + element.getName() + "»" + " - «Foundation date " + element.getValidDate().format(DateTimeFormatter.ofPattern("dd/MM/yy")) + "»");
            }
        }
        else {
            System.out.println("The list is empty");
        }
    }

    public static void printExpiredSecurities(ArrayList<Company> companies) {
        long id;
        LocalDate date;
        String name;
        long counterOfExpiredSecurities = 0;
        String owner;

        System.out.println("Information about expired securities:");

        for (Company x : companies) {
            ArrayList<Security> temp = x.getSecurities();
            long counterOfCompanyExpiredSecurities = 0;
            System.out.println("Company: " + x.getName());

            for (Security s : temp) {
                id =  s.getId();
                date = s.getValidDateTo();
                name = s.getName();
                owner = s.getOwnerOfTheSecurity();

                if (date.isBefore(LocalDate.now())) {
                    counterOfExpiredSecurities++;
                    counterOfCompanyExpiredSecurities++;
                    System.out.format(counterOfCompanyExpiredSecurities + " Expiry date: %s\n", date.format(DateTimeFormatter.ofPattern("dd/MM/yy")), name);
                }
            }

            if (counterOfCompanyExpiredSecurities == 1) {
                System.out.println(x.getName() + " on the current moment (" +
                        LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy")) + ") has " + counterOfCompanyExpiredSecurities + " expired securities.\n");
            }
            else if (counterOfCompanyExpiredSecurities >= 2 && counterOfCompanyExpiredSecurities <= 4) {
                System.out.println(x.getName() + " on the current moment (" +
                        LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy")) + ") has " + counterOfCompanyExpiredSecurities + " expired securities.\n");
            }
            else if (counterOfCompanyExpiredSecurities > 4) {
                System.out.println(x.getName() + " on the current moment (" +
                        LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy")) + ") has " + counterOfCompanyExpiredSecurities + " expired securities.\n");
            }
            else {
                System.out.println("There are no expired securities.\n");
            }
        }

        if (counterOfExpiredSecurities > 0) {
            System.out.println("At the moment (" +
                    LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy")) + ") expired in total " + counterOfExpiredSecurities + " securities.\n");
        }
    }

    public static void printCompaniesAfterDate(ArrayList<Company> companies) {
        String temp;
        DateValidator dv1 = new DateValidator(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        DateValidator dv2= new DateValidator(DateTimeFormatter.ofPattern("dd.MM,yyyy"));
        DateValidator dv3 = new DateValidator(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        DateValidator dv4 = new DateValidator(DateTimeFormatter.ofPattern("dd/MM/yy"));
        LocalDate date = null;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input date: ");
            while (!(temp = reader.readLine()).equalsIgnoreCase("exit")) {
                if (dv1.isValid(temp)) {
                    date = LocalDate.parse(temp, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    break;
                }
                else if (dv2.isValid(temp)) {
                    date = LocalDate.parse(temp, DateTimeFormatter.ofPattern("dd.MM,yy"));
                    break;
                }
                else if (dv3.isValid(temp)) {
                    date = LocalDate.parse(temp, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    break;
                }
                else if (dv4.isValid(temp)) {
                    date = LocalDate.parse(temp, DateTimeFormatter.ofPattern("dd/MM/yy"));
                    break;
                }
                else {
                    System.out.println("Incorrect format.\n(Expected: dd.MM.yyyy; dd.MM,yy; dd/MM/yyyy; dd/MM/yy)");
                }
            }
            System.out.println("The companies founded after " + date + ":");
            for (Company c : companies) {
                if (isFoundedAfter(date, c)) {
                    System.out.println(c.getName());
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isFoundedAfter(LocalDate date, Company company) {
        return company.getValidDate().isAfter(date);
    }

    public static void printTargetedSecurities(ArrayList<Company> companies) {
        String temp;
        String code = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Input currency: ");
            while (!(temp = reader.readLine()).equalsIgnoreCase("exit")) {
                if (temp.equalsIgnoreCase("RUB")) {
                    code = temp;
                    break;
                }
                else if (temp.equalsIgnoreCase("EUR") || temp.equalsIgnoreCase("EU")) {
                    code = temp;
                    break;
                }
                else if (temp.equalsIgnoreCase("USD")) {
                    code = temp;
                    break;
                }
                else {
                    System.out.println("Incorrect format, try again.\n(Expected: RUB ; USD ; EUR ; EU)");
                }
            }

            System.out.println("Securities using " + code.toUpperCase() + ":");
            for (Company c : companies) {
                ArrayList<Security> securities = c.getSecurities();
                for (Security s : securities) {
                    if (doUseCurrency(code, s)) {
                        System.out.format("ID: %d\tCODE: %s\n" ,s.getId(), s.getCode());
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean doUseCurrency(String code, Security security) {
        return security.getCurrency().equalsIgnoreCase(code);
    }
}