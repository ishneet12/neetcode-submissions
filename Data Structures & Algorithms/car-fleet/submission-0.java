class Solution {
   
    public int carFleet(int target, int[] pos, int[] speed) {
        int n = pos.length;
        double[][] car = new double[n][2];

        for(int i=0;i<n;i++){
           
            car[i][0] = pos[i];
            car[i][1] = (double) (target - pos[i]) / speed[i];
        }
         Arrays.sort(car, (a, b) -> Double.compare(a[0], b[0]));
        int fleet = 0;
        double maxtime = 0.0;
        for(int i=n-1;i>=0;i--){

            if(car[i][1]>maxtime){
                maxtime = car[i][1];
                fleet++;
            }
        }
        return fleet;
    }
}
