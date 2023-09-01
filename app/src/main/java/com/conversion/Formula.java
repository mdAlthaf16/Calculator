package com.conversion;
public class Formula {



    public double snfCalculate(String clr, String fat, String stateTemVolume1, String stateTemVolume2) {

        double snf = 0.00;
        if (!clr.isEmpty() && !fat.isEmpty() && !stateTemVolume1.isEmpty() && !stateTemVolume2.isEmpty()) {

            double dClr = Double.parseDouble(clr);
            double dFat = Double.parseDouble(fat);
            double dStateTemVolume1 = Double.parseDouble(stateTemVolume1);
            double dStateTemVolume2 = Double.parseDouble(stateTemVolume2);

            // SNF == ( clr / 4 ) + ( temVolumeOne * fat ) + temVolumeTwo;

            snf = (dClr / 4) + (dStateTemVolume1 * dFat) + dStateTemVolume2;
        }

        return snf;
    }

    public double clrCalculate(String snf, String fat, String stateTemVolume1, String stateTemVolume2) {

        double clr = 0.00;


        if (!snf.isEmpty() && !fat.isEmpty() && !stateTemVolume1.isEmpty() && !stateTemVolume2.isEmpty()) {

            double dSnf = Double.parseDouble(snf);
            double dFat = Double.parseDouble(fat);
            double dStateTemVolume1 = Double.parseDouble(stateTemVolume1);
            double dStateTemVolume2 = Double.parseDouble(stateTemVolume2);

            // CLR == ( snf - ( temVolumeOne * fat ) - temVolumeTwo ) * 4;

           clr = (dSnf - (dStateTemVolume1 * dFat) - dStateTemVolume2) * 4;


        }
        return clr;
    }

    public double totalSolid(String snf, String fat) {

        double totalSolid = 0.00;

        if (!snf.isEmpty() && !fat.isEmpty()) {

            double dSnf = Double.parseDouble(snf);
            double dFat = Double.parseDouble(fat);

            totalSolid = dSnf + dFat;
        }
        return totalSolid;
    }

    public void sampleTextTwo() {
        System.out.println("bla");
    }
}
