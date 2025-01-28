import Enums.VehicleType;
import dto.Ticket;
import dto.Vehicle;
import service.ParkingLot;

import java.util.Scanner;

public class Application
{
    public static void main(String[] args)
    {
        ParkingLot plot = new ParkingLot("P1",2);
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext())
        {
            String line = sc.nextLine();
            if(line.equals("exit"))break;
            String[] spl = line.split(" ");
            String comm = spl[0];
            switch (comm)
            {
                case "SHOW":
                    plot.showFreeSlots(VehicleType.valueOf(spl[1]));
                    break;
                case "PARK":
                    plot.parkVehicle(new Vehicle(VehicleType.valueOf(spl[1]),spl[2],spl[3]));
                    break;
                case "UNPARK":
                    String[] dsp = spl[1].split("-");
                    plot.exitVehicle(Integer.parseInt(dsp[0]),Integer.parseInt(dsp[1]));
            }
        }




    }

}
