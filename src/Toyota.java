public class Toyota extends Car
{
    public Toyota(String model, int price, Double fuel_consumption, int top_speed)
    {
        super("Toyota", model, price, fuel_consumption, top_speed);
    }

    @Override
    public void fill_car_info()
    {
        this.model = Get_input.get_string("Model: ");
        this.price = Get_input.get_int_in_range("Price($): ", 0 , Integer.MAX_VALUE);
        this.fuel_consumption = Get_input.get_double_in_range("Fuel consumption (l/100km): ", 0 , Double.MAX_VALUE);
        this.top_speed =  Get_input.get_int_in_range("Top speed(km/h): ", 0, Integer.MAX_VALUE);
    }
}
