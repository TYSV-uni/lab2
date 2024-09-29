public class Main
{
    // model args go as follows (couldn't think of a better solution)
    //1 = Toyota
    //2 = Honda
    //3 = Mercedes
    //other number = Generic car
    public static Car car_from_console(int model)
    {
        Car x = switch (model)
        {
            case 1 -> new Honda("-", 0, 0.0, 0);
            case 2 -> new Toyota("-", 0, 0.0, 0);
            case 3 -> new Mercedes("-", 0, 0.0, 0);
            default -> new Car("-", "-", 0, 0.0, 0);
        };
        x.fill_car_info();
        return x;
    }

    public static void main(String[] args)
    {
        Car car1 = new Honda("Civic", 22300, 7.7, 272);
        Car car2 = new Toyota("Camry XV40", 7900, 8.0, 230);
        Car car3 = new Mercedes("A-Class", 23500, 6.3, 250);
        Taxi_park car_park = new Taxi_park();

        car_park.add_car(car1);
        car_park.add_car(car2);
        car_park.add_car(car3);

        System.out.println("\nThere are already 3 cars in the taxi park");

        while(true)
        {
            switch (Get_input.get_int_in_range("""
                     
                     Main menu
                     1.Display the Taxi park
                     2.Display the Taxi park sorted by fuel consumption
                     3.Display the value of the Taxi park
                     4.Display cars based on the given speed range
                     5.Add a new car
                     6.Remove a car
                     7.Exit
                     Enter:\s""", 1, 7))
            {
                case 1:
                    switch (Get_input.get_int_in_range("""
                            
                            Displaying options
                            1.Brand and model
                            2.Full info
                            3.Return to menu
                            Enter:\s""", 1, 3))
                    {
                        case 1:
                            System.out.println("\n\tTaxi park:\n");
                            car_park.display_cars_min();
                            break;

                        case 2:
                            System.out.println("\n\tTaxi park:\n");
                            car_park.display_cars_max();
                            break;

                        default:
                            break;
                    }
                    break;

                case 2:
                    System.out.println("\nTaxi park sorted by fuel consumption:\n");
                    Taxi_park sorted_car_park = car_park.sort_by_fuel_consumption();
                    sorted_car_park.display_cars_max();
                    break;

                case 3:
                    System.out.println("\nTotal Taxi park value: " + car_park.get_value() + "$");
                    break;

                case 4:
                    int lower_lim = Get_input.get_int_in_range("Input the lower limit of speed:", 0, Integer.MAX_VALUE);
                    int upper_lim;
                    while (true)
                    {
                        upper_lim = Get_input.get_int_in_range("Input the upper limit of speed:", 0, Integer.MAX_VALUE);
                        if (upper_lim < lower_lim)
                        {
                            System.out.println("Upper limit can't be less than lower limit.");
                            continue;
                        }
                        break;
                    }
                    Taxi_park applicable_cars = car_park.get_cars_by_speed(lower_lim, upper_lim);
                    System.out.println("\nCars based on the given speed range:\n");
                    applicable_cars.display_cars_max();
                    break;

                case 5:
                    int choice = Get_input.get_int_in_range("""
                    
                    Adding a new car
                    1.New Toyota
                    2.New Honda
                    3.New Mercedes
                    4.Other brand
                    5.Return to menu
                    Enter:\s""", 1, 5);

                    if (choice != 5)
                        car_park.add_car(car_from_console(choice));
                    break;

                case 6:
                    String brand = Get_input.get_string("Brand: ");
                    String model = Get_input.get_string("Model: ");
                    if (car_park.remove_car(brand, model))
                        System.out.println("Car has been removed.");
                    else
                        System.out.println("Car not found.");
                    break;

                case 7:
                    System.out.println("You have exited the program.");
                    return;
            }
        }
    }
}
