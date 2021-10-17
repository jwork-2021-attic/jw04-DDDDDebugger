package com.anish.calabashbros;
import java.awt.Color;
import java.util.Random;

public class World {

    public static final int WIDTH = 40;
    public static final int HEIGHT = 20;
    private Calabash[] bros;

    private Tile<Thing>[][] tiles;

    private class Matrix {
        final int row = 8;
        final int column = 8;

        // Matrix(int row, int column){
        //     this.column = column;
        //     this.row = row;
        // }
    }
    private Matrix matrix;

    public World() {

        if (tiles == null) {
            tiles = new Tile[WIDTH][HEIGHT];
        }

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                tiles[i][j] = new Tile<>(i, j);
                tiles[i][j].setThing(new Floor(this));
            }
        }

        matrix = new Matrix();
        initBros();
        putBros();
        randomBros();
        
    }

    public Thing get(int x, int y) {
        return this.tiles[x][y].getThing();
    }

    public void put(Thing t, int x, int y) {
        this.tiles[x][y].setThing(t);
    }

    public Calabash[] getBros(){
        return bros;
    }

    private void putBros(){
        if(bros == null) return;
        int startx = (WIDTH - matrix.column)/2;
        int starty = (HEIGHT - matrix.row)/2;
        for(int i = 0; i<bros.length; ++i){
            this.put(bros[i],startx + i%matrix.column,starty + i/matrix.column);
        }
    }

    private void initBros(){
        if(bros != null) return;
        int nums = matrix.row*matrix.column;
        bros = new Calabash[nums];
        for(int i = 0; i<nums; ++i){
            bros[i] = new Calabash(new Color(255, i*4, 0), i, this);
        }
    }

    private void randomBros(){
        if(bros == null) return;
        int matrixsize = matrix.row*matrix.column;
        int changetimes = matrixsize/2;
        Random random = new Random();
        for(int i = 0; i < changetimes; ++i){
            int i1 = random.nextInt(matrixsize);
            int i2 = random.nextInt(matrixsize);
            if(i1!=i2){
                bros[i1].swap(bros[i2]);
                Calabash temp = bros[i1];
                bros[i1] = bros[i2];
                bros[i2] = temp;
            }
        }
    }

}
