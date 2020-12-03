package InterfacesAndAbstractionLab.CarShopExtended;

import java.io.Serializable;

public interface Car extends Serializable {

    Integer TIRES = 4;

    public String getModel();

    public String getColor();

    public int getHorsePower();

    public String getCountryProduced();

}
