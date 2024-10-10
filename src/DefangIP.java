import java.util.Scanner;

public class DefangIP {
    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        //String ipAddress = "192.168.0.1";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Ip address ");
        String ipAddress = scanner.nextLine();
        String defangedAddress = defangIPaddr(ipAddress);
        System.out.println("Defanged IP Address: " + defangedAddress);
    }
}
