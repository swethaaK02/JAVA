

import java.time.LocalDate; 
import java.util.Scanner; 
class ConsoleColors 
{ 
    static final String def = "\u001b[0;1m";
    static final String blink = "\u001b[5m";
    static final String red =  "\u001b[31;1m";
    static final String green = "\u001b[32;1m";
    static final String yellow = "\u001b[33;1m";
    static final String blue = "\u001b[34;1m";
    static final String purple="\u001b[35;1m";
    static final String skblue = "\u001b[36;1m";
    static final String bgred =  "\u001b[101;1m";
    static final String bggreen = "\u001b[102;1m";
    static final String bgyellow = "\u001b[103;1m";
    static final String bgblue = "\u001b[104;1m";
    static final String bgpurpe = "\u001b[105;1m";
    static final String bgskblue = "\u001b[106;1m";
public static final String RESET = "\u001B[0m";

    // Text Colors
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Background Colors
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String MAGENTA_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";

    // Styles
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
} 
abstract class Payment 
{
	    private String mode;
	    private boolean isPaid;

	    public Payment(String mode) 
	    {
	        this.mode = mode;
	    }

	    public abstract void processPayment();

	    public boolean isPaid() 
	    {
	        return isPaid;
	    }

	    protected void setPaid(boolean paid) 
	    {
	        isPaid = paid;
	    }
	}

	class OnlinePayment extends Payment 
	{
	    private String platform;
	    private String upi;
	    private int pin;

	    public OnlinePayment(String platform, String upi, int pin) 
	    {
	        super("Online");
	        this.platform = platform;
	        this.upi = upi;
	        this.pin = pin;
	    }

	    public void processPayment() 
	    {
	        setPaid(true);
	        System.out.println("Payment processed successfully via " + platform + " using UPI: " + upi);
	        System.out.println("Payment completed successfully!");
	        System.out.println("payment Confirmed!");
	        
	    }

	    public boolean isPhonePe(String upi) 
	    {
	        String upiid = "^[0-9]{10}@(ybl|axl)$";
	        return upi.matches(upiid);
	    }

	    public boolean isPaytm(String upi) 
	    {
	        String upiid = "^[0-9]{10}@(ptsbi)$";
	        return upi.matches(upiid);
	    }

	    public boolean isGooglePay(String upi) 
	    {
	        String upiid = "^[0-9]{10}@(oksbi)$";
	        return upi.matches(upiid);
	    }
	}

	class OfflinePayment extends Payment 
	{
	    public OfflinePayment() 
	    {
	        super("Offline");
	    }

	    public void processPayment() 
	    {
	        setPaid(true);
	        System.out.println("Your booking is confirmed. Kindly pay the amount during the visit");
	    }
	}

	class PaymentProcessor 
	{
	    public static void executePayment() 
	    {
	        Scanner scanner = new Scanner(System.in);
	        boolean paymentSuccessful = false;

	        while (!paymentSuccessful) 
	        {
	            // Prompt user to select payment method
	            System.out.println("Select Payment Method:");
	            System.out.println("1. Online Payment");
	            System.out.println("2. Offline Payment");
	            int choice = scanner.nextInt();

	            if (choice == 1) 
	            {
	                // Online Payment Flow
	                System.out.println("Enter Platform (PhonePe, Paytm, GooglePay):");
	                String platform = scanner.next();

	                System.out.println("Enter your UPI ID:");
	                String upi = scanner.next();

	                System.out.println("Enter your PIN:");
	                int pin = scanner.nextInt();

	                OnlinePayment onlinePayment = new OnlinePayment(platform, upi, pin);

	                boolean isValidUPI = false;
	                switch (platform.toLowerCase()) 
	                {
	                    case "phonepe":
	                        isValidUPI = onlinePayment.isPhonePe(upi);
	                        break;
	                        
	                    case "paytm":
	                        isValidUPI = onlinePayment.isPaytm(upi);
	                        break;
	                        
	                    case "googlepay":
	                        isValidUPI = onlinePayment.isGooglePay(upi);
	                        break;
	                        
	                    default:
	                        System.out.println("Invalid platform. Please select PhonePe, Paytm, or GooglePay.");
	                        break;
	                }

	                if (isValidUPI) 
	                {
	                    onlinePayment.processPayment();
	                    paymentSuccessful = true;
	                } 
	                else 
	                {
	                    System.out.println("Invalid UPI ID for the selected platform. Please try again.");
	                }

	            } 
	            else if (choice == 2) 
	            {
	                // Offline Payment Flow
	                OfflinePayment offlinePayment = new OfflinePayment();
	                offlinePayment.processPayment();
	                paymentSuccessful = true;
	            } 
	            else 
	            {
	                System.out.println("Invalid choice. Please select a valid payment method.");
	            }
	        }

	       
	       
	    }
	} 
 
