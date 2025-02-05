package Week1.primitiveVsReference;

public class primitiveVsReference {
    public static void main(String[] args) {
        int primitiveValue = 10;
        int[] referenceArray = {1, 2, 3};

        System.out.println(Print.BEFORE_CALL);
        System.out.println(Print.INT_VALUE_MSG + primitiveValue);
        displayArray(referenceArray);

        modifyValues(primitiveValue, referenceArray);

        System.out.println(Print.AFTER_CALL);
        System.out.println(Print.INT_VALUE_MSG + primitiveValue);
        displayArray(referenceArray);
    }

    public static void modifyValues(int primitive, int[] array) {
        // This value will not Change
        primitive = 50;
        // These values will Change
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;
        }
    }

    private static void displayArray(int[] array) {
        System.out.print(Print.ARRAY_VALUE_MSG);
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
