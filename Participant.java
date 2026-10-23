public class Participant {

    private String participantID, username, game;
    private int age, fee;
    private boolean status;


    Participant(String participantID, String username, int age, int category){
        this.participantID = participantID;
        this.username = username;
        this.age = age;
        status = false;
        setGame(category);
    }


    private boolean setGame(int category){
        if(category == 1){
            game = "Racing";
            fee = 500;
            return true;
        }
        else if(category == 2){
            game = "Football";
            fee = 700;
            return true;
        }
        else if(category == 3){
            game = "Battle Royale";
            fee = 1000;
            return true;
        }
        return false;
    }

    String getParticipantID(){return participantID;}
    String getUsername(){return username;}
    int getAge(){return age;}
    String getGame(){return game;}
    int getFee(){return fee;}
    boolean getStatus(){return status;}

    String statusText(){return status ? "Confirmed" : "Pending";}

    boolean isEligible(){return age >= 16;}

    String eligibilityText(){return isEligible() ? "Eligible" : "Not Eligible";}

    boolean updateGame(int category){
        if(status){
            System.out.println("Cannot change game: registration already confirmed.");
            return false;
        }
        if(!setGame(category)){
            System.out.println("Invalid game category.");
            return false;
        }
        System.out.println("Game changed to "+game+". Fee: PKR "+fee);
        return true;
    }

    boolean updateAge(int newAge){
        if(status){
            System.out.println("Cannot update age: registration already confirmed.");
            return false;
        }
        if(newAge <= 0){
            System.out.println("Invalid age: age must be positive.");
            return false;
        }
        age = newAge;
        System.out.println("Age updated to "+age+". Eligibility: "+eligibilityText());
        return true;
    }

    boolean checkEligibility(){
        System.out.println("Eligibility: "+eligibilityText());
        return isEligible();
    }

    boolean confirmRegistration(){
        if(status){
            System.out.println("Registration is already confirmed.");
            return false;
        }
        if(!isEligible()){
            System.out.println("Registration rejected: minimum age is 16.");
            return false;
        }
        status = true;
        System.out.println("Registration confirmed.");
        return true;
    }

    void displayParticipant(){
        System.out.println("Participant ID: "+participantID+" \n Gamer: "+username+" \n Age: "+age);
        System.out.println("Game: "+game+" \n Fee: PKR "+fee+" \n Status: "+statusText());
    }
}