package dto;

import Enums.VehicleType;

public class Ticket
{
    public int floorNo;

    public int slotno;
    public Vehicle veh;

    public Ticket(int f, int sn, Vehicle v)
    {
        floorNo=f;  slotno=sn; veh=v;
    }


    public void print()
    {
        System.out.println(floorNo+"-"+slotno+"-"+veh.regNo);
    }
}
