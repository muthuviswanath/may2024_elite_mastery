public class Performance {
    public static void main(String[] args) {
        int total = 70;
        if (total >=0 &&total <35){
            System.out.println("Grade: F");
        }
        else if(total >=35 && total<60){
            System.out.println("Grade: C");
        }
        else if(total >=60 && total<80){
            System.out.println("Grade: B");
        }
        else if(total >=80 && total<90){
            System.out.println("Grade: A");
        }
        else if(total >=90 && total<=100){
            System.out.println("Grade: A+");
        }
        else{
            System.out.println("Invalid mark to calculate grade");
        }
        
    }
}
