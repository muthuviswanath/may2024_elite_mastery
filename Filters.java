public class Filters {
    public static void main(String[] args) {
        //If the age is >30,If the gender is male, if degree is nothing, make him primeminister
        int age = 40;
        char gender = 'm';
        String degree = "nothing";
        if(age > 30){
            if(gender =='m'){
                if(degree.equals("nothing")){
                    System.out.println("Get Rowdified - Rowdi");
                }
                else{
                    System.out.println("Become a samosa vendor");
                }
            }
            else if(gender == 'f')
            {
                System.out.println("If you are a supporter of the flower called lotus then you will be a prime minister");
            }
            else{
                System.out.println("We dont even give you respect");
            }
        }
        else{
            System.out.println("You can only become a president (Rubber Stamp)");
        }
    }
}
