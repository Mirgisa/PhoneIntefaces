//Create Interface and implement it via abstract class
//
//-> Create Phone Interface, it should have call, text, showCallHistory and showTextHistory functions.
//-> Create SimplePhone abstract classes and implement those functions. When you use call function it should ask who you want to call then should store it, if you text it should ask your text message and who you text with.
//
//-> Create YourNamePhone(HuseyinPhone) and inherit the SimplePhone and test your codes.
//
//NOTE: You can add related information or some necessary information to your classes.


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Phone {
    void call();
    void text();
    void showCallHistory();
    void showTextHistory();
}
abstract class SimplePhone implements Phone{
    protected List<String> callHistory;
    protected List<String> textHistory;
    public SimplePhone(){
        callHistory = new ArrayList<>();
        textHistory = new ArrayList<>();
    }
    private String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    @Override
    public void call() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name or number you want to call: ");
        String contact = scanner.nextLine();
        String time = getCurrentTime();
        callHistory.add(contact);
        System.out.println("Calling " + contact + "..."+ "time of call " + time);
    }

    @Override
    public void text() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name or number you want to text: ");
        String contact = scanner.nextLine();
        System.out.print("Enter your text message: ");
        String message = scanner.nextLine();
        String time = getCurrentTime();
        textHistory.add("To: " + contact + " - Message: " + message);
        System.out.println("Texting to " + contact + ": " + message+" "+time);

    }

    @Override
    public void showCallHistory() {
        String time = getCurrentTime();
        System.out.println("Call History:");
        if (callHistory.isEmpty()) {
            System.out.println("No calls made yet.");
        } else {
            for (String call : callHistory) {
                System.out.println(call+" called "+" at "+time);
            }
        }

    }

    @Override
    public void showTextHistory() {
        String time = getCurrentTime();
        System.out.println("Text History:");
        if (textHistory.isEmpty()) {
            System.out.println("No texts sent yet.");
        } else {
            for (String text : textHistory) {
                System.out.println(text+" "+time);
            }

        }
    }
}
class MirgisaPhone extends SimplePhone{
    //protected double time;
    public MirgisaPhone(){
        super();
       // this.time =time;

    }
//
//    public double getTime() {
//        return time;
//    }
}
public class PhoneService{
    public static void main(String[] args) {
        MirgisaPhone myphone = new MirgisaPhone();
        myphone.call();
        myphone.text();
        myphone.showCallHistory();
        myphone.showTextHistory();
    }

}