package middle.arraystring;

public class IncreasingTriplet {
  public boolean increasingTriplet(int[] nums) {
    int length = nums.length;
    if(length<3){
      return false;
    }
    int small = Integer.MAX_VALUE;
    int mid = Integer.MAX_VALUE;

    for(int value:nums){
      if(value<=small){
        small = value;
      }else if(value<=mid){
        mid = value;
      }else if(value>mid){
        return true;
      }
    }
    return false;
  }
}