class Services  
{ 
    String cake; 
    int cakecost; 
    String photoclipping; 
    int photoclippingcost; 
    String partyprops; 
    int partypropscost; 
    String ledlights; 
    int ledlightscost; 
    String hbdletters; 
    int hbdletterscost; 
    String heartpillow; 
    int heartpillowcost; 
    String teddy; 
    int teddycost; 
    String chocolatebouquet; 
    int chocolatebouquetcost; 
    String chocolate; 
    int chocolatecost; 
    String singlerose; 
    int singlerosecost; 
    String bouquet; 
    int bouquetcost; 
    String roseheart; 
    int roseheartcost; 
    String fogeffect; 
    int fogeffectcost; 
    String photography; 
    int noofphotos; 
    int photographycost; 
    int total;
    void assigntotal()
    {
    	total=cakecost + photoclippingcost + partypropscost + ledlightscost + hbdletterscost + heartpillowcost + teddycost + chocolatebouquetcost + chocolatecost + 
                singlerosecost + bouquetcost + roseheartcost + fogeffectcost + photographycost;
    }
    void cakee(String a, int b)  
    { 
        cake = a; 
        cakecost = b; 
    } 
 
    void photos(String a, int b)  
    { 
        photoclipping = a; 
        photoclippingcost = b; 
    } 
 
    void props(String a, int b)  
    { 
        partyprops = a; 
        partypropscost = b; 
    } 
 
    void ledlights(String a, int b)


{ 
        ledlights = a; 
        ledlightscost = b; 
    } 
 
    void hbdletter(String a, int b)  
    { 
        hbdletters = a; 
        hbdletterscost = b; 
    } 
 
    void pillow(String a, int b)  
    { 
        heartpillow = a; 
        heartpillowcost = b; 
    } 
 
    void teddyy(String a, int b)  
    { 
        teddy = a; 
        teddycost = b; 
    } 
 
    void bouquets(String a, int b)  
    { 
        chocolatebouquet = a; 
        chocolatebouquetcost = b; 
    } 
 
    void chocolate(String a, int b)  
    { 
        chocolate = a; 
        chocolatecost = b; 
    } 
 
    void singlerosee(String a, int b)  
    { 
        singlerose = a; 
        singlerosecost = b; 
    } 
 
    void bouquett(String a, int b)  
    { 
        bouquet = a; 
        bouquetcost = b; 
    } 
 
    void roseheartt(String a, int b)  
    { 
        roseheart = a; 
        roseheartcost = b; 
    } 
 
    void fogeffectt(String a, int b)  
    { 
        fogeffect = a; 
        fogeffectcost = b; 
    } 
 
    void photographyy(String a, int b, int c)  
    { 
        photography = a; 
        noofphotos = b; 
        photographycost = c; 
    } 
     
    
    void displayBookingSummary()  
    { 
        System.out.println("\nExtra Services Booking Summary:"); 
        if(cake!=null) 
        { 
            System.out.println("Cake: " + cake + " - " + cakecost); 
        } 
        
        if(photoclipping!=null) 
        { 
            System.out.println("Photo Clipping: " + photoclipping + " - " + photoclippingcost); 
        } 
        if(partyprops!=null) 
        { 
            System.out.println("LED Lights: " + partyprops + " - " + partypropscost); 
        } 
        if(ledlights!=null) 
        { 
            System.out.println("LED Lights: " + ledlights + " - " + ledlightscost); 
        } 
        if(hbdletters!=null) 
        { 
            System.out.println("HBD Letters: " + hbdletters + " - " + hbdletterscost); 
        } 
        if(heartpillow!=null) 
        { 
            System.out.println("Heart Pillow: " + heartpillow + " - " + heartpillowcost); 
        } 
        if(teddy!=null) 
        { 
            System.out.println("Teddy: " + teddy + " - " + teddycost); 
        } 
        if(chocolatebouquet!=null) 
        { 
            System.out.println("Chocolate Bouquet: " + chocolatebouquet + " - " + chocolatebouquetcost); 
        } 
        if(chocolate!=null) 
        { 
            System.out.println("Chocolate: " + chocolate + " - " + chocolatecost); 
        } 
        if(singlerose!=null) 
        { 
            System.out.println("Single Rose: " + singlerose + " - " + singlerosecost); 
        } 
        if(bouquet!=null) 
        { 
            System.out.println("Bouquet: " + bouquet + " - " + bouquetcost); 
        } 
        if(roseheart!=null) 
        { 
            System.out.println("Rose Heart: " + roseheart + " - " + roseheartcost); 
        } 
        if(fogeffect!=null) 
        { 
            System.out.println("Fog Effect: " + fogeffect + " - " + fogeffectcost); 
        } 
        if(photography!=null) 
        { 
            System.out.println("Photography: " + photography + " - " + photographycost); 
        } 
        total=cakecost + photoclippingcost + partypropscost + ledlightscost + hbdletterscost + heartpillowcost + teddycost + chocolatebouquetcost + chocolatecost + 
                singlerosecost + bouquetcost + roseheartcost + fogeffectcost + photographycost;
        if(total!=0) 
        { 
            System.out.println("Total Cost: " + (cakecost + photoclippingcost + partypropscost + ledlightscost + hbdletterscost + heartpillowcost + teddycost + chocolatebouquetcost + chocolatecost + 
            singlerosecost + bouquetcost + roseheartcost + fogeffectcost + photographycost));
        }    
    } 
} 
 

