package com.anish.calabashbros;

public class SelectSorter <T extends Comparable<T>> implements Sorter<T>{
    private String plan = "";
    private T[] elements;


    private void swap(int i, int j){
        T temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
        plan += elements[i] + "<->" + elements[j] + "\n";
    }

    @Override
    public void load(T []array){
        this.elements = array;
    }

    @Override
    public void sort(){
        for(int i = 0; i<elements.length; ++i){
            int min = i;
            for(int j = i + 1; j<elements.length; ++j){
                if(elements[min].compareTo(elements[j]) > 0){
                    min = j;
                }
            }
            if( min!=i ){
                swap(min,i);
            }
        }
    }

    @Override
    public String getPlan(){
        return this.plan;
    }

}