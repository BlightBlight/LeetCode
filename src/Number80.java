/*
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:
给定 nums = [1,1,1,2,2,3],
函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
你不需要考虑数组中超出新长度后面的元素。

示例 2:
给定 nums = [0,0,1,1,1,1,2,3,3],
函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
你不需要考虑数组中超出新长度后面的元素。

说明:
为什么返回数值是整数，但输出的答案是数组呢?
请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
你可以想象内部操作如下:
// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);
// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
*/

public class Number80 {
    public int removeDuplicates(int[] nums) {
    	if(nums.length == 0 || nums.length == 1) {
    		return nums.length;
    	}
    	/*
    	 * 慢指针前两个元素必然有序,慢指针指向的是下一个要修改的元素
    	 * 每次比较慢指针前第二个元素与快指针指向元素是否相同
    	 * 若相同，则说明快指针指向元素大于等于两个，快指针继续向前走
    	 * 若不相同，则说明快指针指向元素小于两个，把快指针指向元素写入慢指针指向元素
    	 * 0 1 1 1 2 2 3 4 
    	 */
    	int i = 2;
    	//快指针
        for(int j = 3; j < nums.length; j++) {
            if(nums[j] != nums[i-2]){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		Number80 n = new Number80();
    	System.out.println(n.removeDuplicates(nums));
	}
}
