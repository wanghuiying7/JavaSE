package f_方法;

public class Demo01_method {
    public static void main(String[] args) {
        // 需求: 将遍历数组的工作抽取到数组中
        //回顾抽取方法的套路: 1 在main方法中实现功能 2 选中核心代码 3 使用快捷键抽取
        int[] arr = {11, 33, 55, 77, 99};
        airPrint(arr);

        int[] arr2 = {22, 44, 66};
        airPrint(arr2);

        int[] arr3 = {111, 333, 666};
        airPrint(arr3);
    }

    private static void airPrint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            System.out.println(element);
        }
    }
    /*
        方法的格式:
            修饰符 返回值类型 方法名(参数类型 参数名, 参数类型 参数名, 参数类型 参数名 ... ...) {
                方法体
                [return xxx;]
            }

            修饰符
                private     私有的
                public      公共的
            返回值类型
                无返回值    void
                有返回值    int, double, String 等
     */
}
