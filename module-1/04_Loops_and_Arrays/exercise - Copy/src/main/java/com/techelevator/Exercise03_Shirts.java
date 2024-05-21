package com.techelevator;

public class Exercise03_Shirts {

    private final static char SMALL_TSHIRT = 'S';
    private final static char MEDIUM_TSHIRT = 'M';
    private final static char LARGE_TSHIRT = 'L';

    /*
    A t-shirt company rep from Top Threads just finished taking an order
    from a client and needs to key it into the system. The client ordered,
    3 Small shirts ('S'), 2 Medium shirts ('M'), and 1 Large shirt ('L').

    Implement the logic to reflect an order of 6 t-shirts.

    Examples:
    buildOrder() → ['S', 'S', 'S', 'M', 'M', 'L']
     */
    public char[] buildOrder() {


        return new char[] {'S','S','S','M','M','L'};
    }

    /*
    Another customer called in and is hosting a large networking event and
    needs a bulk order. Rather than indicate how many of each shirt they
    wanted, they've asked for as even distribution as possible.

    Implement the logic to generate an order representing as even a distribution
    as possible, for example: ('S', 'M', 'L', 'S', 'M', 'L', 'S', ...)

    Note: The number of shirts ordered is guaranteed to be non-negative.

    Examples:
    buildBulkOrder(6) → ['S', 'M', 'L', 'S', 'M', 'L']    
    buildBulkOrder(3) → ['S', 'M', 'L']
    buildBulkOrder(4) → ['S', 'M', 'L', 'S']
    buildBulkOrder(0) → []
     */
<<<<<<< HEAD:module-1/04_Loops_and_Arrays/exercise/src/main/java/com/techelevator/Exercise03_Shirts.java
    public char[] buildBulkOrder(int numberOfShirts) { 
        char [] iUnderstood = new char [numberOfShirts];
        for (int i = 0; i < iUnderstood.length; i++) {
            if (i % 3 == 0) {
                iUnderstood[i] = 'S';
            }
            if(i%3==1){
                iUnderstood[i] = 'M';
            }
            if(i%3==2){
                iUnderstood[i]= 'L';
            }

        }
        return iUnderstood;
=======
    public char[] buildBulkOrder(int numberOfShirts) {
        char[] shirts = new char[numberOfShirts];

        for (int i = 0; i < numberOfShirts; i++) {
            if (i % 3 == 0) {
                shirts[i] = 'S';
            } else if (i % 3 == 1) {
                shirts[i] = 'M';
            } else {
                shirts[i] = 'L';
            }
        }

        return shirts;
>>>>>>> 7f045c6823350f174a44a58f0e5ed0755b905f95:module-1/04_Loops_and_Arrays/exercise - Copy/src/main/java/com/techelevator/Exercise03_Shirts.java
    }

    /*
    The warehouse is out of small shirts and will only request more when the
    next order comes in that includes an 'S' shirt.

    Implement the logic to look through the next incoming order `char[] order`
    and return true if we need to place an order for Small shirts.

    Examples:
    placeRequest(['M', 'L', 'S']) → true
    placeRequest(['M', 'S', 'L']) → true
    placeRequest(['M', 'M', 'L']) → false
    placeRequest([]) → false
     */
    public boolean placeRequest(char[] order) {
<<<<<<< HEAD:module-1/04_Loops_and_Arrays/exercise/src/main/java/com/techelevator/Exercise03_Shirts.java
        boolean result = false;
        char [] greatEr = order;
        for (int i = 0; i < greatEr.length ; i++) {
            char nowHere = greatEr[i];
            if(nowHere == 'S'){
                result = true;
            }
        }

        return result;
=======


        for (char shirt : order) {
            if (shirt == 'S') {
                return true;
            }
        }

        return false; 
>>>>>>> 7f045c6823350f174a44a58f0e5ed0755b905f95:module-1/04_Loops_and_Arrays/exercise - Copy/src/main/java/com/techelevator/Exercise03_Shirts.java
    }
}
