class car{
    int topSpeed;
    int acceleration;
    int weight;

    car(){
        System.out.println("Car created");
    }
}
class truck extends car{
    sportsCar(int topSpeed, int acceleration, int weight){
        this.topSpeed = topSpeed;
        this.acceleration = acceleration;
        this.weight = weight;

        System.out.println("Top Speed: " + topSpeed);
    }
}
public class drive{
    public static void main(String[] args){
        sportsCar sC = new sportsCar(250, 10, 1000);
        System.out.println("Weight: " + sC.weight);
    }
};