class ServicesFunctionality extends Services  
{ 
    int cakecost = 500; 
    int photoclippingcost = 500; 
    int partypropscost = 500; 
    int ledlightscost = 500; 
    int hbdletterscost = 500; 
    int heartpillowcost = 500; 
    int teddycost = 500; 
    int chocolatebouquetcost = 500; 
    int chocolatecost = 500; 
    int singlerosecost = 500; 
    int bouquetcost = 500; 
    int roseheartcost = 500; 
    int fogeffectcost = 500; 
 
    Scanner sc = new Scanner(System.in); 
    boolean continueBooking = true; 
 
    public void selectMainServices()  
    { 
        while (continueBooking)  
        { 
        	displayBookingSummary();
            System.out.println("\nSelect Main Service Category:"); 
            System.out.println("1. Cakes"); 
            System.out.println("2. Gifts"); 
            System.out.println("3. Decorations"); 
            System.out.println("4. Flowers"); 
            System.out.println("5. Effects"); 
            System.out.println("6. Photography"); 
            System.out.println("7. Confirm Booking and Exit"); 
            System.out.println("8. Exit"); 
            System.out.print("Enter your choice: "); 
            int choice = sc.nextInt(); 
            switch(choice)  
            { 
                case 1: 
                	selectCakes();  
                	break; 
                case 2: 
                	selectGifts();  
                	break; 
                case 3: 
                	selectDecorations();  
                	break; 
                case 4: 
                	selectFlowers();  
                	break; 
                case 5: 
                	selectEffects();  
                	break; 
                case 6: 
                	selectPhotography();  
                	break; 
                case 7: 
                	confirmBooking();  
                	break; 
                case 8: 
                	break; 
                default: System.out.println("Invalid Choice"); 
            } 
        } 
    } 
 
    public void selectCakes()  
    { 
        System.out.println("\nSelect a cake: "); 
        System.out.println("1. Dark Chocolate Cake"); 
        System.out.println("2. Red Velvet"); 
        System.out.println("3. Butter Scotch"); 
        System.out.println("4. Black Forest"); 
        System.out.println("5. Blueberry Cake"); 
        System.out.println("6. Rasmalai Cake"); 
        System.out.println("7. Pista Chio"); 
        System.out.println("8. German Block Forest"); 
        System.out.println("9. Go Back"); 
        int choice = sc.nextInt(); 
        switch(choice)  
        { 
            case 1: 
            	cakee("Dark Chocolate Cake", cakecost);  
            	break; 
            case 2: 
            	cakee("Red Velvet", cakecost);  
            	break; 
            case 3: 
            	cakee("Butter Scotch", cakecost);  
            	break; 
            case 4: 
            	cakee("Black Forest", cakecost);  
            	break; 
            case 5: 
            	cakee("Blueberry Cake", cakecost);  
            	break; 
            case 6: 
            	cakee("Rasmalai Cake", cakecost);  
            	break; 
            case 7: 
            	cakee("Pista Chio", cakecost);  
            	break; 
            case 8: 
            	cakee("German Block Forest", cakecost);  
            	break; 
            case 9:  
            	break; 
            default: System.out.println("Invalid Choice"); 
        } 
    } 
 
    public void selectGifts()  
    { 
        System.out.println("\nSelect a gift:"); 
        System.out.println("1. Teddy Bear"); 
        System.out.println("2. Heart Pillow"); 
        System.out.println("3. Chocolate Bouquet"); 
        System.out.println("4. HBD Letters"); 
        System.out.println("5. Go Back"); 
        int choice = sc.nextInt(); 
        switch(choice)  
        { 
            case 1: 
            	teddyy("Teddy Bear", teddycost);  
            	break; 
            case 2: 
            	pillow("Heart Pillow", heartpillowcost);  
            	break; 
            case 3: 
            	bouquets("Chocolate Bouquet", chocolatebouquetcost);
            	break; 
            case 4: 
            	hbdletter("HBD Letters", hbdletterscost);  
            	break; 
            case 5:  
            	break; 
            default: 
            	System.out.println("Invalid Choice"); 
        } 
    } 
 
