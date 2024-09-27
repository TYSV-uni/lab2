public class Mercedes extends Car
{
    public Mercedes(String model, int price, Double fuel_consumption, int top_speed)
    {
        super("Mercedes", model, price, fuel_consumption, top_speed);
    }

    @Override
    public void beep()
    {
        System.out.println("I'm a Mercedes :)");
    }
}
