package AhmadMalik;
/*
Algorithm
1.	A method named inputTempForMonth whose purpose is to input a high and a low temperature for a specific month. The month and the array of temperatures will both be passed as input arguments to the method. The method will not have a return value.
2.	A method named inputTempForYear whose purpose is to input a high and a low temperature for every month of the year. There are no input arguments for this method, but the method does return a completed multidimensional array of temperatures for the year.
3.	A method named calculateAverageHigh whose purpose is to calculate the average high temperature for the year. This method will take the array of temperatures as input and will return the average high temperature for the year.
4.	A method named calculateAverageLow whose purpose is to calculate the average low temperature for the year. This method will take the array of temperatures as input and will return the average low temperature for the year.
5.	A method named findHighestTemp whose purpose is to return the index value of the highest temperature for the year. If the highest temperature of the year occurs more than once in the year, then the method should return the index of the first month that had the temperature. The method will take the array of temperatures as an input argument and return the index of the highest temperature.
6.	A method named findLowestTemp whose purpose is to return the index value of the lowest temperature for the year. If the lowest temperature of the year occurs more than once in the year, then the method should return the index of the first month that had the temperature. The method will take the array of temperatures as an input argument and return the index of the lowest temperature.
7.	A main method that uses the previous methods to determine the average high temperature, average low temperature, and highest and lowest temperatures for the year. The main method must print out these average temperatures as well as the month and temperature for the highest and lowest temperatures for the year.
 */
import java.util.Scanner;
public class Main {
    public static Scanner keyboard = new Scanner(System.in);
    private static int highTemperature, lowTemperature,averageHigh, averageLow;
    private static int index;
    private static int indexOfHighestTemp=0, indexOfLowestTemp=0;
    private static int[][] highAndLowTemps = new int [12][2];//array for highs and lows
    private static String[] months = new String[12];

    public static void main(String[] args) {
        inputTempForYear();
        calculateAverageHigh(highAndLowTemps);
        calculateAverageLow(highAndLowTemps);
        findHighestTemp(highAndLowTemps);
        findLowestTemp(highAndLowTemps);

        System.out.println("The Average High is: "+averageHigh);
        System.out.println("The Average Low is: "+averageLow);
        System.out.println("Highest Temperature and Month: "+highAndLowTemps[indexOfHighestTemp][0]+" "+months[indexOfHighestTemp]);
        System.out.println("Lowest Temperature and Month: "+highAndLowTemps[indexOfLowestTemp][1]+" "+months[indexOfLowestTemp]);
    }
    private static void inputTempForMonth(int[][] highAndLowTemps)
    {
        System.out.println("Input the high temperature for "+months[index]+":");
        highTemperature = keyboard.nextInt();
        highAndLowTemps[index][0]=highTemperature;
        System.out.println("Input the low temperature for "+months[index]+":");
        lowTemperature = keyboard.nextInt();
        highAndLowTemps[index][1]=lowTemperature;
    }
    private static int[][] inputTempForYear()
    {
        months[0]="January";
        months[1]="Febuary";
        months[2]="March";
        months[3]="April";
        months[4]="May";
        months[5]="June";
        months[6]="July";
        months[7]="August";
        months[8]="September";
        months[9]="October";
        months[10]="November";
        months[11]="December";
        for (index=0;index<=11;index++)
        {
            inputTempForMonth(highAndLowTemps);
        }
        return highAndLowTemps;
    }
    private static int calculateAverageHigh(int[][] highAndLowTemps)
    {
        for(int i=0;i<12;i++)
        {
            averageHigh=averageHigh+highAndLowTemps[i][0];
        }
        averageHigh/=12;
        return averageHigh;
    }
    private static int calculateAverageLow(int[][] highAndLowTemps)
    {
        for(int i=0;i<12;i++)
        {
            averageLow=averageLow+highAndLowTemps[i][1];
        }
        averageLow/=12;
        return averageLow;
    }
    private static int findHighestTemp(int[][] highAndLowTemps)
    {
        double max=highAndLowTemps[0][0];
        int indexHigh;
        for(indexHigh=0;indexHigh<11;indexHigh++)
        {
            if(highAndLowTemps[indexHigh][0]>max)
            {
                max=highAndLowTemps[indexHigh][0];
                indexOfHighestTemp=indexHigh;
            }
        }
        return indexOfHighestTemp;
    }
    private static int findLowestTemp(int[][] highAndLowTemps)
    {
        double min=highAndLowTemps[0][1];
        int indexLow;
        for(indexLow=0;indexLow<11;indexLow++)
        {
            if(highAndLowTemps[indexLow][1]<min)
            {
                min=highAndLowTemps[indexLow][1];
                indexOfLowestTemp=indexLow;
            }
        }
        return indexOfLowestTemp;
    }
}

