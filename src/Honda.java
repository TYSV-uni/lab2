public class Honda extends Car
{
    public Honda(String model, int price, Double fuel_consumption, int top_speed)
    {
        super("Honda", model, price, fuel_consumption, top_speed);
    }

    @Override
    public void beep()
    {
        System.out.println("I'm a Honda :)");
    }
}