    public void selectDecorations()  
    { 
        System.out.println("\nSelect Decorations:"); 
        System.out.println("1. Party Props"); 
        System.out.println("2. LED Lights"); 
        System.out.println("3. Fog Effect"); 
        System.out.println("4. Go Back"); 
        int choice = sc.nextInt(); 
        switch(choice)  
        { 
            case 1:  
            	props("Party Props", partypropscost);  
            	break; 
 
            case 2:  
            	ledlights("LED Lights", ledlightscost);  
            	break; 
 
            case 3:  
            	fogeffectt("Fog Effect", fogeffectcost);  
            	break; 
 
            case 4:  
            	break; 
 
            default:  
            	System.out.println("Invalid Choice"); 
        } 
    } 
 
    public void selectFlowers()  
    { 
        System.out.println("\nSelect Flowers:"); 
        System.out.println("1. Single Rose"); 
        System.out.println("2. Bouquet"); 
        System.out.println("3. Rose Heart"); 
        System.out.println("4. Go Back"); 
        int choice = sc.nextInt(); 
        switch(choice) 
        { 
            case 1: 
            	singlerosee("Single Rose", singlerosecost);  
            	break; 
            case 2: 
            	bouquett("Bouquet", bouquetcost);  
            	break; 
            case 3: 
            	roseheartt("Rose Heart", roseheartcost);  
            	break; 
            case 4:  
            	break; 
            default: 
            	System.out.println("Invalid Choice"); 
        } 
    } 
 
    public void selectEffects()  
    { 
        System.out.println("\nSelect Effects:"); 
        System.out.println("1. Fog Effect"); 
        System.out.println("2. Go Back"); 
        int choice = sc.nextInt(); 
        switch(choice)  
        { 
            case 1: 
            	fogeffectt("Fog Effect", fogeffectcost);  
            	break; 
            case 2:  
            	break; 
            default: 
            	System.out.println("Invalid Choice"); 
        } 
    } 
 
    public void selectPhotography()  
    { 
        System.out.println("\nSelect Photography:"); 
        System.out.println("1. Photography"); 
        System.out.println("2. Go Back"); 
        int choice = sc.nextInt(); 
        switch(choice)  
        { 
            case 1:  
            	System.out.print("Enter number of photos required"); 
            	int noofphotos=sc.nextInt(); 
            	photographycost=noofphotos*10; 
            	photographyy("Photography", noofphotos, photographycost);  
            	break; 
            case 2:  
            	break; 
            default: 
            	System.out.println("Invalid Choice"); 
        } 
    } 
    public void confirmBooking()  
    { 
        displayBookingSummary(); 
        System.out.print("\nDo you want to proceed to payment? (y/n): "); 
        char confirm = sc.next().charAt(0); 
        if (confirm == 'y' || confirm == 'Y')  
        { 
            PaymentProcessor.executePayment(); 
            continueBooking = false; 
        }  
        else  
        { 
            System.out.println("Booking Cancelled!"); 
            continueBooking = false; 
        } 
    } 
}


 
class TextCalendar1 
{ 
	static String selectedDate1="";
	static String selectedTimeSlot1="";
    private Scanner scanner; 
 
    // Constructor to initialize the scanner 
    public TextCalendar1() 
    { 
        this.scanner = new Scanner(System.in); 
    } 
 
    // Main entry point to start the scheduling process 
    public void start() 
    { 
        // Step 1: Select the duration of the time slot 
        double selectedDuration = selectTimeSlotDuration(); 
 
        // Step 2: Select a month


        int selectedMonth = selectMonth(); 
        LocalDate selectedMonthDate = LocalDate.now().withMonth(selectedMonth).withDayOfMonth(1); 
 
        // Step 3: Display the calendar for the selected month and select a date 
        displayCalendar(selectedMonthDate); 
        int selectedDay = selectDate(selectedMonthDate); 
        LocalDate selectedDate = selectedMonthDate.withDayOfMonth(selectedDay); 
 
        // Step 4: Display available time slots based on selected duration and allow user to choose 
        String selectedTimeSlot = selectTimeSlot(selectedDuration); 
        selectedDate1=selectedDate1+selectedDate;
        selectedTimeSlot1=selectedTimeSlot1+selectedTimeSlot;
        System.out.println("You selected date: " + selectedDate); 
        System.out.println("With time slot: " + selectedTimeSlot); 
 
        //scanner.close(); // Close the Scanner after use 
    } 
 
