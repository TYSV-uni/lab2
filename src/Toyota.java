public class Toyota extends Car
{
    public Toyota(String model, int price, Double fuel_consumption, int top_speed)
    {
        super("Toyota", model, price, fuel_consumption, top_speed);
    }

    @Override
    public void beep()
    {
        System.out.println("I'm a Toyota :)");
    }
}
