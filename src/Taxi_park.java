import java.util.ArrayList;

public class Taxi_park
{
    private final ArrayList<Car> cars;

    public Taxi_park()
    {
        cars = new ArrayList<>();
    }

    public void add_car(Car x)
    {
        cars.add(x);
    }

    public void remove_car(Car x)
    {
        cars.remove(x);
    }

    public Taxi_park sort_by_fuel_consumption()
    {
        Taxi_park sorted_cars = new Taxi_park();
        for (Car x : cars)
            sorted_cars.add_car(x);

        sorted_cars.get_cars().sort((x, y) -> x.fuel_consumption.compareTo(y.fuel_consumption));

        return sorted_cars;
    }

     public int get_value()
     {
         int sum = 0;
         for (Car x : cars)
             sum += x.price;

         return sum;
     }

    public ArrayList<Car> get_cars()
    {
        return cars;
    }

     public Taxi_park get_cars_by_speed(int lower_speed, int upper_speed)
     {
         Taxi_park correct_cars = new Taxi_park();
         for (Car x : cars)
             if (x.top_speed >= lower_speed && x.top_speed <= upper_speed)
                 correct_cars.add_car(x);

         return correct_cars;
     }

     public void display_cars_min()
     {
         if (cars.isEmpty())
             System.out.println("No cars can be found");
         else
             for (Car x : cars)
                 System.out.println(x.get_model());
     }

    public void display_cars_max()
    {
        if (cars.isEmpty())
            System.out.println("No cars can be found");
        else
            for (Car x : cars)
                System.out.println(x.get_all_info());
    }

}