    private void displayCalendar(LocalDate date) 
    { 
        LocalDate firstDay = date.withDayOfMonth(1); // First day of the month 
        int monthLength = date.lengthOfMonth();       // Number of days in the month 
        int startDayOfWeek = firstDay.getDayOfWeek().getValue(); // 1=Monday, 7=Sunday 
 
        System.out.println("\n" + date.getMonth() + " " + date.getYear()); 
        System.out.println("Mon Tue Wed Thu Fri Sat Sun"); 
 
        // Print leading spaces for the first week 
        for (int i = 1; i < startDayOfWeek; i++) 
        { 
            System.out.print("    "); 
        } 
 
        // Print all days of the month 
        for (int day = 1; day <= monthLength; day++) 
        { 
            System.out.printf("%3d ", day); 
 
            // Move to a new line at the end of each week (after Sunday) 
            if ((startDayOfWeek + day - 1) % 7 == 0) 
            { 
                System.out.println(); 
            } 
        } 
        System.out.println(); // Final newline for formatting 
    } 
 
    private int selectMonth() 
    { 
        int selectedMonth = -1; 
 
        System.out.println("\nSelect a month (1-12):"); 
        System.out.println("1. January\n2. February\n3. March\n4. April\n5. May\n6. June"); 
        System.out.println("7. July\n8. August\n9. September\n10. October\n11. November\n12. December"); 
 
        // Loop until the user enters a valid month number 
        while (selectedMonth < 1 || selectedMonth > 12) 
        { 
            System.out.print("Enter your choice (1-12): "); 
            if (scanner.hasNextInt()) 
            { 
                selectedMonth = scanner.nextInt(); 
                if (selectedMonth < 1 || selectedMonth > 12) 
                { 
                    System.out.println("Invalid month. Please enter a number between 1 and 12."); 
                } 
            } 
            else 
            { 
                System.out.println("Invalid input. Please enter a number between 1 and 12."); 
                scanner.next(); // Consume the invalid input 
            } 
        } 
 
        return selectedMonth; 
    } 
 
    private int selectDate(LocalDate date) 
    { 
        int selectedDay = -1; 
 
        // Loop until the user enters a valid day number 
        while (selectedDay <= 0 || selectedDay > date.lengthOfMonth()) 
        { 
            System.out.print("\nEnter the day you wish to select (1-" + date.lengthOfMonth() + "): "); 
            if (scanner.hasNextInt()) 
            { 
                selectedDay = scanner.nextInt(); 
                if (selectedDay <= 0 || selectedDay > date.lengthOfMonth()) 
                { 
                    System.out.println("Invalid day number. Please enter a valid day between 1 and " + date.lengthOfMonth()); 
                } 
            } 
            else 
            { 
                System.out.println("Invalid input. Please enter a valid day number."); 
                scanner.next(); // Consume the invalid input 
            } 
        } 
 
        return selectedDay; 
    } 
 
    private double selectTimeSlotDuration() 
    { 
        double selectedDuration = -1; 
 
        System.out.println("\nSelect time slot duration:");


        System.out.println("1. 3 hours"); 
        System.out.println("2. 1.5 hours"); 
 
        // Loop until the user enters a valid duration 
        while (selectedDuration != 3.0 && selectedDuration != 1.5) 
        { 
            System.out.print("Enter your choice (1-2): "); 
            if (scanner.hasNextInt()) 
            { 
                int choice = scanner.nextInt(); 
                if (choice == 1) 
                { 
                    selectedDuration = 3.0; 
                } 
                else if (choice == 2) 
                { 
                    selectedDuration = 1.5; 
                } 
                else 
                { 
                    System.out.println("Invalid selection. Please choose 1 or 2."); 
                } 
            } 
            else 
            { 
                System.out.println("Invalid input. Please enter a number."); 
                scanner.next(); // Consume the invalid input 
            } 
        } 
 
        return selectedDuration; 
    } 
 
