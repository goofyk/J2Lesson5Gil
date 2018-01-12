/**
 * @author Anton Gil
 * @version dated Jan 12, 2018
 * @link https://github.com/goofyk/J2Lesson5Gil
 */

public class J2Lesson5Gil {

    static final int size = 100000000;
    static final int h = size / 2;

    public static void main(String[] args){

//        copyArraySimple();
        copyArrayUseThreads();

    }

    public static void copyArraySimple(){

        float[] arr = new float[size];

        for(int i=0;i<size;i++){
            arr[i] = 1f;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Execute time: " + (System.currentTimeMillis() - a));

    }

    public static void copyArrayUseThreads(){

        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        Thread myThread1 = new Thread(new J2RunnableClass(size, a1), "Thread1");
        Thread myThread2 = new Thread(new J2RunnableClass(size, a1), "Thread2");

        for(int i=0; i<size; i++){
            arr[i] = 1f;
        }

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        myThread1.start();
        myThread2.start();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("Execute time: " + (System.currentTimeMillis() - a));

    }

}
