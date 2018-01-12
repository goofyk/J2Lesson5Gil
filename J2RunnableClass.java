/**
 * @author Anton Gil
 * @version dated Jan 12, 2018
 * @link https://github.com/goofyk/J2Lesson5Gil
 */

public class J2RunnableClass implements  Runnable{

    float[] arr;

    J2RunnableClass(int size, float[] arr){
        this.arr = arr;
    }

    @Override
    public void run() {

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Execute time: " + (System.currentTimeMillis() - a));

    }

}
