package lk.coop.calculation;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CoverCalculation {

    public String replaceCalFormulaByRefAlias(List<RefFormula> refFormulaList, String calFormula){


        AtomicReference<String> newCalFormula = new AtomicReference<>("");
        AtomicReference<Boolean> canReplace = new AtomicReference<>(false);

        refFormulaList.forEach(refFormula -> {
            if(calFormula.contains(refFormula.getAlias())){
                newCalFormula.set(calFormula.replaceAll(refFormula.getAlias(), refFormula.getFormula()));
                canReplace.set(true);
            }else if(calFormula.contains("SUMINSUR")){
                newCalFormula.set(calFormula);
                canReplace.set(true);
            }
        });

        if(!canReplace.get()){
            newCalFormula.set(calFormula);
        }
        System.out.println("===============calFormula  ============================>"+newCalFormula.get());
        return newCalFormula.get();
    }

    public static float getCalculatedFractionForSHO(String option){

        float fraction = 0;

        if (option == "1 Week") {
            fraction = 1 / 8;
        }
        if (option == "1 Month") {
            fraction = 1 / 4;
        }
        if (option == "2 Months") {
            fraction = 3 / 8;
        }
        if (option == "3 Months") {
            fraction = 1 / 2;
        }
        if (option == "4 Months") {
            fraction = 5 / 8;
        }
        if (option == "6 Months") {
            fraction = 3 / 4;
        }
        if (option == "8 Months") {
            fraction = 7 / 8;
        }

        return fraction;
    }
}


