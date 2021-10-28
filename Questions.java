/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpidev;

/**
 *
 * @author LENOVO
 */
public class Questions {
    public int id;
    public String question1;
    public String question2;
    public String question3;
     public String question4;
      public String question5;
       public String question6;
        public String question7;
        public  Questions(){
            
        }


public Questions(int Id , String question1, String question2 , String question3,String question4,String question5, String question6,String question7){
this.id =Id;
this.question1=question1;
this.question2=question2;
this.question3=question3;
this.question4=question4;
this.question5=question5;
this.question6=question6;
this.question7=question7;

    
}
public Questions( String question1, String question2 , String question3,String question4,String question5, String question6,String question7){

this.question1=question1;
this.question2=question2;
this.question3=question3;
this.question4=question4;
this.question5=question5;
this.question6=question6;
this.question7=question7;
}

    public int getId() {
        return id;
    }

    public String getQuestion1() {
        return question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public String getQuestion4() {
        return question4;
    }

    public String getQuestion5() {
        return question5;
    }

    public String getQuestion6() {
        return question6;
    }

    public String getQuestion7() {
        return question7;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public void setQuestion4(String question4) {
        this.question4 = question4;
    }

    public void setQuestion5(String question5) {
        this.question5 = question5;
    }

    public void setQuestion6(String question6) {
        this.question6 = question6;
    }

    public void setQuestion7(String question7) {
        this.question7 = question7;
    }

    @Override
    public String toString() {
        return "Questions{" + "id=" + id + ", question1=" + question1 + ", question2=" + question2 + ", question3=" + question3 + ", question4=" + question4 + ", question5=" + question5 + ", question6=" + question6 + ", question7=" + question7 + '}';
    }
    

}
