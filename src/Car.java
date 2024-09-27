public abstract class Car
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
}
