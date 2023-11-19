package org.example;

public class Password {
    public static int evaluatePasswdStrength(char[] str){
        int moreThan8 = 0, smallLetter = 0, bigLetter = 0, num = 0, sym = 0;
        int count = 0;
        for(char sign : str){
            count++;
            if(count >= 8){
                moreThan8 = 1;
            }
            if(sign <= 'z' && sign >= 'a'){
                smallLetter = 1;
                continue;
            }
            if(sign <= 'Z' && sign >= 'A'){
                bigLetter = 1;
                continue;
            }
            if(sign <= '9' && sign >= '0'){
                num = 1;
                continue;
            }
            sym = 1;
        }
        return  moreThan8 + smallLetter + bigLetter + num + sym;
    }
}
