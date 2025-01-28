package dto;

import Enums.SlotState;
import Enums.VehicleType;

public class ParkingSlot
{
    SlotState state;
    VehicleType vehicleType;
    String regNo;

    public ParkingSlot(SlotState s, VehicleType v)
    {
        state=s; vehicleType=v;
    }

}
