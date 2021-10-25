    //String 추가
    public class Combination {//https://ansohxxn.github.io/algorithm/combination/
    
        int size;
        int pick;
        int[] array;
        String[] str_array;

        Combination(int[] array, int n){
            this.size = n;

            this.array = array;
        }
        Combination(String[] array, int n){
            this.size = n;

            this.str_array = array;
        }

        void CombExecute(int[] comb, int r,int depth, int index){//int[] comb = new int[r];

            if(r == 0){
                System.out.println(Arrays.toString(comb));
            }

            else if(array.length == depth){
                return;
            }
            else{
                comb[index] = array[depth];
                CombExecute(comb, r-1,depth+1, index+1);
                CombExecute(comb, r, depth+1, index);
            }
        }
        void CombExecuteStr(String[] comb, int r,int depth, int index){//int[] comb = new int[r];

            if(r == 0){
                System.out.println(Arrays.toString(comb));
            }

            else if(str_array.length == depth){
                return;
            }
            else{
                comb[index] = str_array[depth];
                CombExecuteStr(comb, r-1,depth+1, index+1);
                CombExecuteStr(comb, r, depth+1, index);
            }
        }

        int CombSize(int n, int r){
            this.size = n;
            this.pick = r;
            if(pick==size || pick == 0)
                return 1;
            else
                return CombSize(size-1, pick-1) + CombSize(size - 1, pick);
        }
    }
