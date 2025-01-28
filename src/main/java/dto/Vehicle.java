package dto;

import Enums.VehicleType;

public class Vehicle
{
    public String regNo;
    public VehicleType type;
    String color;

    public Vehicle(VehicleType vt,String reg, String colora)
    {
        regNo=reg; type=vt; color=colora;
    }



}
