import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class solution {
    public static void main(String[] args) {
        LinkedList<String> input = new LinkedList<String>();
        try {
            File myObj = new File("/workspace/AoC2023/inputs/one1.txt");
            Scanner in = new Scanner(myObj);
            while (in.hasNextLine()) {
                input.add(in.nextLine());

            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int first = 0;
        int last = 0;
        boolean needFirst = true;
        LinkedList<Integer> values = new LinkedList<Integer>();

        for (String line : input) {
            needFirst = true;
            for (Character ch : line.toCharArray()) {
                if (Character.isDigit(ch)) {
                    if(needFirst){
                        first = ch - 48;
                        needFirst = false;
                    }
                    last = ch - 48;
                }
            }
            values.add(Integer.parseInt("" + first + last));
        }

        int sum= 0;
        for(Integer num : values){
            sum += num;
        }

        System.out.println(sum);
    }
}