/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass3;
import java.util.*;
import java.io.*;

public class Ass3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //
        ArrayList <Integer> _gList = new ArrayList <Integer> ();
        double avg;
        //load val
        PopulateGrade(_gList);
        //start
        Scanner in =new Scanner(System.in);
        int getChoice;
        do{
            System.out.print("\n===========================================\nStatistical Analysis\n");
            System.out.print("1.Display Unsorted Grades\n2.Display Sorted Grades\n3.Display Sum of Grades\n4.Display Average Grade\n5.Display Max Grade\n6.Display Median Grade\n7.Display Mode\n8.Quit\n");
            System.out.print("===========================================\n");
            getChoice = in.nextInt();
            
            if(getChoice == 8) break;
            switch(getChoice){
                case 1:
                   DisplayGrade(_gList);
                   break;
                case 2:
                    DisplayGrade(SortList(_gList));
                     break;
                case 3:
                    System.out.print(SumGrade(_gList));
                    break;
                case 4:
                    System.out.print(avg = SumGrade(_gList)/_gList.size());
                    break;
                case 5:
                    System.out.print(FindMax(_gList));
                    break;
                case 6:
                    System.out.print(FindMedian(_gList));
                    break;
                case 7:
                    FindMod(_gList);
                    break;
                case 8:
                    break;
                default:
            }
        }while(true);
    }
    public static void PopulateGrade(ArrayList list){
        try{
            Scanner read = new Scanner(new File("C:\\Users\\gene3\\Documents\\NetBeansProjects\\Ass3\\src\\ass3\\Grades.txt"));
            do{
                //list.add(1);
                list.add(read. nextInt());
            }while(read.hasNext());
            read.close();
        }catch(FileNotFoundException msg){
            System.out.print("File was not found !\n");
        }
    }
    public static void DisplayGrade(ArrayList list){
        for(int i = 0; i < list.size(); i++){
            if( i % 5 == 0 && i != 0)
                System.out.print("\n");
            System.out.print(list.get(i) + " ");
        }
                
    }
    public static ArrayList SortList(ArrayList list){
        ArrayList _cList = (ArrayList) list.clone();
        for(int i=0;i < _cList.size(); i++){
            int lowest = i;
            for( int j= i +1; j< _cList.size(); j++){
                if( (int)_cList.get( j ) < (int)_cList.get( lowest )){
                    lowest = j;
                }
            }
            int swap = (int)_cList.get( i );
             _cList.set( i, _cList.get( lowest ) );
            _cList.set( lowest, swap );
        }
        //show sorted
        //DisplayGrade(_cList);
        return _cList;
    }
    public static int SumGrade(ArrayList list){
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += (int)list.get(i);
        }
        return sum;
    }
    public static int FindMax(ArrayList list){
        int _max = 0;
        for(int i = 0; i < list.size(); i++)
            if ((int)list.get(i) > _max)
                _max = (int)list.get(i);
        return _max;
    }
    public static int FindMedian(ArrayList list){
        if(SortList(list).size() % 2 == 0)
            return (int)SortList(list).get((SortList(list).size() / 2) + 1 );
       else
            return (int)SortList(list).get((((SortList(list).size() / 2) + 1) + (SortList(list).size() / 2)) / 2 );
    }
    public static void FindMod(ArrayList list){
        ArrayList <Integer> Mod = new ArrayList <Integer> ();
        //int Threshold = 0;
        int currentHold;
        int tmp = 1;
        int MaxCount =0;
        //int MaxNum = 0;
        int mCounter = 0;
        //int M_NBuffer=0;
        for(int i = 0; i < SortList(list).size(); i++){
            tmp = 1;
            currentHold = (int)SortList(list).get(i);
            for( int j= i +1; j< SortList(list).size(); j++){
                if(currentHold == (int)SortList(list).get(j)){
                    tmp += 1;
                    mCounter = tmp;
                }
                else{
                    //locate the nex int
                    i = j-1;
                    mCounter = tmp; 
                    System.out.print("Counter :"+tmp+"\n");
                    if(MaxCount<tmp){
                        //MaxNum = currentHold;
                        MaxCount = tmp;
                        System.out.print("Cleaned\n");
                        Mod.clear();
                        //System.out.print("Cleaned\n");
                        //System.out.print("Find\n");
                    }
                    else if(MaxCount == tmp)
                        if(mCounter == MaxCount){
                            Mod.add(currentHold);
                            //System.out.print("Same\n");
                            System.out.print(currentHold+"Saved\n");
                        }
                        //trigger input to list
                        
                        
                    //clear list when find a larger num
                    //if(MaxCount)
                    break;
                }
            }
            System.out.print("currentHold :"+currentHold+"\n");
        }
        //locating the max num count (MaxCount)
        //System.out.print(MaxCount+"\n");
       // System.out.print(MaxNum+"\n");
        DisplayGrade(Mod);
    }
}