    private String selectTimeSlot(double duration) 
    { 
        // Define available time slots based on duration 
        String[] timeSlots; 
        if (duration == 3.0) 
        { 
            timeSlots = new String[]{ 
                "9:30 AM - 12:30 PM", 
                "1:00 PM - 4:00 PM", 
                "6:30 PM - 9:30 PM" 
            }; 
        } 
        else 
        { 
            timeSlots = new String[]{ 
                "9:30 AM - 11:00 AM", 
                "11:30 AM - 1:00 PM", 
                "2:00 PM - 3:30 PM", 
                "4:00 PM - 5:30 PM" 
            }; 
        } 
 
        // Display the available time slots 
        System.out.println("\nAvailable Time Slots:"); 
        for (int i = 0; i < timeSlots.length; i++) 
        { 
            System.out.println((i + 1) + ". " + timeSlots[i]); 
        } 
 
        int selectedSlot = -1; 
        // Loop until the user selects a valid time slot 
        while (selectedSlot < 1 || selectedSlot > timeSlots.length) 
        { 
            System.out.print("Select a time slot (1-" + timeSlots.length + "): "); 
            if (scanner.hasNextInt()) 
            { 
                selectedSlot = scanner.nextInt(); 
                if (selectedSlot < 1 || selectedSlot > timeSlots.length) 
                { 
                    System.out.println("Invalid selection. Please select a valid time slot."); 
                } 
            } 
            else 
            { 
                System.out.println("Invalid input. Please enter a number."); 
                scanner.next(); // Consume the invalid input 
            } 
        } 
 
        return timeSlots[selectedSlot - 1]; 
    } 
} 
abstract class Location 
{ 
    public abstract void startSelection();
    public abstract String getPlace();
    public abstract String gettheater();
    public abstract String gettimeDuration();
    public abstract int getprice();
} 
 
class Selection extends Location 
{ 
    private String place; 
    private String theater; 
    private String timeDuration; 
    private int price; 
    public String getPlace()
    {
    	return place;
    }
    public String gettheater()
    {
    	return theater;
    }
    public String gettimeDuration()
    {
    	return timeDuration;
    }
    public int getprice()
    {
    	return price;
    }
    private final String[] places = {"KPHB Colony", "Hitech City", "Dilsukhnagar", "Secunderabad"}; 
    private final String[] theaters = {"Delight Theater", "Heaven Theater", "Cosmos Theater"}; 
    private final String[] timeDurations = {"3 Hours", "1.5 Hours"}; 
 
    private final int[] delightPrices = {1799, 1499}; 
    private final int[] heavenPrices = {2999, 2499}; 
    private final int[] cosmosPrices = {5999, 4599}; 
 
    @Override 
    public void startSelection() 
    { 
        Scanner sc = new Scanner(System.in); 
        System.out.println(ConsoleColors.BOLD+ConsoleColors.CYAN +"$$$$EXPERIENCE THE MAGIC$$$$"+ConsoleColors.RESET); 
        System.out.println(ConsoleColors.BOLD+ConsoleColors.MAGENTA+"Heartwarming stories filled with laughter, love, and unforgettable moments."+ConsoleColors.RESET); 
        System.out.println(ConsoleColors.BOLD+ConsoleColors.bgskblue+ConsoleColors.RED+"Embrace the magic today!"+ConsoleColors.RESET); 
 
        System.out.println(ConsoleColors.BOLD+ConsoleColors.BLUE+"**Select your location**"+ConsoleColors.RESET); 
        for (int i = 0; i < places.length; i++) 
        { 
            System.out.println((i + 1) + ". " + places[i]); 
        } 
        System.out.print(ConsoleColors.BOLD+ConsoleColors.YELLOW+"Choose Your Option: "+ConsoleColors.RESET); 
        int placeOption = sc.nextInt(); 
        selectPlace(placeOption); 
 
        System.out.println("\n1. Delight Theater(Max 4)\n2. Heaven Theater(Max 10)\n3. Cosmos Theater(Max 18)");


        System.out.print(ConsoleColors.BOLD+ConsoleColors.YELLOW+"Choose Your Option: "+ConsoleColors.RESET); 
        int theaterOption = sc.nextInt(); 
        selectTheater(theaterOption); 
 
        displayTimeDurationsWithPrices(theaterOption); 
 
        System.out.print(ConsoleColors.BOLD+ConsoleColors.YELLOW+"\nChoose time duration (1-2): "+ConsoleColors.RESET); 
        int timeDurationOption = sc.nextInt(); 
        selectTimeDuration(theaterOption, timeDurationOption); 
 
        System.out.println(getSelectedOptions()); 
        //sc.close(); 
    } 
 
    private void selectPlace(int placeOption) 
    { 
        if (placeOption >= 1 && placeOption <= places.length) 
        { 
            place = places[placeOption - 1]; 
        } 
    } 
 
    private void selectTheater(int theaterOption) 
    { 
        if (theaterOption >= 1 && theaterOption <= theaters.length) 
        { 
            theater = theaters[theaterOption - 1]; 
        } 
    } 
 
