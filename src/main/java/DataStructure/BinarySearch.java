package DataStructure;

public class BinarySearch {
    public static void main(String[] args) {
        int[] test = {1, 2 ,4 ,5, 7, 10};
        System.out.println(binarySearch(test, 2));

    }

    public static int binarySearch(int[] list, int a) {
        int left = 0;
        int right = list.length - 1;
        int mid;

        while(left < right) {
            mid = (left + right) / 2;
            if(list[mid] == a) {
                return mid;
            }
            else if(list[mid] > a) {
                right = mid;
            }
            else {
                left = mid;
            }
            if(left == right - 1){
                if(list[right] == a) {
                    return right;
                }
                break;
            }
        }
        return -1;
    }
}
