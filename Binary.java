package pack;

public class Binary {

    public static int[] or(int[] bitmask1, int[] bitmask2){
        CheckBinary(bitmask1);
        CheckBinary(bitmask2);

        if(bitmask1.length != bitmask2.length)
            throw new IllegalArgumentException("Bitmask length is not same");
        else{
            for(int i=0 ; i < bitmask1.length ; i++){
                if(bitmask1[i] == 1 || bitmask2[i] == 1)
                    bitmask1[i] = 1;
                else
                    bitmask1[i] = 0;
            }
        }
        return bitmask1;
    }

    public static boolean[] or(boolean[] bitmask1, boolean[] bitmask2){        
        if(bitmask1.length != bitmask2.length)
            throw new IllegalArgumentException("Bitmask length is not same");
        else{
            for(int i=0 ; i < bitmask1.length ; i++){
                if(bitmask1[i] || bitmask2[i])
                    bitmask1[i] = true;
                else
                    bitmask1[i] = false;
            }
        }
        return bitmask1;
    }

    public static boolean[] and(boolean[] bitmask1, boolean[] bitmask2){
        if(bitmask1.length != bitmask2.length)
            throw new IllegalArgumentException("Bitmask length is not same");
        else{
            for(int i=0 ; i < bitmask1.length ; i++){
                if(bitmask1[i] && bitmask2[i])
                    bitmask1[i] = true;
                else
                    bitmask1[i] = false;
            }
        }
        return bitmask1;
    }

    public static int[] and(int[] bitmask1, int[] bitmask2){
        CheckBinary(bitmask1);
        CheckBinary(bitmask2);
        if(bitmask1.length != bitmask2.length)
            throw new IllegalArgumentException("Bitmask length is not same");
        else{
            for(int i=0 ; i < bitmask1.length ; i++){
                if(bitmask1[i] == 1 && bitmask2[i] == 1)
                    bitmask1[i] = 1;
                else
                    bitmask1[i] = 0;
            }
        }
        return bitmask1;
    }

    public static boolean[] not(boolean[] bitmask){
        for(int i=0 ; i<bitmask.length ; i++)
            bitmask[i] = (bitmask[i] ? false : true);

            return bitmask;
    }

    public static int[] not(int[] bitmask){
        CheckBinary(bitmask);
        for(int i=0 ; i<bitmask.length ; i++)
            bitmask[i] = (bitmask[i]==0) ? 1 : 0;

            return bitmask;
    }

    public static boolean[] left(boolean[] bitmask){
        for(int i=0 ; i<bitmask.length-1 ;i++)
            bitmask[i] = bitmask[i+1];

        bitmask[bitmask.length-1] = false;
        return bitmask;
    }

    public static int[] left(int[] bitmask){
        CheckBinary(bitmask);
        for(int i=0 ; i<bitmask.length-1 ;i++)
            bitmask[i] = bitmask[i+1];

        bitmask[bitmask.length-1] = 0;
        return bitmask;
    }
    
    public static boolean[] right(boolean[] bitmask){
        
        for(int i=bitmask.length-1 ; i>0 ;i--)
            bitmask[i] = bitmask[i-1];

        bitmask[0] = false;
        return bitmask;
    }

    public static int[] right(int[] bitmask){
        CheckBinary(bitmask);

        for(int i=bitmask.length-1 ; i>0 ;i--)
            bitmask[i] = bitmask[i-1];

        bitmask[0] = 0;
        return bitmask;
    }

    public static int decimal(boolean[] bitmask){
        int dec = 0;
        int multi = 1; //multiply 2

        for(int i = 0 ; i< bitmask.length ; i++){
            dec += multi*((bitmask[i]) ? 1 : 0);
            multi *= 2;
        }

        return dec;
    }

    public static int decimal(int[] bitmask){
        CheckBinary(bitmask);
        int dec = 0;
        int multi = 1; //multiply 2

        for(int i = 0 ; i< bitmask.length ; i++){
            dec += multi*bitmask[i];
            multi *= 2;
        }

        return dec;
    }

    public static void CheckBinary(int[] bitmask){
        for(int bit : bitmask)
            if(bit != 0 && bit != 1)
                throw new IllegalArgumentException("int[] Arrays is contains non-bit : " + bit);
    }

}