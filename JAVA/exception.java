//make a program to test the exception handling

//make a class to handle custom exceptions
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
    public void resolve(){
        System.out.println("CustomException Resolved");
    }
}

//make a class to test default exceptions
public class exception{
    public static void main(String args[]){
        try{
            int a=10;
            int b=0;
            int c=a/b;
        }
        catch(ArithmeticException e){
            System.out.println("Division by zero");
        }
        catch(Exception e){
            System.out.println("Exception occured");
        }
        catch(CustomException e){
            e.resolve();
        }
        finally{
            System.out.println("This is the finally block");
        }
    }
}