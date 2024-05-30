public class ReturnTypes {
    byte alpha(int a, int b){
        int c= a+b;
        return (byte)c;
    }
    byte beta(){
        byte c = 10;
        return c;
    }

    float get(long a, long b){
        long c = a+b;
        return c;
    }

    // String getString(){
    //     return 'a';
    // }

    static char display(){
        return 630;
    }

    public static void main(String[] args) {
        System.out.println(display());
    }
}
