public class Car
{
    protected String brand, model;
    protected Double fuel_consumption;
    protected int price, top_speed;

    public Car(String brand, String model, int price, Double fuel_consumption, int top_speed)
    {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.fuel_consumption = fuel_consumption;
        this.top_speed = top_speed;
    }

    public String get_model()
    {
        return (brand + " " + model);
    }

    public String get_specs()
    {
        return ("Price: " + price + "$\nFuel consumption: " + fuel_consumption + " l per 100km\nTop speed: " + top_speed + " km/h\n");
    }

    public String get_all_info()
    {
        return(this.get_model() + "\n" + this.get_specs());
    }

    public void fill_car_info()
    {
        this.brand = Get_input.get_string("Brand: ");
        this.model = Get_input.get_string("Model: ");
        this.price = Get_input.get_int_in_range("Price($): ", 0 , Integer.MAX_VALUE);
        this.fuel_consumption = Get_input.get_double_in_range("Fuel consumption (l/100km): ", 0 , Double.MAX_VALUE);
        this.top_speed =  Get_input.get_int_in_range("Top speed(km/h): ", 0, Integer.MAX_VALUE);
    }
}
