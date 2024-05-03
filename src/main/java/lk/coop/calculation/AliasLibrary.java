package lk.coop.calculation;

import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class AliasLibrary {

    private List<AliasObject> aliasList = new ArrayList<>();


    public String replaceCalFormulaWithAliasObject(String calFormula){

        // set all alias to array
        //9
        AliasObject aliasObject1 = new AliasObject();
        aliasObject1.setAlias("PBASCCC");
        aliasObject1.setAliasValue(0);
        aliasList.add(aliasObject1);
        //20
        AliasObject aliasObject2 = new AliasObject();
        aliasObject2.setAlias("PBASRCC");
        aliasObject2.setAliasValue(0);
        aliasList.add(aliasObject2);
        //21
        AliasObject aliasObject3 = new AliasObject();
        aliasObject3.setAlias("PBASTCC");
        aliasObject3.setAliasValue(0);
        aliasList.add(aliasObject3);
        //22
        AliasObject aliasObject4 = new AliasObject();
        aliasObject4.setAlias("PBASHRP");
        aliasObject4.setAliasValue(0);
        aliasList.add(aliasObject4);
        //23
        AliasObject aliasObject5 = new AliasObject();
        aliasObject5.setAlias("PPABINS");
        aliasObject5.setAliasValue(0);
        aliasList.add(aliasObject5);
        //24
        AliasObject aliasObject6 = new AliasObject();
        aliasObject6.setAlias("PPABNMP");
        aliasObject6.setAliasValue(0);
        aliasList.add(aliasObject6);
        //25
        AliasObject aliasObject7 = new AliasObject();
        aliasObject7.setAlias("PPABPSS");
        aliasObject7.setAliasValue(0);
        aliasList.add(aliasObject7);
        //26
        AliasObject aliasObject8 = new AliasObject();
        aliasObject8.setAlias("PPABDRV");
        aliasObject8.setAliasValue(0);
        aliasList.add(aliasObject8);
        //27
        AliasObject aliasObject9 = new AliasObject();
        aliasObject9.setAlias("PPABRID");
        aliasObject9.setAliasValue(0);
        aliasList.add(aliasObject9);
        //28
        AliasObject aliasObject10 = new AliasObject();
        aliasObject10.setAlias("PPABPSR");
        aliasObject10.setAliasValue(0);
        aliasList.add(aliasObject10);
        //29
        AliasObject aliasObject11 = new AliasObject();
        aliasObject11.setAlias("PGITEHF");
        aliasObject11.setAliasValue(0);
        aliasList.add(aliasObject11);
        //30
        AliasObject aliasObject12 = new AliasObject();
        aliasObject12.setAlias("PGITHFC");
        aliasObject12.setAliasValue(0);
        aliasList.add(aliasObject12);
        //31
        AliasObject aliasObject13 = new AliasObject();
        aliasObject13.setAlias("PGITHCC");
        aliasObject13.setAliasValue(0);
        aliasList.add(aliasObject13);
        //32
        AliasObject aliasObject15 = new AliasObject();
        aliasObject15.setAlias("PGITNHC");
        aliasObject15.setAliasValue(0);
        aliasList.add(aliasObject15);
        //33
        AliasObject aliasObject16 = new AliasObject();
        aliasObject16.setAlias("PWCIDRV");
        aliasObject16.setAliasValue(0);
        aliasList.add(aliasObject16);
        //34
        AliasObject aliasObject17 = new AliasObject();
        aliasObject17.setAlias("PWCICLN");
        aliasObject17.setAliasValue(0);
        aliasList.add(aliasObject17);
        //35
        AliasObject aliasObject18 = new AliasObject();
        aliasObject18.setAlias("PWCIATT");
        aliasObject18.setAliasValue(0);
        aliasList.add(aliasObject18);
        //36
        AliasObject aliasObject19 = new AliasObject();
        aliasObject19.setAlias("PWCILAB");
        aliasObject19.setAliasValue(0);
        aliasList.add(aliasObject19);
        //37
        AliasObject aliasObject20 = new AliasObject();
        aliasObject20.setAlias("PTCIPAB");
        aliasObject20.setAliasValue(0);
        aliasList.add(aliasObject20);
        //38
        AliasObject aliasObject21 = new AliasObject();
        aliasObject21.setAlias("PTCCWDR");
        aliasObject21.setAliasValue(0);
        aliasList.add(aliasObject21);
        //39
        AliasObject aliasObject22 = new AliasObject();
        aliasObject22.setAlias("PTCCWCL");
        aliasObject22.setAliasValue(0);
        aliasList.add(aliasObject22);
        //40
        AliasObject aliasObject23 = new AliasObject();
        aliasObject23.setAlias("PTCCWAT");
        aliasObject23.setAliasValue(0);
        aliasList.add(aliasObject23);
        //41
        AliasObject aliasObject24 = new AliasObject();
        aliasObject24.setAlias("PTCCWLB");
        aliasObject24.setAliasValue(0);
        aliasList.add(aliasObject24);
        //42
        AliasObject aliasObject25 = new AliasObject();
        aliasObject25.setAlias("PTCCGIT");
        aliasObject25.setAliasValue(0);
        aliasList.add(aliasObject25);
        //43
        AliasObject aliasObject26 = new AliasObject();
        aliasObject26.setAlias("PRCIPAB");
        aliasObject26.setAliasValue(0);
        aliasList.add(aliasObject26);
        //44
        AliasObject aliasObject27 = new AliasObject();
        aliasObject27.setAlias("PRCCWDR");
        aliasObject27.setAliasValue(0);
        aliasList.add(aliasObject27);
        //45
        AliasObject aliasObject28 = new AliasObject();
        aliasObject28.setAlias("PRCCWCL");
        aliasObject28.setAliasValue(0);
        aliasList.add(aliasObject28);
        //46
        AliasObject aliasObject29 = new AliasObject();
        aliasObject29.setAlias("PRCCWAT");
        aliasObject29.setAliasValue(0);
        aliasList.add(aliasObject29);
        //47
        AliasObject aliasObject30 = new AliasObject();
        aliasObject30.setAlias("PRCCWLB");
        aliasObject30.setAliasValue(0);
        aliasList.add(aliasObject30);
        //48
        AliasObject aliasObject31 = new AliasObject();
        aliasObject31.setAlias("PRCCGIT");
        aliasObject31.setAliasValue(0);
        aliasList.add(aliasObject31);
        //49
        AliasObject aliasObject32 = new AliasObject();
        aliasObject32.setAlias("POTHEXL");
        aliasObject32.setAliasValue(0);
        aliasList.add(aliasObject32);
        //50
        AliasObject aliasObject33 = new AliasObject();
        aliasObject33.setAlias("POTHTOW");
        aliasObject33.setAliasValue(0);
        aliasList.add(aliasObject33);
        //51
        AliasObject aliasObject34 = new AliasObject();
        aliasObject34.setAlias("POTHTPP");
        aliasObject34.setAliasValue(0);
        aliasList.add(aliasObject34);
        //52
        AliasObject aliasObject35 = new AliasObject();
        aliasObject35.setAlias("POTHWDS");
        aliasObject35.setAliasValue(0);
        aliasList.add(aliasObject35);
        //53
        AliasObject aliasObject36 = new AliasObject();
        aliasObject36.setAlias("POTHBUS");
        aliasObject36.setAliasValue(0);
        aliasList.add(aliasObject36);
        //54
        AliasObject aliasObject37 = new AliasObject();
        aliasObject37.setAlias("POTHABC");
        aliasObject37.setAliasValue(0);
        aliasList.add(aliasObject37);
        //55
        AliasObject aliasObject38 = new AliasObject();
        aliasObject38.setAlias("POTHLLB");
        aliasObject38.setAliasValue(0);
        aliasList.add(aliasObject38);
        //56
        AliasObject aliasObject39 = new AliasObject();
        aliasObject39.setAlias("PLDRDSB");
        aliasObject39.setAliasValue(0);
        aliasList.add(aliasObject39);
        //57
        AliasObject aliasObject40 = new AliasObject();
        aliasObject40.setAlias("PLDRDSA");
        aliasObject40.setAliasValue(0);
        aliasList.add(aliasObject40);
        //59
        AliasObject aliasObject41 = new AliasObject();
        aliasObject41.setAlias("PTCNPAB");
        aliasObject41.setAliasValue(0);
        aliasList.add(aliasObject41);
        //60
        AliasObject aliasObject42 = new AliasObject();
        aliasObject42.setAlias("PTCPPAB");
        aliasObject42.setAliasValue(0);
        aliasList.add(aliasObject42);
        //61
        AliasObject aliasObject43 = new AliasObject();
        aliasObject43.setAlias("PTCDPAB");
        aliasObject43.setAliasValue(0);
        aliasList.add(aliasObject43);
        //62
        AliasObject aliasObject44 = new AliasObject();
        aliasObject44.setAlias("PTCRPAB");
        aliasObject44.setAliasValue(0);
        aliasList.add(aliasObject44);
        //63
        AliasObject aliasObject45 = new AliasObject();
        aliasObject45.setAlias("PTCBPAB");
        aliasObject45.setAliasValue(0);
        aliasList.add(aliasObject45);
        //64
        AliasObject aliasObject46 = new AliasObject();
        aliasObject46.setAlias("PRCNPAB");
        aliasObject46.setAliasValue(0);
        aliasList.add(aliasObject46);
        //65
        AliasObject aliasObject47 = new AliasObject();
        aliasObject47.setAlias("PRCPPAB");
        aliasObject47.setAliasValue(0);
        aliasList.add(aliasObject47);
        //66
        AliasObject aliasObject48 = new AliasObject();
        aliasObject48.setAlias("PRCDPAB");
        aliasObject48.setAliasValue(0);
        aliasList.add(aliasObject48);
        //67
        AliasObject aliasObject49 = new AliasObject();
        aliasObject49.setAlias("PRCRPAB");
        aliasObject49.setAliasValue(0);
        aliasList.add(aliasObject49);
        //68
        AliasObject aliasObject50 = new AliasObject();
        aliasObject50.setAlias("PRCBPAB");
        aliasObject50.setAliasValue(0);
        aliasList.add(aliasObject50);
        //69
        AliasObject aliasObject51 = new AliasObject();
        aliasObject51.setAlias("PLDRINB");
        aliasObject51.setAliasValue(0);
        aliasList.add(aliasObject51);
        //70
        AliasObject aliasObject52 = new AliasObject();
        aliasObject52.setAlias("PLDRINA");
        aliasObject52.setAliasValue(0);
        aliasList.add(aliasObject52);

        //start loading alias
        //1
        AliasObject aliasObject53 = new AliasObject();
        aliasObject53.setAlias("LDFR");
        aliasObject53.setAliasValue(0);
        aliasList.add(aliasObject53);
        //2
        AliasObject aliasObject54 = new AliasObject();
        aliasObject54.setAlias("LRBS");
        aliasObject54.setAliasValue(0);
        aliasList.add(aliasObject54);
        //3
        AliasObject aliasObject55 = new AliasObject();
        aliasObject55.setAlias("LRCR");
        aliasObject55.setAliasValue(0);
        aliasList.add(aliasObject55);
        //4
        AliasObject aliasObject56 = new AliasObject();
        aliasObject56.setAlias("LRMC");
        aliasObject56.setAliasValue(0);
        aliasList.add(aliasObject56);
        //5
        AliasObject aliasObject57 = new AliasObject();
        aliasObject57.setAlias("LRLR");
        aliasObject57.setAliasValue(0);
        aliasList.add(aliasObject57);
        //6
        AliasObject aliasObject58 = new AliasObject();
        aliasObject58.setAlias("LSPC");
        aliasObject58.setAliasValue(0);
        aliasList.add(aliasObject58);

        //start pe discount alias
        //1
        AliasObject aliasObject59 = new AliasObject();
        aliasObject59.setAlias("DSAM");
        aliasObject59.setAliasValue(0);
        aliasList.add(aliasObject59);
        //2
        AliasObject aliasObject60 = new AliasObject();
        aliasObject60.setAlias("DBPD");
        aliasObject60.setAliasValue(0);
        aliasList.add(aliasObject60);
        //3
        AliasObject aliasObject61 = new AliasObject();
        aliasObject61.setAlias("DVM1");
        aliasObject61.setAliasValue(0);
        aliasList.add(aliasObject61);
        //4
        AliasObject aliasObject62 = new AliasObject();
        aliasObject62.setAlias("DVM2");
        aliasObject62.setAliasValue(0);
        aliasList.add(aliasObject62);
        //5
        AliasObject aliasObject63 = new AliasObject();
        aliasObject63.setAlias("DVM3");
        aliasObject63.setAliasValue(0);
        aliasList.add(aliasObject63);

        AliasObject aliasObject631 = new AliasObject();
        aliasObject631.setAlias("DVM4");
        aliasObject631.setAliasValue(0);
        aliasList.add(aliasObject631);

        AliasObject aliasObject632 = new AliasObject();
        aliasObject632.setAlias("DVM5");
        aliasObject632.setAliasValue(0);
        aliasList.add(aliasObject632);

        AliasObject aliasObject633 = new AliasObject();
        aliasObject633.setAlias("DVM6");
        aliasObject633.setAliasValue(0);
        aliasList.add(aliasObject633);
        //6
        AliasObject aliasObject64 = new AliasObject();
        aliasObject64.setAlias("DVO1");
        aliasObject64.setAliasValue(0);
        aliasList.add(aliasObject64);
        //7
        AliasObject aliasObject65 = new AliasObject();
        aliasObject65.setAlias("DVO2");
        aliasObject65.setAliasValue(0);
        aliasList.add(aliasObject65);
        //8
        AliasObject aliasObject66 = new AliasObject();
        aliasObject66.setAlias("DVO3");
        aliasObject66.setAliasValue(0);
        aliasList.add(aliasObject66);

        AliasObject aliasObject661 = new AliasObject();
        aliasObject661.setAlias("DVO4");
        aliasObject661.setAliasValue(0);
        aliasList.add(aliasObject661);

        AliasObject aliasObject662 = new AliasObject();
        aliasObject662.setAlias("DVO5");
        aliasObject662.setAliasValue(0);
        aliasList.add(aliasObject662);

        AliasObject aliasObject663 = new AliasObject();
        aliasObject663.setAlias("DVO6");
        aliasObject663.setAliasValue(0);
        aliasList.add(aliasObject663);
        //9
        AliasObject aliasObject67 = new AliasObject();
        aliasObject67.setAlias("DMR1");
        aliasObject67.setAliasValue(0);
        aliasList.add(aliasObject67);
        //10
        AliasObject aliasObject68 = new AliasObject();
        aliasObject68.setAlias("DNCB");
        aliasObject68.setAliasValue(0);
        aliasList.add(aliasObject68);
        //11
        AliasObject aliasObject69 = new AliasObject();
        aliasObject69.setAlias("DSPC");
        aliasObject69.setAliasValue(0);
        aliasList.add(aliasObject69);
        //94
        AliasObject aliasObject700 = new AliasObject();
        aliasObject700.setAlias("DMR1");
        aliasObject700.setAliasValue(0);
        aliasList.add(aliasObject700);

        AliasObject aliasObject70 = new AliasObject();
        aliasObject70.setAlias("DMR2");
        aliasObject70.setAliasValue(0);
        aliasList.add(aliasObject70);
        //95
        AliasObject aliasObject71 = new AliasObject();
        aliasObject71.setAlias("DMR3");
        aliasObject71.setAliasValue(0);
        aliasList.add(aliasObject71);
        //96
        AliasObject aliasObject72 = new AliasObject();
        aliasObject72.setAlias("DMR4");
        aliasObject72.setAliasValue(0);
        aliasList.add(aliasObject72);
        //97
        AliasObject aliasObject73 = new AliasObject();
        aliasObject73.setAlias("DMR5");
        aliasObject73.setAliasValue(0);
        aliasList.add(aliasObject73);
        //98
        AliasObject aliasObject74 = new AliasObject();
        aliasObject74.setAlias("DMR6");
        aliasObject74.setAliasValue(0);
        aliasList.add(aliasObject74);
        //99
        AliasObject aliasObject75 = new AliasObject();
        aliasObject75.setAlias("DMR7");
        aliasObject75.setAliasValue(0);
        aliasList.add(aliasObject75);

        //strt paymentline alias
        //2
        AliasObject aliasObject76 = new AliasObject();
        aliasObject76.setAlias("LPLF");
        aliasObject76.setAliasValue(0);
        aliasList.add(aliasObject76);
        //3
        AliasObject aliasObject77 = new AliasObject();
        aliasObject77.setAlias("LRSF");
        aliasObject77.setAliasValue(0);
        aliasList.add(aliasObject77);
        //4
        AliasObject aliasObject78 = new AliasObject();
        aliasObject78.setAlias("LSRC");
        aliasObject78.setAliasValue(0);
        aliasList.add(aliasObject78);
        //5
        AliasObject aliasObject79 = new AliasObject();
        aliasObject79.setAlias("LTCP");
        aliasObject79.setAliasValue(0);
        aliasList.add(aliasObject79);
        //6
        AliasObject aliasObject80 = new AliasObject();
        aliasObject80.setAlias("LNPP");
        aliasObject80.setAliasValue(0);
        aliasList.add(aliasObject80);
        //7
        AliasObject aliasObject81 = new AliasObject();
        aliasObject81.setAlias("LNBT");
        aliasObject81.setAliasValue(0);
        aliasList.add(aliasObject81);
        //8
        AliasObject aliasObject82 = new AliasObject();
        aliasObject82.setAlias("LVAT");
        aliasObject82.setAliasValue(0);
        aliasList.add(aliasObject82);
        //9
        AliasObject aliasObject83 = new AliasObject();
        aliasObject83.setAlias("LCES");
        aliasObject83.setAliasValue(0);
        aliasList.add(aliasObject83);
        //10
        AliasObject aliasObject84 = new AliasObject();
        aliasObject84.setAlias("LSTD");
        aliasObject84.setAliasValue(0);
        aliasList.add(aliasObject84);
        //11
        AliasObject aliasObject85 = new AliasObject();
        aliasObject85.setAlias("LGRP");
        aliasObject85.setAliasValue(0);
        aliasList.add(aliasObject85);
        //12 cover alias
        AliasObject aliasObject86 = new AliasObject();
        aliasObject86.setAlias("PRCCGIF");
        aliasObject86.setAliasValue(0);
        aliasList.add(aliasObject86);
        //13
        AliasObject aliasObject87 = new AliasObject();
        aliasObject87.setAlias("PRCCGIH");
        aliasObject87.setAliasValue(0);
        aliasList.add(aliasObject87);
        //14
        AliasObject aliasObject88 = new AliasObject();
        aliasObject88.setAlias("PRCCGIN");
        aliasObject88.setAliasValue(0);
        aliasList.add(aliasObject88);
        //15
        AliasObject aliasObject89 = new AliasObject();
        aliasObject89.setAlias("PTCCGIF");
        aliasObject89.setAliasValue(0);
        aliasList.add(aliasObject89);
        //16
        AliasObject aliasObject90 = new AliasObject();
        aliasObject90.setAlias("PTCCGIH");
        aliasObject90.setAliasValue(0);
        aliasList.add(aliasObject90);
        //17
        AliasObject aliasObject91 = new AliasObject();
        aliasObject91.setAlias("PTCCGIN");
        aliasObject91.setAliasValue(0);
        aliasList.add(aliasObject91);

        System.out.println("==============================aliasList==========="+aliasList);

        for (AliasObject tmpAliasObject : aliasList) {
            if(calFormula.contains(tmpAliasObject.getAlias())){
                calFormula = calFormula.replaceAll(tmpAliasObject.getAlias(), tmpAliasObject.getAliasValue()+"");
            }

        }


        return calFormula;
    }
}


