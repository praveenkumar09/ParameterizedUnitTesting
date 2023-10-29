package org.praveen.test;

public enum GenerateNumber {
    ONE(1),ELEVEN(11),SEVENTEEN(17);

    private int number;

    GenerateNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }
}
