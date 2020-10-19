package com.jesse.learn.utils;

public class BitMap {

    //保存数据的
    private Long[] bits;

    //能够存储多少数据
    private int capacity;


    public BitMap(int capacity) {
        this.capacity = capacity;

        //1byte能存储8个数据，那么capacity数据需要多少个bit呢，capacity/8+1,右移3位相当于除以8
        bits = new Long[(capacity>>6) + 1];
    }

    public void add(int num){
        // num/8得到byte[]的index
        int arrayIndex = num >> 6;

        // num%8得到在byte[index]的位置
        int position = num & 0x3f;

        //将1左移position后，那个位置自然就是1，然后和以前的数据做|，这样，那个位置就替换成1了。
        bits[arrayIndex] |= 1 << position;
    }

    public boolean contain(int num){
        // num/8得到byte[]的index
        int arrayIndex = num >> 6;

        // num%8得到在byte[index]的位置
        int position = num & 0x3f;

        //将1左移position后，那个位置自然就是1，然后和以前的数据做&，判断是否为0即可
        return (bits[arrayIndex] & (1 << position)) !=0;
    }

    public void clear(int num){
        // num/8得到byte[]的index
        int arrayIndex = num >> 6;

        // num%8得到在byte[index]的位置
        int position = num & 0x3f;

        //将1左移position后，那个位置自然就是1，然后对取反，再与当前值做&，即可清除当前的位置了.
        bits[arrayIndex] &= ~(1 << position);
    }


    public int bitcount() {
        int totalCount = 0;
        for (int i = 0; i < bits.length; i++) {
            long num = bits[i];
            while (num > 0) {
                totalCount += num & 0x01;
                num >>= 1;
            }
        }

        return totalCount;
    }



}
