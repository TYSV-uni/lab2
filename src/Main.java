import java.util.Scanner;

public class Main
{
    public static int get_int_in_range(String prompt, int min, int max)
    {
        int x;
        Scanner sc = new Scanner(System.in);

        while(true)
            try
            {
                System.out.print(prompt);
                x = Integer.parseInt(sc.nextLine());
                if (!(x >= min))
                {
                    System.out.println("Input should be bigger than " + min);
                    continue;
                }
                else if (!(x <= max))
                {
                    System.out.println("Input should be smaller than " + max);
                    continue;
                }
                break;
            }
            catch(Exception e)
            {
                System.out.println("Invalid input");
            }

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

        System.out.println("\nPolymorphism implementation: ");
        System.out.print("Honda 'beep' method called: ");
        car1.beep();
        System.out.print("Toyota 'beep' method called: ");
        car2.beep();
        System.out.print("Mercedes 'beep' method called: ");
        car3.beep();
        System.out.println();

        while(true)
        {
            switch (get_int_in_range("\nMain menu\n1.Display the Taxi park\n2.Display the Taxi park sorted by fuel consumption\n3.Display the value of the Taxi park\n4.Display cars based on the given speed range\n5.Exit\nEnter: ", 1, 5))
            {
                case 1:
                    System.out.println("\nTaxi park:\n");
                    car_park.display_cars_max();
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
                    int lower_lim = get_int_in_range("Input the lower limit of speed:", 0, Integer.MAX_VALUE);
                    int upper_lim;
                    while (true)
                    {
                        upper_lim = get_int_in_range("Input the upper limit of speed:", 0, Integer.MAX_VALUE);
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
                    System.out.println("You have exited the program.");
                    return;
            }
        }
    }
}
