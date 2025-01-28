package service;

import Enums.VehicleType;
import dto.ParkingFloor;
import dto.Ticket;
import dto.Vehicle;

import java.util.ArrayList;

public class ParkingLot
{
    String pid;
    int noOfFloors;
    ArrayList<ParkingFloor> floors;
    ArrayList<Ticket> tickets;

    public ParkingLot(String id, int n)
    {
        pid=id;
        noOfFloors=n;
        floors = new ArrayList<>();

        for(int i=0;i<n;i++)floors.add(new ParkingFloor(i,2,2,2));
        tickets = new ArrayList<>();
    }

    public void showFreeSlots(VehicleType vt)
    {
        for(ParkingFloor floor_i: floors)
        {

            int free = floor_i.getFreeSlotsOnFloor(vt);
            System.out.println("On floor "+ floor_i.floorid+", available slots for "+vt.toString()+", slots : "+free);
        }
    }

    public void parkVehicle(Vehicle v)
    {
        VehicleType vt = v.type;
        int floor=-1;
        for(int i=0;i<floors.size();i++)
        {
            ParkingFloor curr = floors.get(i);
            int slot = curr.parkVehicle(v);
            if(slot!=-1)
            {
                int sno = slot;
                floor=i;
                Ticket t = new Ticket(floor,sno,v);
                tickets.add(t);
                t.print();
                break;
            }

        }
        if(floor==-1) System.out.println("Slots for "+vt.toString()+" are full");
    }

    public void exitVehicle(int floor, int slot)
    {
        Ticket ts=null;

        for(Ticket t: tickets)
        {
            if(t.floorNo==floor && t.slotno==slot)
            {
                ts=t;
                break;
            }
        }
        if(ts==null)System.out.println("Not found");
        else {

            exitVehicle(ts.veh);

        }
    }

    private void exitVehicle(Vehicle v)
    {
        String reg = v.regNo;
        Ticket ts = null;
        for(Ticket t: tickets)
        {
            if(t.veh.regNo.equals(reg))
            {
                ts=t;
                break;
            }
        }
        if(ts==null)System.out.println("Not found");
        else {
            int f = ts.floorNo;
            floors.get(f).emptySlot(ts);

        }
    }



}
