package lk.coop.calculation;

import java.util.List;

public class QuotationCalculation {

    public String replaceCalFormulaByRefAlias(List<RefFormula> refFormulaList, String calFormula){

        if(refFormulaList.size() > 0){

            for (RefFormula refFormula : refFormulaList) {
                calFormula = calFormula.replaceAll(refFormula.getAlias(), refFormula.getFormula());
            }

        }

        return calFormula;
    }
}
