import java.util.*;
public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your participant ID :");
        String participantID = sc.next();

        System.out.println("Enter your gamer username :");
        String username = sc.next();

        System.out.println("Enter your age :");
        int age = sc.nextInt();
        while(age <= 0){
            System.out.println("Invalid age. Try again :");
            age = sc.nextInt();
        }

        System.out.println("Press 1 for Racing\nPress 2 for Football\nPress 3 for Battle Royale");
        int category = sc.nextInt();
        while(category < 1 || category > 3){
            System.out.println("Invalid game category. Try again :");
            category = sc.nextInt();
        }

        Participant pt = new Participant(participantID, username, age, category);
        pt.displayParticipant();

        int choice = 0;
        while(choice != 6){
            System.out.println("\nPress 1 to Update Game\nPress 2 to Update Age\nPress 3 to Check Eligibility\nPress 4 to Confirm Registration\nPress 5 to Display\nPress 6 to Exit");
            choice = sc.nextInt();

            if(choice == 1){
                System.out.println("Press 1 for Racing\nPress 2 for Football\nPress 3 for Battle Royale");
                int newCategory = sc.nextInt();
                pt.updateGame(newCategory);
            }
            else if(choice == 2){
                System.out.println("Enter new age :");
                int newAge = sc.nextInt();
                pt.updateAge(newAge);
            }
            else if(choice == 3){pt.checkEligibility();}
            else if(choice == 4){pt.confirmRegistration();}
            else if(choice == 5){pt.displayParticipant();}
            else if(choice != 6){System.out.println("Invalid choice.");}
        }

        System.out.println("Final: Participant "+pt.getParticipantID()+" \n "+pt.getUsername()+" \n Age "+pt.getAge()+" \n "+pt.getGame()+" \n PKR "+pt.getFee()+" \n "+pt.statusText());
    }
}