    private void displayTimeDurationsWithPrices(int theaterOption) 
    { 
        System.out.println(ConsoleColors.BOLD+ConsoleColors.MAGENTA+"\nSelect a time duration:"+ConsoleColors.RESET); 
        switch (theaterOption) { 
            case 1: // Delight Theater 
                for (int i = 0; i < timeDurations.length; i++) 
                { 
                    System.out.println((i + 1) + ". " + timeDurations[i] + " - " + delightPrices[i] + "/-"); 
                } 
                break; 
            case 2: // Heaven Theater 
                for (int i = 0; i < timeDurations.length; i++) 
                { 
                    System.out.println((i + 1) + ". " + timeDurations[i] + " - " + heavenPrices[i] + "/-"); 
                } 
                break; 
            case 3: // Cosmos Theater 
                for (int i = 0; i < timeDurations.length; i++) 
                { 
                    System.out.println((i + 1) + ". " + timeDurations[i] + " - " + cosmosPrices[i] + "/-"); 
                } 
                break; 
        } 
    } 
 
    private void selectTimeDuration(int theaterOption, int timeDurationOption) 
    { 
        if (timeDurationOption >= 1 && timeDurationOption <= timeDurations.length) 
        { 
            timeDuration = timeDurations[timeDurationOption - 1]; 
            setPrice(theaterOption, timeDurationOption); 
        } 
    } 
 
    private void setPrice(int theaterOption, int timeDurationOption) 
    { 
        switch (theaterOption) 
        { 
            case 1: 
                price = delightPrices[timeDurationOption - 1]; 
                break; 
            case 2: 
                price = heavenPrices[timeDurationOption - 1]; 
                break; 
            case 3: 
                price = cosmosPrices[timeDurationOption - 1]; 
                break; 
        } 
    } 
 
    private String getSelectedOptions() 
    { 
        return "\nSelected Place: " + place + 
               "\nTheater: " + theater + 
               "\nTime Duration: " + timeDuration + 
               "\nPrice: " + price + "/-"; 
    } 
} 
 
class User { 
    private String username; 
    private String password; 
 
    public String getUsername() 
    { 
        return username; 
    } 
 
    public void setUsername(String username) 
    { 
        this.username = username; 
    } 
 
    public String getPassword() 
    { 
        return password; 
    } 
 
    public void setPassword(String password) 
    { 
        this.password = password; 
    } 
 
    public static int validation(String username, String password, User[] users, int size) 
    { 
        boolean isPasswordValid = (password.length() >= 6) && (password.matches(".*[A-Z].*"))&& (password.matches(".*[!@#$%^&()_+|~=`{}\\[\\]:\";'<>?,./].*"));  
 
        for (int i = 0; i < size; i++) 
        { 
            if ((users[i] != null) && (users[i].getUsername().equals(username))) 
            { 
                System.out.println(ConsoleColors.RED_BACKGROUND + "Username is already taken. Please try again." + ConsoleColors.RESET); 
                return 0; 
            } 
        } 
        if (!isPasswordValid) 
        { 
            System.out.println(ConsoleColors.RED_BACKGROUND + "Password must be at least 6 characters, contain one uppercase letter, and one special character." + ConsoleColors.RESET);

            return 0; 
        } 
 
        System.out.println(ConsoleColors.YELLOW_BACKGROUND + "Successfully Signed Up!" + ConsoleColors.RESET); 
        return 1; 
    } 
} 
// login--------------------------------------------------- 
class SignUpandLogin 
{ 
    public int login(User[] users, int numberOfPlaying) 
    { 
        Scanner in = new Scanner(System.in); 
        System.out.print("Enter Username: "); 
        String username = in.nextLine(); 
        System.out.print("Enter Password: "); 
        String password = in.nextLine(); 
 
        for (int i = 0; i <= numberOfPlaying; i++) 
        { 
            if (users[i] != null && users[i].getPassword().equals(password) && users[i].getUsername().equals(username)) 
            { 
	 	 System.out.println(ConsoleColors.blink);
                System.out.println(ConsoleColors.CYAN + "WELCOME, " + users[i].getUsername() + "!" + ConsoleColors.RESET+ ConsoleColors.RESET);
                return 1; 
            } 
        } 
 
        System.out.println(ConsoleColors.RED_BACKGROUND + "THE ACCOUNT DOES NOT EXIST, PLEASE ENTER YOUR ACCOUNT INFORMATION AGAIN OR SIGN UP." + ConsoleColors.RESET); 
        return 0; 
    } 
} 
 
