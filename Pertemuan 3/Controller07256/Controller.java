package Controller07256;
public class Controller {
    public <T> T model(Class<T> newclass){
        try {
            return newclass.getDeclaredConstructor().newInstance();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
