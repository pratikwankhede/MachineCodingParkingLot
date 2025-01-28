package dto;

import Enums.SlotState;
import Enums.VehicleType;

import java.util.ArrayList;

public class ParkingFloor
{
    public int floorid;
    int bikeSlotsTotal;
    int carSlotsTotal;
    int truckSlotsTotal;
    ArrayList<ParkingSlot> bikeSlots;
    ArrayList<ParkingSlot> carSlots;
    ArrayList<ParkingSlot> truckSlots;

    public ParkingFloor(int f, int b, int c, int t)
    {
        floorid=f; bikeSlotsTotal=b; carSlotsTotal=c; truckSlotsTotal=t;
        bikeSlots = new ArrayList<>();
        for(int i=0;i<b;i++)bikeSlots.add(new ParkingSlot(SlotState.FREE, VehicleType.BIKE));
        carSlots = new ArrayList<>();
        for(int i=0;i<c;i++)carSlots.add(new ParkingSlot(SlotState.FREE,VehicleType.CAR));

    }

    private ArrayList<ParkingSlot> getSlotsForVType(VehicleType t)
    {
        ArrayList<ParkingSlot> rt = null;
        switch (t)
        {
            case BIKE:
            rt=bikeSlots;
            break;

            case CAR:
            rt=carSlots;
            break;

        }
        return rt;
    }

    public int getFreeSlotsOnFloor(VehicleType vt)
    {
        ArrayList<ParkingSlot> li = getSlotsForVType(vt);
        return (int) li.stream().filter(parkingSlot -> parkingSlot.state.equals(SlotState.FREE)).count();
    }

    public int parkVehicle(Vehicle v)
    {
        return parkInRequiredSlot(getSlotsForVType(v.type),v);
    }

    private int parkInRequiredSlot(ArrayList<ParkingSlot> li, Vehicle v)
    {
        int ind=-1;
        ParkingSlot p = null;
        for(int i=0;i<li.size();i++)
        {
            ParkingSlot curr = li.get(i);
            if(curr.state.equals(SlotState.FREE))
            {
                ind = i;
                p=curr;
                break;
            }
        }
        p.state=SlotState.OCCUPIED;
        p.regNo=v.regNo;
        return ind;
    }

    public void emptySlot(Ticket t)
    {
        int sn = t.slotno;
        ArrayList<ParkingSlot> li = getSlotsForVType(t.veh.type);

        li.get(sn).state=SlotState.FREE;
        String goingVehicleNo = li.get(sn).regNo;
        li.get(sn).regNo= String.valueOf(-1);
        System.out.println( goingVehicleNo+" Has exited from floorno "+floorid+" and lsotno: "+sn);
    }




}
