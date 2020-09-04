package paymrntsPlan.mortgage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;


    public class PayCalculator {

        public static void main(String[] args) throws IOException {
            //Specify the file path here...
            File f1=new File("src/main/resources/prospects.txt");
            FileReader fr=new FileReader(f1);
            BufferedReader br=new BufferedReader(fr);
            DecimalFormat df2=new DecimalFormat("#.##");
            String s;
            String words[]=null;
            br.readLine(); //Reading the first line which just provides the description
            while((s=br.readLine())!=null) {
                words=s.split(",");
                if(words.length!=4)
                    return;
                String cName=words[0];                  //Consumer Name
                double U=Double.parseDouble(words[1]); //Total Loan
                double yearlyInterest=Double.parseDouble(words[2]); //Interest on yearly basis
                int Z=Integer.parseInt(words[3]);      //Years
                int p=Z*12;                            //Number of payments
                double b=yearlyInterest/p;             //Calculating interest on monthly basis
                //Calculating fixed monthly payment
                double E=(U*(b*(power(1+b,p)))/((power(1+b,p))-1));
                //Output
                System.out.println(cName+" wants to borrow "+U+"€ for a period of "+Z+" years and is going to pay "+df2.format(E)+"€ each month ");
            }
            fr.close();
        }

        static double power(double N, int P)
        {
            if (P == 0)
                return 1;
            else
                return N * power(N, P - 1);
        }


    }
