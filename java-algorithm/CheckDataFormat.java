import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class CheckDataFormat {
    private static final Scanner sc = new Scanner(System.in);
    private static final String PHONE_STRING = "^(0)[0-9]{9}$";
    private static final String EMAIL_STRING = "^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";

    private static String checkString() {
        while (true)    {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("String not empty!");
                System.out.print("Please enter again: ");
            } else {
                return result;
            }
        }
    }

    public static String checkPhone() {
        while (true) {
            try {
                int phone = Integer.parseInt(sc.nextLine());
                String result = String.valueOf(phone);

                if (!result.matches(PHONE_STRING)) {
                    System.err.println("Phone number must be 10 digits");
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.err.println("Phone number must be number");
                System.out.println("Please enter again: ");
            }
        }
    }

    public static String checkDate() {
        while (true) {
            try {
                String date = checkString();
                Date d = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                return date;
            } catch (ParseException e) {
                System.err.println("Date to correct format(dd/MM/yyyy");
                System.out.println("Please enter again: ");
            }
        }
    }
    
    public static String checkEmail() {
        while (true) {
            String email = checkString();

            if (!email.matches(EMAIL_STRING)) {
                System.err.println("Email must be correct format");
                System.out.println("Please enter again: ");
            } else {
                return email;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Phone number: ");
        String phone = checkPhone();
        System.out.println("Date: ");
        String date = checkDate();
        System.out.println("Email: ");
        String email = checkEmail();
    }
}