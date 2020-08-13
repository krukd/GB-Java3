package ru.geekbrains;

public class BoxWithNumbers <N extends Number>{
    N[] value;

    public BoxWithNumbers(N... value) {//...неограниченное колво элементов которое будет преобразовано в массив
        this.value = value;
    }

    public double avg(){
       double result = 0.0;
       for(int i = 0; i < this.value.length; i++){
           result += this.value[i].doubleValue();
       }
        return result/this.value.length;
    }

    public boolean isSame(BoxWithNumbers<?> another){//<?> говорит о том что можно использовать любой класс(числа строки и тд)
        return Math.abs(this.avg() - another.avg()) < 0.001;// у флоат и дабл значения неточные при мат операциях
    }
}
