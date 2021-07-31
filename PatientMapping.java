import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PatientMapping {
    protected Hospital[] HspArray = new Hospital[10000];
    private int totalHospitals = 0;
    protected Doctor DoctorArr[] = new Doctor[1000];

    public Hospital[] getHspArray() {
        return HspArray;
    }

    public int getTotalHospitals() {
        return totalHospitals;
    }

    public void HospitalBuilder(String filename) throws FileNotFoundException {
        Hospital[] HspArrayLocal = new Hospital[10000];
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        int i = 0;
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
//            System.out.println(line);
            String[] HspStr = line.split("\\|");
            Hospital H1 = new Hospital(Integer.parseInt(HspStr[0]),
                    HspStr[1],
                    Double.parseDouble(HspStr[2]),
                    Double.parseDouble(HspStr[3]),
                    Double.parseDouble(HspStr[4]),
                    HspStr[5],
                    HspStr[6],
                    HspStr[7],
                    Double.parseDouble(HspStr[8]),
                    HspStr[9],
                    HspStr[10]);

            HspArrayLocal[i] = H1;
            i++;
            totalHospitals++;
        }
        this.HspArray = HspArrayLocal;
    }

   public void buildDoctor(String filename) {
        File myObj = new File(filename);
        Scanner myReader;
        int i = 0;
        try {
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                String[] parts = line.split(",");
                Doctor D1 = new Doctor(Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        Double.parseDouble(parts[3]));

                DoctorArr[i] = D1;
                i++;
                totalDoctors++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public Doctor[] getDoctorArr() {
        return DoctorArr;
    }

    public void selectDoctor(int index, String dep, String File) {
        this.buildDoctor(File);
        int[] arr = new int[totalDoctors];
        for (int i = 0, k = 0; i < totalDoctors; i++) {
            if (DoctorArr[i].getHospitalID() == index && DoctorArr[i].getDept().equals(dep)) {
                System.out.println("Doctor " + (k + 1));
                System.out.println(DoctorArr[i]);
                System.out.println("-----------------------------------------");
                arr[k] = i;
                k++;
            }
        }
    }

    public int[] slctDoctorArray(int index, String dep, String File) {
        int[] arr = new int[totalDoctors];
        int k = 0;
        for (int i = 0; i < totalDoctors; i++) {
            if (DoctorArr[i].getHospitalID() == index && DoctorArr[i].getDept().equals(dep)) {
                arr[k] = i;
                k++;
            }
        }
        return arr;
    }
    public Hospital[] recommend(Location l, int n, String File) throws FileNotFoundException {
        this.HospitalBuilder(File);
        System.out.printf("\n\nNearest hospitals are:\n\n", n);
        Hospital temp;
        Hospital[] nearest = new Hospital[totalHospitals];
        for (int i = 0; i < totalHospitals; i++) {
            for (int j = i + 1; j < totalHospitals; j++) {
                if (HspArray[i].getDistance(l) > HspArray[j].getDistance(l)) {
                    temp = HspArray[i];
                    HspArray[i] = HspArray[j];
                    HspArray[j] = temp;
                }
            }
        }
        for (int i = 0, k = 0; (k < n) && (i < HspArray.length); i++) {
            String[] rms = HspArray[i].getRooms().split("-");
            if (rms.length == Integer.parseInt(rms[0]) + 1) {
                continue;
            }
            k++;
            nearest[i] = HspArray[i];
            System.out.println("Hospital " + (k) + " " + HspArray[i].getName() + "  " + HspArray[i].getDistance(l) + "\n");
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        return nearest;
    }

    public Hospital selectHsp(int index) {

        switch (index) {
            case 1:
                System.out.println(HspArray[0]);
                return HspArray[0];
            case 2:
                System.out.println(HspArray[1]);
                return HspArray[1];
            case 3:
                System.out.println(HspArray[2]);
                return HspArray[2];
            case 4:
                System.out.println(HspArray[3]);
                return HspArray[3];
            case 5:
                System.out.println(HspArray[4]);
                return HspArray[4];
            case 6:
                System.out.println(HspArray[5]);
                return HspArray[5];
            case 7:
                System.out.println(HspArray[6]);
                return HspArray[6];
            case 8:
                System.out.println(HspArray[7]);
                return HspArray[7];
            case 9:
                System.out.println(HspArray[8]);
                return HspArray[8];
            case 10:
                System.out.println(HspArray[9]);
                return HspArray[9];
            default:
                System.out.println("No choice was selected");
                return HspArray[0];

        }
    }

    public LabTests[] labTestBuilder(String fileName) {
        LabTests[] labArray = new LabTests[1000];
        File myObj = new File(fileName);
        try {
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                String[] str = data.split("\\|");

                String T = str[0]; // Three parts of LabTest data type as in line above.
                int G = Integer.parseInt(str[1]);
                String D = str[2];
                labArray[i] = new LabTests(T, G, D);
                i++;
            }
            int sizeOfArray = --i;
            LabTests[] labArray2 = new LabTests[i];
            for (int j = 0; j < sizeOfArray; j++) {
                labArray2[j] = labArray[j];
            }

            return labArray2;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }


    public LabTests[] labTestPerformed(LabTests[] labArray) {
        int numOfTests;
        numOfTests = (int) (Math.random() * 11);
        ArrayList<Integer> labTestPerformedIndex = new ArrayList<>(numOfTests);
        while (labTestPerformedIndex.size() != numOfTests) {

            int num = (int) (Math.random() * labArray.length);
            if (!labTestPerformedIndex.contains(num)) {
                labTestPerformedIndex.add(num);
            }
        }
        LabTests[] tests = new LabTests[numOfTests];
        System.out.println("\nTHE MEDICAL TESTS TO BE PERFORMED ON YOU\n");
        for (int i = 0; i < numOfTests; i++) {
            System.out.println((i+1) +" "+labArray[labTestPerformedIndex.get(i)]);
            tests[i] = labArray[labTestPerformedIndex.get(i)];
            System.out.println();
        }
        System.out.println("Enter # if you want to have tests: ");
        Scanner scan1 = new Scanner(System.in);
        String str = scan1.nextLine();
        if(str != "#"){
            return tests;
        }else{
            return null;
        }
    }

}
