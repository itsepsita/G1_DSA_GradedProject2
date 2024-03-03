
import java.util.Scanner;
import java.util.Stack;
import java.util.*;

public class SkyScraper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the total number of floors in the building: ");
        int currentDay;
        int totalFloors = scanner.nextInt();
        Integer floorArray[] = new Integer[totalFloors];
        Integer floorArraySort[] = new Integer[totalFloors];

        for (currentDay = 0; currentDay < totalFloors; currentDay++) {
            System.out.printf("Enter the floor size given on day %d: ", currentDay+1);
            System.out.println();
            int currentFloorSize = scanner.nextInt();
            floorArray[currentDay] = currentFloorSize;
            floorArraySort[currentDay] = currentFloorSize;
        }
        
        Arrays.sort(floorArraySort, Collections.reverseOrder());
        int temp = 0;
        int counter = 0;
        int i;
        for(currentDay = 0; currentDay < totalFloors; currentDay++) {
            System.out.println("Day: "+ (currentDay+1));
            if(floorArray[currentDay] >= floorArraySort[temp]) {
                for(i = temp;i<=currentDay;i++) {
                    for(int j = 0;j<=currentDay;j++) {
                        if(floorArray[j]==floorArraySort[i]) {
                            counter = 1;
                            break;
                        }
                    }
                    if(counter == 1) {
                        System.out.print(floorArraySort[i] + " ");
                        counter = 0;
                    } else {
                        break;
                    }
                }
                System.out.println();
                temp = i;
            } else {
                System.out.println();
            }
        }
        
    }
}