class Main
{ 
    static final String def = "\u001b[0;1m";
    static final String blink = "\u001b[5m";
    static final String red =  "\u001b[31;1m";
    static final String green = "\u001b[32;1m";
    static final String yellow = "\u001b[33;1m";
    static final String blue = "\u001b[34;1m";
    static final String purple="\u001b[35;1m";
    static final String skblue = "\u001b[36;1m";
    static final String bgred =  "\u001b[101;1m";
    static final String bggreen = "\u001b[102;1m";
    static final String bgyellow = "\u001b[103;1m";
    static final String bgblue = "\u001b[104;1m";
    static final String bgpurpe = "\u001b[105;1m";
    static final String bgskblue = "\u001b[106;1m";
public static final String RESET = "\u001B[0m";

    // Text Colors
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Background Colors
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String MAGENTA_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";

    // Styles
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
    public static void main(String[] args) 
    { 
        Scanner in = new Scanner(System.in); 
        System.out.println(RED_BACKGROUND+"MAIN MENU:"+RESET);
        System.out.println(GREEN+"1) LOGIN OR SIGNUP"); 
        System.out.println("2) QUIT"+RESET); 
        int play = in.nextInt(); 
        int bill=0; 
        in.nextLine(); // Consume newline 
 
        User[] users = new User[100]; 
        int numberOfUsers = -1; 
 
        while (play == 1) 
        { 
            System.out.println(GREEN+"1) SIGNUP"); 
            System.out.println("2) LOGIN"+RESET);
            int firstInput = in.nextInt(); 
            in.nextLine(); // Consume newline 
 
            if (firstInput == 1) 
            { 
                numberOfUsers++; 
                users[numberOfUsers] = new User(); 
                System.out.print("Enter Username: "); 
                String username = in.nextLine(); 
                System.out.print("Enter Password: "); 
                String password = in.nextLine(); 
 
                int result = User.validation(username, password, users, numberOfUsers); 
                while (result == 0) 
                { 
                    System.out.print("Enter Username: "); 
                    username = in.nextLine(); 
                    System.out.print("Enter Password: "); 
                    password = in.nextLine(); 
                    result = User.validation(username, password, users, numberOfUsers); 
                } 
 
                if (result == 1) 
                { 
                    users[numberOfUsers].setUsername(username); 
                    users[numberOfUsers].setPassword(password); 
 		    System.out.println(BLUE);
                    System.out.println("Created successfully"+RESET);
                } 
            } 
             
            if (firstInput == 2) 
            { 
               int z= new SignUpandLogin().login(users, numberOfUsers); 
                if(z==1) 
                { 
                    Location selection = new Selection(); 
                    TextCalendar1 calendarApp = new TextCalendar1(); 
                    ServicesFunctionality sf = new ServicesFunctionality(); 
                    
                     
                    while (true) 
                    {  
	  	 	System.out.println(YELLOW);
                        System.out.println("1. select theater\n2.slot booking\n3.extra services\n4.confirm booking\n5.logout"+RESET);
                     
                        int pro=in.nextInt(),t=0; 
                        switch(pro) 
                        { 
                            case 1: 
                            selection.startSelection(); 
                            break; 
 
                            case 2: 
                            calendarApp.start();
                            break; 
 
                            case 3: 
                            sf.selectMainServices();  
                            break; 
 
                            case 4: 
                            	sf.assigntotal();
                            	int total1=sf.total+selection.getprice();                        		
                        		sf.displayBookingSummary();
                        		System.out.println();
 	 	 	 	  	
                        		System.out.println(RED+"Selected place : "+RESET+ selection.getPlace());
	 	  	 	 	
                        		System.out.println(RED+"Selected theater : "+RESET+ selection.gettheater());
 		 	 	  
                        		System.out.println(RED+"Selected timeDuration : "+RESET+ selection.gettimeDuration());
                        		System.out.println();
	  	 	 	 	
                        		System.out.println(RED+"You Selected date : "+RESET+TextCalendar1.selectedDate1);
	 	  	 	 	
                        		System.out.println(RED+"With time slot: "+RESET + TextCalendar1.selectedTimeSlot1);
                        		System.out.println();
	 	 	 	 	 System.out.println(YELLOW);
                        		System.out.println("Total Amount ---- "+RESET+total1);
                            
                            System.out.println("Thank You Please visit Again/nfor any Queries contact to 6301795700");
                            System.exit(0);
                            break; 
                            case 5: 
                            t=1; 
                            break; 
                            default: 
                            System.out.print("Invalid Input"); 
 
                        } 
                        if(t==1) 
                        { 
                            break; 
                        } 
                         
                    } 
    
                } 
            } 
            System.out.print(bill); 
            System.out.println("MAIN MENU:"); 
            System.out.println("1) LOGIN OR SIGNUP"); 
            System.out.println("2) QUIT"); 
            play = in.nextInt(); 
            in.nextLine(); // Consume newline 
        } 
 
    } 
}
