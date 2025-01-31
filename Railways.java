import java.util.*;

public class Railways {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Train train = new Train();

        System.out.println("Welcome to Make My Trip\nEnter your details to login");

        System.out.print("\nEnter username:");
        String us = sc.nextLine();
        
        System.out.print("Enter password:");
        String pw = sc.nextLine();
        
        System.out.print("Enter email id:");
        String em = sc.nextLine();
        
        System.out.println("\nWelcome to the ticket booking counter:");

        while (true) {
            System.out.print("\nEnter username: ");
            String username = sc.nextLine();
            if (username.equals(us)) {
                break;
            } else {
                System.out.println("Invalid username. Enter again.");
            }
        }

        while (true) {
            System.out.print("Enter password (Enter 'forget password' if you forget your password.): ");
            String password = sc.nextLine();
            if (password.equals("forget password")) {
                while (true) {
                    System.out.print("Enter email id: ");
                    String emailid = sc.nextLine();
                    if (emailid.equals(em)) {
                        System.out.println("Login Successful");
                        break;
                    }else {
                        System.out.println("Invalid email id. Enter again.");
                    }
                }
                break;
            } else if (password.equals(pw)) {
                System.out.println("Login Successful");
                break;
            } else {
                System.out.println("Invalid password. Enter again.");
            }
        }

        System.out.println("\nRoute:1 Kadapa\nRoute:2 Hyderabad\nRoute:3 Bangalore");
        int route;
        while (true) {
            System.out.print("Select route (1-3): ");
            route = sc.nextInt();
            if (route == 1 || route == 2 || route == 3) {
                break;
            } else {
                System.out.println("Invalid option. Select again.");
            }
        }

        System.out.println("\nTicket prices (per seat):\n1.First class - 1000/-\n2.Second class - 500/-\n3.Third class - 250/-");
        System.out.print("Select price (options from 1 to 3): ");
        int opt = sc.nextInt();

        sc.nextLine(); 
        switch (opt) {
            case 1:
                while (true){
                    System.out.println("\nTrain 1: Mail Express\nTrain 2: Superfast Express");
                    System.out.print("Select train (1-2): ");
                    int t1 = sc.nextInt();
                    if(t1 == 1 || t1 == 2){
                        System.out.print("Enter number of seats: ");
                        int s1 = sc.nextInt();
                        if (t1 == 1) {
                            train.bookSeats(us, s1, Train.train1, 1000);
                            break;
                        } else if (t1 == 2) {
                            train.bookSeats(us, s1, Train.train2, 1000);
                            break;
                        } else {
                            System.out.println("Invalid train selection.");
                        }
                        break;

                    }else{
                        System.out.println("Invalid selection");
                    }
                    
                }
                break;
            case 2:
                while (true){
                    System.out.println("\nTrain 3: Shatabdi Express\nTrain 4: Duronto Express");
                    System.out.print("Select train (3-4): ");
                    int t2 = sc.nextInt();
                    if(t2 == 3 || t2 == 4){
                        System.out.print("Enter number of seats: ");
                        int s2 = sc.nextInt();
                        if (t2 == 3) {
                            train.bookSeats(us, s2, Train.train3, 500);
                            break;
                        } else if (t2 == 4) {
                            train.bookSeats(us, s2, Train.train4, 500);
                            break;
                        } else {
                            System.out.println("Invalid train selection.");
                        }   
                        break; 
                    }else{
                        System.out.println("Invalid selection");
                    }            
                }
                break;

            case 3:
                while (true){
                    System.out.println("\nTrain 5: Intercity Express\nTrain 6: Garib Rath Express");
                    System.out.print("Select train (5-6): ");
                    int t3 = sc.nextInt();
                    if(t3 == 5 || t3 == 6){
                        System.out.print("Enter number of seats: ");
                        int s3 = sc.nextInt();
                        if (t3 == 5) {
                            train.bookSeats(us, s3, Train.train3, 250);
                            break;
                        } else if (t3 == 6) {
                            train.bookSeats(us, s3, Train.train6, 250);
                            break;
                        } else {
                            System.out.println("Invalid train selection.");
                        }
                        break;
                    }else{
                        System.out.println("Invalid selection");
                    }
                }
                break;
 
            default :
                System.out.println("Invalid price option.");
        }

        sc.close();
    }
}

class Train {
    static int train1 = 100, train2 = 100, train3 = 100, train4 = 100, train5 = 100, train6 = 100;

    public void bookSeats(String username, int seats, int availableSeats, int pricePerSeat) {
        if (availableSeats >= seats) {
            System.out.printf("Your ticket booking price is: %d\n", seats * pricePerSeat);
            availableSeats -= seats;
            payment();
            System.out.println("\nTicket details");
            System.out.println("Username: "+username+"\nSeats: "+seats+"\nTotal price: "+seats * pricePerSeat);

        } else {
            System.out.println("Seats are not available");
        }
    }

    public void payment() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nSelect payment method:\n1.Phone Pay\n2.Google Pay\n3.Paytm\n4.Credit Card");
            System.out.print("Select option: ");
            int pay = sc.nextInt();
            if (pay == 1 || pay == 2 || pay == 3) {
                System.out.print("Enter pin to continue: ");
                sc.nextInt();
                System.out.println("Ticket confirmed.");
                break;
            } else if (pay == 4) {
                System.out.print("Enter credit card pin: ");
                sc.nextLong();
                System.out.println("Ticket confirmed.");
                break;
            } else {
                System.out.println("Select valid option.");
            }
        }
    }
    
}

