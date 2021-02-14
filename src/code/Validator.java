package code;

public class Validator {

    public  static void  checkParam(Object object)
    {
        if (object == null) throw new NullPointerException();
    }

    public  static void  checkParam(String string)
    {
        if (string == null) throw new NullPointerException();
        if (string.isEmpty()) throw new IllegalArgumentException();
    }
    public  static void  checkParam(double d)
    {
        if (d <= 0d) throw new IllegalArgumentException();
    }

    public  static void  checkParam(int integer)
    {
        if (integer < 1) throw new IllegalArgumentException();
    }
}
