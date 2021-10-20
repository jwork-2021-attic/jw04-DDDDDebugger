package com.anish.calabashbros;

public class QuickSorter <T extends Comparable<T>> implements Sorter<T>{
    private String plan = "";
    private T[] elements;


    private void swap(int i, int j){
        T temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
        plan += elements[i] + "<->" + elements[j] + "\n";
    }

    private void quickSort(T[] a, int left, int right){
        if(a.length < 2 || left >= right) return;

        T pivot = a[left];
        int i = left, j = right;
        while(i < j){
            while(a[j].compareTo(pivot) >= 0 && j > i){
                j--;
            }
            while(a[i].compareTo(pivot) <= 0 && i < j){
                i++;
            }
            if(i < j){
                swap(i,j);
            }
        }
        swap(left, i);
        quickSort(a, left, i-1);
        quickSort(a, i+1, right);
    }

    @Override
    public void load(T []array){
        this.elements = array;
    }

    @Override
    public void sort(){
        this.quickSort(this.elements, 0, elements.length-1);
    }

    @Override
    public String getPlan(){
        return this.plan;
    }

}