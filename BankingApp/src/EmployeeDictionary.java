import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeDictionary {
    public static void main(String[] args) {
        Map<String, Map<String, Object>> empDict = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of nested dictionary: ");
        int size = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < size; i++) {
            System.out.print("Enter the name of the employee: ");
            String empName = scanner.nextLine();

            Map<String, Object> empInfo = new HashMap<>();
            System.out.print("Enter the salary: ");
            int salary = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the designation: ");
            String designation = scanner.nextLine();

            empInfo.put("salary", salary);
            empInfo.put("designation", designation);
            empDict.put(empName, empInfo);
        }
        scanner.close();
        
        System.out.println("The original dictionary is : \n" + empDict);

        Map<String, Map<String, Object>> result = new HashMap<>();
        int max = 0;
        for (Map.Entry<String, Map<String, Object>> entry : empDict.entrySet()) {
            Map<String, Object> empInfo = entry.getValue();

            if ((int) empInfo.get("salary") > max) {
                max = (int) empInfo.get("salary");
            }
        }

        for (Map.Entry<String, Map<String, Object>> entry : empDict.entrySet()) {
            Map<String, Object> empInfo = entry.getValue();
            if (empInfo.get("designation").equals("Manager") && (int) empInfo.get("salary") == max) {
                result.put(entry.getKey(), empInfo);
            }
        }

        System.out.println(result);
    }
}

